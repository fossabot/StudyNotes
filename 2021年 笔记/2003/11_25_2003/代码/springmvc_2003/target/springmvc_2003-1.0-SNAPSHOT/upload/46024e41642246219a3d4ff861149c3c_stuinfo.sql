/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 5.5.56 : Database - studb
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`studb` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `studb`;

/*Table structure for table `stucourse` */

DROP TABLE IF EXISTS `stucourse`;

CREATE TABLE `stucourse` (
  `cno` char(4) NOT NULL,
  `cname` varchar(20) DEFAULT NULL,
  `credit` decimal(2,1) NOT NULL,
  `cteacher` char(5) DEFAULT NULL,
  PRIMARY KEY (`cno`),
  UNIQUE KEY `cname` (`cname`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stucourse` */

insert  into `stucourse`(`cno`,`cname`,`credit`,`cteacher`) values ('0001','大学计算机基础','2.0','周宁宁'),('0002','C语言程序设计','3.0','欧阳夏'),('0003','MySQL数据库应用','3.0','张秋丽'),('0004','英语','2.5','李斯文'),('0005','高等数学','2.0','王洁实'),('0006','数据结构','3.0','李佳佳');

/*Table structure for table `stuinfo` */

DROP TABLE IF EXISTS `stuinfo`;

CREATE TABLE `stuinfo` (
  `stuno` char(4) NOT NULL,
  `stuname` char(5) NOT NULL,
  `stusex` enum('男','女') DEFAULT NULL,
  `stubirthday` date DEFAULT NULL,
  `stuaddress` varchar(60) DEFAULT '地址不详',
  PRIMARY KEY (`stuno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stuinfo` */

insert  into `stuinfo`(`stuno`,`stuname`,`stusex`,`stubirthday`,`stuaddress`) values ('S001','刘卫平','男','1994-10-16','衡山市东风路78号'),('S002','张卫民','男','1995-08-11','地址不详'),('S003','马  东','男','1994-10-12','长岭市五一路785号'),('S004','钱达理','男','1995-02-01','滨海市洞庭大道278号'),('S005','东方牧','男','1994-11-07','东方市中山路25号'),('S006','郭文斌','男','1995-03-08','长岛市解放路25号'),('S007','肖海燕','女','1994-12-25','山南市红旗路15号'),('S008','张明华','女','1995-05-27','滨江市韶山路35号');

/*Table structure for table `stumarks` */

DROP TABLE IF EXISTS `stumarks`;

CREATE TABLE `stumarks` (
  `stuno` char(4) NOT NULL DEFAULT '',
  `cno` char(4) NOT NULL DEFAULT '',
  `stuscore` decimal(4,1) DEFAULT NULL,
  PRIMARY KEY (`stuno`,`cno`),
  KEY `cno` (`cno`),
  CONSTRAINT `stumarks_ibfk_1` FOREIGN KEY (`stuno`) REFERENCES `stuinfo` (`stuno`),
  CONSTRAINT `stumarks_ibfk_2` FOREIGN KEY (`cno`) REFERENCES `stucourse` (`cno`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `stumarks` */

insert  into `stumarks`(`stuno`,`cno`,`stuscore`) values ('S001','0001','80.0'),('S001','0002','90.0'),('S001','0003','87.0'),('S001','0004',NULL),('S001','0005','78.0'),('S002','0001','76.0'),('S002','0002','73.0'),('S002','0003','67.0'),('S002','0004',NULL),('S002','0005','89.0'),('S003','0001','83.0'),('S003','0002','73.0'),('S003','0003','84.0'),('S003','0004',NULL),('S003','0005','65.0'),('S004','0006','80.0');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
