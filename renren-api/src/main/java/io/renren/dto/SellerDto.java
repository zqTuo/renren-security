package io.renren.dto;

import com.baomidou.mybatisplus.annotation.TableId;
import io.renren.common.poi.model.ExcelBean;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import javax.validation.constraints.NotBlank;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ApiModel(value = "商家录入资料实体")
@Component
public class SellerDto extends ExcelBean {
    /**
     * ID
     */
    @TableId
    @ApiModelProperty(hidden = true)
    private String sellerId;
    /**
     * 店铺名称
     */
    @NotBlank(message="店铺名称不能为空")
    @ApiModelProperty(value = "店铺名称",required = true)
    private String nickName;
    /**
     * 城市
     */
    @NotBlank(message="城市不能为空")
    @ApiModelProperty(value = "所在城市",required = true)
    private String city;
    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "商家登录密码",required = true)
    private String password;
    /**
     * EMAIL
     */
    private String email;
    /**
     * 公司手机
     */
    @NotBlank(message="公司手机不能为空")
    @ApiModelProperty(value = "公司手机",required = true)
    private String mobile;
    /**
     * 公司电话
     */
    @NotBlank(message="公司电话不能为空")
    @ApiModelProperty(value = "公司电话",required = true)
    private String telephone;
    /**
     * 押金缴费状态  0 已退款 1 未交押金 2 已交押金
     */
    private String status;
    /**
     * 区域
     */
    @NotBlank(message="区域不能为空")
    @ApiModelProperty(value = "区域",required = true)
    private String region;
    /**
     * 详细地址
     */
    private String addressDetail;
    /**
     * 联系人姓名
     */
    @NotBlank(message="联系人姓名不能为空")
    @ApiModelProperty(value = "联系人",required = true)
    private String linkmanName;
    /**
     * 联系人QQ
     */
    private String linkmanQq;
    /**
     * 联系人电话
     */
    private String linkmanMobile;
    /**
     * 联系人EMAIL
     */
    private String linkmanEmail;
    /**
     * 职位
     */
    @NotBlank(message="职位不能为空")
    @ApiModelProperty(value = "职位",required = true)
    private String linkmanJod;
    /**
     * 是否连锁经营
     */
    private String storeSize;
    /**
     * 是否支持地推
     */
    @NotBlank(message="是否支持地推为空")
    @ApiModelProperty(value = "是否支持地推",required = true)
    private String addressGround;
    /**
     * 店面大小
     */
    @NotBlank(message="店面大小不能为空")
    @ApiModelProperty(value = "店面大小",required = true)
    private String linkmanOperation;
    /**
     * 营业执照号
     */
    @NotBlank(message="营业执照不能为空")
    @ApiModelProperty(value = "营业执照",required = true)
    private String licenseNumber;
    /**
     * 税务登记证号
     */
    private String taxNumber;
    /**
     * 组织机构代码
     */
    @NotBlank(message="组织机构代码不能为空")
    @ApiModelProperty(value = "组织机构代码",required = true)
    private String orgNumber;
    /**
     * 公司地址
     */
    @NotBlank(message="公司地址不能为空")
    @ApiModelProperty(value = "公司地址",required = true)
    private String address;
    /**
     * 奶茶店周边
     */
    @NotBlank(message="奶茶店周边不能为空")
    @ApiModelProperty(value = "奶茶店周边",required = true)
    private String addressShop;
    /**
     * 简介
     */
    private String brief;
    /**
     * 创建日期
     */
    private Date createTime;
    /**
     * 法定代表人
     */
    private String legalPerson;
    /**
     * 距离周边距离
     */
    private String addressDistance;
    /**
     * 分类
     */
    private String shopCategory;
    /**
     * 门店合作等级
     */
    private String shopLv;
    /**
     * 转化率
     */
    private String conversionRate;
}
