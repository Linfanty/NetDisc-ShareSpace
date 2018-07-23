/*
SQLyog Job Agent v11.33 (64 bit) Copyright(c) Webyog Inc. All Rights Reserved.


MySQL - 5.1.49-community : Database - sharespace
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`sharespace` /*!40100 DEFAULT CHARACTER SET utf8 */;

USE `sharespace`;

/*Table structure for table `admin` 管理员表 */

DROP TABLE IF EXISTS `admin`;

CREATE TABLE `admin` (
  `adminid` int(10) NOT NULL AUTO_INCREMENT,
  `adminname` char(20) DEFAULT NULL DEFAULT '' COMMENT '账号',
  `adminpwd` char(20) DEFAULT NULL DEFAULT '' COMMENT '密码',
  PRIMARY KEY (`adminid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sadmin` */

/*Table structure for table `user` 用户表 */

DROP TABLE IF EXISTS `user`;

CREATE TABLE `user` (
  `userid` int(11) NOT NULL AUTO_INCREMENT,
  `username` char(20) NOT NULL DEFAULT '' COMMENT '账号',
  `userpwd` char(20) NOT NULL DEFAULT '' COMMENT '密码',
  `usersex` char(5) NOT NULL DEFAULT '男' COMMENT '性别',
  `grade` int(10) NOT NULL DEFAULT '0' COMMENT '等级',
  `userimage` char(50) DEFAULT NULL COMMENT '头像',
  PRIMARY KEY (`userid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `suser` */

/*Table structure for table `user_file` 用户文件表 */

DROP TABLE IF EXISTS `user_file`;

CREATE TABLE `user_file` (
  `userid` int(11) NOT NULL COMMENT '用户名',
  `fileid` char(36) NOT NULL COMMENT '文件名',
  PRIMARY KEY (`userid`,`fileid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `user_file` */



/*Table structure for table `file` 文件表*/

DROP TABLE IF EXISTS `file`;

CREATE TABLE `file` (
  `fileid` char(36) NOT NULL COMMENT '文件ID',
  `filepath` char(250) DEFAULT NULL COMMENT '文件目录',
  `filename` char(20) DEFAULT NULL COMMENT '文件名',
  `filedesc` char(100) DEFAULT NULL COMMENT '文件描述',
  `filestate` char(10) DEFAULT NULL DEFAULT '公开' COMMENT '文件公开/私有',
  `downloadnum` int(10) DEFAULT NULL COMMENT '下载数',
  `filedate` date DEFAULT NULL COMMENT '文件上传日期',
  `filetype` char(10) DEFAULT NULL COMMENT '文件类型',
  PRIMARY KEY (`fileid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `sfile` */

/*Table structure for table `gfile` 群组文件表*/

DROP TABLE IF EXISTS `gfile`;

CREATE TABLE `gfile` (
  `gid` int(20) NOT NULL AUTO_INCREMENT COMMENT '群组文件ID',
  `groupid` int(20) DEFAULT NULL COMMENT '群组ID',
  `fileid` char(10) DEFAULT NULL COMMENT '文件ID',
  `groupname` char(20) DEFAULT NULL COMMENT '群组名',
  `filename` char(10) DEFAULT NULL COMMENT '文件名',
  PRIMARY KEY (`gid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `gfile` */

/*Table structure for table `group` 群组表*/

DROP TABLE IF EXISTS `group`;

CREATE TABLE `group` (
  `groupid` int(10) NOT NULL AUTO_INCREMENT COMMENT '群组ID',
  `grouppwd` char(20) DEFAULT NULL COMMENT '群组密码',
  `groupname` char(20) NOT NULL COMMENT '群组名',
  `groupdesc` char(50) DEFAULT NULL COMMENT '群组描述',
  `userid` int(10) NOT NULL COMMENT '用户ID',
  PRIMARY KEY (`groupid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `group` */

/*Table structure for table `guser` 群组用户表*/

DROP TABLE IF EXISTS `guser`;

CREATE TABLE `guser` (
  `guid` int(10) NOT NULL AUTO_INCREMENT COMMENT '群组用户ID',
  `groupid` int(10) NOT NULL COMMENT '群组ID',
  `userid` int(10) NOT NULL COMMENT '用户ID',
  `username` char(20) NOT NULL COMMENT '用户名',
  `groupname` char(20) NOT NULL COMMENT '群组名',
  PRIMARY KEY (`guid`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

/*Data for the table `guser` */

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
