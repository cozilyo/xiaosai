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

 Date: 15/01/2020 11:26:07
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for xiaosai_permission_group
-- ----------------------------
DROP TABLE IF EXISTS `xiaosai_permission_group`;
CREATE TABLE `xiaosai_permission_group`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `group_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '权限组名称',
  `group_type` int(3) NULL DEFAULT NULL COMMENT '权限组代码（支持999个）',
  `access_level` int(1) NULL DEFAULT NULL COMMENT '权限等级（数字越大等级越低）',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE,
  UNIQUE INDEX `permission_group_index`(`id`) USING BTREE COMMENT '权限组索引'
) ENGINE = InnoDB AUTO_INCREMENT = 20 CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '权限管理表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
