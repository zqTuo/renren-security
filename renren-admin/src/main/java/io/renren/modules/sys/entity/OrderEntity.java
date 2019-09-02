package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.math.BigDecimal;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-28 09:14:53
 */
@Data
@TableName("tb_order")
public class OrderEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 订单id
	 */
	@TableId
	private Long orderId;

	/**
	 * 订单创建时间
	 */
	private Date createTime;

	/**
	 * 商家ID
	 */
	private String sellerId;

	/*
	* 广告主id
	* */
	private String advertisersId;


	public OrderEntity() {
	}

	public OrderEntity(Long orderId, Date createTime, String sellerId, String advertisersId) {
		this.orderId = orderId;
		this.createTime = createTime;
		this.sellerId = sellerId;
		this.advertisersId = advertisersId;
	}

	public static long getSerialVersionUID() {
		return serialVersionUID;
	}

	public Long getOrderId() {
		return orderId;
	}

	public void setOrderId(Long orderId) {
		this.orderId = orderId;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public String getSellerId() {
		return sellerId;
	}

	public void setSellerId(String sellerId) {
		this.sellerId = sellerId;
	}

	public String getAdvertisersId() {
		return advertisersId;
	}

	public void setAdvertisersId(String advertisersId) {
		this.advertisersId = advertisersId;
	}

	@Override
	public String toString() {
		return "OrderEntity{" +
				"orderId=" + orderId +
				", createTime=" + createTime +
				", sellerId='" + sellerId + '\'' +
				", advertisersId='" + advertisersId + '\'' +
				'}';
	}
}
