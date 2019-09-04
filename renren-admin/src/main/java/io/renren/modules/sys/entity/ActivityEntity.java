package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 活动
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-28 10:20:59
 */
@Data
@TableName("tb_activity")
public class ActivityEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 活动ID
	 */
	@TableId
	private String activityId;
	/**
	 * 活动名称
	 */
	private String activityName;
	/**
	 * 是否关注
	 */
	private String isFocus;
	/**
	 * 商家id
	 */
	private String sellerId;
	/**
	 * 是否扫码
	 */
	private String isQr;
	/**
	 * 商家名字
	 */
	private String sellerName;


	public ActivityEntity() {
	}

	public ActivityEntity(String activityId, String activityName, String isFocus, String sellerId, String isQr, String status, String region, String addressDetail) {
		this.activityId = activityId;
		this.activityName = activityName;
		this.isFocus = isFocus;
		this.sellerId = sellerId;
		this.isQr = isQr;
		this.sellerName = sellerName;

	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public String getActivityId() {
		return activityId;
	}

	public void setActivityId(String activityId) {
		this.activityId = activityId;
	}

	public String getActivityName() {
		return activityName;
	}

	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}

	public String getIsFocus() {
		return isFocus;
	}

	public void setIsFocus(String isFocus) {
		this.isFocus = isFocus;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getIsQr() {
		return isQr;
	}

	public void setIsQr(String isQr) {
		this.isQr = isQr;
	}

	public String getSellerName() {
		return sellerName;
	}

	public void setSellerName(String status) {
		this.sellerName = sellerName;
	}


	@Override
	public String toString() {
		return "ActivityEntity{" +
				"activityId='" + activityId + '\'' +
				", activityName='" + activityName + '\'' +
				", isFocus='" + isFocus + '\'' +
				", sellerId='" + sellerId + '\'' +
				", isQr='" + isQr + '\'' +
				", sellerName='" + sellerName + '\'' +
				'}';
	}
}
