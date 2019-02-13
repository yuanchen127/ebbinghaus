/*
Navicat MySQL Data Transfer

Source Server         : localhost
Source Server Version : 50534
Source Host           : localhost:3306
Source Database       : ebbinghaus

Target Server Type    : MYSQL
Target Server Version : 50534
File Encoding         : 65001

Date: 2019-02-13 14:14:36
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for cycle
-- ----------------------------
DROP TABLE IF EXISTS `cycle`;
CREATE TABLE `cycle` (
  `ID` int(11) NOT NULL AUTO_INCREMENT COMMENT 'ID',
  `CREATED_BY` varchar(32) DEFAULT NULL COMMENT '创建人',
  `CREATED_TIME` datetime DEFAULT NULL COMMENT '创建时间',
  `UPDATED_BY` varchar(32) DEFAULT NULL COMMENT '更新人',
  `UPDATED_TIME` datetime DEFAULT NULL COMMENT '更新时间',
  `UNIT` int(11) DEFAULT NULL COMMENT '单位',
  `INCREMENT` int(11) DEFAULT NULL COMMENT '增量',
  `CAPACITY` decimal(10,5) DEFAULT NULL COMMENT '记忆占比',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=8 DEFAULT CHARSET=utf8 COMMENT='周期 ';
