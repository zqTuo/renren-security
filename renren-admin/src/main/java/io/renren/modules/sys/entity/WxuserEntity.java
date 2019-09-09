package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * 用户表
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-09-09 17:06:46
 */
@Data
@TableName("tb_wxuser")
public class WxuserEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * 
	 */
	@TableId
	private Long id;
	/**
	 * 用户昵称
	 */
	private String userName;
	/**
	 * 用户头像
	 */
	private String userHead;
	/**
	 * openid
	 */
	private String userOpenid;
	/**
	 * unionid
	 */
	private String userUnionid;
	/**
	 * 上次登录IP地址
	 */
	private String userLastip;
	/**
	 * 上次登录时间
	 */
	private Date userLastlogintime;
	/**
	 * 是否关注公众号 1：已关注 0：未关注
	 */
	private Integer subscribe;
	/**
	 * 创建时间
	 */
	private Date createTime;
	/**
	 * 修改时间
	 */
	private Date updateTime;
	/**
	 * 修改管理员
	 */
	private String updateBy;

}
