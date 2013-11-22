CREATE DATABASE  IF NOT EXISTS `h21` /*!40100 DEFAULT CHARACTER SET utf8 */;
USE `h21`;
-- MySQL dump 10.13  Distrib 5.6.13, for Win32 (x86)
--
-- Host: localhost    Database: h21
-- ------------------------------------------------------
-- Server version	5.6.14

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
-- Table structure for table `address`
--

DROP TABLE IF EXISTS `address`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `address` (
  `addressId` int(11) NOT NULL AUTO_INCREMENT,
  `street` varchar(45) DEFAULT NULL,
  `city` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `postalCode` varchar(45) DEFAULT NULL,
  `country` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`addressId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `beds`
--

DROP TABLE IF EXISTS `beds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `beds` (
  `hostelId` int(11) NOT NULL,
  `date` varchar(45) DEFAULT NULL,
  `room` varchar(45) DEFAULT NULL,
  `bed` varchar(45) DEFAULT NULL,
  `price` varchar(45) DEFAULT NULL,
  `state` varchar(45) DEFAULT "AVAILABLE",
  UNIQUE KEY `hostelId` (`hostelId`,`date`,`room`,`bed`),
  KEY `hostelId_BFK_idx` (`hostelId`),
  CONSTRAINT `hostelId_BFK` FOREIGN KEY (`hostelId`) REFERENCES `hostel` (`hostelId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `booked_beds`
--

DROP TABLE IF EXISTS `booked_beds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `booked_beds` (
  `bookingId` int(11) NOT NULL,
  `room` int(11) DEFAULT NULL,
  `bed` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `date` date DEFAULT NULL,
  `hostelId` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `bookings`
--

DROP TABLE IF EXISTS `bookings`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `bookings` (
  `bookingId` int(11) NOT NULL AUTO_INCREMENT,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `hostelId` int(11) DEFAULT NULL,
  `hostelName` varchar(45) DEFAULT NULL,
  `totalPrice` int(11) DEFAULT NULL,
  `userId` int(11) NOT NULL,
  `state` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`bookingId`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `contact`
--

DROP TABLE IF EXISTS `contact`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `contact` (
  `contactId` int(11) NOT NULL AUTO_INCREMENT,
  `phone` varchar(45) DEFAULT NULL,
  `email` varchar(45) DEFAULT NULL,
  `facebook` varchar(45) DEFAULT NULL,
  `webURL` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`contactId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


DROP TABLE IF EXISTS `hostel`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `hostel` (
  `hostelId` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(45) DEFAULT NULL,
  `addressId` int(11) DEFAULT NULL,
  `policyId` int(11) DEFAULT NULL,
  `contactId` int(11) DEFAULT NULL,
  PRIMARY KEY (`hostelId`),
  KEY `addressId_HFK_idx` (`addressId`),
  KEY `contactId_HFK_idx` (`contactId`),
  KEY `policyId_HFK_idx` (`policyId`),
  CONSTRAINT `addressId_HFK` FOREIGN KEY (`addressId`) REFERENCES `address` (`addressId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `contactId_HFK` FOREIGN KEY (`contactId`) REFERENCES `contact` (`contactId`) ON DELETE NO ACTION ON UPDATE NO ACTION,
  CONSTRAINT `policyId_HFK` FOREIGN KEY (`policyId`) REFERENCES `policy` (`policyId`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `policy`
--

DROP TABLE IF EXISTS `policy`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `policy` (
  `policyId` int(11) NOT NULL AUTO_INCREMENT,
  `checkInTime` varchar(45) DEFAULT NULL,
  `checkOutTime` varchar(45) DEFAULT NULL,
  `smoking` tinyint(4) DEFAULT NULL,
  `alcohol` tinyint(4) DEFAULT NULL,
  `cancellationDeadline` int(11) DEFAULT NULL,
  `cancellationPenalty` int(11) DEFAULT NULL,
  PRIMARY KEY (`policyId`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `search_result`
--

DROP TABLE IF EXISTS `search_result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `search_result` (
  `searchId` int(11) NOT NULL,
  `hostelId` int(11) DEFAULT NULL,
  `hostelName` varchar(45) DEFAULT NULL,
  `startDate` date DEFAULT NULL,
  `endDate` date DEFAULT NULL,
  `totalPrice` int(11) DEFAULT NULL,
  PRIMARY KEY (`searchId`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Table structure for table `searched_beds`
--

DROP TABLE IF EXISTS `searched_beds`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `searched_beds` (
  `searchId` int(11) NOT NULL,
  `room` int(11) DEFAULT NULL,
  `bed` int(11) DEFAULT NULL,
  `price` int(11) DEFAULT NULL,
  `state` varchar(45) DEFAULT NULL,
  `hostelId` int(11) DEFAULT NULL,
  `date` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;


--
-- Table structure for table `users`
--

DROP TABLE IF EXISTS `users`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `users` (
  `userId` int(11) NOT NULL AUTO_INCREMENT,
  `firstName` varchar(45) DEFAULT NULL,
  `lastName` varchar(45) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `ccNumber` varchar(45) DEFAULT NULL,
  `expirationDate` date DEFAULT NULL,
  `securityCode` int(11) DEFAULT NULL,
  `phone` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`userId`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=3 DEFAULT CHARSET=utf8;



