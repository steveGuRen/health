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
-- Table structure for table `th_history_operation`
--

DROP TABLE IF EXISTS `th_history_operation`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `th_history_operation` (
  `id` varchar(45) NOT NULL,
  `operationName` varchar(45) DEFAULT NULL COMMENT '手术名称',
  `operationTime` datetime DEFAULT NULL COMMENT '手术时间',
  `operationResult` varchar(45) DEFAULT NULL COMMENT '诊断结果',
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `createUser` varchar(45) DEFAULT NULL,
  `updateUser` varchar(45) DEFAULT NULL,
  `userId` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `th_history_operation`
--

LOCK TABLES `th_history_operation` WRITE;
/*!40000 ALTER TABLE `th_history_operation` DISABLE KEYS */;
INSERT INTO `th_history_operation` VALUES ('123','operationName','2017-02-14 14:43:31','operationResult','2017-02-14 14:43:31','2017-02-14 14:43:31','test-userId','test-userId','test-userId'),('45471bc9-88c9-4ca4-a577-bb35874a82c7','测','2017-02-27 00:00:00','测 的订单的的d','2017-03-01 10:56:13','2017-03-01 10:56:13',NULL,NULL,'3b01b335-211f-4c1f-a8bc-cdc3ad7f2de1'),('70297a49-047e-47c0-b3e6-7d5e7ed0b129','收费','2017-01-30 00:00:00','斯蒂芬森发放第三神对手','2017-03-04 09:19:19','2017-03-04 09:19:25',NULL,NULL,'fd7ec4c4-ba30-4afc-a613-329eccd4d1d0'),('8058018f-9c31-4ae9-94de-2cb91dd968ee','险恶','2016-11-28 00:00:00','测试','2017-02-28 10:22:22','2017-02-28 10:22:22',NULL,NULL,'a5ae29f4-811b-4f77-8328-5880c33820f4'),('8bec4f5d-12a7-45fa-b46c-111d0d11b624','ces','2017-03-05 00:00:00','ce','2017-03-21 17:03:56','2017-03-21 17:04:12',NULL,NULL,'3d3b3d17-9a6f-47cd-a91c-041dfd27fcf1'),('913c9b89-c1bf-45af-9183-d68fab59d98c','tytytyytty','2017-01-30 00:00:00','ssdfsfsfsfsfsdsfsfsdfdsf','2017-03-01 17:24:07','2017-03-01 17:24:07',NULL,NULL,'c4588231-df44-4df3-9fdc-05a94f0b5e37'),('a108cb17-8cdb-4bcc-8d36-f56367eca861','品牌可怕可怕','2017-02-27 00:00:00','的地方的的','2017-03-04 09:19:41','2017-03-04 09:19:41',NULL,NULL,'fd7ec4c4-ba30-4afc-a613-329eccd4d1d0'),('b45c7cfd-9155-4e35-bcbf-71f9c0fbcd5a','测试','2015-05-21 00:00:00','测试 斯蒂芬森','2017-03-01 15:41:15','2017-03-01 15:43:24',NULL,NULL,'a5ae29f4-811b-4f77-8328-5880c33820f4'),('e44cd61a-6abe-4abd-842b-5e3baad41f4a','无聊','2015-04-29 00:00:00','测试第三方身份','2017-03-01 15:40:52','2017-03-01 15:50:05',NULL,NULL,'a5ae29f4-811b-4f77-8328-5880c33820f4'),('f29fd22e-a47d-4236-816e-4392279d8fc6','测测','2016-06-07 00:00:00','踩死踩死踩死','2017-02-28 10:32:17','2017-03-01 15:43:34',NULL,NULL,'a5ae29f4-811b-4f77-8328-5880c33820f4');
/*!40000 ALTER TABLE `th_history_operation` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-26 10:11:49
