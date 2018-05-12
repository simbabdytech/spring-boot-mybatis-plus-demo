/*
SQLyog Community v9.63 
MySQL - 5.7.21 : Database - test
*********************************************************************
*/

/*!40101 SET NAMES utf8 */;

/*!40101 SET SQL_MODE=''*/;

/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;
CREATE DATABASE /*!32312 IF NOT EXISTS*/`test` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci */;

USE `test`;

/*Table structure for table `tbl_role` */

DROP TABLE IF EXISTS `tbl_role`;

CREATE TABLE `tbl_role` (
  `_ID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ROLENAME` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `CREATEDBY` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `CREATEDDATE` datetime DEFAULT NULL,
  `UPDATEDBY` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `_DATA` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `UPDATEDDATE` datetime DEFAULT NULL,
  PRIMARY KEY (`_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `tbl_role_permission` */

DROP TABLE IF EXISTS `tbl_role_permission`;

CREATE TABLE `tbl_role_permission` (
  `_ID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ROLEID` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PERMISSION` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `CREATEDDATE` datetime DEFAULT NULL,
  `CREATEDBY` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`_ID`),
  KEY `FKo16lw5f0fxeihpmkr8xi1l1vm` (`PERMISSION`),
  KEY `FK6la7tfcu0wna9ewfk3oi0d2fn` (`ROLEID`),
  CONSTRAINT `FK6la7tfcu0wna9ewfk3oi0d2fn` FOREIGN KEY (`ROLEID`) REFERENCES `tbl_role` (`_ID`),
  CONSTRAINT `FKo16lw5f0fxeihpmkr8xi1l1vm` FOREIGN KEY (`PERMISSION`) REFERENCES `tbl_permission` (`_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `tbl_user` */

DROP TABLE IF EXISTS `tbl_user`;

CREATE TABLE `tbl_user` (
  `_ID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ADDRESS` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `AUTHENTICATE` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `MAIL` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `NAME` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PASSWORD` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PHONE` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `SEX` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `UPDATEDBY` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `MOBILE` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `UPDATEDDATE` datetime DEFAULT NULL,
  `REALNAME` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `DOB` datetime DEFAULT NULL,
  `LOGO` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `CREATEDBY` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `CREATEDDATE` datetime DEFAULT NULL,
  `OPENID` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `tbl_user_permission` */

DROP TABLE IF EXISTS `tbl_user_permission`;

CREATE TABLE `tbl_user_permission` (
  `_ID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `USERID` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `PERMISSION` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `CREATEDDATE` datetime DEFAULT NULL,
  `CREATEDBY` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `UPDATEDDATE` datetime DEFAULT NULL,
  `UPDATEDBY` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*Table structure for table `tbl_user_role` */

DROP TABLE IF EXISTS `tbl_user_role`;

CREATE TABLE `tbl_user_role` (
  `_ID` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `USERID` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `ROLEID` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `CREATEDDATE` datetime DEFAULT NULL,
  `CREATEDBY` varchar(500) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `UPDATEDDATE` datetime DEFAULT NULL,
  `UPDATEDBY` varchar(50) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  PRIMARY KEY (`_ID`),
  KEY `FKax3fl348w718bys2i8oypgqit` (`USERID`),
  KEY `FK9xpw0hb3duraq2tomrpvimvd6` (`ROLEID`),
  CONSTRAINT `FK9xpw0hb3duraq2tomrpvimvd6` FOREIGN KEY (`ROLEID`) REFERENCES `tbl_role` (`_ID`),
  CONSTRAINT `FKax3fl348w718bys2i8oypgqit` FOREIGN KEY (`USERID`) REFERENCES `tbl_user` (`_ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;
