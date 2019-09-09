CREATE TABLE `tb_order` (
  `order_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单id',
  `create_time` datetime DEFAULT NULL COMMENT '订单创建时间',
  `seller_id` varchar(100) COLLATE utf8_bin DEFAULT NULL COMMENT '商家ID',
  `advertisers_id` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '广告主id',
  `seller_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '商家名称',
  `advertisers_name` varchar(20) COLLATE utf8_bin DEFAULT NULL COMMENT '广告主名称',
  PRIMARY KEY (`order_id`),
  KEY `create_time` (`create_time`)
) ENGINE=InnoDB AUTO_INCREMENT=1170878537012482049 DEFAULT CHARSET=utf8 COLLATE=utf8_bin