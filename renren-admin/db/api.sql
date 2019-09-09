-- 微信用户表
create table tb_wxuser(
id BIGINT(20) AUTO_INCREMENT,
user_name VARCHAR(200) not null default '' COMMENT '用户昵称',
user_head VARCHAR(200) not null default '' COMMENT '用户头像',
user_openid VARCHAR(200) not null default '' COMMENT 'openid',
user_unionid VARCHAR(200) default '' COMMENT 'unionid',
user_lastIp VARCHAR(100) not NULL default '' COMMENT '上次登录IP地址',
user_lastLoginTime datetime not null comment '上次登录时间',
subscribe int not null default 0 comment '是否关注公众号 1：已关注 0：未关注',
create_time datetime not null COMMENT '创建时间',
update_time datetime COMMENT '修改时间',
update_by VARCHAR(100) default '' comment '修改管理员',
PRIMARY KEY(id)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户表';