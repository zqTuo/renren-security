package io.renren.modules.sys.controller;

import com.alibaba.fastjson.JSONObject;

import io.renren.common.utils.Constant;
import io.renren.common.utils.DateUtil;
import io.renren.modules.sys.dto.PackageDto;
import io.renren.modules.sys.dto.SellerDto;
import io.renren.modules.sys.entity.SellerEntity;
import io.renren.modules.sys.service.ExcelService;
import io.renren.modules.sys.service.SellerService;
import org.apache.commons.lang.StringUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: Clarence
 * @Description: 文件控制器
 * @Date: 2019/3/9 19:14.
 */
@RestController
@RequestMapping("admin/upload")
public class AdminFileUploadCtrl {
    private static Logger logger = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);


    @Value("${D:\\}")
    private String uploadFilePath;

    @Resource
    private ExcelService excelService;
    @Autowired
    private SellerService sellerService;


    
    /**
     * 下载Excel表 页面直接使用window.location.href = "admin/upload/downloadOrder?ids=" + xxx
     * @param request
     * @param response
     */
    @RequestMapping(value = "/exportExcel")
    @RequiresPermissions("sys:seller:exportExcel")
    public void downloadOrder(HttpServletRequest request,HttpServletResponse response){
        response.setCharacterEncoding("utf-8");
        String date = ServletRequestUtils.getStringParameter(request,"date","");
        String dateEnd =ServletRequestUtils.getStringParameter(request,"dateEnd","");
        String ids = ServletRequestUtils.getStringParameter(request,"ids","");

        Map<String,Object> map = new HashMap<>();

        if(StringUtils.isNotBlank(ids)){ //说明要下载选中行的数据
            String[] idStr=ids.split(",");
            map.put("idArr",idStr);
        }
        if(StringUtils.isNotBlank(date)){
            map.put("date",date);
        }
        if(StringUtils.isNotBlank(dateEnd)){
            map.put("dateEnd",dateEnd);
        }

        List<SellerDto> sellerDtoList = sellerService.getBusinessReport();

        if(sellerDtoList == null || sellerDtoList.size()==0){
            logger.error("下载数据为空！");
            return;
        }



        try {
            String fileName = "商品表_" + DateUtil.getNowLongTime();
            logger.info("正在下载包裹表：" + sellerDtoList.size() + " 条数据");
            excelService.createExport(request,response,sellerDtoList, Constant.EXPORT_PACKAGE_EXCEL,fileName,null);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
