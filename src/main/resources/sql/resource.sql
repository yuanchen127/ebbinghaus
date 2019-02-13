/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50534
Source Host           : localhost:3306
Source Database       : ebbinghaus

Target Server Type    : MYSQL
Target Server Version : 50534
File Encoding         : 65001

Date: 2019-02-13 14:57:46
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for resource
-- ----------------------------
DROP TABLE IF EXISTS `resource`;
CREATE TABLE `resource` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `CONTENT` varchar(3120) DEFAULT NULL COMMENT '记忆内容',
  `FIRST_TIME` datetime DEFAULT NULL COMMENT '第一次记忆正确时间',
  `LAST_TIME` datetime DEFAULT NULL COMMENT '上一次记忆正确时间',
  `MEMORY` tinyint(1) DEFAULT '0' COMMENT '是否记忆正确',
  `NOTE` varchar(512) DEFAULT NULL COMMENT '卑职',
  `MARK` decimal(64,5) DEFAULT NULL COMMENT '记忆指数',
  `ANSWER` varchar(255) DEFAULT NULL COMMENT '答案',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8 COMMENT='记忆信息 ';
