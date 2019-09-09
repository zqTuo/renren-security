CREATE TABLE `tb_activity` (
  `activity_id` bigint(30) NOT NULL AUTO_INCREMENT COMMENT '活动ID',
  `activity_name` varchar(50) DEFAULT NULL COMMENT '活动名称',
  `is_focus` varchar(20) DEFAULT NULL COMMENT '是否关注',
  `is_qr` varchar(20) DEFAULT NULL COMMENT '是否扫码',
  `activity_address` varchar(20) DEFAULT '0' COMMENT '活动链接',
  PRIMARY KEY (`activity_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1169444015054127106 DEFAULT CHARSET=utf8 COMMENT='活动'