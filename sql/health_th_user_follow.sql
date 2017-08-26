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
-- Table structure for table `th_user_follow`
--

DROP TABLE IF EXISTS `th_user_follow`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `th_user_follow` (
  `followId` int(20) NOT NULL AUTO_INCREMENT,
  `userId` varchar(50) DEFAULT NULL COMMENT '被关注者Id',
  `followUserId` varchar(50) DEFAULT NULL COMMENT '关注者ID',
  `quotaId` int(11) DEFAULT NULL COMMENT '授权关注的指标Id：0:体重,1:体温,2:血压,3:脉搏,4:血糖,5:心率,6:脂肪,7:尿液',
  `userRemark` varchar(45) DEFAULT NULL COMMENT '被关注者对关注者的备注',
  `followerRemark` varchar(45) DEFAULT NULL COMMENT '关注者对被关注者的备注',
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `createUser` varchar(45) DEFAULT NULL,
  `updateUser` varchar(45) DEFAULT NULL,
  `flag` int(11) DEFAULT NULL COMMENT '关注关系的状态标志位：\n0：关注关系无效\n1：已请求\n2：已关注',
  `isMutualFollowed` int(11) DEFAULT NULL COMMENT '是否互相关注：\n0：否\n1：是',
  PRIMARY KEY (`followId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `th_user_follow`
--

LOCK TABLES `th_user_follow` WRITE;
/*!40000 ALTER TABLE `th_user_follow` DISABLE KEYS */;
INSERT INTO `th_user_follow` VALUES (1,'3b01b335-211f-4c1f-a8bc-cdc3ad7f2de1','3a3b7bed-d302-4dbd-820a-60f366863279',NULL,'北关组','南关组','2017-02-24 11:36:16',NULL,'3b01b335-211f-4c1f-a8bc-cdc3ad7f2de1',NULL,2,1),(2,'3a3b7bed-d302-4dbd-820a-60f366863279','3b01b335-211f-4c1f-a8bc-cdc3ad7f2de1',NULL,'测试aa79','测试377','2017-04-11 17:49:19','2017-04-11 18:50:35','3a3b7bed-d302-4dbd-820a-60f366863279','3a3b7bed-d302-4dbd-820a-60f366863279',2,1);
/*!40000 ALTER TABLE `th_user_follow` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-26 10:11:14
