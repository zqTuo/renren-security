CREATE TABLE `tb_order_desc` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '订单详情id',
  `seller_name` varchar(50) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '商家名字',
  `num` bigint(20) DEFAULT NULL COMMENT '二维码数量',
  `order_id` bigint(20) DEFAULT NULL COMMENT '订单ID',
  `seller_id` bigint(20) DEFAULT NULL COMMENT '商家ID',
  `activity_id` bigint(20) DEFAULT NULL COMMENT '活动id',
  PRIMARY KEY (`id`),
  KEY `order_id` (`order_id`),
  CONSTRAINT `tb_order_desc_ibfk_1` FOREIGN KEY (`order_id`) REFERENCES `tb_order` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1168512803741503489 DEFAULT CHARSET=utf8 COMMENT='订单详情'
