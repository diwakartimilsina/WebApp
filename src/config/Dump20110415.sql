CREATE DATABASE  IF NOT EXISTS `softbeacon` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `softbeacon`;
-- MySQL dump 10.13  Distrib 5.1.40, for Win32 (ia32)
--
-- Host: localhost    Database: softbeacon
-- ------------------------------------------------------
-- Server version	5.5.9

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
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `idusers` int(11) NOT NULL AUTO_INCREMENT,
  `username` varchar(16) NOT NULL,
  `firstname` varchar(45) NOT NULL,
  `lastname` varchar(45) NOT NULL,
  `sex` varchar(1) NOT NULL,
  `age` smallint(6) NOT NULL,
  `zipcode` varchar(5) NOT NULL,
  `email` varchar(45) NOT NULL,
  `datecreated` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  PRIMARY KEY (`idusers`),
  UNIQUE KEY `username_UNIQUE` (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=35 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `users`
--

LOCK TABLES `users` WRITE;
/*!40000 ALTER TABLE `users` DISABLE KEYS */;
INSERT INTO `users` VALUES (1,'diwakartimilsina','Diwakar','Timilsina','M',30,'72758','diwakar.timilsina@gmail.com','2011-04-05 05:00:00'),(2,'diwakar1','Diwakar','Timilsina','M',30,'72758','diwakar.timilsina@gmail.com','2011-04-05 05:00:00'),(3,'diwakar2','Diwakar','Timilsina','M',30,'72758','diwakar.timilsina@gmail.com','2011-04-05 22:33:22'),(4,'diwakar3','Diwakar','Timilsina','M',30,'72758','diwakar.timilsina@gmail.com','2011-04-06 20:14:59'),(5,'diwakar4','Diwakar','Timilsina','M',30,'72758','diwakar.timilsina@gmail.com','2011-04-06 20:21:40'),(6,'diwakar5','Diwakar','Timilsina','M',30,'72758','diwakar.timilsina@gmail.com','2011-04-06 20:22:37'),(7,'diwakar6','Diwakar','Timilsina','M',30,'72758','diwakar.timilsina@gmail.com','2011-04-06 20:23:42'),(8,'diwakar7','Diwakar','Timilsina','M',30,'72758','diwakar.timilsina@gmail.com','2011-04-06 20:26:36'),(9,'diwakar8','Diwakar','Timilsina','M',30,'72758','diwakar.timilsina@gmail.com','2011-04-06 20:29:13'),(10,'tomhanks','Tom','Hanks','M',55,'90898','tom.hanks@hollywood.com','2011-04-09 17:54:46'),(11,'mandymoore','Mandy','Moore','F',30,'90210','mandy.moore@abc.com','2011-04-09 17:56:48'),(12,'tomhanks2','Tom','Hanks','F',30,'90210','tom.hanks@hollywood.com','2011-04-09 17:59:13'),(13,'mandymoore2','Mandy','Moore','F',55,'90210','mandy.moore@abc.com','2011-04-09 18:03:11'),(14,'mandymoore3','Mandy','Moore','M',55,'90210','mandy.moore@abc.com','2011-04-09 18:04:20'),(15,'tomhanks3','Mandy','Moore','M',55,'90210','tom.hanks@hollywood.com','2011-04-09 18:06:07'),(16,'mandymoore4','Mandy','Moore','F',55,'90210','tom.hanks@hollywood.com','2011-04-09 18:09:49'),(17,'mandymoore5','Mandy','Moore','F',30,'90210','mandy.moore@abc.com','2011-04-09 18:12:39'),(18,'tomhanks4','Tom','Hanks','M',55,'90210','tom.hanks@hollywood.com','2011-04-09 18:14:03'),(19,'pearljam','Pearl','Jam','M',99,'28888','laksjdf@asdf.com','2011-04-10 19:09:29'),(20,'shazrajput','Shaz','Rajput','M',34,'72715','shazrajput@yahoo.com','2011-04-10 21:23:30'),(21,'silulohani','Silu','Lohani','F',26,'72758','silu600@hotmail.com','2011-04-11 16:15:51'),(22,'silulohani1','Silu','Lohani','F',26,'72758','silu600@hotmail.com','2011-04-11 16:26:38'),(23,'silulohani3','Silu','Lohani','F',3,'72758','silu600@hotmail.com','2011-04-11 18:35:48'),(24,'silulohani5','Mandy','Moore','M',9,'98888','tom.hanks@hollywood.com','2011-04-12 00:46:20'),(25,'silulohani6','Mandy','Moore','M',9,'98888','tom.hanks@hollywood.com','2011-04-12 00:49:49'),(26,'silulohani7','Mandy','Moore','M',9,'98888','tom.hanks@hollywood.com','2011-04-12 00:50:05'),(27,'mattdamon','Matt','Damon','M',38,'02145','matt.damon@abc.com','2011-04-13 17:08:55'),(28,'benaffleck','Ben','Affleck','M',39,'08901','ben.affack@abc.com','2011-04-14 04:41:59'),(29,'benaffleck2','Ben','Affleck','M',39,'08901','ben.affack@abc.com','2011-04-14 04:51:15'),(30,'mattdamon5','Matt','Damon','M',55,'90210','matt.damon@abc.com','2011-04-15 03:06:16'),(31,'dukuonline','Diwakar','Timilsina','M',30,'72758','diwakar.timilsina@gmail.com','2011-04-15 18:00:21'),(32,'dukuonline2','Diwakar','Timilsina','M',30,'72758','diwakar.timilsina@gmail.com','2011-04-15 18:02:11'),(33,'dukuonline3','Diwakar','Timilsina','M',30,'72758','diwakar.timilsina@gmail.com','2011-04-15 18:04:34'),(34,'harrypotter','Harry','Potter','M',17,'72789','harry@abc.com','2011-04-15 18:06:17');
/*!40000 ALTER TABLE `users` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'softbeacon'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2011-04-15 13:13:03
