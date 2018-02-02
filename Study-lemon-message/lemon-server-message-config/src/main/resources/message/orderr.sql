/*
SQLyog  v12.2.6 (64 bit)
MySQL - 5.7.17-log : Database - lemon_order
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`lemon_order` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `lemon_order`;

/*Table structure for table `lemon_order_info` */

DROP TABLE IF EXISTS `lemon_order_info`;

CREATE TABLE `lemon_order_info` (
  `id` bigint(11) NOT NULL AUTO_INCREMENT COMMENT '主键自增ID',
  `order_id` varchar(50) NOT NULL COMMENT '订单号',
  `user_id` varchar(50) NOT NULL COMMENT '用户的ID',
  `account` varchar(20) NOT NULL COMMENT '申请贷款金额',
  `status` varchar(20) NOT NULL COMMENT '状态：  待支付，支付成功，支付失败',
  `create_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '插入时间',
  `update_time` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  `field1` varchar(256) DEFAULT NULL COMMENT '扩容字段1',
  `field2` varchar(256) DEFAULT NULL COMMENT '扩容字段2',
  `field3` varchar(256) DEFAULT NULL COMMENT '扩容字段3',
  PRIMARY KEY (`id`),
  UNIQUE KEY `order_info_orderid_index` (`order_id`)
) ENGINE=InnoDB AUTO_INCREMENT=1187 DEFAULT CHARSET=utf8;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
