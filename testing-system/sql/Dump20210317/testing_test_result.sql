-- MySQL dump 10.13  Distrib 8.0.23, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: testing
-- ------------------------------------------------------
-- Server version	8.0.23-commercial

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `test_result`
--

DROP TABLE IF EXISTS `test_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `test_result` (
  `id` int NOT NULL AUTO_INCREMENT,
  `result` int DEFAULT NULL,
  `user_id` int NOT NULL,
  `test_id` int NOT NULL,
  `create_time` timestamp NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`id`),
  KEY `fk_test_results_user1_idx` (`user_id`),
  KEY `fk_test_results_test1_idx` (`test_id`),
  CONSTRAINT `fk_test_results_test1` FOREIGN KEY (`test_id`) REFERENCES `test` (`id`),
  CONSTRAINT `fk_test_results_user1` FOREIGN KEY (`user_id`) REFERENCES `user` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=53 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `test_result`
--

LOCK TABLES `test_result` WRITE;
/*!40000 ALTER TABLE `test_result` DISABLE KEYS */;
INSERT INTO `test_result` VALUES (1,100,26,7,'2021-03-01 11:44:04'),(2,25,26,7,'2021-03-01 11:45:00'),(3,0,26,7,'2021-03-01 11:48:09'),(4,17,26,4,'2021-03-01 11:50:03'),(5,0,26,6,'2021-03-01 11:51:50'),(6,0,26,6,'2021-03-01 11:52:08'),(7,0,26,7,'2021-03-01 11:52:37'),(8,0,26,6,'2021-03-01 11:59:14'),(9,50,26,7,'2021-03-01 12:05:46'),(10,0,26,6,'2021-03-01 12:07:29'),(11,75,26,7,'2021-03-01 12:28:55'),(12,50,26,7,'2021-03-01 12:31:33'),(13,0,26,6,'2021-03-01 12:35:24'),(14,0,26,6,'2021-03-01 12:40:10'),(15,0,26,4,'2021-03-01 12:41:43'),(16,100,26,5,'2021-03-01 12:44:30'),(17,0,26,6,'2021-03-01 12:55:06'),(18,75,26,7,'2021-03-01 13:12:21'),(19,8,26,4,'2021-03-01 13:21:52'),(20,0,26,6,'2021-03-01 13:24:43'),(21,0,26,4,'2021-03-01 16:45:10'),(22,0,26,5,'2021-03-01 16:46:19'),(23,0,26,5,'2021-03-01 16:54:13'),(24,0,26,5,'2021-03-01 16:54:22'),(25,0,26,5,'2021-03-01 16:54:36'),(26,0,26,5,'2021-03-01 16:54:47'),(27,0,26,5,'2021-03-01 16:55:06'),(28,0,26,7,'2021-03-01 17:00:07'),(29,75,26,7,'2021-03-01 17:00:19'),(30,0,26,5,'2021-03-01 17:09:31'),(31,0,26,5,'2021-03-01 17:09:36'),(32,0,26,5,'2021-03-01 17:10:13'),(33,0,26,4,'2021-03-01 17:17:33'),(34,100,26,4,'2021-03-01 17:19:45'),(35,0,26,4,'2021-03-01 17:20:41'),(36,0,26,4,'2021-03-01 17:20:59'),(37,0,30,6,'2021-03-01 18:03:15'),(38,50,26,4,'2021-03-01 19:14:30'),(39,0,26,4,'2021-03-01 19:32:47'),(40,0,26,6,'2021-03-02 10:48:41'),(41,8,26,4,'2021-03-04 09:25:52'),(42,17,26,4,'2021-03-04 09:26:55'),(43,0,26,6,'2021-03-04 09:29:21'),(44,0,26,6,'2021-03-09 13:32:17'),(45,0,26,6,'2021-03-17 12:10:58'),(46,0,26,4,'2021-03-17 12:17:36'),(47,0,26,4,'2021-03-17 12:22:40'),(48,0,26,4,'2021-03-17 12:25:42'),(49,0,26,4,'2021-03-17 12:30:05'),(50,0,26,4,'2021-03-17 12:31:45'),(51,0,26,4,'2021-03-17 12:32:59'),(52,0,26,6,'2021-03-17 12:33:50');
/*!40000 ALTER TABLE `test_result` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-17 14:43:40
