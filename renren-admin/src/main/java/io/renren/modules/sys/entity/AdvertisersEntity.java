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
	private Long address;
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
	private Long number;

	public AdvertisersEntity() {
	}

	public AdvertisersEntity(String advertisersId, String name, String password, String email, String mobile, String telephone, String status, String addressDetail, String linkmanName, String linkmanQq, String linkmanMobile, String linkmanEmail, String licenseNumber, String taxNumber, String orgNumber, Long address, String logoPic, String brief, Date createTime, String legalPerson, String legalPersonCardId, String bankUser, String customers, String money, String orderlist, String jod, String type, Long number) {
		this.advertisersId = advertisersId;
		this.name = name;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.telephone = telephone;
		this.status = status;
		this.addressDetail = addressDetail;
		this.linkmanName = linkmanName;
		this.linkmanQq = linkmanQq;
		this.linkmanMobile = linkmanMobile;
		this.linkmanEmail = linkmanEmail;
		this.licenseNumber = licenseNumber;
		this.taxNumber = taxNumber;
		this.orgNumber = orgNumber;
		this.address = address;
		this.logoPic = logoPic;
		this.brief = brief;
		this.createTime = createTime;
		this.legalPerson = legalPerson;
		this.legalPersonCardId = legalPersonCardId;
		this.bankUser = bankUser;
		this.customers = customers;
		this.money = money;
		this.orderlist = orderlist;
		this.jod = jod;
		this.type = type;
		this.number = number;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getAdvertisersId() {
		return advertisersId;
	}

	public void setAdvertisersId(String advertisersId) {
		this.advertisersId = advertisersId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	public String getLinkmanName() {
		return linkmanName;
	}

	public void setLinkmanName(String linkmanName) {
		this.linkmanName = linkmanName;
	}

	public String getLinkmanQq() {
		return linkmanQq;
	}

	public void setLinkmanQq(String linkmanQq) {
		this.linkmanQq = linkmanQq;
	}

	public String getLinkmanMobile() {
		return linkmanMobile;
	}

	public void setLinkmanMobile(String linkmanMobile) {
		this.linkmanMobile = linkmanMobile;
	}

	public String getLinkmanEmail() {
		return linkmanEmail;
	}

	public void setLinkmanEmail(String linkmanEmail) {
		this.linkmanEmail = linkmanEmail;
	}

	public String getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(String licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getTaxNumber() {
		return taxNumber;
	}

	public void setTaxNumber(String taxNumber) {
		this.taxNumber = taxNumber;
	}

	public String getOrgNumber() {
		return orgNumber;
	}

	public void setOrgNumber(String orgNumber) {
		this.orgNumber = orgNumber;
	}

	public Long getAddress() {
		return address;
	}

	public void setAddress(Long address) {
		this.address = address;
	}

	public String getLogoPic() {
		return logoPic;
	}

	public void setLogoPic(String logoPic) {
		this.logoPic = logoPic;
	}

	public String getBrief() {
		return brief;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getLegalPerson() {
		return legalPerson;
	}

	public void setLegalPerson(String legalPerson) {
		this.legalPerson = legalPerson;
	}

	public String getLegalPersonCardId() {
		return legalPersonCardId;
	}

	public void setLegalPersonCardId(String legalPersonCardId) {
		this.legalPersonCardId = legalPersonCardId;
	}

	public String getBankUser() {
		return bankUser;
	}

	public void setBankUser(String bankUser) {
		this.bankUser = bankUser;
	}

	public String getCustomers() {
		return customers;
	}

	public void setCustomers(String customers) {
		this.customers = customers;
	}

	public String getMoney() {
		return money;
	}

	public void setMoney(String money) {
		this.money = money;
	}

	public String getOrderlist() {
		return orderlist;
	}

	public void setOrderlist(String orderlist) {
		this.orderlist = orderlist;
	}

	public String getJod() {
		return jod;
	}

	public void setJod(String jod) {
		this.jod = jod;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Long getNumber() {
		return number;
	}

	public void setNumber(Long number) {
		this.number = number;
	}

	@Override
	public String toString() {
		return "AdvertisersEntity{" +
				"advertisersId='" + advertisersId + '\'' +
				", name='" + name + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", mobile='" + mobile + '\'' +
				", telephone='" + telephone + '\'' +
				", status='" + status + '\'' +
				", addressDetail='" + addressDetail + '\'' +
				", linkmanName='" + linkmanName + '\'' +
				", linkmanQq='" + linkmanQq + '\'' +
				", linkmanMobile='" + linkmanMobile + '\'' +
				", linkmanEmail='" + linkmanEmail + '\'' +
				", licenseNumber='" + licenseNumber + '\'' +
				", taxNumber='" + taxNumber + '\'' +
				", orgNumber='" + orgNumber + '\'' +
				", address=" + address +
				", logoPic='" + logoPic + '\'' +
				", brief='" + brief + '\'' +
				", createTime=" + createTime +
				", legalPerson='" + legalPerson + '\'' +
				", legalPersonCardId='" + legalPersonCardId + '\'' +
				", bankUser='" + bankUser + '\'' +
				", customers='" + customers + '\'' +
				", money='" + money + '\'' +
				", orderlist='" + orderlist + '\'' +
				", jod='" + jod + '\'' +
				", type='" + type + '\'' +
				", number=" + number +
				'}';
	}
}
