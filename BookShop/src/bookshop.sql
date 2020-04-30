/*
SQLyog Ultimate v11.24 (32 bit)
MySQL - 5.7.9-log : Database - bookshop
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`bookshop` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `bookshop`;

/*Table structure for table `t_orderitem` */

DROP TABLE IF EXISTS `t_orderitem`;

CREATE TABLE `t_orderitem` (
  `id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `buynum` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `t_orderitem` */

/*Table structure for table `t_orders` */

DROP TABLE IF EXISTS `t_orders`;

CREATE TABLE `t_orders` (
  `id` int(11) NOT NULL,
  `money` double NOT NULL,
  `receiverName` varchar(20) DEFAULT NULL,
  `receiverPhone` varchar(20) DEFAULT NULL,
  `payState` int(11) DEFAULT NULL,
  `ordertime` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  `user_id` int(11) DEFAULT NULL,
  `receiverAddress` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `t_orders` */

/*Table structure for table `t_product` */

DROP TABLE IF EXISTS `t_product`;

CREATE TABLE `t_product` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `price` varchar(10) NOT NULL,
  `img_url` varchar(200) NOT NULL,
  `pnum` int(11) NOT NULL,
  `category` varchar(100) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `t_product` */

insert  into `t_product`(`id`,`name`,`price`,`img_url`,`pnum`,`category`,`description`) values (27,'泰戈尔诗集','18.00','images/book/book_01.gif',976,'文学','ffffff'),(28,'痕记','22.80','images/book/book_02.gif',977,'科学','fffffffff'),(29,'天堂之旅','25.00','images/book/book_03.gif',989,'呵呵','fffffffffff'),(30,'钱钟书集','332.50','images/book/book_04.gif',999,'aaa','ffffffffffff'),(31,'赵俪生高昭—夫妻回忆录','38.00','images/book/book_05.gif',998,'sss','fffffffffff'),(32,'无聊斋','28.00','images/book/book_06.gif',998,'ddd','gggggggg'),(33,'一颗热土豆是一张温馨的床','38.00','images/book/book_07.gif',999,'ccc','ggggggggggg'),(34,'李戡戡乱记','22.00','images/book/book_08.gif',999,'vvv','hhhhhhhhh'),(35,'生生世世未了缘','17.50','images/book/book_09.gif',999,'xxx','aaaaaaaaa'),(36,'一生有多少爱','17.50','images/book/book_10.gif',944,'vvv','sssssss');

/*Table structure for table `t_user` */

DROP TABLE IF EXISTS `t_user`;

CREATE TABLE `t_user` (
  `id` int(10) NOT NULL AUTO_INCREMENT,
  `username` varchar(50) NOT NULL,
  `password` varchar(50) NOT NULL,
  `email` varchar(50) NOT NULL,
  `telephone` varchar(20) NOT NULL,
  `introduce` varchar(100) NOT NULL,
  `role` int(11) NOT NULL DEFAULT '1',
  `gender` varchar(10) NOT NULL,
  `registerTime` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `t_user` */

insert  into `t_user`(`id`,`username`,`password`,`email`,`telephone`,`introduce`,`role`,`gender`,`registerTime`) values (1,'test3','aaaaaaaa','test@163.com','','',1,'','2020-04-30 19:29:18'),(2,'test2','aaaaaaaa','test2@163.com','','',1,'','2020-04-30 19:29:18'),(3,'test4','aaaaaaaa','test2@163.com','','',1,'','2020-04-30 19:29:18'),(4,'test007','12312312','test007@aptech.com.cn','','',1,'','2020-04-30 19:29:18'),(5,'test321','aaaaaaaa','aa@com.cm','','',1,'','2020-04-30 19:29:18'),(6,'test008','aaaaaaaa','test008@1.c','','',1,'','2020-04-30 19:29:18'),(7,'user1','aaaaaaaa','user1@aptech.com.cn','','',1,'','2020-04-30 19:29:18'),(8,'test','test','test@test.com','','',1,'','2020-04-30 19:29:18'),(9,'user123','12312312','user123@123.com','','',1,'','2020-04-30 19:29:18'),(10,'wangxiao','12345678','123@asd.com','','',1,'','2020-04-30 19:29:18'),(11,'admin','admin','admin@qq.com','','',1,'','2020-04-30 19:29:18'),(12,'123','12345678','1184791118@qq.com','','',1,'','2020-04-30 19:29:18'),(13,'zhangjiabao','12345678','222@qq.com','','',1,'','2020-04-30 19:29:18'),(14,'yyyy','yyyyyyyy','yy@qq.com','','',1,'','2020-04-30 19:29:18');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
