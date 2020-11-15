use ecommerce;

create table `tb_user`(

	`user_id` int(10) NOT NULL AUTO_INCREMENT,
    `name` varchar(32) DEFAULT NULL,
    `profile_image` varchar(1024) DEFAULT NULL,
	`email` varchar(1024) DEFAULT NULL,
	`gender` varchar(5) DEFAULT NULL,
    `user_type` int(2) NOT NULL DEFAULT '1' COMMENT '1.customer 2.merchant 3.admin',
    `time_created` datetime DEFAULT NULL,
    `time_updated` datetime DEFAULT NULL,
    primary key (`user_id`)
)ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8