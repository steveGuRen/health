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
-- Table structure for table `th_history_hospitalized`
--

DROP TABLE IF EXISTS `th_history_hospitalized`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `th_history_hospitalized` (
  `id` varchar(45) NOT NULL,
  `patientId` varchar(45) DEFAULT NULL COMMENT '病案号',
  `institution` varchar(45) DEFAULT NULL COMMENT '医疗机构名称',
  `cause` varchar(45) DEFAULT NULL COMMENT '住院原因',
  `hospitalInTime` datetime DEFAULT NULL COMMENT '住院时间',
  `hospitalOutTime` datetime DEFAULT NULL,
  `bedId` varchar(45) DEFAULT NULL COMMENT '病床病案号',
  `bedInstitution` varchar(45) DEFAULT NULL COMMENT '病床医疗机构名称',
  `bedCreateTime` datetime DEFAULT NULL,
  `bedDelTime` datetime DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `createUser` varchar(45) DEFAULT NULL,
  `updateUser` varchar(45) DEFAULT NULL,
  `userId` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='住院史';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `th_history_hospitalized`
--

LOCK TABLES `th_history_hospitalized` WRITE;
/*!40000 ALTER TABLE `th_history_hospitalized` DISABLE KEYS */;
INSERT INTO `th_history_hospitalized` VALUES ('123','patientId','institution','cause','2017-02-14 13:54:34','2017-02-14 13:54:34','bedId','bedInstitution',NULL,NULL,'2017-02-14 13:54:34','2017-02-14 13:54:34','test-userId','test-userId','test-userId'),('2006c366-762e-43d0-84a0-c2d4b88d82cd','适当放松放松的','第三方身份','是电风扇电风扇','2017-02-26 00:00:00','2017-02-27 00:00:00','阿道夫的','是都是发送','2017-02-26 00:00:00','2017-02-26 00:00:00','2017-03-01 17:15:20','2017-03-01 17:22:58',NULL,NULL,'c4588231-df44-4df3-9fdc-05a94f0b5e37'),('2ed85e51-16b4-49b6-99f2-c5601f2b7dd8','10100','第一人民医院','这是测试','2016-12-01 00:00:00','2016-12-08 00:00:00','100','测试','2016-12-01 00:00:00','2016-12-08 00:00:00','2017-02-28 11:00:28','2017-03-01 15:46:01',NULL,NULL,'a5ae29f4-811b-4f77-8328-5880c33820f4'),('619dedfc-8f3f-45e4-9c12-d8d5631bb3c1','1010','sda','adasdad','2017-02-26 00:00:00','2017-02-26 00:00:00',NULL,NULL,NULL,NULL,'2017-03-21 17:28:46','2017-03-21 17:28:46',NULL,NULL,'3d3b3d17-9a6f-47cd-a91c-041dfd27fcf1'),('7bd7c574-bdaf-44c5-80f0-a5e9ba5515be','10310','省立医院','测试','2015-02-03 00:00:00','2015-03-01 00:00:00','123300','神对手','2016-11-08 00:00:00','2016-12-01 00:00:00','2017-02-28 11:04:53','2017-02-28 11:04:53',NULL,NULL,'a5ae29f4-811b-4f77-8328-5880c33820f4'),('c7e6d311-c7df-484c-a1ae-33a1102681c8','101','斯蒂芬斯蒂芬','阿大区完全','2017-02-19 00:00:00','2017-02-26 00:00:00','1233','受到委屈求全恶气','2017-02-26 00:00:00','2017-02-26 00:00:00','2017-03-04 09:52:16','2017-03-04 09:53:43',NULL,NULL,'fd7ec4c4-ba30-4afc-a613-329eccd4d1d0'),('d1007467-49f7-4a05-b5f0-1f75f18ef48f','15111','第二人民医院','你猜你猜你猜猜猜','2016-09-26 00:00:00','2016-10-04 00:00:00','65656656','测试','2016-09-29 00:00:00','2016-10-04 00:00:00','2017-03-01 16:34:46','2017-03-01 16:34:55',NULL,NULL,'a5ae29f4-811b-4f77-8328-5880c33820f4');
/*!40000 ALTER TABLE `th_history_hospitalized` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-26 10:11:31
