package io.renren.modules.sys.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;


import io.renren.common.utils.*;
import io.renren.common.validator.ValidatorUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.modules.sys.entity.SellerEntity;
import io.renren.modules.sys.service.SellerService;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


/**
 * 商家
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-28 10:19:22
 */
@RestController
@RequestMapping("sys/seller")
public class SellerController {

    @Autowired
    private SellerService sellerService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    @RequiresPermissions("sys:seller:list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = sellerService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{sellerId}")
    @RequiresPermissions("sys:seller:info")
    public R info(@PathVariable("sellerId") String sellerId) {
        SellerEntity seller = sellerService.getById(sellerId);

        return R.ok().put("seller", seller);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    @RequiresPermissions("sys:seller:save")
    public R save(@RequestBody SellerEntity seller) {
        IdWorker idworker=new IdWorker(0,1);
        String s = idworker.nextId() + "";
        seller.setSellerId(s);
        String conversionRate = seller.getConversionRate();
        String s1 = conversionRate + "%";
        seller.setConversionRate(s1);
        sellerService.save(seller);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    @RequiresPermissions("sys:seller:update")
    public R update(@RequestBody SellerEntity seller) {
        ValidatorUtils.validateEntity(seller);
        sellerService.updateById(seller);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    @RequiresPermissions("sys:seller:delete")
    public R delete(@RequestBody String[] sellerIds) {
        sellerService.removeByIds(Arrays.asList(sellerIds));

        return R.ok();
    }

    /**
     * 导出Excel报表
     *
     * @return
     */
    @RequestMapping(value = "/exportExcel1")
    @RequiresPermissions("sys:seller:exportExcel1")
    public Result  exportBusinessReport(HttpServletRequest request, HttpServletResponse response) {
       /* XSSFWorkbook workbook = null;
        try {
            Map<String, Object> result = sellerService.getBusinessReport();
            String sellerId = (String) result.get("sellerId");
            String nickName = (String) result.get("nickName");
            String password = (String) result.get("password");
            String email = (String) result.get("email");
            String mobile = (String) result.get("mobile");
            String telephone = (String) result.get("telephone");
            String status = (String) result.get("status");
            String region = (String) result.get("region");
            String addressDetail = (String) result.get("addressDetail");
            String linkmanName = (String) result.get("linkmanName");
            String linkmanQq = (String) result.get("linkmanQq");
            String linkmanMobile = (String) result.get("linkmanMobile");
            String linkmanEmail = (String) result.get("linkmanEmail");
            String linkmanJod = (String) result.get("linkmanJod");
            String storeSize = (String) result.get("storeSize");
            String licenseNumber = (String) result.get("licenseNumber");
            String addressGround = (String) result.get("addressGround");
            String linkmanOperation = (String) result.get("linkmanOperation");
            String taxNumber = (String) result.get("taxNumber");
            String orgNumber = (String) result.get("orgNumber");
            Long address = (Long) result.get("address");
            String brief = (String) result.get("brief");
            String createTime = (String) result.get("createTime");
            String legalPerson = (String) result.get("legalPerson");
            String shopCategory = (String) result.get("shopCategory");
            String addressDistance = (String) result.get("addressDistance");
            String shopLcv = (String) result.get("shopLcv");
            String conversionRate = (String) result.get("conversionRate");

            //获得Excel模板文件绝对路径
            String temlateRealPath = "D:\\JAVA_code\\renren-security\\renren-admin\\src\\main\\resources\\templates" + File.separator + "ordersetting_template.xlsx";

            //读取模板文件创建Excel表格对象


            workbook = new XSSFWorkbook(new FileInputStream(new File(temlateRealPath)));
            XSSFSheet sheet = workbook.getSheetAt(0);

            Row row = sheet.getRow(0);
            System.out.println(row);

            Cell cell = row.getCell(0);
            System.out.println(cell);
            cell.setCellValue(sellerId);



            //row.getCell(5).setCellValue(nickName);


          *//*  row.getCell(5).setCellValue(password);
            row.getCell(5).setCellValue(email);
            row.getCell(5).setCellValue(mobile);
            row.getCell(5).setCellValue(telephone);
            row.getCell(5).setCellValue(status);
            row.getCell(5).setCellValue(region);
            row.getCell(5).setCellValue(addressDetail);
            row.getCell(5).setCellValue(linkmanName);
            row.getCell(5).setCellValue(linkmanQq);
            row.getCell(5).setCellValue(linkmanMobile);
            row.getCell(5).setCellValue(linkmanEmail);
            row.getCell(5).setCellValue(linkmanJod);
            row.getCell(5).setCellValue(storeSize);
            row.getCell(5).setCellValue(addressGround);
            row.getCell(5).setCellValue(licenseNumber);
            row.getCell(5).setCellValue(linkmanOperation);
            row.getCell(5).setCellValue(taxNumber);
            row.getCell(5).setCellValue(orgNumber);
            row.getCell(5).setCellValue(address);
            row.getCell(5).setCellValue(createTime);
            row.getCell(5).setCellValue(legalPerson);
            row.getCell(5).setCellValue(brief);
            row.getCell(5).setCellValue(shopCategory);
            row.getCell(5).setCellValue(addressDistance);
            row.getCell(5).setCellValue(shopLcv);
            row.getCell(5).setCellValue(conversionRate);*//*

            //通过输出流进行文件下载
            ServletOutputStream out = response.getOutputStream();
            response.setContentType("application/vnd.ms-excel");
            response.setHeader("content-Disposition", "attachment;filename=report.xlsx");
            workbook.write(out);

            out.flush();
            out.close();
            workbook.close();

            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return new Result(false, "有异常  请先处理异常");

        }*/
        return null;
    }

}
