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
-- Table structure for table `th_notification_all`
--

DROP TABLE IF EXISTS `th_notification_all`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `th_notification_all` (
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
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `createUser` varchar(45) DEFAULT NULL,
  `updateUser` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`notificationId`)
) ENGINE=MyISAM AUTO_INCREMENT=29 DEFAULT CHARSET=utf8 COMMENT='全部用户时的消息提醒';
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `th_notification_all`
--

LOCK TABLES `th_notification_all` WRITE;
/*!40000 ALTER TABLE `th_notification_all` DISABLE KEYS */;
INSERT INTO `th_notification_all` VALUES (3,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:22:22','2017-02-24 10:22:22','createUser','updateUser'),(4,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:43','2017-02-24 10:23:43','createUser','updateUser'),(5,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:44','2017-02-24 10:23:44','createUser','updateUser'),(6,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:45','2017-02-24 10:23:45','createUser','updateUser'),(7,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:45','2017-02-24 10:23:45','createUser','updateUser'),(8,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:45','2017-02-24 10:23:45','createUser','updateUser'),(9,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:45','2017-02-24 10:23:45','createUser','updateUser'),(10,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:45','2017-02-24 10:23:45','createUser','updateUser'),(11,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:45','2017-02-24 10:23:45','createUser','updateUser'),(12,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:46','2017-02-24 10:23:46','createUser','updateUser'),(13,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:46','2017-02-24 10:23:46','createUser','updateUser'),(14,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:46','2017-02-24 10:23:46','createUser','updateUser'),(15,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:46','2017-02-24 10:23:46','createUser','updateUser'),(16,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:46','2017-02-24 10:23:46','createUser','updateUser'),(17,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:46','2017-02-24 10:23:46','createUser','updateUser'),(18,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:46','2017-02-24 10:23:46','createUser','updateUser'),(19,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:47','2017-02-24 10:23:47','createUser','updateUser'),(20,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:47','2017-02-24 10:23:47','createUser','updateUser'),(21,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:47','2017-02-24 10:23:47','createUser','updateUser'),(22,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:47','2017-02-24 10:23:47','createUser','updateUser'),(23,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:47','2017-02-24 10:23:47','createUser','updateUser'),(24,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:47','2017-02-24 10:23:47','createUser','updateUser'),(25,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:48','2017-02-24 10:23:48','createUser','updateUser'),(26,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:48','2017-02-24 10:23:48','createUser','updateUser'),(27,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:23:48','2017-02-24 10:23:48','createUser','updateUser'),(28,'summary','title','content','contentType','action',1,1,'templateUrl','type','2017-02-24 10:24:34','2017-02-24 10:24:34','createUser','updateUser');
/*!40000 ALTER TABLE `th_notification_all` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-26 10:11:33
