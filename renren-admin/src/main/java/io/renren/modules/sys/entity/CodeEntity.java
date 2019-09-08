package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 二维码管理
 * 
 * @author Mark
 * @email sunlightcs@gmail.com
 * @date 2019-08-28 10:10:41
 */
@Data
@TableName("tb_code")
public class CodeEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	/**
	 * ID
	 */
	@TableId
	private String qrcodeId;
	/**
	 * 广告主id
	 */
	private String advertisersId;
	/**
	 * 商家id
	 */
	private String sellerId;
	/**
	 * 活动id
	 */
	private String activityId;
	/**
	 * 参与类型
	 */
	private String activityType;
	/**
	 * 是否关注
	 */
	private String isFocus;
	/**
	 * 是否扫码
	 */
	private String isQr;
	/**
	 * 扫码用户id
	 */
	private String codeUser;
	/**
	 * 订单id
	 */
	private Long orderId;
	/**
	 * 订单详情id
	 */
	private Long orderdescId;
	/**
	 * 商家名字
	 */
	private String sellerName;
	/*
	* 广告主名字
	* */
	private String advertisersName;
	/*
	* 活动名字
	* */
	private String activityName;


}
