
DROP TABLE IF EXISTS `th_graph_temp`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `th_graph_temp` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `quotaName` varchar(45) DEFAULT NULL COMMENT '???绉?,
  `diff` double DEFAULT NULL COMMENT '?镐技搴?,
  `source` varchar(45) DEFAULT NULL,
  `target` varchar(45) DEFAULT NULL,
  `compareStartTime` datetime DEFAULT NULL,
  `compareEndTime` datetime DEFAULT NULL,
  `createTime` datetime DEFAULT NULL,
  `updateTime` datetime DEFAULT NULL,
  `createUser` varchar(45) DEFAULT NULL,
  `updateUser` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=997137 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;