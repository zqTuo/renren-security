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

	/**
	 * 商家名字
	 */
	private String sellerName;

	/*
	* 广告主id
	* */
	private String advertisersId;
	/**
	 * 广告主名字名字
	 */
	private String advertisersName;

}
