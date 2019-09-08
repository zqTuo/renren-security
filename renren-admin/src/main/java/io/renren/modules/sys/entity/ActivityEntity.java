package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

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
	private String activityName;
	/**
	 * 是否关注
	 */
	private String isFocus;
	/**
	 * 是否扫码
	 */
	private String isQr;
	/**
	 * 活动链接
	 */
	private String activityAddress;

}
