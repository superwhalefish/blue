/*
Navicat MySQL Data Transfer

Source Server         : yy
Source Server Version : 50725
Source Host           : rm-wz945r62i2q3gk936do.mysql.rds.aliyuncs.com:3306
Source Database       : gg

Target Server Type    : MYSQL
Target Server Version : 50725
File Encoding         : 65001

Date: 2019-12-20 11:46:24
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for adress
-- ----------------------------
DROP TABLE IF EXISTS `adress`;
CREATE TABLE `adress` (
  `aid` int(11) NOT NULL,
  `aadress` varchar(255) DEFAULT NULL,
  `astatus` varchar(255) DEFAULT NULL,
  `aid_uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`aid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of adress
-- ----------------------------

-- ----------------------------
-- Table structure for comment
-- ----------------------------
DROP TABLE IF EXISTS `comment`;
CREATE TABLE `comment` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `content` varchar(255) DEFAULT NULL,
  `pshopid` varchar(255) DEFAULT NULL,
  `cid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of comment
-- ----------------------------
INSERT INTO `comment` VALUES ('1', '质量很好，价格也很实惠，好评', '20191125171009', '1');
INSERT INTO `comment` VALUES ('2', '质量很好，价格也很实惠，下次还来买', '20191125171009', '1');

-- ----------------------------
-- Table structure for consumer
-- ----------------------------
DROP TABLE IF EXISTS `consumer`;
CREATE TABLE `consumer` (
  `cid` int(11) NOT NULL,
  `cadressid` int(11) DEFAULT NULL,
  `cbirthday` varchar(255) DEFAULT NULL,
  `cerrortimes` int(11) DEFAULT NULL,
  `clasterrortime` varchar(255) DEFAULT NULL,
  `clasttome` varchar(255) DEFAULT NULL,
  `clockstatus` int(11) DEFAULT NULL,
  `clocktime` varchar(255) DEFAULT NULL,
  `cmail` varchar(255) DEFAULT NULL,
  `cname` varchar(255) DEFAULT NULL,
  `cpwd` varchar(255) DEFAULT NULL,
  `crname` varchar(255) DEFAULT NULL,
  `csex` varchar(255) DEFAULT NULL,
  `ctel` varchar(255) DEFAULT NULL,
  `cvipid` int(11) DEFAULT NULL,
  `code` varchar(255) DEFAULT NULL,
  `codetime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of consumer
-- ----------------------------
INSERT INTO `consumer` VALUES ('7', null, null, null, null, null, '2', null, 'superwhalefish@163.com', 'whale', '123', null, '男', '1234567899', null, null, null);
INSERT INTO `consumer` VALUES ('8', null, null, '1', null, '2019-12-12 16:13:13', '2', null, 'superwhalefish@163.com', 'blue', '123', null, '男', '123', null, null, null);
INSERT INTO `consumer` VALUES ('9', null, null, null, null, null, '2', null, 'superwhalefish@163.com', 'haha', '111', null, '男', '1234567899', null, null, null);

-- ----------------------------
-- Table structure for discountcoupon
-- ----------------------------
DROP TABLE IF EXISTS `discountcoupon`;
CREATE TABLE `discountcoupon` (
  `yid` int(11) NOT NULL AUTO_INCREMENT,
  `yname` varchar(255) DEFAULT NULL,
  `yid_product` int(11) DEFAULT NULL,
  `ystartime` varchar(255) DEFAULT NULL,
  `yendtime` varchar(255) DEFAULT NULL,
  `ynum` int(11) DEFAULT NULL,
  `yid_pshop` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`yid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of discountcoupon
-- ----------------------------

-- ----------------------------
-- Table structure for hibernate_sequence
-- ----------------------------
DROP TABLE IF EXISTS `hibernate_sequence`;
CREATE TABLE `hibernate_sequence` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of hibernate_sequence
-- ----------------------------
INSERT INTO `hibernate_sequence` VALUES ('10');
INSERT INTO `hibernate_sequence` VALUES ('10');
INSERT INTO `hibernate_sequence` VALUES ('10');
INSERT INTO `hibernate_sequence` VALUES ('10');
INSERT INTO `hibernate_sequence` VALUES ('10');

-- ----------------------------
-- Table structure for orderinfo
-- ----------------------------
DROP TABLE IF EXISTS `orderinfo`;
CREATE TABLE `orderinfo` (
  `ordid` int(11) NOT NULL AUTO_INCREMENT,
  `ordnumber` varchar(255) DEFAULT NULL,
  `pid` int(11) DEFAULT NULL,
  `pnum` int(11) DEFAULT NULL COMMENT '商品数量',
  `rcolor` varchar(255) DEFAULT NULL,
  `rtype` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ordid`)
) ENGINE=InnoDB AUTO_INCREMENT=34 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orderinfo
-- ----------------------------
INSERT INTO `orderinfo` VALUES ('1', '201712030812', '1', '1', '白色', 'MM');
INSERT INTO `orderinfo` VALUES ('2', '201712030838', '2', '1', '黑色', 'LL');
INSERT INTO `orderinfo` VALUES ('3', '201712030837', '2', '2', '黑色', 'LL');
INSERT INTO `orderinfo` VALUES ('11', '20191212163247', '1', '2', '绿色', 'MM');
INSERT INTO `orderinfo` VALUES ('12', '20191212163327', '1', '1', '绿色', 'SS');
INSERT INTO `orderinfo` VALUES ('13', '20191212163950', '1', '1', '绿色', 'SS');
INSERT INTO `orderinfo` VALUES ('14', '20191212164113', '1', '1', '绿色', 'MM');
INSERT INTO `orderinfo` VALUES ('15', '20191212164204', '4', '2', '白色', 'SS');
INSERT INTO `orderinfo` VALUES ('16', '20191212164357', '4', '4', '白色', 'SS');
INSERT INTO `orderinfo` VALUES ('17', '20191212164450', '1', '6', '绿色', 'MM');
INSERT INTO `orderinfo` VALUES ('18', '20191212164541', '4', '3', '白色', 'SS');
INSERT INTO `orderinfo` VALUES ('19', '20191212164604', '1', '1', '绿色', 'MM');
INSERT INTO `orderinfo` VALUES ('20', '20191212164801', '1', '2', '绿色', 'MM');
INSERT INTO `orderinfo` VALUES ('21', '20191212164803', '1', '2', '绿色', 'MM');
INSERT INTO `orderinfo` VALUES ('22', '20191212164820', '1', '2', '绿色', 'SS');
INSERT INTO `orderinfo` VALUES ('23', '20191212164822', '1', '2', '绿色', 'SS');
INSERT INTO `orderinfo` VALUES ('24', '20191212164822', '1', '2', '绿色', 'SS');
INSERT INTO `orderinfo` VALUES ('25', '20191212164822', '1', '2', '绿色', 'SS');
INSERT INTO `orderinfo` VALUES ('26', '20191212164838', '1', '1', '绿色', 'SS');
INSERT INTO `orderinfo` VALUES ('27', '20191212164854', '1', '1', '绿色', 'MM');
INSERT INTO `orderinfo` VALUES ('28', '20191212164923', '1', '8', '黑色', 'MM');
INSERT INTO `orderinfo` VALUES ('29', '20191212164940', '1', '2', '绿色', 'MM');
INSERT INTO `orderinfo` VALUES ('30', '20191212165100', '1', '2', '绿色', 'SS');
INSERT INTO `orderinfo` VALUES ('31', '20191212170108', '4', '7', '白色', 'SS');
INSERT INTO `orderinfo` VALUES ('32', '20191212170217', '1', '1', '绿色', 'SS');
INSERT INTO `orderinfo` VALUES ('33', '20191212170343', '1', '1', '绿色', 'SS');

-- ----------------------------
-- Table structure for orders
-- ----------------------------
DROP TABLE IF EXISTS `orders`;
CREATE TABLE `orders` (
  `oid` int(11) NOT NULL AUTO_INCREMENT,
  `ordnumber` varchar(255) DEFAULT NULL,
  `ocid` int(11) DEFAULT NULL,
  `consignee` varchar(255) DEFAULT NULL,
  `oadress` varchar(255) DEFAULT NULL,
  `otel` varchar(255) DEFAULT NULL,
  `opaystatus` varchar(255) DEFAULT NULL,
  `opayway` varchar(255) DEFAULT NULL,
  `ofhstatus` varchar(255) DEFAULT NULL,
  `ojsstatus` varchar(255) DEFAULT NULL,
  `xordtime` varchar(255) DEFAULT NULL,
  `fordtime` varchar(255) DEFAULT NULL,
  `jsordtime` varchar(255) DEFAULT NULL,
  `pjstatus` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`oid`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of orders
-- ----------------------------
INSERT INTO `orders` VALUES ('1', '201712030837', '1', '张三', '不急', '13513513555', '未付款', '微信', '未发货', '未收货', '2019-11-13 06:58:22', '2019-12-11 18:43:59', '2019-11-21 08:44:25', '未评价');
INSERT INTO `orders` VALUES ('2', '201712030838', '1', '张三', ' ', null, '未付款', '微信', '未发货', '未收货', '2019-11-13 06:58:22', '2019-12-11 18:18:41', null, null);
INSERT INTO `orders` VALUES ('14', '20191212163247', '1', '张三', '不知道', '11111111111', '未付款', '微信', null, null, '2019-12-12 16:32:47', null, null, null);
INSERT INTO `orders` VALUES ('15', '20191212163327', '1', '张三', '不知道', '11111111111', '未付款', '微信', null, null, '2019-12-12 16:33:27', null, null, null);
INSERT INTO `orders` VALUES ('16', '20191212163950', '1', '张三', '不知道', '11111111111', '未付款', '微信', null, null, '2019-12-12 16:39:50', null, null, null);
INSERT INTO `orders` VALUES ('17', '20191212164113', '1', '张三', '不知道', '11111111111', '未付款', '微信', null, null, '2019-12-12 16:41:13', null, null, null);
INSERT INTO `orders` VALUES ('18', '20191212164204', '1', '张三', '不知道', '11111111111', '未付款', '微信', null, null, '2019-12-12 16:42:04', null, null, null);
INSERT INTO `orders` VALUES ('19', '20191212164357', '1', '张三', '不知道', '11111111111', '未付款', '微信', null, null, '2019-12-12 16:43:57', null, null, null);
INSERT INTO `orders` VALUES ('20', '20191212164450', '1', '张三', '不知道', '11111111111', '未付款', '微信', null, null, '2019-12-12 16:44:50', null, null, null);
INSERT INTO `orders` VALUES ('21', '20191212164541', '1', '张三', '不知道', '11111111111', '未付款', '微信', null, null, '2019-12-12 16:45:41', null, null, null);
INSERT INTO `orders` VALUES ('22', '20191212164604', '1', '张三', '不知道', '11111111111', '未付款', '微信', null, null, '2019-12-12 16:46:04', null, null, null);
INSERT INTO `orders` VALUES ('23', '20191212164801', '1', '张三', '不知道', '11111111111', '未付款', '微信', null, null, '2019-12-12 16:48:01', null, null, null);
INSERT INTO `orders` VALUES ('24', '20191212164803', '1', '张三', '不知道', '11111111111', '未付款', '微信', null, null, '2019-12-12 16:48:03', null, null, null);
INSERT INTO `orders` VALUES ('25', '20191212164820', '1', '张三', '不知道', '11111111111', '未付款', '微信', null, null, '2019-12-12 16:48:20', null, null, null);
INSERT INTO `orders` VALUES ('26', '20191212164822', '1', '张三', '不知道', '11111111111', '未付款', '微信', null, null, '2019-12-12 16:48:22', null, null, null);
INSERT INTO `orders` VALUES ('27', '20191212164822', '1', '张三', '不知道', '11111111111', '未付款', '微信', null, null, '2019-12-12 16:48:22', null, null, null);
INSERT INTO `orders` VALUES ('28', '20191212164822', '1', '张三', '不知道', '11111111111', '未付款', '微信', null, null, '2019-12-12 16:48:22', null, null, null);
INSERT INTO `orders` VALUES ('29', '20191212164838', '1', '张三', '不知道', '11111111111', '未付款', '微信', null, null, '2019-12-12 16:48:38', null, null, null);
INSERT INTO `orders` VALUES ('30', '20191212164854', '1', '张三', '不知道', '11111111111', '未付款', '微信', null, null, '2019-12-12 16:48:54', null, null, null);
INSERT INTO `orders` VALUES ('31', '20191212164923', '1', '张三', '不知道', '11111111111', '未付款', '微信', null, null, '2019-12-12 16:49:23', null, null, null);
INSERT INTO `orders` VALUES ('32', '20191212164940', '1', '张三', '不知道', '11111111111', '未付款', '微信', null, null, '2019-12-12 16:49:40', null, null, null);
INSERT INTO `orders` VALUES ('33', '20191212165100', '1', '张三', '不知道', '11111111111', '未付款', '微信', null, null, '2019-12-12 16:51:00', null, null, null);
INSERT INTO `orders` VALUES ('34', '20191212170108', '1', '张三', '不知道', '11111111111', '未付款', '微信', null, null, '2019-12-12 17:01:08', null, null, null);
INSERT INTO `orders` VALUES ('35', '20191212170217', '1', '张三', '不知道', '11111111111', '未付款', '微信', null, null, '2019-12-12 17:02:17', null, null, null);
INSERT INTO `orders` VALUES ('36', '20191212170343', '1', '张三', '不知道', '11111111111', '未付款', '微信', null, null, '2019-12-12 17:03:43', null, null, null);

-- ----------------------------
-- Table structure for product
-- ----------------------------
DROP TABLE IF EXISTS `product`;
CREATE TABLE `product` (
  `pid` int(11) NOT NULL AUTO_INCREMENT,
  `pname` varchar(255) DEFAULT NULL,
  `pprice` double DEFAULT NULL,
  `clicknum` int(11) DEFAULT NULL,
  `pshopid` varchar(255) DEFAULT NULL,
  `istui` varchar(255) DEFAULT NULL,
  `cpid` int(11) DEFAULT NULL,
  `pstatus` int(11) DEFAULT NULL,
  `ptstatus` int(11) DEFAULT NULL,
  `uptime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`pid`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of product
-- ----------------------------
INSERT INTO `product` VALUES ('1', '韩式风衣', '20', '77', '20191125171009', '1', '1', '1', '2', '2019-11-25 17:10:09');
INSERT INTO `product` VALUES ('2', '大衣', '40', '23', '20191125171012', '2', '1', '2', '2', '2019-12-04 09:28:13');
INSERT INTO `product` VALUES ('3', '女生秋衣', '56', '56', '20191125171011', '2', '6', '2', '2', '2019-11-25 17:10:09');
INSERT INTO `product` VALUES ('4', '毛呢外套', '180', '165', '20191125171010', '1', '1', '1', '1', '2019-12-04 09:31:47');

-- ----------------------------
-- Table structure for productcategroy
-- ----------------------------
DROP TABLE IF EXISTS `productcategroy`;
CREATE TABLE `productcategroy` (
  `cpid` int(11) NOT NULL AUTO_INCREMENT,
  `cpname` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`cpid`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of productcategroy
-- ----------------------------
INSERT INTO `productcategroy` VALUES ('1', '风衣');
INSERT INTO `productcategroy` VALUES ('2', '毛衣');
INSERT INTO `productcategroy` VALUES ('3', '运动裤');
INSERT INTO `productcategroy` VALUES ('6', '秋衣');

-- ----------------------------
-- Table structure for productimg
-- ----------------------------
DROP TABLE IF EXISTS `productimg`;
CREATE TABLE `productimg` (
  `iid` int(11) NOT NULL AUTO_INCREMENT,
  `iurl` varchar(255) DEFAULT NULL,
  `shopid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`iid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of productimg
-- ----------------------------
INSERT INTO `productimg` VALUES ('1', 'hot3.png', '20191125171009');
INSERT INTO `productimg` VALUES ('2', '20191202144124.jpg', '20191125171012');
INSERT INTO `productimg` VALUES ('3', 'hot3.png', '20191125171011');
INSERT INTO `productimg` VALUES ('4', 'hot3.png', '20191125171010');
INSERT INTO `productimg` VALUES ('5', '20191202144124.jpg', '201911251716');

-- ----------------------------
-- Table structure for repertory
-- ----------------------------
DROP TABLE IF EXISTS `repertory`;
CREATE TABLE `repertory` (
  `rid` int(11) NOT NULL AUTO_INCREMENT,
  `rtype` varchar(255) DEFAULT NULL,
  `rpnum` int(11) DEFAULT NULL,
  `rpcolor` varchar(255) DEFAULT NULL,
  `shopid` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`rid`)
) ENGINE=InnoDB AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of repertory
-- ----------------------------
INSERT INTO `repertory` VALUES ('1', 'LL', '2000', '黑色', '20191125171011');
INSERT INTO `repertory` VALUES ('2', 'ML', '4500', '暗色', '20191125171012');
INSERT INTO `repertory` VALUES ('3', 'SS', '3905', '白色', '20191125171010');
INSERT INTO `repertory` VALUES ('4', 'SS', '3221', '绿色', '20191125171009');
INSERT INTO `repertory` VALUES ('5', 'MM', '2231', '白色', '20191125171009');
INSERT INTO `repertory` VALUES ('6', 'MM', '2313', '黑色', '20191125171009');
INSERT INTO `repertory` VALUES ('7', 'MM', '2133', '绿色', '20191125171009');
INSERT INTO `repertory` VALUES ('8', 'SS', '2324', '白色', '20191125171009');
INSERT INTO `repertory` VALUES ('9', 'SS', '1312', '黑色', '20191125171009');

-- ----------------------------
-- Table structure for shopcar
-- ----------------------------
DROP TABLE IF EXISTS `shopcar`;
CREATE TABLE `shopcar` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cpid` int(11) DEFAULT NULL,
  `ccid` int(11) DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of shopcar
-- ----------------------------

-- ----------------------------
-- Table structure for tuijian
-- ----------------------------
DROP TABLE IF EXISTS `tuijian`;
CREATE TABLE `tuijian` (
  `tid` int(11) NOT NULL AUTO_INCREMENT,
  `tyouhui` double DEFAULT NULL,
  `pshopid` varchar(255) DEFAULT NULL,
  `endtime` varchar(255) DEFAULT NULL,
  `starttime` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`tid`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of tuijian
-- ----------------------------
INSERT INTO `tuijian` VALUES ('1', '0.3', '20191125171010', '2019-12-05 00:00:00', '2019-12-04 16:05:56');
INSERT INTO `tuijian` VALUES ('2', '0.7', '20191125171011', '2019-12-20 10:51:30', '2019-12-03 10:51:26');
INSERT INTO `tuijian` VALUES ('5', '0.7', '20191125171012', '2019-12-31 00:00:00', '2019-12-10 00:00:00');

-- ----------------------------
-- Table structure for vip
-- ----------------------------
DROP TABLE IF EXISTS `vip`;
CREATE TABLE `vip` (
  `vid` int(11) NOT NULL AUTO_INCREMENT,
  `vipname` varchar(255) DEFAULT NULL,
  `vipmoney` double(255,0) DEFAULT NULL,
  `vweight` int(11) DEFAULT NULL,
  `vipcont` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`vid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of vip
-- ----------------------------

-- ----------------------------
-- Table structure for wuliu
-- ----------------------------
DROP TABLE IF EXISTS `wuliu`;
CREATE TABLE `wuliu` (
  `wid` int(11) NOT NULL AUTO_INCREMENT,
  `wname` varchar(255) NOT NULL,
  `ordnumber` varchar(30) DEFAULT NULL,
  `consignee` varchar(11) DEFAULT NULL,
  `oadress` varchar(255) DEFAULT NULL,
  `otel` varchar(255) DEFAULT NULL,
  `fordtime` datetime DEFAULT NULL,
  `pname` varchar(255) DEFAULT NULL,
  `cpname` varchar(255) DEFAULT NULL,
  `wuliudanhao` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`wid`)
) ENGINE=InnoDB AUTO_INCREMENT=45 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of wuliu
-- ----------------------------
INSERT INTO `wuliu` VALUES ('1', '中通快递', '1', '1', null, null, null, null, null, null);
INSERT INTO `wuliu` VALUES ('2', '韵达快递', '1232323', '小花', '河南省新乡市新乡职业技术学院', '123456', '2019-09-09 12:09:12', 'mac口红', '口红', null);
INSERT INTO `wuliu` VALUES ('9', '京东快递', '70593784212313', '小米', '河南省商丘市济宁小区', '157345898', '2019-11-26 00:00:00', '阿玛尼口红', '口红', null);
INSERT INTO `wuliu` VALUES ('41', '中通快递', '70593784212312', '王博', '河南省新乡市新乡职业技术学校', '15560281905', '2019-12-11 17:03:44', '香奈儿口红', '口红', '175800');
INSERT INTO `wuliu` VALUES ('42', '圆通快递', '70593784212313', '小米', '河南省商丘市济宁小区', '157345898', '2019-12-11 17:03:49', '阿玛尼口红', '口红', '997948');
INSERT INTO `wuliu` VALUES ('43', '中通快递', '70593784212312', '王博', '河南省新乡市新乡职业技术学校', '15560281905', '2019-12-11 17:11:20', '香奈儿口红', '口红', '2147483647');
INSERT INTO `wuliu` VALUES ('44', '中通快递', '201712030837', '张三', '不急', '13513513555', '2019-11-13 09:01:22', '韩式风衣', '风衣', '2147483647');

-- ----------------------------
-- Table structure for xiaofei
-- ----------------------------
DROP TABLE IF EXISTS `xiaofei`;
CREATE TABLE `xiaofei` (
  `cid` int(11) NOT NULL AUTO_INCREMENT,
  `cuid` int(11) DEFAULT NULL,
  `cmoney` double DEFAULT NULL,
  PRIMARY KEY (`cid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of xiaofei
-- ----------------------------
