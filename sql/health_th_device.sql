-- MySQL dump 10.13  Distrib 5.6.24, for Win64 (x86_64)
--
-- Host: 210.75.252.61    Database: health
-- ------------------------------------------------------
-- Server version	5.1.73

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `th_device`
--

DROP TABLE IF EXISTS `th_device`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `th_device` (
  `deviceId` varchar(45) NOT NULL,
  `deviceType` varchar(45) DEFAULT NULL COMMENT '设备类型',
  `deviceName` varchar(45) DEFAULT NULL COMMENT '设备名称',
  `connectTime` datetime DEFAULT NULL COMMENT '最近连接时间',
  `transportTime` datetime DEFAULT NULL COMMENT '最近传输时间',
  `bluetoothSupport` int(11) DEFAULT NULL COMMENT '支持蓝牙',
  `microUSBSupport` int(11) DEFAULT NULL COMMENT '支持micro USB接口',
  `usbTypeCSupport` int(11) DEFAULT NULL COMMENT '支持usb type c接口',
  `createTime` datetime DEFAULT NULL COMMENT '创建时间、入库时间',
  `updateTime` datetime DEFAULT NULL,
  `createUser` varchar(45) DEFAULT NULL,
  `updateUser` varchar(45) DEFAULT NULL,
  `sn` varchar(45) DEFAULT NULL,
  `device_status` varchar(45) DEFAULT NULL COMMENT '未授权、已授权、已绑定',
  `mac` varchar(45) DEFAULT NULL COMMENT 'mac地址',
  `imei` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`deviceId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `th_device`
--

LOCK TABLES `th_device` WRITE;
/*!40000 ALTER TABLE `th_device` DISABLE KEYS */;
INSERT INTO `th_device` VALUES ('1','手机','蓝牙','2017-02-13 16:51:15','2017-02-13 16:51:15',1,1,NULL,'2017-02-13 16:51:15','2017-02-13 16:51:15','denghuizhi',NULL,'sn123446','使用中','1234-7676-9898-8787','abcd1345');
/*!40000 ALTER TABLE `th_device` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-26 10:11:25
