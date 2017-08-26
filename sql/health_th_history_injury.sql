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
-- Table structure for table `th_history_injury`
--

DROP TABLE IF EXISTS `th_history_injury`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `th_history_injury` (
  `id` varchar(45) NOT NULL,
  `injuryName` varchar(45) DEFAULT NULL COMMENT '外伤名称',
  `injuryTime` datetime DEFAULT NULL,
  `injuryDescription` varchar(45) DEFAULT NULL COMMENT '描述',
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `createUser` varchar(45) DEFAULT NULL,
  `updateUser` varchar(45) DEFAULT NULL,
  `userId` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `th_history_injury`
--

LOCK TABLES `th_history_injury` WRITE;
/*!40000 ALTER TABLE `th_history_injury` DISABLE KEYS */;
INSERT INTO `th_history_injury` VALUES ('123','injuryName','2017-02-14 14:30:00','injuryDescription','2017-02-14 14:30:00','2017-02-14 14:30:00','test-userId','test-userId','test-userId'),('2b373c44-18c8-4d29-b236-d8ad4b23dd85','sdfsfsfsf','2017-01-29 00:00:00','sdfsdfsfsfdsfs fsdf','2017-03-01 17:23:50','2017-03-02 14:47:40',NULL,NULL,'c4588231-df44-4df3-9fdc-05a94f0b5e37'),('913b78bb-7bbe-408d-966e-9a3fc5b916de','差点迟到','2016-11-27 00:00:00','踩单车','2017-02-28 10:36:03','2017-03-01 15:49:56',NULL,NULL,'a5ae29f4-811b-4f77-8328-5880c33820f4'),('988bec04-22e6-42a4-a41d-56a080fb4969','对方感到孤独','2017-02-26 00:00:00','德国风格的的','2017-03-04 09:20:21','2017-03-04 09:20:21',NULL,NULL,'fd7ec4c4-ba30-4afc-a613-329eccd4d1d0'),('d16e1fca-f155-487f-aafd-9413d411e020','sfdfsdfd','2017-03-06 00:00:00','sfddfsfdf','2017-03-21 17:04:32','2017-03-21 17:04:38',NULL,NULL,'3d3b3d17-9a6f-47cd-a91c-041dfd27fcf1'),('de772605-cb40-4da7-a6bc-567dfc5e9984','内部vn','2017-02-26 00:00:00','豆腐干梵蒂冈','2017-03-04 09:19:57','2017-03-04 09:20:25',NULL,NULL,'fd7ec4c4-ba30-4afc-a613-329eccd4d1d0');
/*!40000 ALTER TABLE `th_history_injury` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-26 10:11:35
