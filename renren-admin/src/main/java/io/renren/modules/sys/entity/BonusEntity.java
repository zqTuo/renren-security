package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
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
	@NotBlank(message="奖品名字不能为空")
	private String bonusName;
	/**
	 * 奖品数量
	 */
	@NotBlank(message="奖品数量不能为空")
	private Long bonusNum;
	/**
	 * 中奖的概率
	 */
	@NotBlank(message="中奖的概率不能为空")
	private String bonusGailv;
	/**
	 * 剩余的当前数量
	 */

	private Long currentNum;
	/**
	 * 活动id
	 */

	private String orderId;
	/**
	 * 创建时间
	 */
	@NotBlank(message="创建时间不能为空")
	private Date createTime;
	/**
	 * 更改时间
	 */
	private Date updateTime;
	/**
	 * 创建人的名字
	 */
	@NotBlank(message="创建人的名字不能为空")
	private String createmanagerName;
	/**
	 * 更改人的名字
	 */
	private String updatemanagerName;
	/**
	 * 图片地址
	 */
	@NotBlank(message="活动图片不能为空")
	private String picUrl;

	/**
	 * 活动地址
	 */
	@NotBlank(message="活动地址不能为空")
	private String activityUrl;

}
