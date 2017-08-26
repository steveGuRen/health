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
-- Table structure for table `th_quota`
--

DROP TABLE IF EXISTS `th_quota`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `th_quota` (
  `quotaId` int(11) NOT NULL AUTO_INCREMENT,
  `quotaType` int(11) DEFAULT NULL COMMENT '(备用字段)0:体重,1:体温,2:血压,3:血氧,4:血糖,5:心率,6:脂肪率,7:尿检',
  `quotaName` varchar(45) DEFAULT NULL COMMENT '指标名称',
  `secondQuotaName` varchar(45) DEFAULT NULL COMMENT '二级指标名称',
  `createTime` datetime DEFAULT NULL COMMENT '测量时间',
  `createUser` varchar(45) DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `updateUser` varchar(45) DEFAULT NULL,
  `remark` varchar(45) DEFAULT NULL COMMENT '备用字段',
  PRIMARY KEY (`quotaId`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `th_quota`
--

LOCK TABLES `th_quota` WRITE;
/*!40000 ALTER TABLE `th_quota` DISABLE KEYS */;
INSERT INTO `th_quota` VALUES (8,0,'体重',NULL,'2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL),(9,1,'体温',NULL,'2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL),(10,2,'血压','舒张压','2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL),(11,2,'血压','伸缩压','2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL),(12,3,'血氧',NULL,'2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL),(13,4,'血糖',NULL,'2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL),(14,5,'心率',NULL,'2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL),(15,6,'脂肪率',NULL,'2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL),(16,7,'尿检','尿蛋白','2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL),(17,7,'尿检','尿白细胞','2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL),(18,7,'尿检','尿酮体','2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL),(19,7,'尿检','尿亚硝酸盐','2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL),(20,7,'尿检','尿胆原','2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL),(21,7,'尿检','尿胆红素','2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL),(22,7,'尿检','蛋白尿','2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL),(23,7,'尿检','尿糖','2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL),(24,7,'尿检','尿比重','2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL),(25,7,'尿检','尿酸碱度','2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL),(26,7,'尿检','隐血','2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL),(27,7,'尿检','酮体','2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL),(28,7,'尿检','尿红细胞','2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL),(29,7,'尿检','尿液颜色','2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL),(30,7,'尿检','维C','2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL),(31,7,'尿检','尿肌酐','2017-02-18 11:03:49','秦召红','2017-02-18 11:03:49','秦召红',NULL);
/*!40000 ALTER TABLE `th_quota` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-26 10:12:32
