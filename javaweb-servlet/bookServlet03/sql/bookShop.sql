set names utf8mb4;
create database if not exists bookShop character set 'utf8mb4' collate 'utf8mb4_cs_0900_as_cs';
create user 'bookManager'@'%' identified by '123456';
grant all privileges on bookShop.* to 'bookShop'@'%' with grant option ;

#创建用户信息表
drop table if exists t_user;
CREATE TABLE t_user(
                       `id` INT  PRIMARY KEY AUTO_INCREMENT COMMENT '用户ID',
                       `username` VARCHAR(20) NOT NULL UNIQUE COMMENT '用户名',
                       `password` VARCHAR(32) NOT NULL COMMENT '密码',
                       `email` VARCHAR(200) COMMENT '邮箱'
) COMMENT '用户信息表';

#插入一些数据
insert into t_user (`username`,`password`,`email`) values('Curry','123456','test@vip.com');