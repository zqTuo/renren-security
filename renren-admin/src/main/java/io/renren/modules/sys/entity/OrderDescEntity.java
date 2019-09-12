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
	private String id;
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
	private String orderId;
	/**
	 * 商家ID
	 */
	private String sellerId;

//	活动id
	private String activityId;


}
