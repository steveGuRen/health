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
-- Table structure for table `th_admin_role_organization`
--

DROP TABLE IF EXISTS `th_admin_role_organization`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `th_admin_role_organization` (
  `id` int(20) NOT NULL AUTO_INCREMENT,
  `userId` varchar(50) DEFAULT NULL,
  `roleId` int(11) DEFAULT NULL,
  `organizationId` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=32 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `th_admin_role_organization`
--

LOCK TABLES `th_admin_role_organization` WRITE;
/*!40000 ALTER TABLE `th_admin_role_organization` DISABLE KEYS */;
INSERT INTO `th_admin_role_organization` VALUES (14,'fd7ec4c4-ba30-4afc-a613-329eccd4d1d0',6,1),(15,'fd7ec4c4-ba30-4afc-a613-329eccd4d1d0',6,3),(16,'fd7ec4c4-ba30-4afc-a613-329eccd4d1d0',7,1),(17,'fd7ec4c4-ba30-4afc-a613-329eccd4d1d0',7,3),(18,'a5ae29f4-811b-4f77-8328-5880c33820f4',6,1),(19,'a5ae29f4-811b-4f77-8328-5880c33820f4',6,3),(20,'a5ae29f4-811b-4f77-8328-5880c33820f4',7,1),(21,'a5ae29f4-811b-4f77-8328-5880c33820f4',7,3),(22,'c4588231-df44-4df3-9fdc-05a94f0b5e37',6,1),(23,'c4588231-df44-4df3-9fdc-05a94f0b5e37',6,3),(24,'d95f7d80-d9cf-4d7d-a947-53b734d2ccf4',6,1),(25,'d95f7d80-d9cf-4d7d-a947-53b734d2ccf4',6,3),(28,'3a3b7bed-d302-4dbd-820a-60f366863279',6,1),(29,'3a3b7bed-d302-4dbd-820a-60f366863279',6,3),(30,'3a3b7bed-d302-4dbd-820a-60f366863279',8,0),(31,'a5ae29f4-811b-4f77-8328-5880c33820f4',8,0);
/*!40000 ALTER TABLE `th_admin_role_organization` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2017-08-26 10:11:48
