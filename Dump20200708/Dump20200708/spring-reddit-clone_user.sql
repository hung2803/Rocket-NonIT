CREATE DATABASE  IF NOT EXISTS `spring-reddit-clone` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `spring-reddit-clone`;
-- MySQL dump 10.13  Distrib 8.0.20, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: spring-reddit-clone
-- ------------------------------------------------------
-- Server version	8.0.20

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
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `user` (
  `user_id` bigint NOT NULL AUTO_INCREMENT,
  `created` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `enabled` bit(1) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=7 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,'2020-07-06 07:08:54','test5@programmingteachied.com',_binary '\0','$2a$10$pnhnL/9kPsGGIBZjmbyj2u/wdW/BSKLqPGKvxZDF/SeTp5fXcvdGu','TestUser5'),(2,'2020-07-06 07:27:27','test5@programmingteachied.com',_binary '\0','$2a$10$/IOw3FWDT9S1YeZfIqijmeyX2.1MN.UP9ZKPlUff0gKSTwvcMqNnK','TestUser5'),(3,'2020-07-06 07:27:42','test6@programmingteachied.com',_binary '','$2a$10$ntnXn8xX2Ylk40fRG9zoY.CK/wFBWPWA63WfNazPD07JGAsWc.VZ6','TestUser6'),(4,'2020-07-06 07:31:08','test7@programmingteachied.com',_binary '\0','$2a$10$kUbhuVRA5bJcZjxLvjGVvOFYj1ly2.4VXjdWUwuwiqWjdL6Yq5i9m','TestUser7'),(5,'2020-07-06 08:35:25','test8@programmingteachied.com',_binary '\0','$2a$10$m149UBPDqjozewFBub7RDO47wUlQildQ3ve8WHKeWgKr/Esqm7hDC','TestUser8'),(6,'2020-07-06 08:54:40','test7@programmingteachied.com',_binary '\0','$2a$10$2aAVTbgVwFODfWOACEq6u.Ar6gEHfpv.UaLrnm/BLAg49rXRdD1Qy','TestUser9');
/*!40000 ALTER TABLE `user` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-07-08 14:27:31
