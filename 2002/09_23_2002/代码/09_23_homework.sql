/*
SQLyog Ultimate v11.25 (64 bit)
MySQL - 5.5.56 : Database - homework_2002
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`homework_2002` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `homework_2002`;

/*Table structure for table `student2` */

DROP TABLE IF EXISTS `student2`;

CREATE TABLE `student2` (
  `id` int(11) DEFAULT NULL,
  `NAME` varchar(20) DEFAULT NULL,
  `chinese` float DEFAULT NULL,
  `english` float DEFAULT NULL,
  `math` float DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `student2` */

insert  into `student2`(`id`,`NAME`,`chinese`,`english`,`math`) values (1,'张小明',89,78,90),(2,'李进',67,53,95),(3,'王五',87,78,77),(4,'李一',88,98,92),(5,'李来财',82,84,67),(6,'张进宝',55,85,45),(7,'黄蓉',75,65,30);

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
