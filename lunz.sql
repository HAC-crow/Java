/*
Navicat MySQL Data Transfer

Source Server         : xzzc
Source Server Version : 80013
Source Host           : 127.0.0.1:3306
Source Database       : lunz

Target Server Type    : MYSQL
Target Server Version : 80013
File Encoding         : 65001

Date: 2019-08-28 17:04:37
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for menu
-- ----------------------------
DROP TABLE IF EXISTS `menu`;
CREATE TABLE `menu` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of menu
-- ----------------------------
INSERT INTO `menu` VALUES ('1', '网站首页');
INSERT INTO `menu` VALUES ('2', '订单详情');
INSERT INTO `menu` VALUES ('3', '测试菜单');
INSERT INTO `menu` VALUES ('4', '测试菜单2');

-- ----------------------------
-- Table structure for menudetailed
-- ----------------------------
DROP TABLE IF EXISTS `menudetailed`;
CREATE TABLE `menudetailed` (
  `value` varchar(255) NOT NULL,
  `id` int(11) NOT NULL,
  `pid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of menudetailed
-- ----------------------------
INSERT INTO `menudetailed` VALUES ('测试1', '1', '1');
INSERT INTO `menudetailed` VALUES ('测试2', '2', '1');
INSERT INTO `menudetailed` VALUES ('测试3', '3', '1');
INSERT INTO `menudetailed` VALUES ('测试4', '4', '2');
INSERT INTO `menudetailed` VALUES ('测试5', '5', '2');
INSERT INTO `menudetailed` VALUES ('测试6', '6', '2');

-- ----------------------------
-- Table structure for menulist
-- ----------------------------
DROP TABLE IF EXISTS `menulist`;
CREATE TABLE `menulist` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `SUBMENU` varchar(255) DEFAULT NULL,
  `PID` int(11) DEFAULT NULL,
  `MENU` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

-- ----------------------------
-- Records of menulist
-- ----------------------------
INSERT INTO `menulist` VALUES ('1', '网站首页', '1', '网站首页');
INSERT INTO `menulist` VALUES ('2', '手机', '2', '商品分类');
INSERT INTO `menulist` VALUES ('3', '数码', '2', '商品分类');
INSERT INTO `menulist` VALUES ('4', '服装', '2', '商品分类');
INSERT INTO `menulist` VALUES ('5', '居家', '2', '商品分类');
INSERT INTO `menulist` VALUES ('6', '美妆', '2', '商品分类');
INSERT INTO `menulist` VALUES ('7', '收藏的宝贝', '3', '收藏夹');
INSERT INTO `menulist` VALUES ('8', '收藏的店铺', '3', '收藏夹');
INSERT INTO `menulist` VALUES ('9', '已卖出', '4', '我的闲置');
INSERT INTO `menulist` VALUES ('10', '正在上架', '4', '我的闲置');
INSERT INTO `menulist` VALUES ('11', 'Q我吧', '5', '联系客服');
INSERT INTO `menulist` VALUES ('12', '团队成员', '6', '关于我们');
INSERT INTO `menulist` VALUES ('13', '团队宗旨', '6', '关于我们');
