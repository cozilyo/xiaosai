/**
 *所有后续进行更改的sql
 */

ALTER TABLE `xiaosai`.`xiaosai_user`
ADD COLUMN `is_super_admin` tinyint(1) NULL COMMENT '是否为超级管理员 1-是' AFTER `logo_icon_id`;