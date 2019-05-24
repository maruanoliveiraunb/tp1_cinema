CREATE DATABASE  IF NOT EXISTS `tp1_cinema` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `tp1_cinema`;
-- MySQL dump 10.13  Distrib 5.7.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: tp1_cinema
-- ------------------------------------------------------
-- Server version	5.5.5-10.1.32-MariaDB

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
-- Table structure for table `filmes`
--

DROP TABLE IF EXISTS `filmes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `filmes` (
  `FilmeID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(255) COLLATE utf8_bin NOT NULL,
  `Idioma` varchar(255) COLLATE utf8_bin NOT NULL,
  `Tipo` varchar(255) COLLATE utf8_bin NOT NULL,
  `Duracao` int(11) NOT NULL,
  PRIMARY KEY (`FilmeID`)
) ENGINE=MyISAM AUTO_INCREMENT=316 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `filmes`
--

LOCK TABLES `filmes` WRITE;
/*!40000 ALTER TABLE `filmes` DISABLE KEYS */;
INSERT INTO `filmes` VALUES (1,'O Inquilino','Dublado','2D',4800),(2,'O Albergue','Dublado','2D',6240),(3,'O Rei Leao','Dublado','3D',7933),(4,'O Rei Leao','Legendado','3D',7933),(5,'O Rei Leao','Dublado','2D',7933),(6,'Os Vingadores - Ultimato','Dublado','3D',11958),(7,'Os Vingadores - Ultimato','Legendo','3D',11958),(8,'O Cemitério Maldito','Dublado','2D',6390),(9,'A Maldição da Chorona','Dublado','2D',7170);
/*!40000 ALTER TABLE `filmes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `ingressos`
--

DROP TABLE IF EXISTS `ingressos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `ingressos` (
  `IngressoID` int(11) NOT NULL AUTO_INCREMENT,
  `SessaoID` int(11) NOT NULL DEFAULT '0',
  `Lugar` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '0',
  `Status` varchar(50) COLLATE utf8_bin NOT NULL,
  `tipo` varchar(255) COLLATE utf8_bin DEFAULT NULL,
  `valor` double DEFAULT NULL,
  PRIMARY KEY (`IngressoID`)
) ENGINE=MyISAM AUTO_INCREMENT=22 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `ingressos`
--

LOCK TABLES `ingressos` WRITE;
/*!40000 ALTER TABLE `ingressos` DISABLE KEYS */;
INSERT INTO `ingressos` VALUES (1,1,'Patio Brasil','Vendido',NULL,NULL),(2,1,'Patio Brasil','Vendido',NULL,NULL),(3,1,'Patio Brasil','Vendido',NULL,NULL),(4,1,'Patio Brasil','Disponivel',NULL,NULL),(5,1,'Patio Brasil','Vendido',NULL,NULL),(6,1,'Patio Brasil','Vendido',NULL,NULL),(7,1,'Patio Brasil','Disponivel',NULL,NULL),(16,1,'21C','Disponivel',NULL,NULL),(15,1,'21C','Vendido',NULL,NULL),(14,1,'21C','Vendido',NULL,NULL),(13,1,'21C','Disponivel',NULL,NULL),(12,1,'21C','Disponivel',NULL,NULL),(17,1,'21C','Disponivel',NULL,NULL),(18,1,'21C','Disponivel',NULL,NULL),(19,1,'21C','Disponivel',NULL,NULL),(20,1,'21C','Disponivel','Meia',NULL),(21,1,'21C','Disponivel','Meia',NULL);
/*!40000 ALTER TABLE `ingressos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `preferencias`
--

DROP TABLE IF EXISTS `preferencias`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `preferencias` (
  `Nome` varchar(255) COLLATE utf8_bin NOT NULL,
  `Valor` varchar(255) COLLATE utf8_bin NOT NULL,
  `DDA` datetime NOT NULL,
  PRIMARY KEY (`Nome`),
  KEY `Nome` (`Nome`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `preferencias`
--

LOCK TABLES `preferencias` WRITE;
/*!40000 ALTER TABLE `preferencias` DISABLE KEYS */;
/*!40000 ALTER TABLE `preferencias` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `salas`
--

DROP TABLE IF EXISTS `salas`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `salas` (
  `SalaID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '0',
  `Poltronas` int(11) NOT NULL DEFAULT '0',
  `Fileiras` int(11) NOT NULL DEFAULT '0',
  `DDC` datetime NOT NULL,
  `DDM` datetime NOT NULL,
  PRIMARY KEY (`SalaID`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `salas`
--

LOCK TABLES `salas` WRITE;
/*!40000 ALTER TABLE `salas` DISABLE KEYS */;
INSERT INTO `salas` VALUES (1,'Vermelha',10,10,'2019-05-19 12:08:16','2019-05-19 12:08:16'),(2,'Amarelo',10,10,'2019-05-19 12:34:55','2019-05-19 12:34:55'),(3,'Branco',2,4,'2019-05-19 12:36:23','2019-05-19 12:36:23');
/*!40000 ALTER TABLE `salas` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `sessoes`
--

DROP TABLE IF EXISTS `sessoes`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `sessoes` (
  `SessaoID` int(11) NOT NULL AUTO_INCREMENT,
  `SalaID` int(11) NOT NULL DEFAULT '0',
  `FilmeID` int(11) NOT NULL DEFAULT '0',
  `Data` varchar(50) COLLATE utf8_bin NOT NULL,
  `Horario` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`SessaoID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `sessoes`
--

LOCK TABLES `sessoes` WRITE;
/*!40000 ALTER TABLE `sessoes` DISABLE KEYS */;
INSERT INTO `sessoes` VALUES (1,1,1,'1','1'),(2,1,1,'1','1');
/*!40000 ALTER TABLE `sessoes` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usuarios` (
  `UsuarioID` int(11) NOT NULL AUTO_INCREMENT,
  `CPF` varchar(15) COLLATE utf8_bin NOT NULL,
  `Usuario` varchar(255) COLLATE utf8_bin NOT NULL,
  `PWD` varchar(255) COLLATE utf8_bin NOT NULL,
  `Tipo` varchar(15) COLLATE utf8_bin NOT NULL,
  `DDC` datetime NOT NULL,
  `DDM` datetime NOT NULL,
  `Status` varchar(10) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`UsuarioID`),
  UNIQUE KEY `Usuario` (`Usuario`),
  UNIQUE KEY `CPF` (`CPF`)
) ENGINE=MyISAM AUTO_INCREMENT=5 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (4,'234','alex','0ec09ef9836da03f1add21e3ef607627e687e790','funcionario','2019-05-19 11:36:30','2019-05-19 11:36:30','ativo'),(3,'123','luan','40bd001563085fc35165329ea1ff5c5ecbdbbeef','admin','2019-05-19 11:36:06','2019-05-19 11:36:06','ativo');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-05-23 21:49:57
