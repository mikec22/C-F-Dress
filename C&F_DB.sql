CREATE DATABASE  IF NOT EXISTS `CF_DB` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `CF_DB`;
-- MySQL dump 10.13  Distrib 5.7.12, for osx10.9 (x86_64)
--
-- Host: dev16.asuscomm.com    Database: CF_DB
-- ------------------------------------------------------
-- Server version	5.7.16-0ubuntu0.16.04.1

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
-- Table structure for table `client`
--

DROP TABLE IF EXISTS `client`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `client` (
  `client_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_id` varchar(15) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `gender` varchar(1) NOT NULL,
  `dob` date DEFAULT NULL,
  `email` varchar(50) NOT NULL,
  `phone` varchar(8) NOT NULL,
  `address` varchar(255) NOT NULL,
  `bonus_point` int(11) NOT NULL DEFAULT '1000',
  `verified` tinyint(1) NOT NULL DEFAULT '0',
  `balance` decimal(9,2) NOT NULL DEFAULT '0.00',
  `credit_amount` decimal(9,2) NOT NULL DEFAULT '0.00',
  PRIMARY KEY (`client_id`),
  UNIQUE KEY `email_UNIQUE` (`email`),
  UNIQUE KEY `login_id_UNIQUE` (`login_id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `client`
--

LOCK TABLES `client` WRITE;
/*!40000 ALTER TABLE `client` DISABLE KEYS */;
INSERT INTO `client` VALUES (1,'Chris','123','Chris Wong','M','1993-01-02','abc@vtc.edu.hk','12345678','hhh',1139,1,6704.00,0.00),(2,'Peter','123','Peter Chan','M','1994-02-01','edf@vdc.edu.hk','23456789','777',1000,0,100.00,0.00),(3,'Joe','123','Joe Lam','M','1993-04-03','joe@vtc.edu.hk','12345678','20 Tsing Yi Road\r\nTsing Yi Island\r\nNew Territories',10217,1,994992.99,0.00),(4,'Dick','123','Dick Hui','M','1994-01-01','dick@gmail.com','12312333','asd',1000,1,0.00,0.00),(5,'JSON','123','JSON Lam','M','1997-07-01','json@vtc.edu.hk','87634321','abc',1000,0,0.00,0.00),(7,'Mary','123','Mary Chan','M','1803-04-04','mary@gmail.com','12312312','123',1000,0,0.00,0.00),(10,'Apple','123','Apple Wong','M','2016-11-10','123@123.com','12345678','Test',1000,0,0.00,0.00),(11,'Ben','123','Ben Wong','M','1988-04-04','ben@vtc.edu.hk','23456766','123',1000,0,0.00,0.00),(12,'usa','123','Chan Tai Man','M','1995-11-11','usa@vtc.edu.hk','67891234','123',1000,1,103.50,0.00);
/*!40000 ALTER TABLE `client` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `item`
--

DROP TABLE IF EXISTS `item`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `category` varchar(20) NOT NULL,
  `designer` varchar(45) NOT NULL,
  `price` decimal(7,2) NOT NULL,
  `description` varchar(255) NOT NULL,
  `img` varchar(255) NOT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `item`
--

LOCK TABLES `item` WRITE;
/*!40000 ALTER TABLE `item` DISABLE KEYS */;
INSERT INTO `item` VALUES (1,'Black Halo Women\'s Constance Velvet Dress','clothing','Black Halo',400.00,'5% elastane,91% polyamide/9% elastane,95% polyamide/5% elastane,Dry cleanWidth 48in / 122cm, from shoulder','c1.jpg'),(2,'Sleeve Oversized Bubble Jersey Midi Dress','clothing','Tabeez ',450.00,'Material Content: 95% Rayon, 5% Spandex','c2.jpg'),(3,'Women\'s Marissa Sheath Dress','clothing','Black Halo',330.00,'Stretch suiting,\r\n62% polyamide/33% viscose/5% elastane,\r\n95% polyamide/5% elastane','c3.jpg'),(4,'Women\'s Nella Polka Dot Dress','clothing','Black Halo',570.00,'5% elastane,\r\nCrepe,\r\n99% polyamide/1% elastane,\r\n95% polyamide/5% elastane','c4.jpg'),(5,'Lace Dress Long Sleeve Bodycon Casual Dresses','clothing','ACEVOG ',220.00,'High quality Lace,strench','c5.jpg'),(6,'Women\'s Jackie O Dress','clothing','Black Halo',790.00,'90% Polyamide, 10% Elastane; Lining: 95% Polyamide, 5% Elastane','c6.jpg'),(7,'Sleeve A-line and Flare Midi Long Dress','clothing','Tabeez ',499.00,'Soft and comfortable material, casual loose fit, features a swing hem and pleated t-shirt dress.','c7.jpg'),(8,'Stylish A-Line Trapeze Midi Dress','clothing','Tabeez ',288.00,'Made in USA with the highest standard of quality material.','c8.jpg'),(9,'Loose Hacci Knit Flared Dress with Side Pockets','clothing','Tabeez ',399.00,'Designed with sensibility, this whisper-soft sweater dress is spun from a delectable, two-tone fabric to offer rich contrast and fashion-forward appeal.','c9.jpg'),(10,'Bohemian Long Sleeve Floral Print Tunic Dress','clothing','ACEVOG ',599.00,'Suitable for: Beachwear, Party, Daily wear, Vocation','c10.jpg'),(11,'Quartz Gold-Tone and Rubber Casual Watch','watches','Tommy Hilfiger',999.00,'Water resistant to 30m (100ft): in general, withstands splashes or brief immersion in water, but not suitable for swimming or bathing','w1.jpg'),(12,'Quartz Tone and Gold-Plated Casual Watch','watches','Tommy Hilfiger',1299.00,'Water resistant to 30m (100ft): In general, withstands splashes or brief immersion in water, but not suitable for swimming or bathing\r\n','w2.jpg'),(13,' Quartz Gold and Nylon Casual Watch','watches','Tommy Hilfiger',1398.00,'Gold-tone watch featuring round white dial with GiGi patterned inner dial and Arabic numeric indices with flag logo at 3 o\'clock','w3.jpg'),(14,'Stainless Steel Watch with White Silicone Band','watches','Tommy Hilfiger',730.00,'Round watch featuring branded silver-tone bezel and white dial with Arabic numeric hour markers and inner seconds track','w4.jpg'),(15,'Silver Steel Watch Kw6010s','watches','Lava Watches',599.00,'Rhombic shape watch featuring white dial, analog display, combine fashion and casual style, along with rhombic hour marks','w5.jpg'),(16,'Diamond-Accented Bangle Watch','watches','Lava Watches',1499.00,'Bangle watch featuring rectangular dial with three-hand movement and diamond at 12 o\'clock mark','w6.jpg'),(17,'Bangle Cuff Bracelet Analog Watch','watches','Lava Watches',988.00,'For all occasions. A perfect gift. Both a fashion watch & a chic bracelet jewelry.','w7.jpg'),(18,'Norie Gold Watch MK3586','watches','Michael Kors ',1288.00,'Norie two-tone three-hand watch','w8.jpg'),(19,'Mini Darci Gold Watch MK3583','watches','Michael Kors ',1399.00,'Water resistant to 50m (165ft: in general, suitable for short periods of recreational swimming, but not diving or snorkeling','w9.jpg'),(20,'Darci Grey Rose Gold Watch MK3584','watches','Michael Kors ',1599.00,'Two rows of rhinestones inset at bezel','w10.jpg'),(21,'Kaylee Suede Dress Pump','shoes','Nine West',377.00,'Heel measures approximately 3.75\"','s1.jpg'),(22,'Hollison Suede Dress Pump','shoes','Nine West',399.00,'Heel measures approximately 3.25\"','s2.jpg'),(23,'Garrie Dress Pump','shoes','Nine West ',249.00,'Make by leather','s3.jpg'),(24,'Franny Leather Dress Pump','shoes','Nine West ',299.00,'Heel measures approximately 2.5\"','s4.jpg'),(25,'Low Wedge Heel – Cute Office Casual Shoe','shoes','J. Adams',268.00,'These gorgeous easy to wear shoes offer balance and stability for all day walking comfort and support on the heel.','s5.jpg'),(26,'Comfortable Low Flats - Diana Casual Walking Shoe','shoes','J. Adams',199.00,' These classic loafers are a perfect addition to any outfit. Wear them out or at the office.','s6.jpg'),(27,'Faux Suede Comfort Slip-on Penny Loafer Flat Shoes','shoes','J. Adams',210.00,'Heel measures approximately 0.75 inches\"','s7.jpg'),(28,'Jessica Dress Pump','shoes','Kate Spade',589.00,'Heel measures approximately 2.75\"','s8.jpg'),(29,'Juliette Dress Pump','shoes','Kate Spade New York',729.00,'Heel measures approximately 2.5\"','s9.jpg'),(30,'Sala D\'Orsay Pump','shoes','Kate Spade New York',890.00,'Two-piece pump in satin with bow adorning open toe and lightly cushioned heel.','s10.jpg'),(31,'Women\'s Marled Fedora Hat','gifts','Nautica',2400.00,'100% Other Fibers\r\nImported\r\nDry Clean Only\r\nNautica logo plate\r\nEasy to wear','g1.jpg'),(32,'RB3016 Classic Clubmaster Sunglasses','gifts','Ray-Ban',4900.00,'Composite/Plastic Frame.\r\nImported\r\nPlastic frame\r\nSynthetic lens\r\nNon-Polarized\r\n100% UV protection coating\r\nLens width: 49.2 millimeters','g2.jpg'),(33,'Mens 38mm Leather Belt With Two Row Stitch','gifts','Dickies ',1500.00,'100% Leather\r\nWash by hand with damp cloth\r\nDouble row stitching\r\nFor a proper fit, order belt two full sizes larger than your normal waist size\r\nImported','g3.jpg'),(34,'Trump 2016 Adjustable Cap with Rope Front','gifts','BRC',1900.00,'Wear the cap worn by 2016 presidential nominee Donald Trump on his 2016 Presidential Trail\r\nAdjustable snap back - One size fits most\r\nHigh quality beautiful embroidered text\r\nProudly embroidered in the U.S.A.\r\nSide vents style may vary slightly','g4.jpg'),(35,'Balaclava Fleece Hood - Windproof Face Ski Mask ','gifts','Self Pro',2600.00,'ULTIMATE PROTECTION from EXTREME COLD, WIND, DUST and SUN\'s UV Rays. HEADWEAR BUNDLE: Unisex Versatile Balaclava. Perfect fit for Women Men and Children - Protect Yourself & Family\r\n','g5.jpg');
/*!40000 ALTER TABLE `item` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order`
--

DROP TABLE IF EXISTS `order`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `delivery_datetime` datetime NOT NULL,
  `order_datetime` datetime DEFAULT CURRENT_TIMESTAMP,
  `address` varchar(255) NOT NULL,
  `option` varchar(10) NOT NULL,
  `status` varchar(20) NOT NULL,
  `delay_day` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_id`),
  KEY `Order_client_id_idx` (`client_id`),
  CONSTRAINT `Order_client_id` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order`
--

LOCK TABLES `order` WRITE;
/*!40000 ALTER TABLE `order` DISABLE KEYS */;
INSERT INTO `order` VALUES (1,1,'1999-01-01 01:01:01','2016-11-26 20:28:39','self pick-up','self','processing',0),(2,3,'2016-11-30 01:00:00','2016-11-26 20:50:53','20 Tsing Yi Road\r\nTsing Yi Island\r\nNew Territories','delivery','processing',0),(3,3,'1999-01-01 01:01:01','2016-11-26 22:28:54','self pick-up','self','processing',0),(4,3,'1999-01-01 01:01:01','2016-11-26 23:04:01','self pick-up','self','processing',0);
/*!40000 ALTER TABLE `order` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `order_line`
--

DROP TABLE IF EXISTS `order_line`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `order_line` (
  `order_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `total_price` decimal(7,2) NOT NULL,
  `quantity` int(3) NOT NULL,
  `bonus_point` int(11) NOT NULL DEFAULT '0',
  `item_price` decimal(7,2) NOT NULL,
  PRIMARY KEY (`order_id`,`item_id`),
  KEY `order_line_item_id_idx` (`item_id`),
  CONSTRAINT `order_line_item_id` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `order_line_order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `order_line`
--

LOCK TABLES `order_line` WRITE;
/*!40000 ALTER TABLE `order_line` DISABLE KEYS */;
INSERT INTO `order_line` VALUES (1,13,2796.00,2,0,0.00),(2,3,330.00,1,0,0.00),(3,3,660.00,2,0,330.00),(4,2,450.00,1,0,450.00),(4,12,3897.00,3,0,1299.00);
/*!40000 ALTER TABLE `order_line` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `staff`
--

DROP TABLE IF EXISTS `staff`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `staff` (
  `staff_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_id` varchar(45) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `gender` varchar(1) NOT NULL,
  PRIMARY KEY (`staff_id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `staff`
--

LOCK TABLES `staff` WRITE;
/*!40000 ALTER TABLE `staff` DISABLE KEYS */;
INSERT INTO `staff` VALUES (1,'MaryAdmin','123','Mary Chan','F');
/*!40000 ALTER TABLE `staff` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2016-11-26 23:18:27
