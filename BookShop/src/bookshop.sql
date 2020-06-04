/*
Navicat MySQL Data Transfer

Source Server         : localhost_3306
Source Server Version : 50714
Source Host           : localhost:3306
Source Database       : bookshop

Target Server Type    : MYSQL
Target Server Version : 50714
File Encoding         : 65001

Date: 2020-06-04 10:28:31
*/

SET FOREIGN_KEY_CHECKS=0;
-- ----------------------------
-- Table structure for `t_orderitem`
-- ----------------------------
DROP TABLE IF EXISTS `t_orderitem`;
CREATE TABLE `t_orderitem` (
  `id` int(11) NOT NULL,
  `order_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  `buynum` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_orderitem
-- ----------------------------

-- ----------------------------
-- Table structure for `t_orders`
-- ----------------------------
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

-- ----------------------------
-- Records of t_orders
-- ----------------------------

-- ----------------------------
-- Table structure for `t_product`
-- ----------------------------
DROP TABLE IF EXISTS `t_product`;
CREATE TABLE `t_product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(100) NOT NULL,
  `price` varchar(10) NOT NULL,
  `img_url` varchar(200) NOT NULL,
  `pnum` int(11) NOT NULL,
  `category` varchar(100) NOT NULL,
  `description` varchar(200) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=55 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_product
-- ----------------------------
INSERT INTO `t_product` VALUES ('30', '钱钟书集', '332.50', 'images/book/book_04.gif', '999', '5', 'ffffffffffff');
INSERT INTO `t_product` VALUES ('31', '赵俪生高昭—夫妻回忆录', '38.00', 'images/book/book_05.gif', '998', '5', 'fffffffffff');
INSERT INTO `t_product` VALUES ('32', '无聊斋', '28.00', 'images/book/book_06.gif', '998', '6', 'gggggggg');
INSERT INTO `t_product` VALUES ('33', '一颗热土豆是一张温馨的床', '38.00', 'images/book/book_07.gif', '999', '6', 'ggggggggggg');
INSERT INTO `t_product` VALUES ('34', '李戡戡乱记', '22.00', 'images/book/book_08.gif', '999', '7', 'hhhhhhhhh');
INSERT INTO `t_product` VALUES ('35', '生生世世未了缘', '17.50', 'images/book/book_09.gif', '999', '8', 'aaaaaaaaa');
INSERT INTO `t_product` VALUES ('36', '一生有多少爱', '17.50', 'images/book/book_10.gif', '944', '11', 'sssssss');
INSERT INTO `t_product` VALUES ('37', '悲惨世界', '39', 'D:\\BYB\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\work\\Catalina\\localhost\\BookShop\\upload_e7110080_8376_44d1_9de7_2e28d50a91ce_00000004.tmp', '1', '12', '仅供参考');
INSERT INTO `t_product` VALUES ('40', '苦儿流浪记', '123', 'D:\\BYB\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\work\\Catalina\\localhost\\BookShop\\upload_f3a00b96_7caa_4f3e_b63b_171dd2e212df_00000004.tmp', '11', '13', '课外阅读');
INSERT INTO `t_product` VALUES ('41', '活着', '39', 'D:\\BYB\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\work\\Catalina\\localhost\\BookShop\\upload_21a05891_3938_40e6_88fa_8bc4340a9b36_00000004.tmp', '1', '15', '万物皆可富贵');
INSERT INTO `t_product` VALUES ('52', '家宝大直男', '666', 'D:\\BYB\\.metadata\\.plugins\\org.eclipse.wst.server.core\\tmp0\\work\\Catalina\\localhost\\BookShop\\upload_b880fbdc_311f_45e1_a9dc_a2902083a2ba_00000010.tmp', '0', '14', '1234');
INSERT INTO `t_product` VALUES ('53', '家宝子', '1', 'G:\\桌面\\快捷\\壁纸.jpg', '1', '1', '11');

-- ----------------------------
-- Table structure for `t_user`
-- ----------------------------
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
  `telphone` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=15 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of t_user
-- ----------------------------
INSERT INTO `t_user` VALUES ('1', 'test3', 'aaaaaaaa', 'test@163.com', '', '', '1', '', '2020-04-30 19:29:18', null);
INSERT INTO `t_user` VALUES ('2', 'test2', 'aaaaaaaa', 'test2@163.com', '', '', '1', '', '2020-04-30 19:29:18', null);
INSERT INTO `t_user` VALUES ('3', 'test4', 'aaaaaaaa', 'test2@163.com', '', '', '1', '', '2020-04-30 19:29:18', null);
INSERT INTO `t_user` VALUES ('4', 'test007', '12312312', 'test007@aptech.com.cn', '', '', '1', '', '2020-04-30 19:29:18', null);
INSERT INTO `t_user` VALUES ('5', 'test321', 'aaaaaaaa', 'aa@com.cm', '', '', '1', '', '2020-04-30 19:29:18', null);
INSERT INTO `t_user` VALUES ('6', 'test008', 'aaaaaaaa', 'test008@1.c', '', '', '1', '', '2020-04-30 19:29:18', null);
INSERT INTO `t_user` VALUES ('7', 'user1', 'aaaaaaaa', 'user1@aptech.com.cn', '', '', '1', '', '2020-04-30 19:29:18', null);
INSERT INTO `t_user` VALUES ('8', 'test', 'test', 'test@test.com', '', '', '1', '', '2020-04-30 19:29:18', null);
INSERT INTO `t_user` VALUES ('9', 'user123', '12312312', 'user123@123.com', '', '', '1', '', '2020-04-30 19:29:18', null);
INSERT INTO `t_user` VALUES ('10', 'wangxiao', '12345678', '123@asd.com', '', '', '1', '', '2020-04-30 19:29:18', null);
INSERT INTO `t_user` VALUES ('11', 'admin', 'admin', 'admin@qq.com', '', '', '2', '', '2020-04-30 19:29:18', null);
INSERT INTO `t_user` VALUES ('12', '123', '12345678', '1184791118@qq.com', '', '', '1', '', '2020-04-30 19:29:18', null);
INSERT INTO `t_user` VALUES ('13', 'zhangjiabao', '12345678', '222@qq.com', '', '', '1', '', '2020-04-30 19:29:18', null);
INSERT INTO `t_user` VALUES ('14', 'yyyy', 'yyyyyyyy', 'yy@qq.com', '', '', '1', '', '2020-04-30 19:29:18', null);
