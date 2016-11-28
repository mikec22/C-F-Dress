-- phpMyAdmin SQL Dump
-- version 4.5.4.1deb2ubuntu2
-- http://www.phpmyadmin.net
--
-- 主機: localhost
-- 產生時間： 2016 年 11 月 28 日 08:20
-- 伺服器版本: 5.7.16-0ubuntu0.16.04.1
-- PHP 版本： 7.0.8-0ubuntu0.16.04.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- 資料庫： `CF_DB`
--
CREATE DATABASE IF NOT EXISTS `CF_DB` DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
USE `CF_DB`;

-- --------------------------------------------------------

--
-- 資料表結構 `client`
--
-- 建立時間: 2016 年 11 月 26 日 14:21
-- 最後更新: 2016 年 11 月 27 日 23:57
--

DROP TABLE IF EXISTS `client`;
CREATE TABLE IF NOT EXISTS `client` (
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
) ENGINE=InnoDB AUTO_INCREMENT=23 DEFAULT CHARSET=utf8;

--
-- 資料表新增前先清除舊資料 `client`
--

TRUNCATE TABLE `client`;
--
-- 資料表的匯出資料 `client`
--

INSERT INTO `client` (`client_id`, `login_id`, `password`, `name`, `gender`, `dob`, `email`, `phone`, `address`, `bonus_point`, `verified`, `balance`, `credit_amount`) VALUES
(1, 'Chris', '123', 'Chris Wong', 'F', '1995-09-03', 'abc@vtc.edu.hk', '12345678', 'hhh', 15787, 1, '43584.00', '999999.00'),
(2, 'Peter', '123', 'Peter Chan', 'M', '1994-02-01', 'edf@vdc.edu.hk', '23456789', '777', 1000, 1, '-499.00', '500.00'),
(3, 'Joe', '123', 'Joe Lam', 'M', '1993-04-03', 'joe@vtc.edu.hk', '12345678', '20 Tsing Yi Road\r\nTsing Yi Island\r\nNew Territories', 977699, 1, '989844.99', '0.00'),
(4, 'Dick', '123', 'Dick Hui', 'M', '1994-01-01', 'dick@gmail.com', '12312333', 'asd', 1000, 1, '0.00', '0.00'),
(5, 'JSON', '123', 'JSON Lam', 'M', '1997-07-01', 'json@vtc.edu.hk', '87634321', 'abc', 1000, 1, '0.00', '0.00'),
(10, 'Apple', '123', 'Apple Wong', 'M', '2016-11-10', '123@123.com', '12345678', 'Test', 1000, 1, '0.00', '0.00'),
(11, 'Ben', '123', 'Ben Wong', 'M', '1988-04-04', 'ben@vtc.edu.hk', '23456766', '123', 1000, 0, '0.00', '0.00'),
(12, 'usa', '123', 'Chan Tai Man', 'M', '1995-11-11', 'usa@vtc.edu.hk', '67891234', '123', 1000, 1, '103.50', '0.00'),
(13, 'syw', '123', 'SYW', 'F', '1995-09-03', 'syw@syw.com', '99999999', 'PIGPIGPIG', 1000, 0, '0.00', '0.00'),
(16, 'sywsyw', '123', 'syw', 'F', '2016-12-31', 'syw@12345.com.hk', '12345678', 'TY', 1000, 0, '0.00', '0.00'),
(21, 'Mary', '123', 'Mary Wong', 'F', '2016-01-01', 'Marywong@abc.com.hk', '87654321', 'A204, Block A,  20 Tsing Yi Road, Tsing Yi Island, New Territories,\r\nHong Kong', 263, 1, '89607.00', '0.00');

-- --------------------------------------------------------

--
-- 資料表結構 `item`
--
-- 建立時間: 2016 年 11 月 25 日 03:09
-- 最後更新: 2016 年 11 月 27 日 20:03
--

