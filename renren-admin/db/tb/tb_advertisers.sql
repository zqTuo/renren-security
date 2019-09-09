CREATE TABLE `tb_advertisers` (
  `advertisers_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `name` varchar(80) DEFAULT NULL COMMENT '公司名',
  `password` varchar(60) DEFAULT NULL COMMENT '密码',
  `email` varchar(40) DEFAULT NULL COMMENT 'EMAIL',
  `mobile` varchar(20) DEFAULT NULL COMMENT '公司手机',
  `telephone` varchar(50) DEFAULT NULL COMMENT '公司电话',
  `status` varchar(1) DEFAULT '0' COMMENT '状态',
  `address_detail` varchar(100) DEFAULT NULL COMMENT '详细地址',
  `linkman_name` varchar(50) DEFAULT NULL COMMENT '联系人姓名',
  `linkman_qq` varchar(13) DEFAULT NULL COMMENT '联系人QQ',
  `linkman_mobile` varchar(20) DEFAULT NULL COMMENT '联系人电话',
  `linkman_email` varchar(40) DEFAULT NULL COMMENT '联系人EMAIL',
  `license_number` varchar(20) DEFAULT NULL COMMENT '营业执照号',
  `tax_number` varchar(20) DEFAULT NULL COMMENT '税务登记证号',
  `org_number` varchar(20) DEFAULT NULL COMMENT '组织机构代码',
  `address` varchar(50) DEFAULT NULL COMMENT '公司地址',
  `logo_pic` varchar(100) DEFAULT NULL COMMENT '公司LOGO图',
  `brief` varchar(2000) DEFAULT NULL COMMENT '简介',
  `create_time` datetime DEFAULT NULL COMMENT '创建日期',
  `legal_person` varchar(40) DEFAULT NULL COMMENT '法定代表人',
  `legal_person_card_id` varchar(25) DEFAULT NULL COMMENT '法定代表人身份证',
  `bank_user` varchar(50) DEFAULT NULL COMMENT '开户行账号名称',
  `customers` varchar(100) DEFAULT NULL COMMENT '是否渠道客户',
  `money` varchar(100) DEFAULT NULL COMMENT '充值金额',
  `orderList` varchar(100) DEFAULT NULL COMMENT '订单列表',
  `jod` varchar(100) DEFAULT NULL COMMENT '职位',
  `type` varchar(100) DEFAULT NULL COMMENT '类型',
  `number` bigint(20) DEFAULT NULL COMMENT '需求数量',
  PRIMARY KEY (`advertisers_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1169421353649045505 DEFAULT CHARSET=utf8 COMMENT='广告主'
