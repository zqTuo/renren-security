package io.renren.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.Result.Result;
import io.renren.annotation.Login;
import io.renren.common.IdWorker;
import io.renren.common.PageUtils;
import io.renren.common.R;
import io.renren.common.utils.Constant;
import io.renren.common.validator.ValidatorUtils;
import io.renren.dto.SellerDto;
import io.renren.entity.MoneyEntity;
import io.renren.entity.SellerEntity;
import io.renren.entity.WxuserEntity;
import io.renren.service.MoneyService;
import io.renren.service.SellerService;
import io.renren.service.WxuserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.math.BigDecimal;
import java.util.*;


/**
 * 商家
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-28 10:19:22
 */
@RestController
@RequestMapping("api/seller")
@Api(tags="商家注册登录")
public class SellerController {
    private static Logger log = LogManager.getLogger(LogManager.ROOT_LOGGER_NAME);
    @Resource
    private SellerService sellerService;
    @Autowired
    private MoneyService moneyService;
    @Resource
    private IdWorker idWorker;
    @Resource
    private WxuserService wxuserService;

    /**
     * 保存
     */
    @Login
    @PostMapping("save")
    @ApiOperation(value = "新增商家接口",notes = "响应数据orderNo为支付订单号")
    public Result save(@RequestBody SellerEntity seller, @ApiIgnore @RequestAttribute("userId")Long userId) {
        ValidatorUtils.validateEntity(seller);

        log.info("========用户：" + userId + ",正在录入商家资料==========");
        WxuserEntity wxuserEntity = wxuserService.getById(userId);

        String s = "";

        if(wxuserEntity.getSellerId() !=null){ //已经提交过商家资料
            log.info("已经录入过商家资料");
            // 已经提交过了
            SellerEntity sellerEntity = sellerService.getById(wxuserEntity.getSellerId());
            if(sellerEntity.getStatus().equals(Constant.ORDER_PAY_SUCCESS)){
                return new Result().error("您的商家资料已录入并成功缴费，无需重复提交！");
            }

            //说明已提交但未支付
            s = sellerEntity.getSellerId();
            seller.setSellerId(s);
            seller.setCreateTime(new Date());
            String conversionRate = seller.getConversionRate();
            String s1 = conversionRate + "%";
            seller.setConversionRate(s1);
            seller.setStatus("1");
            sellerService.updateById(seller);
            log.info("资料更新成功：" + seller.toString());
        }else{
            //新增商家
            s = String.valueOf(idWorker.nextId());
            log.info("新增商家ID：" + s);
            seller.setSellerId(s);
            seller.setCreateTime(new Date());
            String conversionRate = seller.getConversionRate();
            String s1 = conversionRate + "%";
            seller.setConversionRate(s1);
            seller.setStatus("1");
            sellerService.save(seller);
            log.info("资料新增成功：" + seller.toString());
        }

        //生成商家押金缴费订单
        MoneyEntity moneyEntity = new MoneyEntity();
        long id = idWorker.nextId();
        log.info("商家押金订单ID：" + id);
        moneyEntity.setMoneyId(String.valueOf(id));
        moneyEntity.setSellerId(String.valueOf(s));
        moneyEntity.setSellerName(seller.getNickName());
        moneyEntity.setCreateTime(new Date());
        moneyEntity.setPayStatus("1");
        moneyEntity.setMoneyYajin(BigDecimal.valueOf(300));
        moneyService.save(moneyEntity);
        wxuserService.updateSeller(seller.getSellerId(),userId);
        log.info("商家:" + seller.getSellerId() + ",押金订单生成成功：" + moneyEntity.toString());

        Map<String,Object> map = new HashMap<>();
        String orderNo = String.valueOf(moneyEntity.getMoneyId());
        map.put("orderNo",orderNo);
        return new Result().ok(map);
    }
}
