-- MySQL dump 10.13  Distrib 5.6.24, for osx10.8 (x86_64)
--
-- Host: 127.0.0.1    Database: eBookPortal_db
-- ------------------------------------------------------
-- Server version	5.6.26

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
-- Table structure for table `admin_table`
--

DROP TABLE IF EXISTS `admin_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `admin_table` (
  `adminAge` int(11) DEFAULT NULL,
  `userID` bigint(20) NOT NULL,
  PRIMARY KEY (`userID`),
  KEY `FKF770AADE134C119B` (`userID`),
  CONSTRAINT `FKF770AADE134C119B` FOREIGN KEY (`userID`) REFERENCES `user_table` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin_table`
--

LOCK TABLES `admin_table` WRITE;
/*!40000 ALTER TABLE `admin_table` DISABLE KEYS */;
INSERT INTO `admin_table` VALUES (0,1);
/*!40000 ALTER TABLE `admin_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `book_table`
--

DROP TABLE IF EXISTS `book_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `book_table` (
  `bookID` bigint(20) NOT NULL AUTO_INCREMENT,
  `author` varchar(255) DEFAULT NULL,
  `description` varchar(255) DEFAULT NULL,
  `genreId` bigint(20) NOT NULL,
  `isbn` varchar(255) DEFAULT NULL,
  `photoName` varchar(255) DEFAULT NULL,
  `price` float DEFAULT NULL,
  `title` varchar(255) DEFAULT NULL,
  `quantity` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`bookID`),
  KEY `FK9D5346F8596E4CF7` (`genreId`),
  CONSTRAINT `FK9D5346F8596E4CF7` FOREIGN KEY (`genreId`) REFERENCES `genre_table` (`genreID`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `book_table`
--

LOCK TABLES `book_table` WRITE;
/*!40000 ALTER TABLE `book_table` DISABLE KEYS */;
INSERT INTO `book_table` VALUES (2,'Stephnie Meyer','A soulful book of love',2,'2345678901','/EBookPortal/1461654195235darkback.png',120,'Twilight Saga',NULL),(4,'JKRowling','An indeed magical journey',2,'4567890123','/EBookPortal/1461656661267nj.png',100,'Harry Potter',NULL),(5,'Steve Jobs','Journey of life of Steve Jobs',3,'0987654234','/EBookPortal/1461656760355E-Mail-Icon.png',480,'The autbiography of Steve Jobs',NULL);
/*!40000 ALTER TABLE `book_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `customer_table`
--

DROP TABLE IF EXISTS `customer_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `customer_table` (
  `customerAddress` varchar(255) DEFAULT NULL,
  `customerCity` varchar(255) DEFAULT NULL,
  `customerCountry` varchar(255) DEFAULT NULL,
  `customerGender` varchar(255) DEFAULT NULL,
  `customerPhone` varchar(255) DEFAULT NULL,
  `customerState` varchar(255) DEFAULT NULL,
  `customerZip` varchar(255) DEFAULT NULL,
  `userID` bigint(20) NOT NULL,
  PRIMARY KEY (`userID`),
  KEY `FK871A402D134C119B` (`userID`),
  CONSTRAINT `FK871A402D134C119B` FOREIGN KEY (`userID`) REFERENCES `user_table` (`userID`)
) ENGINE=InnoDB DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `customer_table`
--

LOCK TABLES `customer_table` WRITE;
/*!40000 ALTER TABLE `customer_table` DISABLE KEYS */;
INSERT INTO `customer_table` VALUES ('8SummerfieldBoulevard','SouthBrunswickTownship','United States','Female','7328533996','NJ','08810',2),('75 St. alphonsus','boston','usa','Female','9827034115','ma','02120',3);
/*!40000 ALTER TABLE `customer_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `genre_table`
--

DROP TABLE IF EXISTS `genre_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `genre_table` (
  `genreID` bigint(20) NOT NULL AUTO_INCREMENT,
  `genreName` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`genreID`),
  UNIQUE KEY `genreID` (`genreID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `genre_table`
--

LOCK TABLES `genre_table` WRITE;
/*!40000 ALTER TABLE `genre_table` DISABLE KEYS */;
INSERT INTO `genre_table` VALUES (1,'Romance'),(2,'Fiction'),(3,'NonFiction');
/*!40000 ALTER TABLE `genre_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `orderDetails_table`
--

DROP TABLE IF EXISTS `orderDetails_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `orderDetails_table` (
  `orderDetailID` bigint(20) NOT NULL AUTO_INCREMENT,
  `bookAuthor` varchar(255) DEFAULT NULL,
  `bookId` bigint(20) DEFAULT NULL,
  `bookName` varchar(255) DEFAULT NULL,
  `customerId` bigint(20) DEFAULT NULL,
  `date` varchar(255) DEFAULT NULL,
  `orderID` bigint(20) DEFAULT NULL,
  `price` float DEFAULT NULL,
  PRIMARY KEY (`orderDetailID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `orderDetails_table`
--

LOCK TABLES `orderDetails_table` WRITE;
/*!40000 ALTER TABLE `orderDetails_table` DISABLE KEYS */;
INSERT INTO `orderDetails_table` VALUES (1,'Chetan Bhagat',1,'Two States',2,'2016/04/26 03:12:33',2,50),(2,'Chetan Bhagat',1,'Two States',3,'2016/04/26 03:23:39',3,50),(3,'Stephnie Meyer',2,'Twilight Saga',3,'2016/04/26 03:23:39',3,120);
/*!40000 ALTER TABLE `orderDetails_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_table`
--

DROP TABLE IF EXISTS `order_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_table` (
  `orderID` bigint(20) NOT NULL AUTO_INCREMENT,
  `customerId` bigint(20) DEFAULT NULL,
  `itemNumber` int(11) DEFAULT NULL,
  `orderDate` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`orderID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_table`
--

LOCK TABLES `order_table` WRITE;
/*!40000 ALTER TABLE `order_table` DISABLE KEYS */;
INSERT INTO `order_table` VALUES (2,2,1,'2016/04/26 03:12:33'),(3,3,2,'2016/04/26 03:23:39');
/*!40000 ALTER TABLE `order_table` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `user_table`
--

DROP TABLE IF EXISTS `user_table`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `user_table` (
  `userID` bigint(20) NOT NULL AUTO_INCREMENT,
  `emailID` varchar(255) DEFAULT NULL,
  `firstName` varchar(255) DEFAULT NULL,
  `lastName` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `roleName` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`userID`),
  UNIQUE KEY `userID` (`userID`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=big5;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `user_table`
--

LOCK TABLES `user_table` WRITE;
/*!40000 ALTER TABLE `user_table` DISABLE KEYS */;
INSERT INTO `user_table` VALUES (1,'admin@bookstore.com','admin','admin','admin','admin','admin'),(2,'tanishajain.94@gmail.com','Tanisha','Jain','tan','Customer','tan'),(3,'shetty.v@husky.neu.edu','vega','shetty','vega','Customer','vega');
/*!40000 ALTER TABLE `user_table` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-04-26  3:46:53
