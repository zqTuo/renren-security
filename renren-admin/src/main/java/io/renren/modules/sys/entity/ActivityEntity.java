package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;
import java.util.Date;

/**
 * 活动·
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
	@NotBlank(message="活动名称不能为空")
	private String activityName;
	/**
	 * 是否关注
	 */
	@NotBlank(message="是否关注不能为空")
	private String isFocus;

	/**
	 * 活动链接
	 */
	@NotBlank(message="活动链接不能为空")
	private String activityAddress;

}
