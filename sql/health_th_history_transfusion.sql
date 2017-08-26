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
-- Table structure for table `th_history_transfusion`
--

DROP TABLE IF EXISTS `th_history_transfusion`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `th_history_transfusion` (
  `id` varchar(45) NOT NULL,
  `transfusionTime` datetime DEFAULT NULL COMMENT '输血时间',
  `bloodTransfusion` int(11) DEFAULT NULL COMMENT '输血量',
  `cause` varchar(45) DEFAULT NULL COMMENT '原因',
  `createTime` datetime DEFAULT NULL,
  `updateTIme` datetime DEFAULT NULL,
  `createUser` varchar(45) DEFAULT NULL,
  `updateUser` varchar(45) DEFAULT NULL,
  `userId` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='输血史';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `th_history_transfusion`
--

LOCK TABLES `th_history_transfusion` WRITE;
/*!40000 ALTER TABLE `th_history_transfusion` DISABLE KEYS */;
INSERT INTO `th_history_transfusion` VALUES ('0cf9d18b-630b-4c14-a6ec-bab4f19ea59e','2016-09-27 00:00:00',200,'炒的菜','2017-02-28 10:36:25','2017-03-01 15:43:50',NULL,NULL,'a5ae29f4-811b-4f77-8328-5880c33820f4'),('123','2017-02-14 15:54:48',100,'cause','2017-02-14 15:54:48','2017-02-14 15:54:48','test-userId','test-userId','test-userId'),('4824c246-bd83-4f63-ad36-e07dc879beac','2017-02-27 00:00:00',303,'从多个发达国','2017-03-04 09:20:11','2017-03-04 09:20:11',NULL,NULL,'fd7ec4c4-ba30-4afc-a613-329eccd4d1d0'),('53580f38-2fb2-48b5-aac1-06a931700ac2','2017-01-29 00:00:00',100,'sdfsfdsff','2017-03-21 17:07:45','2017-03-21 17:07:45',NULL,NULL,'3d3b3d17-9a6f-47cd-a91c-041dfd27fcf1'),('56796afd-41e5-47e9-9860-985c2f201baa','2017-03-01 00:00:00',123,'下次发呆发','2017-03-04 09:20:40','2017-03-04 09:20:40',NULL,NULL,'fd7ec4c4-ba30-4afc-a613-329eccd4d1d0'),('5ed86ff9-96c4-4f11-b602-a95876eb9c96','2017-02-26 00:00:00',400,'三翻四复商法典分','2017-03-01 15:49:43','2017-03-01 15:49:49',NULL,NULL,'a5ae29f4-811b-4f77-8328-5880c33820f4'),('d6daf88b-db8e-4951-9418-4d59ec424293','2017-02-26 00:00:00',344,'dfsdfsfsfsfsfsfsfsdfsf','2017-03-01 17:23:35','2017-03-01 17:23:42',NULL,NULL,'c4588231-df44-4df3-9fdc-05a94f0b5e37');
/*!40000 ALTER TABLE `th_history_transfusion` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-26 10:11:16
