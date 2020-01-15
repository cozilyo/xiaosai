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

 Date: 15/01/2020 11:26:37
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for xiaosai_user_token
-- ----------------------------
DROP TABLE IF EXISTS `xiaosai_user_token`;
CREATE TABLE `xiaosai_user_token`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `uuid` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT 'uuid-全局唯一',
  `user_id` int(11) NULL DEFAULT NULL COMMENT '用户id',
  `login_time` datetime(0) NULL DEFAULT NULL COMMENT '登录时间',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `state` int(1) NULL DEFAULT NULL COMMENT '二维码失效，0有效，1失效',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '扫码登录token' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
