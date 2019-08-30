package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 订单详情
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-30 17:53:00
 */
@Data
@TableName("tb_order_desc")
public class OrderDescEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 订单详情id
	 */
	@TableId
	private Long id;
	/**
	 * 商家名字
	 */
	private String sellerName;
	/**
	 * 二维码数量
	 */
	private Long num;
	/**
	 * 订单ID
	 */
	private Long orderId;
	/**
	 * 商家ID
	 */
	private Long sellerId;

//	活动id
	private Long activityId;

    public OrderDescEntity() {
    }

    public OrderDescEntity(Long id, String sellerName, Long num, Long orderId, Long sellerId, Long activityId) {
        this.id = id;
        this.sellerName = sellerName;
        this.num = num;
        this.orderId = orderId;
        this.sellerId = sellerId;
        this.activityId = activityId;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getSellerName() {
        return sellerName;
    }

    public void setSellerName(String sellerName) {
        this.sellerName = sellerName;
    }

    public Long getNum() {
        return num;
    }

    public void setNum(Long num) {
        this.num = num;
    }

    public Long getOrderId() {
        return orderId;
    }

    public void setOrderId(Long orderId) {
        this.orderId = orderId;
    }

    public Long getSellerId() {
        return sellerId;
    }

    public void setSellerId(Long sellerId) {
        this.sellerId = sellerId;
    }

    public Long getActivityId() {
        return activityId;
    }

    public void setActivityId(Long activityId) {
        this.activityId = activityId;
    }

    @Override
    public String toString() {
        return "OrderDescEntity{" +
                "id=" + id +
                ", sellerName='" + sellerName + '\'' +
                ", num=" + num +
                ", orderId=" + orderId +
                ", sellerId=" + sellerId +
                ", activityId=" + activityId +
                '}';
    }
}
