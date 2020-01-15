/*
 Navicat Premium Data Transfer

 Source Server         : 192.168.1.44
 Source Server Type    : MySQL
 Source Server Version : 80015
 Source Host           : localhost:3306
 Source Schema         : xiaosai

 Target Server Type    : MySQL
 Target Server Version : 80015
 File Encoding         : 65001

 Date: 15/01/2020 11:26:00
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for xiaosai_navigation_bar
-- ----------------------------
DROP TABLE IF EXISTS `xiaosai_navigation_bar`;
CREATE TABLE `xiaosai_navigation_bar`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `navigation_bar_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '导航栏名称',
  `navigation_bar_index` int(2) NULL DEFAULT NULL COMMENT '导航栏序号',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `modify_time` datetime(0) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `nav_bar_index`(`id`) USING BTREE
) ENGINE = InnoDB AUTO_INCREMENT = 6 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '导航栏记录表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
