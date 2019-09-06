package io.renren.test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.IOException;

public class test01 {
    @Test
    public void exportExcel(){
//        创建工作蒲
        XSSFWorkbook workbook = null;
        try {
            workbook = new XSSFWorkbook("D:\\hello.xlsx");


//        获取工作表 既可以根据工作表的顺序获取，特可以根据工作表的名称获取

        XSSFSheet sheetAt = workbook.getSheetAt(0);


        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
