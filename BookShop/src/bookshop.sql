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

/*Table structure for table `books` */

DROP TABLE IF EXISTS `books`;

CREATE TABLE `books` (
  `BID` int(11) NOT NULL,
  `BOOKNAME` varchar(100) NOT NULL,
  `B_PRICE` varchar(10) NOT NULL,
  `IMAGE` varchar(200) NOT NULL,
  `STOCK` int(11) NOT NULL,
  PRIMARY KEY (`BID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `books` */

insert  into `books`(`BID`,`BOOKNAME`,`B_PRICE`,`IMAGE`,`STOCK`) values (27,'泰戈尔诗集','18.00','images/book/book_01.gif',976),(28,'痕记','22.80','images/book/book_02.gif',977),(29,'天堂之旅','25.00','images/book/book_03.gif',989),(30,'钱钟书集','332.50','images/book/book_04.gif',999),(31,'赵俪生高昭—夫妻回忆录','38.00','images/book/book_05.gif',998),(32,'无聊斋','28.00','images/book/book_06.gif',998),(33,'一颗热土豆是一张温馨的床','38.00','images/book/book_07.gif',999),(34,'李戡戡乱记','22.00','images/book/book_08.gif',999),(35,'生生世世未了缘','17.50','images/book/book_09.gif',999),(36,'一生有多少爱','17.50','images/book/book_10.gif',944);

/*Table structure for table `items` */

DROP TABLE IF EXISTS `items`;

CREATE TABLE `items` (
  `IID` int(11) NOT NULL,
  `OID` int(11) NOT NULL,
  `BID` int(11) NOT NULL,
  `CREATEDATE` varchar(50) NOT NULL,
  `COUNT` int(11) NOT NULL,
  `PRICE` varchar(50) NOT NULL,
  `STATE` int(11) NOT NULL,
  `TOTAL_PRICE` varchar(50) NOT NULL,
  PRIMARY KEY (`IID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `items` */

insert  into `items`(`IID`,`OID`,`BID`,`CREATEDATE`,`COUNT`,`PRICE`,`STATE`,`TOTAL_PRICE`) values (84,81,31,'2010-11-18 10:24:15',4,'152',0,'605.1'),(82,81,29,'2010-11-18 10:24:15',3,'75',0,'605.1'),(83,81,30,'2010-11-18 10:24:15',1,'332.5',0,'605.1'),(81,81,28,'2010-11-18 10:24:15',2,'45.6',0,'605.1'),(65,61,32,'2010-11-15 10:12:05',1,'28',0,'143.5'),(61,61,33,'2010-11-15 10:12:05',1,'38',0,'143.5'),(64,61,31,'2010-11-15 10:12:05',1,'38',0,'143.5'),(62,61,34,'2010-11-15 10:12:05',1,'22',0,'143.5'),(63,61,35,'2010-11-15 10:12:05',1,'17.5',0,'143.5'),(1001,1001,27,'2013-04-07 19:25:21',1,'18',0,'18'),(1002,1002,27,'2013-04-07 19:58:54',4,'72',0,'72'),(1004,1004,27,'2013-04-07 20:09:30',1,'18',0,'40.8'),(1005,1004,28,'2013-04-07 20:09:30',1,'22.8',0,'40.8'),(1006,1005,28,'2013-04-07 20:37:42',4,'91.2',0,'91.2'),(1003,1003,27,'2013-04-07 20:00:33',1,'18',0,'18');

/*Table structure for table `orders` */

DROP TABLE IF EXISTS `orders`;

CREATE TABLE `orders` (
  `OID` int(11) NOT NULL,
  `USERNAME` varchar(50) NOT NULL,
  PRIMARY KEY (`OID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

/*Data for the table `orders` */

insert  into `orders`(`OID`,`USERNAME`) values (81,'test'),(61,'test'),(1001,'test'),(1002,'test'),(1004,'test'),(1005,'wangxiao'),(1003,'test');

/*Table structure for table `userinfo` */

DROP TABLE IF EXISTS `userinfo`;

CREATE TABLE `userinfo` (
  `ID` int(10) NOT NULL AUTO_INCREMENT,
  `USERNAME` varchar(50) NOT NULL,
  `PASSWORD` varchar(50) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

/*Data for the table `userinfo` */

insert  into `userinfo`(`ID`,`USERNAME`,`PASSWORD`,`EMAIL`) values (1,'test3','aaaaaaaa','test@163.com'),(2,'test2','aaaaaaaa','test2@163.com'),(3,'test4','aaaaaaaa','test2@163.com'),(4,'test007','12312312','test007@aptech.com.cn'),(5,'test321','aaaaaaaa','aa@com.cm'),(6,'test008','aaaaaaaa','test008@1.c'),(7,'user1','aaaaaaaa','user1@aptech.com.cn'),(8,'test','test','test@test.com'),(9,'user123','12312312','user123@123.com'),(10,'wangxiao','12345678','123@asd.com'),(11,'admin','admin','admin@qq.com'),(12,'123','12345678','1184791118@qq.com'),(13,'zhangjiabao','12345678','222@qq.com'),(14,'yyyy','yyyyyyyy','yy@qq.com');

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
