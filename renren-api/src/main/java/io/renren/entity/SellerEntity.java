package io.renren.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotBlank;
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
public class SellerEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private String sellerId;
	/**
	 * 店铺名称
	 */
	@NotBlank(message="店铺名称不能为空")
	private String nickName;
	/**
	 * 城市
	 */
	@NotBlank(message="城市不能为空")
	private String city;
	/**
	 * 密码
	 */
	private String password;
	/**
	 * EMAIL
	 */
	private String email;
	/**
	 * 公司手机
	 */
	@NotBlank(message="公司手机不能为空")
	private String mobile;
	/**
	 * 公司电话
	 */
	@NotBlank(message="公司电话不能为空")
	private String telephone;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 区域
	 */
	@NotBlank(message="区域不能为空")
	private String region;
	/**
	 * 详细地址
	 */
	private String addressDetail;
	/**
	 * 联系人姓名
	 */
	@NotBlank(message="联系人姓名不能为空")
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
	private String linkmanJod;
	/**
	 * 是否连锁经营
	 */
	private String storeSize;
	/**
	 * 是否支持地推
	 */
	@NotBlank(message="是否支持地推为空")
	private String addressGround;
	/**
	 * 店面大小
	 */
	@NotBlank(message="店面大小不能为空")
	private String linkmanOperation;
	/**
	 * 营业执照号
	 */
	@NotBlank(message="营业执照号不能为空")
	private String licenseNumber;
	/**
	 * 税务登记证号
	 */
	private String taxNumber;
	/**
	 * 组织机构代码
	 */
	@NotBlank(message="组织机构代码不能为空")
	private String orgNumber;
	/**
	 * 公司地址
	 */
	@NotBlank(message="公司地址不能为空")
	private String address;
	/**
	 * 奶茶店周边
	 */
	@NotBlank(message="奶茶店周边不能为空")
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
