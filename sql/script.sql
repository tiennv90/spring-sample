-- phpMyAdmin SQL Dump
-- version 2.10.3
-- http://www.phpmyadmin.net
-- 
-- Host: localhost
-- Generation Time: Apr 12, 2015 at 03:00 AM
-- Server version: 5.0.51
-- PHP Version: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";

-- 
-- Database: `spring-ecomercial`
-- 

-- --------------------------------------------------------

-- 
-- Table structure for table `category`
-- 

CREATE TABLE `category` (
  `id` int(11) NOT NULL auto_increment,
  `name` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=8 ;

-- 
-- Dumping data for table `category`
-- 

INSERT INTO `category` VALUES (1, 'Clothing');
INSERT INTO `category` VALUES (2, 'Bathing & Grooming');
INSERT INTO `category` VALUES (3, 'Health Products');
INSERT INTO `category` VALUES (4, 'Mobility');
INSERT INTO `category` VALUES (5, 'Kitchen');
INSERT INTO `category` VALUES (6, 'Hobbies');
INSERT INTO `category` VALUES (7, 'Phones & Pagers');

-- --------------------------------------------------------

-- 
-- Table structure for table `feedback`
-- 

CREATE TABLE `feedback` (
  `id` int(11) NOT NULL auto_increment,
  `email` varchar(255) default NULL,
  `feedback` varchar(255) default NULL,
  `name` varchar(255) default NULL,
  `phoneNumber` varchar(255) default NULL,
  PRIMARY KEY  (`id`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

-- 
-- Dumping data for table `feedback`
-- 

INSERT INTO `feedback` VALUES (1, 'tiennv90@gmail.com', 'dasdasdadasd', 'Tien Nguyen', '0167323232');
INSERT INTO `feedback` VALUES (2, 'tiennv90@gmail.com', 'dasdasdadasd', 'Tien Nguyen', '0167323232');
INSERT INTO `feedback` VALUES (3, 'tiennv90@gmail.com', 'asdasdasdasda', 'Tien Nguyen', '0167323232');
INSERT INTO `feedback` VALUES (4, 'tienstreetdance@yahoo.com', 'asdasdasdasd', 'Tien Nguyen', '0167323232');
INSERT INTO `feedback` VALUES (5, 'tienstreetdance@yahoo.com', 'asdasdasdasd', 'Tien Nguyen', '0167323232');
INSERT INTO `feedback` VALUES (6, 'caube_ngaytho8@yahoo.com', 'caube_ngaytho8@yahoo.com', 'Nguyen Tien', '0167323232');
INSERT INTO `feedback` VALUES (7, 'hiepnguyenkh@gmail.com', 'hiepnguyenkh@gmail.com', 'Tien Nguyen', '0167323232');
INSERT INTO `feedback` VALUES (8, 'viettien20@gmail.com', 'sadasdasdas', 'Nguyen Tien', '0167323232');
INSERT INTO `feedback` VALUES (9, 'viettien20@gmail.com', 'asdasdasdsa', 'ntproduction', '0167323232');

-- --------------------------------------------------------

-- 
-- Table structure for table `orders`
-- 

CREATE TABLE `orders` (
  `id` int(11) NOT NULL auto_increment,
  `orderDate` datetime default NULL,
  `status` varchar(255) default NULL,
  `cardNumber` varchar(255) default NULL,
  `cvv` varchar(255) default NULL,
  `userId` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FKC3DF62E555912EA6` (`userId`),
  KEY `FKC3DF62E539C23640` (`userId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=7 ;

-- 
-- Dumping data for table `orders`
-- 

INSERT INTO `orders` VALUES (1, NULL, 'Waiting', '1234567890123456', 'AXB', 2);
INSERT INTO `orders` VALUES (2, NULL, 'Waiting', '1234567890123456', 'AXB', 2);
INSERT INTO `orders` VALUES (3, NULL, 'Waiting', '1234567890123456', 'AXB', 2);
INSERT INTO `orders` VALUES (4, NULL, 'Waiting', '1234567890123456', 'AXB', 2);
INSERT INTO `orders` VALUES (5, NULL, 'Waiting', '1234567890123456', 'AXK', 2);
INSERT INTO `orders` VALUES (6, '2015-04-11 23:50:03', 'Waiting', '1234567890123456', 'DXG', 2);

-- --------------------------------------------------------

-- 
-- Table structure for table `orders_product`
-- 

CREATE TABLE `orders_product` (
  `orders_id` int(11) NOT NULL,
  `product_id` int(11) NOT NULL,
  KEY `FKC2B22195D413CE85` (`product_id`),
  KEY `FKC2B221952444030F` (`orders_id`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8;

-- 
-- Dumping data for table `orders_product`
-- 

INSERT INTO `orders_product` VALUES (5, 5);
INSERT INTO `orders_product` VALUES (6, 8);

-- --------------------------------------------------------

-- 
-- Table structure for table `product`
-- 

CREATE TABLE `product` (
  `id` int(11) NOT NULL auto_increment,
  `dealOfTheDay` tinyint(1) NOT NULL,
  `discountPrice` double default NULL,
  `imageUrl` varchar(255) default NULL,
  `isSpecialProduct` tinyint(1) NOT NULL,
  `name` varchar(255) default NULL,
  `price` double default NULL,
  `categoryId` int(11) NOT NULL,
  PRIMARY KEY  (`id`),
  KEY `FKED8DCCEF9367EDCC` (`categoryId`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=22 ;

-- 
-- Dumping data for table `product`
-- 

INSERT INTO `product` VALUES (2, 1, 0, '/images/product/clothing/01.jpg', 0, 'Solid Color Sage Blouse with Velcro Closures - Short Sleeve', 41.95, 1);
INSERT INTO `product` VALUES (3, 1, NULL, '/images/product/clothing/02.jpg', 0, 'Rose Solid Color Blouse with Velcro Closures - Short Sleeve', 41.95, 1);
INSERT INTO `product` VALUES (4, 1, NULL, '/images/product/clothing/03.jpg', 0, 'Ladies'' Booties with Velcro Closures', 8.95, 1);
INSERT INTO `product` VALUES (5, 1, NULL, '/images/product/clothing/04.jpg', 1, 'Primrose II Fancy Blouse with Velcro Closures - Short Sleeve', 31.95, 1);
INSERT INTO `product` VALUES (6, 0, NULL, '/images/product/bath/01.jpg', 1, 'Deluxe Tub Grab Bar', 55.95, 2);
INSERT INTO `product` VALUES (7, 0, NULL, '/images/product/bath/02.jpg', 0, 'Swiveling Long Handle Lotion Applicator', 15.95, 2);
INSERT INTO `product` VALUES (8, 0, NULL, '/images/product/bath/03.jpg', 0, 'Toilet Safety Frame', 50.95, 2);
INSERT INTO `product` VALUES (9, 0, NULL, '/images/product/bath/04.jpg', 0, 'Microfiber Mesh Back Scrubber', 12.95, 2);
INSERT INTO `product` VALUES (10, 0, NULL, '/images/product/health/01.jpg', 0, 'Classic IsoFlex for Stress Relief', 4.99, 3);
INSERT INTO `product` VALUES (11, 0, NULL, '/images/product/health/02.jpg', 0, 'Bed Buddy Back Wrap', 22.95, 3);
INSERT INTO `product` VALUES (12, 0, NULL, '/images/product/health/05.jpg', 0, 'Bed Buddy Hot and Cold Pack', 16.95, 3);
INSERT INTO `product` VALUES (13, 0, NULL, '/images/product/health/04.jpg', 0, 'Bed Buddy Large Joint Wrap', 23.95, 3);
INSERT INTO `product` VALUES (14, 0, NULL, '/images/product/health/04.jpg', 0, 'UPEASY Lifting Cushion', 12.95, 4);
INSERT INTO `product` VALUES (15, 0, NULL, '/images/product/mobility/02.jpg', 0, 'Pathlighter Lighted Walking Cane with extra bulb', 50.95, 4);
INSERT INTO `product` VALUES (16, 0, NULL, '/images/product/mobility/03.jpg', 0, 'Rising-Aid Walking Cane', 25.95, 4);
INSERT INTO `product` VALUES (17, 0, NULL, '/images/product/mobility/04.jpg', 0, 'Leg Lift by Ableware', 13.95, 4);
INSERT INTO `product` VALUES (18, 0, NULL, '/images/product/kitchen/01.jpg', 0, 'Set of 4 Utensils Built Up Handle Cutlery Set', 28.95, 5);
INSERT INTO `product` VALUES (19, 0, NULL, '/images/product/kitchen/02.jpg', 0, 'Foam Tubing for Arthritis in Hands', 17.95, 5);
INSERT INTO `product` VALUES (20, 0, 0, '/images/product/kitchen/03.jpg', 0, 'Clip-on Vegetable Peeler', 19.95, 5);
INSERT INTO `product` VALUES (21, 0, NULL, '/images/product/kitchen/04.jpg', 0, 'ADL Cuff', 8.95, 5);

-- --------------------------------------------------------

-- 
-- Table structure for table `user`
-- 

CREATE TABLE `user` (
  `id` int(11) NOT NULL auto_increment,
  `address` varchar(255) default NULL,
  `email` varchar(255) default NULL,
  `isAdmin` tinyint(1) NOT NULL,
  `password` varchar(255) default NULL,
  `userName` varchar(255) NOT NULL,
  `firstName` varchar(255) default NULL,
  `lastName` varchar(255) default NULL,
  `imageUrl` varchar(255) default NULL,
  PRIMARY KEY  (`id`),
  UNIQUE KEY `userName` (`userName`)
) ENGINE=MyISAM  DEFAULT CHARSET=utf8 AUTO_INCREMENT=10 ;

-- 
-- Dumping data for table `user`
-- 

INSERT INTO `user` VALUES (1, NULL, 'admin@gmail.com', 1, '21232f297a57a5a743894a0e4a801fc3', 'admin@gmail.com', NULL, NULL, NULL);
INSERT INTO `user` VALUES (2, 'Russia', 'tien@gmail.com', 0, '2a26569e98b26668f39e98e6baef2d54', 'tien@gmail.com', 'Tien', 'Le', NULL);
INSERT INTO `user` VALUES (9, 'sa', 'sa@gmail.com', 0, 'c12e01f2a13ff5587e1e9e4aedb8242d', 'sa@gmail.com', 'sa', 'sa', NULL);
