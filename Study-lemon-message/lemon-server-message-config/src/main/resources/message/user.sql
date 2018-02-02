/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.7.17-log : Database - lemon_user
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lemon_user` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `lemon_user`;

/*Table structure for table `lemon_user_info` */

DROP TABLE IF EXISTS `lemon_user_info`;

CREATE TABLE `lemon_user_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增ID',
  `user_id` varchar(50) NOT NULL COMMENT '用户的ID',
  `point` int(11) DEFAULT NULL COMMENT '积分项',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `field1` varchar(256) DEFAULT NULL COMMENT '扩容字段1',
  `field2` varchar(256) DEFAULT NULL COMMENT '扩容字段2',
  `field3` varchar(256) DEFAULT NULL COMMENT '扩容字段3',
  PRIMARY KEY (`id`),
  UNIQUE KEY `lemon_user_info_index` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

/*Table structure for table `lemon_user_message_log` */

DROP TABLE IF EXISTS `lemon_user_message_log`;

CREATE TABLE `lemon_user_message_log` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增ID',
  `message_id` varchar(100) NOT NULL COMMENT '消息消费记录',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `field1` varchar(256) DEFAULT NULL COMMENT '扩容字段1',
  `field2` varchar(256) DEFAULT NULL COMMENT '扩容字段2',
  `field3` varchar(256) DEFAULT NULL COMMENT '扩容字段3',
  PRIMARY KEY (`id`),
  UNIQUE KEY `lemon_user_message_log_index` (`message_id`)
) ENGINE=InnoDB AUTO_INCREMENT=855 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
