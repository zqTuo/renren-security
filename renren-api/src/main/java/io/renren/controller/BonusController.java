package io.renren.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.renren.Result.Result;
import io.renren.annotation.Login;
import io.renren.common.utils.PageUtils;
import io.renren.common.utils.R;
import io.renren.common.validator.ValidatorUtils;
import io.renren.entity.CodeEntity;
import io.renren.service.BonusLogService;
import io.renren.service.CodeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import io.renren.entity.BonusEntity;
import io.renren.service.BonusService;
import springfox.documentation.annotations.ApiIgnore;


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
    @Autowired
    private BonusLogService bonusLogService;

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
    @PostMapping("game")
//         待传参数  二维码id  客户id
    public Result game(@RequestBody CodeEntity code, @ApiIgnore @RequestAttribute("userId") Long userId) {

        try {
//        根据二维码id查询  该为二维码是否存在
            CodeEntity codeEntity = codeService.getOne(new QueryWrapper<CodeEntity>().eq("qrCode_id", code.getQrcodeId()));
            if (codeEntity == null) {
                return new Result().error("订单不存在");
            }
//        判断该二维码是否已经被扫过  0: 未扫过的 1:已经扫过的了
            if (codeEntity.getIsQr().equals("1")) {
                return new Result().error("该二维码已经被扫过了");
            }


//        获取改订单下所有的奖品
            List<BonusEntity> BonusEntityList = bonusService.list(new QueryWrapper<BonusEntity>().eq("order_id", codeEntity.getOrderId()));

            BonusEntity bonusEntity = bonusService.BigGame(BonusEntityList,userId,codeEntity);

            if (bonusEntity==null) {
                return new Result().error("获取奖品失败 请稍候再试");
            }

//          把二维码设置已扫码状态
            codeEntity.setIsQr("1");
            codeEntity.setCodeUser(String.valueOf(userId));
            codeService.saveOrUpdate(codeEntity);


            return new Result().ok( bonusEntity);
        } catch (Exception e) {
            e.printStackTrace();
            return new Result().error(e.getMessage());
        }
    }
    @Login
    @ApiOperation(value = "根据订单id查询奖品")
    @GetMapping("findActivityByCode/{codeId}")
    public Result findBonusByCodeId(@PathVariable String codeId){
//        传过来一个二维码id  根据这个id去查找 相对应的订单的下的活动内容
        CodeEntity codeEntity = codeService.getOne(new QueryWrapper<CodeEntity>().eq("qrCode_id", codeId));

        List<BonusEntity> bonusEntities = bonusService.list(new QueryWrapper<BonusEntity>().eq("order_id", codeEntity.getOrderId()));

        return new Result().ok(bonusEntities);
    }
}
