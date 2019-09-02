CREATE TABLE `tb_code` (
  `code_id` bigint(50) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `advertisers_id` varchar(60) DEFAULT NULL COMMENT '广告主id',
  `seller_id` varchar(50) DEFAULT NULL COMMENT '商家id',
  `activity_id` varchar(50) DEFAULT '0' COMMENT '活动id',
  `activity_type` varchar(1) DEFAULT NULL COMMENT '参与类型',
  `is_focus` varchar(1) DEFAULT NULL COMMENT '是否关注',
  `is_qr` varchar(1) DEFAULT NULL COMMENT '是否扫码',
  `code_user` varchar(50) DEFAULT '0' COMMENT '扫码用户id',
  `status` varchar(1) DEFAULT '0' COMMENT 'null',
  `region` varchar(20) DEFAULT '0' COMMENT 'null',
  `address_detail` varchar(100) DEFAULT NULL COMMENT 'null',
  PRIMARY KEY (`code_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1168512803791835137 DEFAULT CHARSET=utf8 COMMENT='二维码管理'