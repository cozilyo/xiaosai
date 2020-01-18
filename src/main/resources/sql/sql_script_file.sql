/**
 *所有后续进行更改的sql
 */

ALTER TABLE `xiaosai`.`xiaosai_user`
ADD COLUMN `is_super_admin` tinyint(1) NULL COMMENT '是否为超级管理员 1-是' AFTER `logo_icon_id`;

ALTER TABLE `xiaosai`.`xiaosai_user`
ADD COLUMN `dept_id` int(11) NULL COMMENT '部门id' AFTER `logo_icon_id`;

ALTER TABLE `xiaosai`.`xiaosai_user`
MODIFY COLUMN `user_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_bin NOT NULL COMMENT '用户名' AFTER `name`,
DROP PRIMARY KEY,
ADD PRIMARY KEY (`id`, `user_name`) USING BTREE;