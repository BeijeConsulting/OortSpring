CREATE DATABASE  IF NOT EXISTS `biblioteca` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `biblioteca`;
-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: biblioteca
-- ------------------------------------------------------
-- Server version	8.0.21

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
-- Table structure for table `autore`
--

DROP TABLE IF EXISTS `autore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `autore` (
  `idautore` int NOT NULL AUTO_INCREMENT,
  `cognome` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `data_nascita` date DEFAULT NULL,
  `data_morte` date DEFAULT NULL,
  `biografia` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`idautore`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `autore`
--

LOCK TABLES `autore` WRITE;
/*!40000 ALTER TABLE `autore` DISABLE KEYS */;
INSERT INTO `autore` VALUES (1,'Alighieri','Dante','1265-05-21','1321-09-14','ha scritto la Divina Commedia'),(2,'Petrarca','Francesco','1304-07-20','1374-07-20','ha scritto il Canzoniere'),(3,'Boccaccio','Giovanni','1313-06-16','1375-12-21','ha scritto il Decamerone'),(4,'Ungaretti','Giuseppe','1888-02-08','1970-06-01','poesie brevi');
/*!40000 ALTER TABLE `autore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `editore`
--

DROP TABLE IF EXISTS `editore`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `editore` (
  `ideditore` int NOT NULL AUTO_INCREMENT,
  `denominazione` varchar(45) DEFAULT NULL,
  `descrizione` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`ideditore`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `editore`
--

LOCK TABLES `editore` WRITE;
/*!40000 ALTER TABLE `editore` DISABLE KEYS */;
INSERT INTO `editore` VALUES (1,'Mondadori',NULL),(2,'Feltrinelli',NULL),(3,'Adelphi',NULL),(4,'Hoepli',NULL);
/*!40000 ALTER TABLE `editore` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `libro`
--

DROP TABLE IF EXISTS `libro`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `libro` (
  `idlibro` int NOT NULL AUTO_INCREMENT,
  `titolo` varchar(100) DEFAULT NULL,
  `descrizione` varchar(1000) DEFAULT NULL,
  `autore` varchar(100) DEFAULT NULL,
  `editore` varchar(100) DEFAULT NULL,
  `anno` int DEFAULT NULL,
  PRIMARY KEY (`idlibro`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `libro`
--

LOCK TABLES `libro` WRITE;
/*!40000 ALTER TABLE `libro` DISABLE KEYS */;
INSERT INTO `libro` VALUES (1,'Divina Commedia','è composto da 3 parti','Dante Alighieri','Feltrinelli',2020),(2,'Canzoniere','questa edizione non mi piace','Francesco Petrarca','Mondadori',2005),(3,'Decamerone','ottimo','Giovanni Boccaccio','Hoepli',2018);
/*!40000 ALTER TABLE `libro` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `prestito`
--

DROP TABLE IF EXISTS `prestito`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `prestito` (
  `idprestito` int NOT NULL AUTO_INCREMENT,
  `libro` varchar(100) DEFAULT NULL,
  `utente` varchar(100) DEFAULT NULL,
  `data_inizio` date DEFAULT NULL,
  `data_fine` date DEFAULT NULL,
  `note` varchar(1000) DEFAULT NULL,
  PRIMARY KEY (`idprestito`)
) ENGINE=InnoDB AUTO_INCREMENT=6 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `prestito`
--

LOCK TABLES `prestito` WRITE;
/*!40000 ALTER TABLE `prestito` DISABLE KEYS */;
INSERT INTO `prestito` VALUES (1,'Divina Commedia','1','2020-10-15',NULL,NULL),(2,'Manuale OCA','1',NULL,NULL,NULL),(3,'Manuale SQL','1',NULL,NULL,NULL),(4,'Canzoniere','2',NULL,NULL,NULL),(5,'Decamerone','1',NULL,NULL,NULL);
/*!40000 ALTER TABLE `prestito` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `utente`
--

DROP TABLE IF EXISTS `utente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `utente` (
  `idutente` int NOT NULL AUTO_INCREMENT,
  `cognome` varchar(45) DEFAULT NULL,
  `nome` varchar(45) DEFAULT NULL,
  `codice_fiscale` varchar(45) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `telefono` varchar(45) DEFAULT NULL,
  `indirizzo` varchar(100) DEFAULT NULL,
  `password` varchar(45) DEFAULT NULL,
  `admin` tinyint NOT NULL,
  PRIMARY KEY (`idutente`),
  UNIQUE KEY `email_UNIQUE` (`email`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `utente`
--

LOCK TABLES `utente` WRITE;
/*!40000 ALTER TABLE `utente` DISABLE KEYS */;
INSERT INTO `utente` VALUES (1,'Mater','Kirolos','svmsv','kirolos.mater@gmail.com','3772417616','viale Romagna','password1',1),(2,'Madonia','Giuseppe','sgshdd','giuseppe.madonia@outlook.com','355623','via Talco','passwordr45',0),(3,'Gregori','Luca','ssdsf','luca.gregori@tim.it','365683323','via Mentolo','password42',0);
/*!40000 ALTER TABLE `utente` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-10-20 15:59:17
