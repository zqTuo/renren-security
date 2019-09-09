CREATE TABLE `tb_code` (
  `qrCode_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `advertisers_id` varchar(60) DEFAULT NULL COMMENT '广告主id',
  `seller_id` varchar(50) DEFAULT NULL COMMENT '商家id',
  `activity_id` varchar(50) DEFAULT '0' COMMENT '活动id',
  `activity_type` varchar(1) DEFAULT NULL COMMENT '参与类型',
  `is_focus` varchar(1) DEFAULT NULL COMMENT '是否关注',
  `is_qr` varchar(1) DEFAULT NULL COMMENT '是否扫码',
  `code_user` varchar(50) DEFAULT '0' COMMENT '扫码用户id',
  `order_id` bigint(50) DEFAULT '0' COMMENT '订单编码',
  `orderDesc_id` bigint(50) DEFAULT '0' COMMENT '订单详情编码',
  `seller_name` varchar(50) DEFAULT NULL COMMENT '商家名称',
  `advertisers_name` varchar(50) DEFAULT NULL COMMENT '广告主名称',
  `activity_name` varchar(50) DEFAULT NULL COMMENT '活动名称',
  PRIMARY KEY (`qrCode_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1170878537104756737 DEFAULT CHARSET=utf8 COMMENT='二维码管理'