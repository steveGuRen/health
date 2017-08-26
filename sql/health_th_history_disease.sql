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
-- Table structure for table `th_history_disease`
--

DROP TABLE IF EXISTS `th_history_disease`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `th_history_disease` (
  `id` varchar(45) NOT NULL,
  `disease` varchar(45) DEFAULT NULL COMMENT '疾病名称',
  `diagnosisTime` varchar(45) DEFAULT NULL COMMENT '确诊时间',
  `iscured` varchar(45) DEFAULT NULL COMMENT '是否治愈。是、否',
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `createUser` varchar(45) DEFAULT NULL,
  `updateUser` varchar(45) DEFAULT NULL,
  `userId` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='疾病史';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `th_history_disease`
--

LOCK TABLES `th_history_disease` WRITE;
/*!40000 ALTER TABLE `th_history_disease` DISABLE KEYS */;
INSERT INTO `th_history_disease` VALUES ('0d0d9f1d-2e91-4193-aee0-6583f95f9627','肚子疼','2016-10-03 00:00:00','否','2017-02-28 09:42:38','2017-03-01 15:39:32',NULL,NULL,'a5ae29f4-811b-4f77-8328-5880c33820f4'),('123','艾滋病','确诊时间','已经治愈','2017-02-14 10:59:45','2017-02-14 10:59:45','test-userId','test-userId','test-userId'),('63c4cb55-2b7e-4a0a-9ea3-c4db1fba8afe','高血压','2017-02-26 00:00:00','是','2017-03-04 09:15:04','2017-03-04 09:15:04',NULL,NULL,'fd7ec4c4-ba30-4afc-a613-329eccd4d1d0'),('7fd9527c-4f74-412d-adf4-31c8ff2cf095','高血压',' 00:00:00',NULL,'2017-03-01 10:52:08','2017-03-01 10:52:08',NULL,NULL,'3b01b335-211f-4c1f-a8bc-cdc3ad7f2de1'),('845bd998-078d-4c1d-8a8b-39b3adb7b4fc','糖尿病',' 00:00:00',NULL,'2017-03-21 17:03:48','2017-03-21 17:03:48',NULL,NULL,'3d3b3d17-9a6f-47cd-a91c-041dfd27fcf1'),('9546b3ea-ae60-401c-a853-ae909596fe5c','结核病','2016-10-24 00:00:00','否','2017-03-01 17:24:23','2017-03-01 17:24:30',NULL,NULL,'c4588231-df44-4df3-9fdc-05a94f0b5e37'),('ae5e71c9-68ba-41f3-a1dc-6d8985e1952d','高血压','2016-06-29 00:00:00','是','2017-03-01 10:53:45','2017-03-01 10:53:45',NULL,NULL,'3b01b335-211f-4c1f-a8bc-cdc3ad7f2de1'),('b84e6d4a-adb7-4c31-9a2c-ed0eba950ee0','感冒','2017-02-07 00:00:00','是','2017-02-28 09:39:40','2017-03-01 15:44:04',NULL,NULL,'a5ae29f4-811b-4f77-8328-5880c33820f4'),('c484eedc-9adc-4995-af64-c772d0c3371e','感冒','2017-02-26 00:00:00','是','2017-03-04 09:14:52','2017-03-04 09:14:52',NULL,NULL,'fd7ec4c4-ba30-4afc-a613-329eccd4d1d0'),('cce45c99-7263-47d2-b0a3-aa559504ac5a','发烧','2016-12-03 00:00:00 00:00:00','是','2017-02-28 09:40:58','2017-03-01 15:44:14',NULL,NULL,'a5ae29f4-811b-4f77-8328-5880c33820f4');
/*!40000 ALTER TABLE `th_history_disease` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-26 10:12:30
