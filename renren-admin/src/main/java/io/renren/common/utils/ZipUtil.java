package io.renren.common.utils;



import org.apache.tomcat.jni.Directory;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * zip压缩文件
 */
public class ZipUtil {

    /**
     * 压缩文件列表中的文件
     *
     * @param files
     * @param outputStream
     * @throws IOException
     */
    public static void zipFile(List<File> files, ZipOutputStream outputStream)
            throws IOException, ServletException {
        try {
            int size = files.size();
            // 压缩列表中的文件
            for (int i = 0; i < size; i++) {
                File file = (File) files.get(i);
                zipFile(file, outputStream);
            }
        } catch (IOException e) {
            throw e;
        }
    }
    /**
     * 将文件写入到zip文件中
     *
     * @param inputFile
     * @param outputstream
     * @throws Exception
     */
    public static void zipFile(File inputFile, ZipOutputStream outputstream)
            throws IOException, ServletException {
        try {
            if (inputFile.exists()) {
                if (inputFile.isFile()) {
                    FileInputStream inStream = new FileInputStream(inputFile);
                    BufferedInputStream bInStream = new BufferedInputStream(
                            inStream);
                    ZipEntry entry = new ZipEntry(inputFile.getName());
                    outputstream.putNextEntry(entry);
                    final int MAX_BYTE = 10 * 1024 * 1024; // 最大的流为10M
                    long streamTotal = 0; // 接受流的容量
                    int streamNum = 0; // 流需要分开的数量
                    int leaveByte = 0; // 文件剩下的字符数
                    byte[] inOutbyte; // byte数组接受文件的数据
                    streamTotal = bInStream.available(); // 通过available方法取得流的最大字符数
                    streamNum = (int) Math.floor(streamTotal / MAX_BYTE); // 取得流文件需要分开的数量
                    leaveByte = (int) streamTotal % MAX_BYTE; // 分开文件之后,剩余的数量
                    if (streamNum > 0) {
                        for (int j = 0; j < streamNum; ++j) {
                            inOutbyte = new byte[MAX_BYTE];
                            // 读入流,保存在byte数组
                            bInStream.read(inOutbyte, 0, MAX_BYTE);
                            outputstream.write(inOutbyte, 0, MAX_BYTE); // 写出流
                        }
                    }
                    // 写出剩下的流数据
                    inOutbyte = new byte[leaveByte];
                    bInStream.read(inOutbyte, 0, leaveByte);
                    outputstream.write(inOutbyte);
                    outputstream.closeEntry(); // Closes the current ZIP entry
                    // and positions the stream for
                    // writing the next entry
                    bInStream.close(); // 关闭
                    inStream.close();
                }
            } else {
                throw new ServletException("文件不存在！");
            }
        } catch (IOException e) {
            throw e;
        }
    }
    /**
     * 下载文件
     *
     * @param file
     * @param response
     */
    public static void downloadFile(File file, HttpServletResponse response,
                                    boolean isDelete) {
        try {
            // 以流的形式下载文件。
            BufferedInputStream fis = new BufferedInputStream(
                    new FileInputStream(file.getPath()));
            byte[] buffer = new byte[fis.available()];
            fis.read(buffer);
            fis.close();
            // 清空response
            response.reset();
            OutputStream toClient = new BufferedOutputStream(
                    response.getOutputStream());
            response.setContentType("application/octet-stream");
            response.setHeader("Content-Disposition",
                    "attachment;filename="
                            + new String(file.getName().getBytes("UTF-8"),
                            "ISO-8859-1"));
            toClient.write(buffer);
            toClient.flush();
            toClient.close();
            if (isDelete) {
                file.delete(); // 是否将生成的服务器端文件删除
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    /**
     *  创建文件
     * @param path
     * @param fileName
     */
    public static void createFile(String path, String fileName) {
        File f = new File(path);
        File file = new File(f, fileName);
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    /**
     * 删除文件，可以是文件或文件夹
     * @param fileName 要删除的文件名
     * @return 删除成功返回true，否则返回false
     */
    public static boolean delete(String fileName) {
        File file = new File(fileName);
        if (!file.exists()) {
            System.out.println("删除文件失败:" + fileName + "不存在！");
            return false;
        } else {
            if (file.isFile())
                return deleteFile(fileName);
            else
                return deleteDirectory(fileName);
        }
    }

//    删除文件夹
    private static boolean deleteDirectory(String fileName) {
        return false;
    }



    /**
     * 删除单个文件
     *
     * @param fileName
     *            要删除的文件的文件名
     * @return 单个文件删除成功返回true，否则返回false
     */
    public static boolean deleteFile(String fileName) {
        File file = new File(fileName);
        // 如果文件路径所对应的文件存在，并且是一个文件，则直接删除
        if (file.exists() && file.isFile()) {
            if (file.delete()) {
                System.out.println("删除单个文件" + fileName + "成功！");
                return true;
            } else {
                System.out.println("删除单个文件" + fileName + "失败！");
                return false;
            }
        } else {
            System.out.println("删除单个文件失败：" + fileName + "不存在！");
            return false;
        }
    }

}
