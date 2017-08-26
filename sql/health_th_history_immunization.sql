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
-- Table structure for table `th_history_immunization`
--

DROP TABLE IF EXISTS `th_history_immunization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `th_history_immunization` (
  `id` varchar(45) NOT NULL,
  `immunizationName` varchar(45) DEFAULT NULL COMMENT '非免疫规划预防接种史名称',
  `immunizationDate` datetime DEFAULT NULL COMMENT '非免疫规划预防接种史日期',
  `immunizationInstitution` varchar(45) DEFAULT NULL COMMENT '非免疫规划预防接种史机构',
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `createUser` varchar(45) DEFAULT NULL,
  `updateUser` varchar(45) DEFAULT NULL,
  `userId` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='非预防接种史';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `th_history_immunization`
--

LOCK TABLES `th_history_immunization` WRITE;
/*!40000 ALTER TABLE `th_history_immunization` DISABLE KEYS */;
INSERT INTO `th_history_immunization` VALUES ('123','immunizationName','2017-02-14 14:17:33','immunizationInstitution','2017-02-14 14:17:33','2017-02-14 14:17:33','test-userId','test-userId','test-userId'),('3a0043a3-4975-441b-938a-3a5d17345644','纷飞','2017-01-29 00:00:00','大幅度手酸酸','2017-02-28 17:48:28','2017-03-01 16:35:04',NULL,NULL,'a5ae29f4-811b-4f77-8328-5880c33820f4'),('814bbf3f-6d0c-4eee-a230-0720545ba188','在现场咨询','2017-02-19 00:00:00','阿斯达斯','2017-03-04 09:53:28','2017-03-04 09:53:34',NULL,NULL,'fd7ec4c4-ba30-4afc-a613-329eccd4d1d0'),('a52716ee-248e-4543-8778-1fcc74d47c5a','qweqwe','2017-02-26 00:00:00','bvnvnbvnbv','2017-03-01 17:23:06','2017-03-01 17:23:24',NULL,NULL,'c4588231-df44-4df3-9fdc-05a94f0b5e37'),('febec2b3-e392-4544-900c-bea85e9c8c73','说的','2017-03-06 00:00:00','神对手','2017-02-28 17:45:30','2017-03-01 15:45:30',NULL,NULL,'a5ae29f4-811b-4f77-8328-5880c33820f4');
/*!40000 ALTER TABLE `th_history_immunization` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-26 10:11:22
