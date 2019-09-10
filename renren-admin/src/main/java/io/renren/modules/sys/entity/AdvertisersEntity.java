package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 广告主
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-28 10:16:27
 */
@Data
@TableName("tb_advertisers")
public class AdvertisersEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private String advertisersId;
	/**
	 * 公司名
	 */
	private String name;
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
	private String mobile;
	/**
	 * 公司电话
	 */
	private String telephone;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 详细地址
	 */
	private String addressDetail;
	/**
	 * 联系人姓名
	 */
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
	 * 营业执照号
	 */
	private String licenseNumber;
	/**
	 * 税务登记证号
	 */
	private String taxNumber;
	/**
	 * 组织机构代码
	 */
	private String orgNumber;
	/**
	 * 公司地址
	 */
	private String address;
	/**
	 * 公司LOGO图
	 */
	private String logoPic;
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
	 * 法定代表人身份证
	 */
	private String legalPersonCardId;
	/**
	 * 开户行账号名称
	 */
	private String bankUser;
	/**
	 * 是否渠道客户
	 */
	private String customers;
	/**
	 * 充值金额
	 */
	private String money;
	/**
	 * 订单列表
	 */
	private String orderlist;
	/**
	 * 职位
	 */
	private String jod;
	/**
	 * 类型
	 */
	private String type;
	/**
	 * 需求数量
	 */
	private String number;


}
