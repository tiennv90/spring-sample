CREATE DATABASE  IF NOT EXISTS `spring-ecomercial` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `spring-ecomercial`;
-- MySQL dump 10.13  Distrib 5.5.40, for debian-linux-gnu (x86_64)
--
-- Host: 127.0.0.1    Database: spring-ecomercial
-- ------------------------------------------------------
-- Server version	5.5.40-0ubuntu0.14.04.1

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
-- Table structure for table `category`
--

DROP TABLE IF EXISTS `category`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `category` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=8 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `category`
--

LOCK TABLES `category` WRITE;
/*!40000 ALTER TABLE `category` DISABLE KEYS */;
INSERT INTO `category` VALUES (1,'Clothing'),(2,'Bathing & Grooming'),(3,'Health Products'),(4,'Mobility'),(5,'Kitchen'),(6,'Hobbies'),(7,'Phones & Pagers');
/*!40000 ALTER TABLE `category` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `feedback`
--

DROP TABLE IF EXISTS `feedback`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `feedback` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `email` varchar(255) DEFAULT NULL,
  `feedback` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `phoneNumber` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=MyISAM AUTO_INCREMENT=10 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `feedback`
--

LOCK TABLES `feedback` WRITE;
/*!40000 ALTER TABLE `feedback` DISABLE KEYS */;
INSERT INTO `feedback` VALUES (1,'tiennv90@gmail.com','dasdasdadasd','Tien Nguyen','0167323232'),(2,'tiennv90@gmail.com','dasdasdadasd','Tien Nguyen','0167323232'),(3,'tiennv90@gmail.com','asdasdasdasda','Tien Nguyen','0167323232'),(4,'tienstreetdance@yahoo.com','asdasdasdasd','Tien Nguyen','0167323232'),(5,'tienstreetdance@yahoo.com','asdasdasdasd','Tien Nguyen','0167323232'),(6,'caube_ngaytho8@yahoo.com','caube_ngaytho8@yahoo.com','Nguyen Tien','0167323232'),(7,'hiepnguyenkh@gmail.com','hiepnguyenkh@gmail.com','Tien Nguyen','0167323232'),(8,'viettien20@gmail.com','sadasdasdas','Nguyen Tien','0167323232'),(9,'viettien20@gmail.com','asdasdasdsa','ntproduction','0167323232');
/*!40000 ALTER TABLE `feedback` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders`
--

DROP TABLE IF EXISTS `orders`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `orderDate` datetime DEFAULT NULL,
  `status` varchar(255) DEFAULT NULL,
  `cardNumber` varchar(255) DEFAULT NULL,
  `cvv` varchar(255) DEFAULT NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKC3DF62E555912EA6` (`userId`),
  KEY `FKC3DF62E539C23640` (`userId`)
) ENGINE=MyISAM AUTO_INCREMENT=16 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders`
--

LOCK TABLES `orders` WRITE;
/*!40000 ALTER TABLE `orders` DISABLE KEYS */;
INSERT INTO `orders` VALUES (1,NULL,'Waiting','1234567890123456','AXB',2),(2,NULL,'Waiting','1234567890123456','AXB',2),(3,NULL,'Waiting','1234567890123456','AXB',2),(4,NULL,'Waiting','1234567890123456','AXB',2),(5,NULL,'Waiting','1234567890123456','AXK',2),(6,'2015-04-11 23:50:03','Waiting','1234567890123456','DXG',2),(7,'2015-04-12 11:45:25','Waiting','1234567891234567','VBD',2),(8,'2015-04-12 11:46:53','Waiting','1234567891234567','VGZ',2),(9,'2015-04-12 11:49:06','Waiting','1234567891234567','UYR',2),(10,'2015-04-12 11:52:16','Waiting','1234567891234567','UYE',2),(11,'2015-04-12 12:40:10','Waiting','1234567891234567','AAA',2),(13,'2015-04-12 12:54:57','Waiting','1234567891234567','UYE',2),(14,'2015-04-12 13:37:23','Waiting','1234567891234567','VGZ',2),(15,'2015-04-12 18:01:43','Waiting','1234567891234567','ASC',10);
/*!40000 ALTER TABLE `orders` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orders_product`
--

DROP TABLE IF EXISTS `orders_product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orders_product` (
  `orders_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  KEY `FKC2B22195D413CE85` (`product_id`),
  KEY `FKC2B221952444030F` (`orders_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orders_product`
--

LOCK TABLES `orders_product` WRITE;
/*!40000 ALTER TABLE `orders_product` DISABLE KEYS */;
INSERT INTO `orders_product` VALUES (2,1),(13,11),(14,6),(15,5),(15,11),(15,19);
/*!40000 ALTER TABLE `orders_product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `paymentmethod`
--

DROP TABLE IF EXISTS `paymentmethod`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `paymentmethod` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `cvv` varchar(255) DEFAULT NULL,
  `number` varchar(255) DEFAULT NULL,
  `user_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `paymentmethod`
--

LOCK TABLES `paymentmethod` WRITE;
/*!40000 ALTER TABLE `paymentmethod` DISABLE KEYS */;
/*!40000 ALTER TABLE `paymentmethod` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `product`
--

DROP TABLE IF EXISTS `product`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `product` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `dealOfTheDay` tinyint(1) NOT NULL,
  `discountPrice` double DEFAULT NULL,
  `imageUrl` varchar(255) DEFAULT NULL,
  `isSpecialProduct` tinyint(1) NOT NULL,
  `name` varchar(255) DEFAULT NULL,
  `price` double DEFAULT NULL,
  `categoryId` int(11) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `FKED8DCCEF9367EDCC` (`categoryId`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `product`
--

LOCK TABLES `product` WRITE;
/*!40000 ALTER TABLE `product` DISABLE KEYS */;
INSERT INTO `product` VALUES (2,1,0,'/images/product/clothing/01.jpg',0,'Solid Color Sage Blouse with Velcro Closures - Short Sleeve',41.95,1),(3,1,NULL,'/images/product/clothing/02.jpg',0,'Rose Solid Color Blouse with Velcro Closures - Short Sleeve',41.95,1),(4,1,NULL,'/images/product/clothing/03.jpg',0,'Ladies\' Booties with Velcro Closures',8.95,1),(5,1,NULL,'/images/product/clothing/04.jpg',1,'Primrose II Fancy Blouse with Velcro Closures - Short Sleeve',31.95,1),(6,0,NULL,'/images/product/bath/01.jpg',1,'Deluxe Tub Grab Bar',55.95,2),(7,0,NULL,'/images/product/bath/02.jpg',0,'Swiveling Long Handle Lotion Applicator',15.95,2),(8,0,NULL,'/images/product/bath/03.jpg',0,'Toilet Safety Frame',50.95,2),(9,0,NULL,'/images/product/bath/04.jpg',0,'Microfiber Mesh Back Scrubber',12.95,2),(10,0,NULL,'/images/product/health/01.jpg',0,'Classic IsoFlex for Stress Relief',4.99,3),(11,0,NULL,'/images/product/health/02.jpg',0,'Bed Buddy Back Wrap',22.95,3),(12,0,NULL,'/images/product/health/05.jpg',0,'Bed Buddy Hot and Cold Pack',16.95,3),(13,0,NULL,'/images/product/health/04.jpg',0,'Bed Buddy Large Joint Wrap',23.95,3),(14,0,NULL,'/images/product/health/04.jpg',0,'UPEASY Lifting Cushion',12.95,4),(15,0,NULL,'/images/product/mobility/02.jpg',0,'Pathlighter Lighted Walking Cane with extra bulb',50.95,4),(16,0,NULL,'/images/product/mobility/03.jpg',0,'Rising-Aid Walking Cane',25.95,4),(17,0,NULL,'/images/product/mobility/04.jpg',0,'Leg Lift by Ableware',13.95,4),(18,0,NULL,'/images/product/kitchen/01.jpg',0,'Set of 4 Utensils Built Up Handle Cutlery Set',28.95,5),(19,0,NULL,'/images/product/kitchen/02.jpg',0,'Foam Tubing for Arthritis in Hands',17.95,5),(20,0,0,'/images/product/kitchen/03.jpg',0,'Clip-on Vegetable Peeler',19.95,5),(21,0,NULL,'/images/product/kitchen/04.jpg',0,'ADL Cuff',8.95,5);
/*!40000 ALTER TABLE `product` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user`
--

DROP TABLE IF EXISTS `user`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `address` varchar(255) DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `isAdmin` tinyint(1) NOT NULL,
  `password` varchar(255) DEFAULT NULL,
  `userName` varchar(255) NOT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `imageUrl` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=MyISAM AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user`
--

LOCK TABLES `user` WRITE;
/*!40000 ALTER TABLE `user` DISABLE KEYS */;
INSERT INTO `user` VALUES (1,NULL,'admin@gmail.com',1,'21232f297a57a5a743894a0e4a801fc3','admin@gmail.com',NULL,NULL,NULL),(2,'Russia','tien@gmail.com',0,'2a26569e98b26668f39e98e6baef2d54','tien@gmail.com','Tien','Le',NULL),(9,'sa','sa@gmail.com',0,'c12e01f2a13ff5587e1e9e4aedb8242d','sa@gmail.com','sa','sa',NULL),(10,'Demacia','jarvan@gmail.com',0,'18aed7a71e919e7b5ace30e36deb56e0','jarvan@gmail.com','jarvan','IV',NULL);
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

-- Dump completed on 2015-04-12 19:47:55