-- --------------------------------------------------------
-- Servidor:                     127.0.0.1
-- Versão do servidor:           5.1.44-community - MySQL Community Server (GPL)
-- OS do Servidor:               Win32
-- HeidiSQL Versão:              10.1.0.5464
-- --------------------------------------------------------

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET NAMES utf8 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;


-- Copiando estrutura do banco de dados para tp1_cinema
CREATE DATABASE IF NOT EXISTS `tp1_cinema` /*!40100 DEFAULT CHARACTER SET utf8 COLLATE utf8_bin */;
USE `tp1_cinema`;

-- Copiando estrutura para tabela tp1_cinema.filmes
CREATE TABLE IF NOT EXISTS `filmes` (
  `FilmeID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(255) COLLATE utf8_bin NOT NULL,
  `Idioma` varchar(255) COLLATE utf8_bin NOT NULL,
  `Tipo` varchar(255) COLLATE utf8_bin NOT NULL,
  `Duracao` int(11) NOT NULL,
  PRIMARY KEY (`FilmeID`)
) ENGINE=MyISAM AUTO_INCREMENT=316 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Copiando dados para a tabela tp1_cinema.filmes: 315 rows
/*!40000 ALTER TABLE `filmes` DISABLE KEYS */;
INSERT INTO `filmes` (`FilmeID`, `Nome`, `Idioma`, `Tipo`, `Duracao`) VALUES
	(1, 'O Inquilino', 'Dublado', '2D', 4800),
	(2, 'O Albergue', 'Dublado', '2D', 6240),
	(3, 'O Rei Leao', 'Dublado', '3D', 7933),
	(4, 'O Rei Leao', 'Legendado', '3D', 7933),
	(5, 'O Rei Leao', 'Dublado', '2D', 7933),
	(6, 'Os Vingadores - Ultimato', 'Dublado', '3D', 11958),
	(7, 'Os Vingadores - Ultimato', 'Legendo', '3D', 11958),
	(8, 'O Cemitério Maldito', 'Dublado', '2D', 6390),
	(9, 'A Maldição da Chorona', 'Dublado', '2D', 7170);
/*!40000 ALTER TABLE `filmes` ENABLE KEYS */;

-- Copiando estrutura para tabela tp1_cinema.ingressos
CREATE TABLE IF NOT EXISTS `ingressos` (
  `IngressoID` int(11) NOT NULL AUTO_INCREMENT,
  `SessaoID` int(11) NOT NULL DEFAULT '0',
  `Lugar` varchar(50) COLLATE utf8_bin NOT NULL DEFAULT '0',
  `Status` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`IngressoID`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Copiando dados para a tabela tp1_cinema.ingressos: 0 rows
/*!40000 ALTER TABLE `ingressos` DISABLE KEYS */;
/*!40000 ALTER TABLE `ingressos` ENABLE KEYS */;

-- Copiando estrutura para tabela tp1_cinema.preferencias
CREATE TABLE IF NOT EXISTS `preferencias` (
  `Nome` varchar(255) COLLATE utf8_bin NOT NULL,
  `Valor` varchar(255) COLLATE utf8_bin NOT NULL,
  `DDA` datetime NOT NULL,
  PRIMARY KEY (`Nome`),
  KEY `Nome` (`Nome`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Copiando dados para a tabela tp1_cinema.preferencias: 0 rows
/*!40000 ALTER TABLE `preferencias` DISABLE KEYS */;
/*!40000 ALTER TABLE `preferencias` ENABLE KEYS */;

-- Copiando estrutura para tabela tp1_cinema.salas
CREATE TABLE IF NOT EXISTS `salas` (
  `SalaID` int(11) NOT NULL AUTO_INCREMENT,
  `Nome` varchar(255) COLLATE utf8_bin NOT NULL DEFAULT '0',
  `Poltronas` int(11) NOT NULL DEFAULT '0',
  `Fileiras` int(11) NOT NULL DEFAULT '0',
  `DDC` datetime NOT NULL,
  `DDM` datetime NOT NULL,
  PRIMARY KEY (`SalaID`)
) ENGINE=MyISAM AUTO_INCREMENT=4 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Copiando dados para a tabela tp1_cinema.salas: 3 rows
/*!40000 ALTER TABLE `salas` DISABLE KEYS */;
INSERT INTO `salas` (`SalaID`, `Nome`, `Poltronas`, `Fileiras`, `DDC`, `DDM`) VALUES
	(1, 'Vermelha', 10, 10, '2019-05-19 12:08:16', '2019-05-19 12:08:16'),
	(2, 'Amarelo', 10, 10, '2019-05-19 12:34:55', '2019-05-19 12:34:55'),
	(3, 'Branco', 2, 4, '2019-05-19 12:36:23', '2019-05-19 12:36:23');
/*!40000 ALTER TABLE `salas` ENABLE KEYS */;

-- Copiando estrutura para tabela tp1_cinema.sessoes
CREATE TABLE IF NOT EXISTS `sessoes` (
  `SessaoID` int(11) NOT NULL AUTO_INCREMENT,
  `SalaID` int(11) NOT NULL DEFAULT '0',
  `FilmeID` int(11) NOT NULL DEFAULT '0',
  `Data` varchar(50) COLLATE utf8_bin NOT NULL,
  `Horario` varchar(50) COLLATE utf8_bin NOT NULL,
  PRIMARY KEY (`SessaoID`)
) ENGINE=MyISAM AUTO_INCREMENT=3 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Copiando dados para a tabela tp1_cinema.sessoes: 0 rows
/*!40000 ALTER TABLE `sessoes` DISABLE KEYS */;
INSERT INTO `sessoes` (`SessaoID`, `SalaID`, `FilmeID`, `Data`, `Horario`) VALUES
	(1, 1, 1, '1', '1'),
	(2, 1, 1, '1', '1');
/*!40000 ALTER TABLE `sessoes` ENABLE KEYS */;

-- Copiando estrutura para tabela tp1_cinema.usuarios
CREATE TABLE IF NOT EXISTS `usuarios` (
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

-- Copiando dados para a tabela tp1_cinema.usuarios: 2 rows
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`UsuarioID`, `CPF`, `Usuario`, `PWD`, `Tipo`, `DDC`, `DDM`, `Status`) VALUES
	(4, '234', 'alex', '0ec09ef9836da03f1add21e3ef607627e687e790', 'funcionario', '2019-05-19 11:36:30', '2019-05-19 11:36:30', 'ativo'),
	(3, '123', 'luan', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'admin', '2019-05-19 11:36:06', '2019-05-19 11:36:06', 'ativo');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
