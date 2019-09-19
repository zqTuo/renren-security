package io.renren.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 中奖记录
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-09-19 11:03:50
 */
@Data
@TableName("tb_bonus_log")
public class BonusLogEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long blId;
	/**
	 * 用户id
	 */
	private String userId;
	/**
	 * 二维码编号
	 */
	private String qrCode;
	/**
	 * 奖品id
	 */
	private String bonusId;
	/**
	 * 奖品名称
	 */
	private String bonusName;
	/**
	 * 状态 0:未兑换 1:已兑换
	 */
	private String status;
	/**
	 * 活动名字
	 */
	private String actitityName;
	/**
	 * 中奖时间
	 */
	private Date createTime;

}
