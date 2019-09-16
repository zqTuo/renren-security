package io.renren.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 押金
 *
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-09-10 16:23:30
 */
@Data
@TableName("tb_money")
public class MoneyEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 *
	 */
	@TableId
	private String moneyId;
	/**
	 * 商家id
	 */
	private String sellerId;
	/**
	 * 商家名字
	 */
	private String sellerName;
	/**
	 * 押金
	 */
	private String moneyYajin;
	/**
	 * 支付方式0 微信支付 1 支付宝支付
	 */
	private String moneyPay;
	/**
	 * 支付状态 0 已退款 1 未交押金 2 已交押金
	 */
	private String payStatus;
	/**
	 * 创建时间
	 */
	private Date createTime;

}
