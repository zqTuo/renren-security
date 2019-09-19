package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 渠道用户管理
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-09-18 17:33:31
 */
@Data
@TableName("tb_qudaouser")
public class QudaouserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long qudaoId;
	/**
	 * 渠道类型  0：渠道用户 1：渠道公司
	 */
	private String qudaoType;
	/**
	 * 渠道名称
	 */
	private String qudaoName;
	/**
	 * 渠道码
	 */
	private String qudaoCode;

}
