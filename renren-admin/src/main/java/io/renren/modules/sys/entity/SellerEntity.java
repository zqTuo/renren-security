package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.renren.common.utils.poi.model.ExcelBean;
import lombok.Data;

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
	private Long sellerId;
	/**
	 * 店铺名称
	 */
	private String nickName;
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
	 * 公L司电话
	 */
	private String telephone;
	/**
	 * 状态
	 */
	private String status;
	/**
	 * 区域
	 */
	private String region;
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
	 * 职位
	 */
	private String linkmanJod;
	/**
	 * 是否连锁经营
	 */
	private String storeSize;
	/**
	 * 是否支持地推
	 */
	private String addressGround;
	/**
	 * 店面大小
	 */
	private String linkmanOperation;
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
	 * 奶茶店周边
	 */
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
	 * null
	 */

	/**
	 * 转化率
	 */
	private String conversionRate;

	public SellerEntity() {
	}

	public SellerEntity(Long sellerId, String nickName, String password, String email, String mobile, String telephone, String status, String region, String addressDetail, String linkmanName, String linkmanQq, String linkmanMobile, String linkmanEmail, String linkmanJod, String storeSize, String addressGround, String linkmanOperation, String licenseNumber, String taxNumber, String orgNumber, String address, String addressShop, String brief, Date createTime, String legalPerson, String addressDistance, String shopCategory, String shopLv , String conversionRate) {

		this.sellerId = sellerId;
		this.nickName = nickName;
		this.password = password;
		this.email = email;
		this.mobile = mobile;
		this.telephone = telephone;
		this.status = status;
		this.region = region;
		this.addressDetail = addressDetail;
		this.linkmanName = linkmanName;
		this.linkmanQq = linkmanQq;
		this.linkmanMobile = linkmanMobile;
		this.linkmanEmail = linkmanEmail;
		this.linkmanJod = linkmanJod;
		this.storeSize = storeSize;
		this.addressGround = addressGround;
		this.linkmanOperation = linkmanOperation;
		this.licenseNumber = licenseNumber;
		this.taxNumber = taxNumber;
		this.orgNumber = orgNumber;
		this.address = address;
		this.addressShop = addressShop;
		this.brief = brief;
		this.createTime = createTime;
		this.legalPerson = legalPerson;
		this.addressDistance = addressDistance;
		this.shopCategory = shopCategory;
		this.shopLv = shopLv;
		this.conversionRate = conversionRate;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getSellerId() {
		return sellerId;
	}

	public void setSellerId(Long sellerId) {
		this.sellerId = sellerId;
	}

	public String getNickName() {
		return nickName;
	}

	public void setNickName(String nickName) {
		this.nickName = nickName;
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

	public String getRegion() {
		return region;
	}

	public void setRegion(String region) {
		this.region = region;
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

	public String getLinkmanJod() {
		return linkmanJod;
	}

	public void setLinkmanJod(String linkmanJod) {
		this.linkmanJod = linkmanJod;
	}

	public String getStoreSize() {
		return storeSize;
	}

	public void setStoreSize(String storeSize) {
		this.storeSize = storeSize;
	}

	public String getAddressGround() {
		return addressGround;
	}

	public void setAddressGround(String addressGround) {
		this.addressGround = addressGround;
	}

	public String getLinkmanOperation() {
		return linkmanOperation;
	}

	public void setLinkmanOperation(String linkmanOperation) {
		this.linkmanOperation = linkmanOperation;
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

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddressShop() {
		return addressShop;
	}

	public void setAddressShop(String addressShop) {
		this.addressShop = addressShop;
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

	public String getAddressDistance() {
		return addressDistance;
	}

	public void setAddressDistance(String addressDistance) {
		this.addressDistance = addressDistance;
	}

	public String getShopCategory() {
		return shopCategory;
	}

	public void setShopCategory(String shopCategory) {
		this.shopCategory = shopCategory;
	}

	public String getShopLv() {
		return shopLv;
	}

	public void setShopLv(String shopLv) {
		this.shopLv = shopLv;
	}


	public String getConversionRate() {
		return conversionRate;
	}

	public void setConversionRate(String conversionRate) {
		this.conversionRate = conversionRate;
	}

	@Override
	public String toString() {
		return "SellerEntity{" +
				"sellerId='" + sellerId + '\'' +
				", nickName='" + nickName + '\'' +
				", password='" + password + '\'' +
				", email='" + email + '\'' +
				", mobile='" + mobile + '\'' +
				", telephone='" + telephone + '\'' +
				", status='" + status + '\'' +
				", region='" + region + '\'' +
				", addressDetail='" + addressDetail + '\'' +
				", linkmanName='" + linkmanName + '\'' +
				", linkmanQq='" + linkmanQq + '\'' +
				", linkmanMobile='" + linkmanMobile + '\'' +
				", linkmanEmail='" + linkmanEmail + '\'' +
				", linkmanJod='" + linkmanJod + '\'' +
				", storeSize='" + storeSize + '\'' +
				", addressGround='" + addressGround + '\'' +
				", linkmanOperation='" + linkmanOperation + '\'' +
				", licenseNumber='" + licenseNumber + '\'' +
				", taxNumber='" + taxNumber + '\'' +
				", orgNumber='" + orgNumber + '\'' +
				", address=" + address +
				", addressShop='" + addressShop + '\'' +
				", brief='" + brief + '\'' +
				", createTime=" + createTime +
				", legalPerson='" + legalPerson + '\'' +
				", addressDistance='" + addressDistance + '\'' +
				", shopCategory='" + shopCategory + '\'' +
				", shopLv='" + shopLv + '\'' +
				", conversionRate='" + conversionRate + '\'' +
				'}';
	}
}
