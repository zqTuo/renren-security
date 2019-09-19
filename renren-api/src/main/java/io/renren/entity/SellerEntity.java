package io.renren.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import java.util.Date;

/**
 * 商家
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-28 10:19:22
 */
@Data
@TableName("tb_seller")
@ApiModel(value = "商家录入实体")
public class SellerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

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
	@ApiModelProperty(hidden = true)
	private String password;
	/**
	 * EMAIL
	 */
	@ApiModelProperty(hidden = true)
	private String email;
	/**
	 * 公司手机
	 */
	@ApiModelProperty(hidden = true)
	private String mobile;
	/**
	 * 公司电话
	 */
	@ApiModelProperty(hidden = true)
	private String telephone;
	/**
	 * 押金缴费状态  0 已退款 1 未交押金 2 已交押金
	 */
	@ApiModelProperty(hidden = true)
	private String status;
	/**
	 * 区域
	 */
	@ApiModelProperty(hidden = true)
	private String region;
	/**
	 * 详细地址
	 */
	@NotBlank(message = "具体地址不能为空")
	@ApiModelProperty(value = "具体地址",required = true)
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
	@ApiModelProperty(hidden = true)
	private String linkmanQq;
	/**
	 * 联系人电话
	 */
	@NotBlank(message="联系人电话不能为空")
	@ApiModelProperty(value = "联系人电话",required = true)
	@Pattern(regexp = "^((13[0-9])|(14[0-9])|(15([0-9]))|(16([0-9]))|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$",message = "手机号格式不正确")
	private String linkmanMobile;
	/**
	 * 联系人EMAIL
	 */
	@ApiModelProperty(hidden = true)
	private String linkmanEmail;
	/**
	 * 职位
	 */
	@ApiModelProperty(hidden = true)
	private String linkmanJod;
	/**
	 * 是否连锁经营
	 */
	@ApiModelProperty(hidden = true)
	private String storeSize;
	/**
	 * 是否支持地推
	 */
	@NotBlank(message="是否支持地推为空")
	@ApiModelProperty(value = "是否支持地推  0：不支持 1：支持",required = true)
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
	@ApiModelProperty(hidden = true)
	private String licenseNumber;
	/**
	 * 税务登记证号
	 */
	@ApiModelProperty(hidden = true)
	private String taxNumber;
	/**
	 * 组织机构代码
	 */
	@ApiModelProperty(hidden = true)
	private String orgNumber;
	/**
	 * 公司地址
	 */
	@ApiModelProperty(hidden = true)
	private String address;
	/**
	 * 奶茶店周边
	 */
	@NotBlank(message="奶茶店周边不能为空")
	@ApiModelProperty(value = "奶茶店周边  0：高校 1：商场 2：写字楼 3：工厂",required = true)
	private String addressShop;
	/**
	 * 简介
	 */
	@ApiModelProperty(hidden = true)
	private String brief;
	/**
	 * 创建日期
	 */
	@ApiModelProperty(hidden = true)
	private Date createTime;
	/**
	 * 法定代表人
	 */
	@ApiModelProperty(hidden = true)
	private String legalPerson;
	/**
	 * 距离周边距离
	 */
	@ApiModelProperty(hidden = true)
	private String addressDistance;
	/**
	 * 分类
	 */
	@ApiModelProperty(hidden = true)
	private String shopCategory;
	/**
	 * 门店合作等级
	 */
	@ApiModelProperty(hidden = true)
	private String shopLv;
	/**
	 * 转化率
	 */
	@ApiModelProperty(hidden = true)
	private String conversionRate;


}
