package io.renren.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.annotation.Login;
import io.renren.common.PageUtils;
import io.renren.common.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.entity.CodeEntity;
import io.renren.service.CodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.entity.BonusEntity;
import io.renren.service.BonusService;
import springfox.documentation.annotations.ApiIgnore;

import javax.servlet.http.HttpServletRequest;
import javax.swing.*;


/**
 * 奖金池
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-09-19 11:03:50
 */
@RestController
@RequestMapping("api/bonus")
@Api(tags = "奖品池")
public class BonusController {
    @Autowired
    private BonusService bonusService;
    @Autowired
    private CodeService codeService;

    /**
     * 列表
     */
    @RequestMapping("/list")
    public R list(@RequestParam Map<String, Object> params) {
        PageUtils page = bonusService.queryPage(params);

        return R.ok().put("page", page);
    }


    /**
     * 信息
     */
    @RequestMapping("/info/{bonusId}")
    public R info(@PathVariable("bonusId") Long bonusId) {
        BonusEntity bonus = bonusService.getById(bonusId);

        return R.ok().put("bonus", bonus);
    }

    /**
     * 保存
     */
    @RequestMapping("/save")
    public R save(@RequestBody BonusEntity bonus) {
        bonusService.save(bonus);

        return R.ok();
    }

    /**
     * 修改
     */
    @RequestMapping("/update")
    public R update(@RequestBody BonusEntity bonus) {
        ValidatorUtils.validateEntity(bonus);
        bonusService.updateById(bonus);

        return R.ok();
    }

    /**
     * 删除
     */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] bonusIds) {
        bonusService.removeByIds(Arrays.asList(bonusIds));

        return R.ok();
    }

    @Login
    @ApiOperation(value = "大转盘活动接口")
    @GetMapping("game")
//         待传参数  二维码id  客户id
    public R ganme(@RequestParam("qrCodeId") Long qrCodeId, @ApiIgnore @RequestAttribute("userId") Long userId) {

        try {
//        根据二维码id查询  该为二维码是否存在
            CodeEntity codeEntity = codeService.getOne(new QueryWrapper<CodeEntity>().eq("qrCode_id", qrCodeId));
            if (codeEntity == null) {
                return new R().error("订单不存在");
            }
//        判断该二维码是否已经被扫过  0: 未扫过的 1:已经扫过的了
            if (codeEntity.getIsQr().equals("1")) {
                return new R().error("该二维码已经被扫过了");
            }


//        获取改订单下所有的奖品
            List<BonusEntity> BonusEntityList = bonusService.list(new QueryWrapper<BonusEntity>().eq("order_id", codeEntity.getOrderId()));

            BonusEntity bonusEntity = bonusService.BigGame(BonusEntityList);

//          把二维码设置已扫码状态
            codeEntity.setIsQr("1");
            codeEntity.setCodeUser(String.valueOf(userId));
            codeService.saveOrUpdate(codeEntity);
            return R.ok().put("bonusEntity", bonusEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return R.error(e.getMessage());
        }
    }
}
