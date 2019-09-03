package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 二维码管理
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-28 10:10:41
 */
@Data
@TableName("tb_code")
public class CodeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private Long codeId;
	/**
	 * 广告主id
	 */
	private String advertisersId;
	/**
	 * 商家id
	 */
	private String sellerId;
	/**
	 * 活动id
	 */
	private String activityId;
	/**
	 * 参与类型
	 */
	private String activityType;
	/**
	 * 是否关注
	 */
	private String isFocus;
	/**
	 * 是否扫码
	 */
	private String isQr;
	/**
	 * 扫码用户id
	 */
	private String codeUser;
	/**
	 * 订单id
	 */
	private String orderId;
	/**
	 * 订单详情id
	 */
	private String orderdescId;
	/**
	 * null
	 */
	private String addressDetail;

	public CodeEntity() {
	}

	public CodeEntity(Long codeId, String advertisersId, String sellerId, String activityId, String activityType, String isFocus, String isQr, String codeUser, String orderId, String orderdescId, String addressDetail) {
		this.codeId = codeId;
		this.advertisersId = advertisersId;
		this.sellerId = sellerId;
		this.activityId = activityId;
		this.activityType = activityType;
		this.isFocus = isFocus;
		this.isQr = isQr;
		this.codeUser = codeUser;
		this.orderId = orderId;
		this.orderdescId = orderdescId;
		this.addressDetail = addressDetail;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getCodeId() {
		return codeId;
	}

	public void setCodeId(Long codeId) {
		this.codeId = codeId;
	}

	public String getAdvertisersId() {
		return advertisersId;
	}

	public void setAdvertisersId(String advertisersId) {
		this.advertisersId = advertisersId;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getActivityType() {
		return activityType;
	}

	public void setActivityType(String activityType) {
		this.activityType = activityType;
	}

	public String getIsFocus() {
		return isFocus;
	}

	public void setIsFocus(String isFocus) {
		this.isFocus = isFocus;
	}

	public String getIsQr() {
		return isQr;
	}

	public void setIsQr(String isQr) {
		this.isQr = isQr;
	}

	public String getCodeUser() {
		return codeUser;
	}

	public void setCodeUser(String codeUser) {
		this.codeUser = codeUser;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getOrderdescId() {
		return orderdescId;
	}

	public void setOrderdescId(String orderdescId) {
		this.orderdescId = orderdescId;
	}

	public String getAddressDetail() {
		return addressDetail;
	}

	public void setAddressDetail(String addressDetail) {
		this.addressDetail = addressDetail;
	}

	@Override
	public String toString() {
		return "CodeEntity{" +
				"codeId=" + codeId +
				", advertisersId='" + advertisersId + '\'' +
				", sellerId='" + sellerId + '\'' +
				", activityId='" + activityId + '\'' +
				", activityType='" + activityType + '\'' +
				", isFocus='" + isFocus + '\'' +
				", isQr='" + isQr + '\'' +
				", codeUser='" + codeUser + '\'' +
				", orderId='" + orderId + '\'' +
				", orderdescId='" + orderdescId + '\'' +
				", addressDetail='" + addressDetail + '\'' +
				'}';
	}
}
