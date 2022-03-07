/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 5.5.56 : Database - jd
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`jd` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `jd`;

/*Table structure for table `goodstable` */

DROP TABLE IF EXISTS `goodstable`;

-- 商品表
CREATE TABLE `goodstable` (
  `id` int(4) NOT NULL AUTO_INCREMENT, -- 商品编号
  `name` varchar(30) NOT NULL, -- 商品名称
  `gtId` int(2) NOT NULL, -- 商品类别编号
  `price` double(10,2) NOT NULL, -- 商品价格
  `stock` int(11) NOT NULL, -- 商品库存
  `remarks` varchar(300) DEFAULT NULL, -- 商品备注
  PRIMARY KEY (`id`), -- 主键
  KEY `gtId` (`gtId`),
  CONSTRAINT `goodstable_ibfk_1` FOREIGN KEY (`gtId`) REFERENCES `goodstype` (`id`) -- 外键
) ENGINE=InnoDB AUTO_INCREMENT=1009 DEFAULT CHARSET=utf8;

/*Data for the table `goodstable` */

insert  into `goodstable`(`id`,`name`,`gtId`,`price`,`stock`,`remarks`) values (1001,'天津麻花',1,188.00,100,'富有丰富的防腐剂,开袋即食'),(1002,'旺仔小窝窝',1,9.80,1000,'开袋即食'),(1003,'兰州瓷砖',2,188.00,10000,'坚硬耐磨'),(1004,'吊床',3,1880.00,100,'柔软舒适'),(1005,'水床',3,588.00,100,'冬冷夏凉'),(1006,'止疼片',4,8.00,100,'开袋即食'),(1007,'感冒药',4,15.00,100,'开袋即食'),(1008,'红牛',4,5.50,100,'开袋即食');

/*Table structure for table `goodstype` */

DROP TABLE IF EXISTS `goodstype`;

-- 商品类别表
CREATE TABLE `goodstype` (
  `id` int(2) NOT NULL AUTO_INCREMENT,  -- 商品类别编号
  `name` varchar(30) NOT NULL, -- 商品类别名称
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

/*Data for the table `goodstype` */

insert  into `goodstype`(`id`,`name`) values (1,'食品类'),(2,'建材类'),(3,'家具类'),(4,'药品类'),(5,'服装类');

/*Table structure for table `usertable` */

DROP TABLE IF EXISTS `usertable`;

-- 用户表
CREATE TABLE `usertable` (
  `id` int(4) NOT NULL AUTO_INCREMENT, -- 用户编号
  `name` varchar(30) NOT NULL, -- 用户名
  `password` varchar(30) NOT NULL, -- 密码 
  PRIMARY KEY (`id`) -- 主键
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

/*Data for the table `usertable` */

insert  into `usertable`(`id`,`name`,`password`) values (1001,'admin','1'),(1002,'liyang','1');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
