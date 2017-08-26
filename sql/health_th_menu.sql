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
-- Table structure for table `th_menu`
--

DROP TABLE IF EXISTS `th_menu`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `th_menu` (
  `menuId` int(8) NOT NULL AUTO_INCREMENT,
  `pid` int(8) DEFAULT NULL,
  `menuName` varchar(32) DEFAULT NULL,
  `typeId` int(11) DEFAULT NULL,
  `isValid` int(1) DEFAULT NULL,
  `createUser` varchar(32) DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateUser` varchar(32) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `url` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`menuId`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `th_menu`
--

LOCK TABLES `th_menu` WRITE;
/*!40000 ALTER TABLE `th_menu` DISABLE KEYS */;
INSERT INTO `th_menu` VALUES (1,0,'系统管理',1,0,'admin','2016-09-20 10:05:27','admin','2016-09-20 10:05:27',NULL),(2,0,'用户档案',0,0,'admin','2016-09-20 10:05:27','admin','2016-09-20 10:05:27',NULL),(3,0,'设备管理',0,0,'admin','2016-09-20 10:05:27','admin','2016-09-20 10:05:27',NULL),(4,0,'检测数据',1,0,'admin','2016-09-20 10:05:27','admin','2016-09-20 10:05:27',NULL),(5,1,'系统角色',1,0,'admin','2016-09-20 10:05:27','admin','2016-09-20 10:05:27',NULL),(6,1,'用户信息',1,0,'admin','2016-09-20 10:05:27','admin','2016-09-20 10:05:27',NULL),(7,1,'组织结构',1,0,'admin','2016-09-20 10:05:27','admin','2016-09-20 10:05:27',NULL),(8,2,'档案管理',0,0,'admin','2016-09-20 10:05:27','admin','2016-09-20 10:05:27',NULL),(9,3,'设备信息',0,0,'admin','2016-09-20 10:05:27','admin','2016-09-20 10:05:27',NULL),(10,3,'试纸信息',0,0,'admin','2016-09-20 10:05:27','admin','2016-09-20 10:05:27',NULL),(11,4,'检测指标',1,0,'admin','2016-09-20 10:05:27','admin','2016-09-20 10:05:27',NULL),(12,4,'检测数据',1,0,'admin','2016-09-20 10:05:27','admin','2016-09-20 10:05:27',NULL),(13,4,'数据分析',1,0,'admin','2016-09-20 10:05:27','admin','2016-09-20 10:05:27',NULL);
/*!40000 ALTER TABLE `th_menu` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-26 10:11:46
