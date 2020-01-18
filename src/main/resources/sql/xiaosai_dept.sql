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

 Date: 18/01/2020 10:12:54
*/

SET NAMES utf8mb4;
SET FOREIGN_KEY_CHECKS = 0;

-- ----------------------------
-- Table structure for xiaosai_dept
-- ----------------------------
DROP TABLE IF EXISTS `xiaosai_dept`;
CREATE TABLE `xiaosai_dept`  (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dept_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NULL DEFAULT NULL COMMENT '部门名称',
  `dept_parent_id` int(11) NULL DEFAULT NULL COMMENT '部门父级id(没有父级则为0)',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `modify_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_bin COMMENT = '部门信息表' ROW_FORMAT = Dynamic;

SET FOREIGN_KEY_CHECKS = 1;
