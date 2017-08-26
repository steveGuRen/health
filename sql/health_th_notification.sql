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
-- Table structure for table `th_notification`
--

DROP TABLE IF EXISTS `th_notification`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `th_notification` (
  `notificationId` int(11) NOT NULL AUTO_INCREMENT,
  `summary` varchar(450) DEFAULT NULL COMMENT '内容摘要',
  `title` varchar(45) DEFAULT NULL COMMENT '标题',
  `content` varchar(20000) DEFAULT NULL,
  `contentType` varchar(45) DEFAULT NULL COMMENT '标明content的类型：1,字符串类型;2,网页类型;3,markdown类型;',
  `action` varchar(45) DEFAULT NULL COMMENT '动作',
  `weight` int(11) DEFAULT NULL COMMENT '权重,用于排序，默认为1',
  `activeTime` int(11) DEFAULT NULL COMMENT '单位,分钟',
  `templateUrl` varchar(200) DEFAULT NULL COMMENT '模板url',
  `type` varchar(45) DEFAULT NULL COMMENT '通知类型',
  `userId` varchar(45) DEFAULT NULL COMMENT '用户ID，被通知人',
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `createUser` varchar(45) DEFAULT NULL,
  `updateUser` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`notificationId`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `th_notification`
--

LOCK TABLES `th_notification` WRITE;
/*!40000 ALTER TABLE `th_notification` DISABLE KEYS */;
INSERT INTO `th_notification` VALUES (1,NULL,'','','1','',1,60,'','','','2017-01-16 14:48:45','2017-02-13 15:39:33','',''),(2,NULL,'','','1','',1,60,'','','','2017-01-16 15:02:24','2017-01-16 15:02:24','',''),(3,'请求关注好友','请求添加关注',NULL,'1',NULL,1,60,NULL,'关注','3b01b335-211f-4c1f-a8bc-cdc3ad7f2de1','2017-04-11 17:49:19','2017-04-11 17:49:19','3a3b7bed-d302-4dbd-820a-60f366863279','3a3b7bed-d302-4dbd-820a-60f366863279'),(4,'好友请求已同意','添加关注请求已同意',NULL,'1',NULL,1,60,NULL,'关注','3b01b335-211f-4c1f-a8bc-cdc3ad7f2de1','2017-04-11 18:50:35','2017-04-11 18:50:35','3a3b7bed-d302-4dbd-820a-60f366863279','3a3b7bed-d302-4dbd-820a-60f366863279');
/*!40000 ALTER TABLE `th_notification` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-26 10:11:42
