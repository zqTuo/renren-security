package io.renren.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 奖金池
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-09-19 11:03:50
 */
@Data
@TableName("tb_bonus")
public class BonusEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long bonusId;
	/**
	 * 奖品名字
	 */
	private String bonusName;
	/**
	 * 奖品数量
	 */
	private Long bonusNum;
	/**
	 * 中奖的概率
	 */
	private String bonusGailv;
	/**
	 * 剩余的当前数量
	 */
	private Long currentNum;
	/**
	 * 活动id
	 */
	private String actitityId;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 更改时间
	 */
	private Date updateTime;
	/**
	 * 创建人的名字
	 */
	private String createmanagerName;
	/**
	 * 更改人的名字
	 */
	private String updatemanagerName;
	/**
	 * 图片地址
	 */
	private String picUrl;

	/**
	 * 活动地址
	 */
	private String activityUrl;

}