DROP TABLE IF EXISTS `item`;
CREATE TABLE IF NOT EXISTS `item` (
  `item_id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(50) NOT NULL,
  `category` varchar(20) NOT NULL,
  `designer` varchar(45) NOT NULL,
  `price` decimal(7,2) NOT NULL,
  `description` varchar(255) NOT NULL,
  `img` varchar(255) NOT NULL,
  PRIMARY KEY (`item_id`)
) ENGINE=InnoDB AUTO_INCREMENT=36 DEFAULT CHARSET=utf8;

--
-- 資料表新增前先清除舊資料 `item`
--

TRUNCATE TABLE `item`;
--
-- 資料表的匯出資料 `item`
--

INSERT INTO `item` (`item_id`, `name`, `category`, `designer`, `price`, `description`, `img`) VALUES
(1, 'Black Halo Women\'s Constance Velvet Dress', 'clothing', 'Black Halo', '400.00', '5% elastane,91% polyamide/9% elastane,95% polyamide/5% elastane,Dry cleanWidth 48in / 122cm, from shoulder', 'c1.jpg'),
(2, 'Sleeve Oversized Bubble Jersey Midi Dress', 'clothing', 'Tabeez ', '450.00', 'Material Content: 95% Rayon, 5% Spandex', 'c2.jpg'),
(3, 'Women\'s Marissa Sheath Dress', 'clothing', 'Black Halo', '330.00', 'Stretch suiting,\r\n62% polyamide/33% viscose/5% elastane,\r\n95% polyamide/5% elastane', 'c3.jpg'),
(4, 'Women\'s Nella Polka Dot Dress', 'clothing', 'Black Halo', '570.00', '5% elastane,\r\nCrepe,\r\n99% polyamide/1% elastane,\r\n95% polyamide/5% elastane', 'c4.jpg'),
(5, 'Lace Dress Long Sleeve Bodycon Casual Dresses', 'clothing', 'ACEVOG ', '220.00', 'High quality Lace,strench', 'c5.jpg'),
(6, 'Women\'s Jackie O Dress', 'clothing', 'Black Halo', '790.00', '90% Polyamide, 10% Elastane; Lining: 95% Polyamide, 5% Elastane', 'c6.jpg'),
(7, 'Sleeve A-line and Flare Midi Long Dress', 'clothing', 'Tabeez ', '499.00', 'Soft and comfortable material, casual loose fit, features a swing hem and pleated t-shirt dress.', 'c7.jpg'),
(8, 'Stylish A-Line Trapeze Midi Dress', 'clothing', 'Tabeez ', '288.00', 'Made in USA with the highest standard of quality material.', 'c8.jpg'),
(9, 'Loose Hacci Knit Flared Dress with Side Pockets', 'clothing', 'Tabeez ', '399.00', 'Designed with sensibility, this whisper-soft sweater dress is spun from a delectable, two-tone fabric to offer rich contrast and fashion-forward appeal.', 'c9.jpg'),
(10, 'Bohemian Long Sleeve Floral Print Tunic Dress', 'clothing', 'ACEVOG ', '599.00', 'Suitable for: Beachwear, Party, Daily wear, Vocation', 'c10.jpg'),
(11, 'Quartz Gold-Tone and Rubber Casual Watch', 'watches', 'Tommy Hilfiger', '999.00', 'Water resistant to 30m (100ft): in general, withstands splashes or brief immersion in water, but not suitable for swimming or bathing', 'w1.jpg'),
(12, 'Quartz Tone and Gold-Plated Casual Watch', 'watches', 'Tommy Hilfiger', '1299.00', 'Water resistant to 30m (100ft): In general, withstands splashes or brief immersion in water, but not suitable for swimming or bathing\r\n', 'w2.jpg'),
(13, ' Quartz Gold and Nylon Casual Watch', 'watches', 'Tommy Hilfiger', '1398.00', 'Gold-tone watch featuring round white dial with GiGi patterned inner dial and Arabic numeric indices with flag logo at 3 o\'clock', 'w3.jpg'),
(14, 'Stainless Steel Watch with White Silicone Band', 'watches', 'Tommy Hilfiger', '730.00', 'Round watch featuring branded silver-tone bezel and white dial with Arabic numeric hour markers and inner seconds track', 'w4.jpg'),
(15, 'Silver Steel Watch Kw6010s', 'watches', 'Lava Watches', '599.00', 'Rhombic shape watch featuring white dial, analog display, combine fashion and casual style, along with rhombic hour marks', 'w5.jpg'),
(16, 'Diamond-Accented Bangle Watch', 'watches', 'Lava Watches', '1499.00', 'Bangle watch featuring rectangular dial with three-hand movement and diamond at 12 o\'clock mark', 'w6.jpg'),
(17, 'Bangle Cuff Bracelet Analog Watch', 'watches', 'Lava Watches', '988.00', 'For all occasions. A perfect gift. Both a fashion watch & a chic bracelet jewelry.', 'w7.jpg'),
(18, 'Norie Gold Watch MK3586', 'watches', 'Michael Kors ', '1288.00', 'Norie two-tone three-hand watch', 'w8.jpg'),
(19, 'Mini Darci Gold Watch MK3583', 'watches', 'Michael Kors ', '1399.00', 'Water resistant to 50m (165ft: in general, suitable for short periods of recreational swimming, but not diving or snorkeling', 'w9.jpg'),
(20, 'Darci Grey Rose Gold Watch MK3584', 'watches', 'Michael Kors ', '1599.00', 'Two rows of rhinestones inset at bezel', 'w10.jpg'),
(21, 'Kaylee Suede Dress Pump', 'shoes', 'Nine West', '377.00', 'Heel measures approximately 3.75"', 's1.jpg'),
(22, 'Hollison Suede Dress Pump', 'shoes', 'Nine West', '399.00', 'Heel measures approximately 3.25"', 's2.jpg'),
(23, 'Garrie Dress Pump', 'shoes', 'Nine West ', '249.00', 'Make by leather', 's3.jpg'),
(24, 'Franny Leather Dress Pump', 'shoes', 'Nine West ', '299.00', 'Heel measures approximately 2.5"', 's4.jpg'),
(25, 'Low Wedge Heel – Cute Office Casual Shoe', 'shoes', 'J. Adams', '268.00', 'These gorgeous easy to wear shoes offer balance and stability for all day walking comfort and support on the heel.', 's5.jpg'),
(26, 'Comfortable Low Flats - Diana Casual Walking Shoe', 'shoes', 'J. Adams', '199.00', ' These classic loafers are a perfect addition to any outfit. Wear them out or at the office.', 's6.jpg'),
(27, 'Faux Suede Comfort Slip-on Penny Loafer Flat Shoes', 'shoes', 'J. Adams', '210.00', 'Heel measures approximately 0.75 inches"', 's7.jpg'),
(28, 'Jessica Dress Pump', 'shoes', 'Kate Spade', '589.00', 'Heel measures approximately 2.75"', 's8.jpg'),
(29, 'Juliette Dress Pump', 'shoes', 'Kate Spade New York', '729.00', 'Heel measures approximately 2.5"', 's9.jpg'),
(30, 'Sala D\'Orsay Pump', 'shoes', 'Kate Spade New York', '890.00', 'Two-piece pump in satin with bow adorning open toe and lightly cushioned heel.', 's10.jpg'),
(31, 'Women\'s Marled Fedora Hat', 'gifts', 'Nautica', '2400.00', '100% Other Fibers\r\nImported\r\nDry Clean Only\r\nNautica logo plate\r\nEasy to wear', 'g1.jpg'),
(32, 'RB3016 Classic Clubmaster Sunglasses', 'gifts', 'Ray-Ban', '4900.00', 'Composite/Plastic Frame.\r\nImported\r\nPlastic frame\r\nSynthetic lens\r\nNon-Polarized\r\n100% UV protection coating\r\nLens width: 49.2 millimeters', 'g2.jpg'),
(33, 'Mens 38mm Leather Belt With Two Row Stitch', 'gifts', 'Dickies ', '1500.00', '100% Leather\r\nWash by hand with damp cloth\r\nDouble row stitching\r\nFor a proper fit, order belt two full sizes larger than your normal waist size\r\nImported', 'g3.jpg'),
(34, 'Trump 2016 Adjustable Cap with Rope Front', 'gifts', 'BRC', '1900.00', 'Wear the cap worn by 2016 presidential nominee Donald Trump on his 2016 Presidential Trail\r\nAdjustable snap back - One size fits most\r\nHigh quality beautiful embroidered text\r\nProudly embroidered in the U.S.A.\r\nSide vents style may vary slightly', 'g4.jpg'),
(35, 'Balaclava Fleece Hood - Windproof Face Ski Mask ', 'gifts', 'Self Pro', '2600.00', 'ULTIMATE PROTECTION from EXTREME COLD, WIND, DUST and SUN\'s UV Rays. HEADWEAR BUNDLE: Unisex Versatile Balaclava. Perfect fit for Women Men and Children - Protect Yourself & Family\r\n', 'g5.jpg');

-- --------------------------------------------------------

--
-- 資料表結構 `order`
--
-- 建立時間: 2016 年 11 月 27 日 12:48
-- 最後更新: 2016 年 11 月 27 日 23:57
--

DROP TABLE IF EXISTS `order`;
CREATE TABLE IF NOT EXISTS `order` (
  `order_id` int(11) NOT NULL AUTO_INCREMENT,
  `client_id` int(11) NOT NULL,
  `delivery_datetime` datetime NOT NULL,
  `order_datetime` datetime DEFAULT CURRENT_TIMESTAMP,
  `address` varchar(255) NOT NULL,
  `option` varchar(10) NOT NULL,
  `status` varchar(20) NOT NULL,
  `delay_day` int(11) NOT NULL DEFAULT '0',
  PRIMARY KEY (`order_id`),
  KEY `Order_client_id_idx` (`client_id`)
) ENGINE=InnoDB AUTO_INCREMENT=47 DEFAULT CHARSET=utf8;

--
-- 資料表新增前先清除舊資料 `order`
--

TRUNCATE TABLE `order`;
--
-- 資料表的匯出資料 `order`
--

INSERT INTO `order` (`order_id`, `client_id`, `delivery_datetime`, `order_datetime`, `address`, `option`, `status`, `delay_day`) VALUES
(1, 1, '2019-02-02 15:00:00', '2016-11-26 20:28:39', 'self pick-up', 'self', 'processing', 0),
(2, 3, '2016-12-01 01:00:00', '2016-11-26 20:50:53', '20 Tsing Yi Road\r\nTsing Yi Island\r\nNew Territories', 'delivery', 'processing', 0),
(3, 3, '1999-01-01 01:01:01', '2016-11-26 22:28:54', 'self pick-up', 'self', 'processing', 0),
(4, 3, '1999-01-01 01:01:01', '2016-11-26 23:04:01', 'self pick-up', 'self', 'processing', 0),
(5, 2, '1999-01-01 01:01:01', '2016-11-27 02:08:17', 'self pick-up', 'self', 'processing', 0),
(6, 3, '1999-01-01 01:01:01', '2016-11-27 02:27:02', 'self pick-up', 'self', 'processing', 0),
(7, 3, '1999-01-01 01:01:01', '2016-11-27 02:28:32', 'self pick-up', 'self', 'processing', 0),
(8, 3, '1999-01-01 01:01:01', '2016-11-27 02:29:28', 'self pick-up', 'self', 'processing', 0),
(9, 3, '1999-01-01 01:01:01', '2016-11-27 02:37:06', 'self pick-up', 'self', 'processing', 0),
(10, 3, '1999-01-01 01:01:01', '2016-11-27 02:39:14', 'self pick-up', 'self', 'processing', 0),
(11, 3, '1999-01-01 01:01:01', '2016-11-27 02:40:50', 'self pick-up', 'self', 'processing', 0),
(12, 3, '1999-01-01 01:01:01', '2016-11-27 02:52:25', 'self pick-up', 'self', 'processing', 0),
(13, 3, '1999-01-01 01:01:01', '2016-11-27 02:55:50', 'self pick-up', 'self', 'processing', 0),
(14, 3, '1999-01-01 01:01:01', '2016-11-27 02:56:09', 'self pick-up', 'self', 'processing', 0),
(15, 1, '1999-01-01 01:01:01', '2016-11-27 03:43:55', 'hhh', 'delivery', 'calcelled', 0),
(16, 3, '1999-01-01 01:01:01', '2016-11-27 18:37:28', 'self pick-up', 'self', 'processing', 0),
(17, 3, '1999-01-01 01:01:01', '2016-11-27 18:42:13', 'self pick-up', 'self', 'processing', 0),
(18, 3, '1999-01-01 01:01:01', '2016-11-27 18:42:44', 'self pick-up', 'self', 'processing', 0),
(19, 3, '1999-01-01 01:01:01', '2016-11-27 22:54:24', 'self pick-up', 'self', 'processing', 0),
(20, 3, '2016-11-29 01:00:00', '2016-11-27 23:04:52', '20 Tsing Yi Road\r\nTsing Yi Island\r\nNew Territories', 'delivery', 'processing', 0),
(21, 1, '2019-12-31 15:59:00', '2016-11-28 01:11:53', 'hhh', 'delivery', 'processing', 0),
(22, 21, '2017-12-30 13:00:00', '2016-11-28 02:17:31', 'self pick-up', 'self', 'processing', 0),
(23, 21, '2016-12-30 13:00:00', '2016-11-28 02:20:28', 'A204, Block A,  20 Tsing Yi Road, Tsing Yi Island, New Territories,\r\nHong Kong', 'delivery', 'processing', 0),
(24, 3, '2016-11-30 02:00:00', '2016-11-28 02:25:02', '20 Tsing Yi Road\r\nTsing Yi Island\r\nNew Territories', 'delivery', 'processing', 0),
(25, 21, '1999-01-01 01:01:01', '2016-11-28 02:43:15', 'self pick-up', 'self', 'processing', 0),
(26, 1, '1999-01-01 01:01:01', '2016-11-28 02:51:29', 'self pick-up', 'self', 'calcelled', 0),
(27, 1, '1999-01-01 01:01:01', '2016-11-28 02:53:06', 'hhh', 'delivery', 'calcelled', 0),
(28, 1, '1999-01-01 01:01:01', '2016-11-28 06:25:53', 'self pick-up', 'self', 'calcelled', 0),
(29, 1, '1999-01-01 01:01:01', '2016-11-28 07:01:33', 'self pick-up', 'self', 'calcelled', 0),
(30, 1, '1999-01-01 01:01:01', '2016-11-28 07:02:31', 'self pick-up', 'self', 'calcelled', 0),
(31, 3, '1999-01-01 01:01:01', '2016-11-28 07:12:38', 'self pick-up', 'self', 'processing', 0),
(32, 3, '2016-11-30 13:00:00', '2016-11-28 07:16:16', '20 Tsing Yi Road\r\nTsing Yi Island\r\nNew Territories', 'delivery', 'processing', 0),
(33, 1, '1999-01-01 01:01:01', '2016-11-28 07:22:32', 'self pick-up', 'self', 'calcelled', 0),
(34, 1, '1999-01-01 01:01:01', '2016-11-28 07:24:27', 'self pick-up', 'self', 'calcelled', 0),
(35, 1, '1999-01-01 01:01:01', '2016-11-28 07:39:55', 'self pick-up', 'self', 'calcelled', 0),
(36, 1, '2017-01-01 13:00:00', '2016-11-28 07:57:06', 'hhh', 'delivery', 'processing', 0);

-- --------------------------------------------------------

--
-- 資料表結構 `order_line`
--
-- 建立時間: 2016 年 11 月 26 日 13:37
-- 最後更新: 2016 年 11 月 27 日 23:57
--

DROP TABLE IF EXISTS `order_line`;
CREATE TABLE IF NOT EXISTS `order_line` (
  `order_id` int(11) NOT NULL,
  `item_id` int(11) NOT NULL,
  `total_price` decimal(7,2) NOT NULL,
  `quantity` int(3) NOT NULL,
  `bonus_point` int(11) NOT NULL DEFAULT '0',
  `item_price` decimal(7,2) NOT NULL,
  PRIMARY KEY (`order_id`,`item_id`),
  KEY `order_line_item_id_idx` (`item_id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- 資料表新增前先清除舊資料 `order_line`
--

TRUNCATE TABLE `order_line`;
--
-- 資料表的匯出資料 `order_line`
--

INSERT INTO `order_line` (`order_id`, `item_id`, `total_price`, `quantity`, `bonus_point`, `item_price`) VALUES
(1, 13, '2796.00', 2, 0, '0.00'),
(2, 3, '330.00', 1, 0, '0.00'),
(3, 3, '660.00', 2, 0, '330.00'),
(4, 2, '450.00', 1, 0, '450.00'),
(4, 12, '3897.00', 3, 0, '1299.00'),
(5, 16, '1499.00', 1, 0, '1499.00'),
(6, 3, '330.00', 1, 0, '330.00'),
(8, 12, '1299.00', 1, 0, '1299.00'),
(9, 2, '450.00', 1, 0, '450.00'),
(12, 2, '450.00', 1, 0, '450.00'),
(15, 21, '37700.00', 100, 0, '377.00'),
(16, 31, '0.00', 1, 0, '0.00'),
(16, 32, '0.00', 1, 0, '0.00'),
(16, 33, '0.00', 1, 0, '0.00'),
(16, 34, '0.00', 1, 0, '0.00'),
(16, 35, '0.00', 1, 0, '0.00'),
(17, 32, '0.00', 1, 4900, '0.00'),
(17, 33, '0.00', 1, 1500, '0.00'),
(18, 35, '0.00', 1, 2600, '0.00'),
(19, 3, '330.00', 1, 0, '330.00'),
(20, 3, '330.00', 1, 0, '330.00'),
(21, 1, '1200.00', 3, 0, '400.00'),
(21, 22, '798.00', 2, 0, '399.00'),
(22, 12, '10392.00', 8, 0, '1299.00'),
(22, 23, '2490.00', 10, 0, '249.00'),
(23, 12, '10392.00', 8, 0, '1299.00'),
(24, 3, '330.00', 1, 0, '330.00'),
(25, 34, '0.00', 1, 1900, '0.00'),
(26, 16, '29980.00', 20, 0, '1499.00'),
(27, 17, '29640.00', 30, 0, '988.00'),
(28, 11, '99900.00', 100, 0, '999.00'),
(29, 21, '37700.00', 100, 0, '377.00'),
(30, 23, '24900.00', 100, 0, '249.00'),
(31, 3, '330.00', 1, 0, '330.00'),
(32, 12, '1299.00', 1, 0, '1299.00'),
(33, 13, '13980.00', 10, 0, '1398.00'),
(34, 13, '13980.00', 10, 0, '1398.00'),
(35, 11, '10989.00', 11, 0, '999.00'),
(36, 12, '5196.00', 4, 0, '1299.00');

-- --------------------------------------------------------

--
-- 資料表結構 `staff`
--
-- 建立時間: 2016 年 11 月 27 日 12:39
-- 最後更新: 2016 年 11 月 27 日 13:10
--

DROP TABLE IF EXISTS `staff`;
CREATE TABLE IF NOT EXISTS `staff` (
  `staff_id` int(11) NOT NULL AUTO_INCREMENT,
  `login_id` varchar(45) NOT NULL,
  `password` varchar(20) NOT NULL,
  `name` varchar(20) NOT NULL,
  `gender` varchar(1) NOT NULL,
  PRIMARY KEY (`staff_id`),
  UNIQUE KEY `login_id_UNIQUE` (`login_id`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;

--
-- 資料表新增前先清除舊資料 `staff`
--

TRUNCATE TABLE `staff`;
--
-- 資料表的匯出資料 `staff`
--

INSERT INTO `staff` (`staff_id`, `login_id`, `password`, `name`, `gender`) VALUES
(1, 'MaryAdmin', '123', 'Mary Chan', 'F'),
(2, 'admin', '123', 'Peter Wong', 'M');

--
-- 已匯出資料表的限制(Constraint)
--

--
-- 資料表的 Constraints `order`
--
ALTER TABLE `order`
  ADD CONSTRAINT `Order_client_id` FOREIGN KEY (`client_id`) REFERENCES `client` (`client_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

--
-- 資料表的 Constraints `order_line`
--
ALTER TABLE `order_line`
  ADD CONSTRAINT `order_line_item_id` FOREIGN KEY (`item_id`) REFERENCES `item` (`item_id`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  ADD CONSTRAINT `order_line_order_id` FOREIGN KEY (`order_id`) REFERENCES `order` (`order_id`) ON DELETE NO ACTION ON UPDATE NO ACTION;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
