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

-- Copiando dados para a tabela tp1_cinema.filmes: 9 rows
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
  `Tipo` varchar(50) COLLATE utf8_bin DEFAULT NULL,
  `Valor` double DEFAULT '0',
  PRIMARY KEY (`IngressoID`)
) ENGINE=MyISAM AUTO_INCREMENT=101 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Copiando dados para a tabela tp1_cinema.ingressos: 100 rows
/*!40000 ALTER TABLE `ingressos` DISABLE KEYS */;
INSERT INTO `ingressos` (`IngressoID`, `SessaoID`, `Lugar`, `Status`, `Tipo`, `Valor`) VALUES
	(1, 12, 'A01', 'Disponivel', NULL, 0),
	(2, 12, 'A02', 'Disponivel', NULL, 0),
	(3, 12, 'A03', 'Disponivel', NULL, 0),
	(4, 12, 'A04', 'Disponivel', NULL, 0),
	(5, 12, 'A05', 'Vendido', 'Inteira', 0),
	(6, 12, 'A06', 'Disponivel', NULL, 0),
	(7, 12, 'A07', 'Disponivel', NULL, 0),
	(8, 12, 'A08', 'Disponivel', NULL, 0),
	(9, 12, 'A09', 'Disponivel', NULL, 0),
	(10, 12, 'A10', 'Disponivel', NULL, 0),
	(11, 12, 'B01', 'Disponivel', NULL, 0),
	(12, 12, 'B02', 'Disponivel', NULL, 0),
	(13, 12, 'B03', 'Disponivel', NULL, 0),
	(14, 12, 'B04', 'Disponivel', NULL, 0),
	(15, 12, 'B05', 'Disponivel', NULL, 0),
	(16, 12, 'B06', 'Disponivel', NULL, 0),
	(17, 12, 'B07', 'Disponivel', NULL, 0),
	(18, 12, 'B08', 'Disponivel', NULL, 0),
	(19, 12, 'B09', 'Disponivel', NULL, 0),
	(20, 12, 'B10', 'Disponivel', NULL, 0),
	(21, 12, 'C01', 'Disponivel', NULL, 0),
	(22, 12, 'C02', 'Disponivel', NULL, 0),
	(23, 12, 'C03', 'Disponivel', NULL, 0),
	(24, 12, 'C04', 'Disponivel', NULL, 0),
	(25, 12, 'C05', 'Disponivel', NULL, 0),
	(26, 12, 'C06', 'Disponivel', NULL, 0),
	(27, 12, 'C07', 'Disponivel', NULL, 0),
	(28, 12, 'C08', 'Disponivel', NULL, 0),
	(29, 12, 'C09', 'Disponivel', NULL, 0),
	(30, 12, 'C10', 'Disponivel', NULL, 0),
	(31, 12, 'D01', 'Disponivel', NULL, 0),
	(32, 12, 'D02', 'Disponivel', NULL, 0),
	(33, 12, 'D03', 'Disponivel', NULL, 0),
	(34, 12, 'D04', 'Disponivel', NULL, 0),
	(35, 12, 'D05', 'Disponivel', NULL, 0),
	(36, 12, 'D06', 'Disponivel', NULL, 0),
	(37, 12, 'D07', 'Disponivel', NULL, 0),
	(38, 12, 'D08', 'Disponivel', NULL, 0),
	(39, 12, 'D09', 'Disponivel', NULL, 0),
	(40, 12, 'D10', 'Disponivel', NULL, 0),
	(41, 12, 'E01', 'Disponivel', NULL, 0),
	(42, 12, 'E02', 'Disponivel', NULL, 0),
	(43, 12, 'E03', 'Disponivel', NULL, 0),
	(44, 12, 'E04', 'Disponivel', NULL, 0),
	(45, 12, 'E05', 'Disponivel', NULL, 0),
	(46, 12, 'E06', 'Disponivel', NULL, 0),
	(47, 12, 'E07', 'Disponivel', NULL, 0),
	(48, 12, 'E08', 'Disponivel', NULL, 0),
	(49, 12, 'E09', 'Disponivel', NULL, 0),
	(50, 12, 'E10', 'Disponivel', NULL, 0),
	(51, 12, 'F01', 'Disponivel', NULL, 0),
	(52, 12, 'F02', 'Disponivel', NULL, 0),
	(53, 12, 'F03', 'Disponivel', NULL, 0),
	(54, 12, 'F04', 'Disponivel', NULL, 0),
	(55, 12, 'F05', 'Disponivel', NULL, 0),
	(56, 12, 'F06', 'Disponivel', NULL, 0),
	(57, 12, 'F07', 'Disponivel', NULL, 0),
	(58, 12, 'F08', 'Disponivel', NULL, 0),
	(59, 12, 'F09', 'Disponivel', NULL, 0),
	(60, 12, 'F10', 'Disponivel', NULL, 0),
	(61, 12, 'G01', 'Disponivel', NULL, 0),
	(62, 12, 'G02', 'Disponivel', NULL, 0),
	(63, 12, 'G03', 'Disponivel', NULL, 0),
	(64, 12, 'G04', 'Disponivel', NULL, 0),
	(65, 12, 'G05', 'Disponivel', NULL, 0),
	(66, 12, 'G06', 'Disponivel', NULL, 0),
	(67, 12, 'G07', 'Disponivel', NULL, 0),
	(68, 12, 'G08', 'Disponivel', NULL, 0),
	(69, 12, 'G09', 'Disponivel', NULL, 0),
	(70, 12, 'G10', 'Disponivel', NULL, 0),
	(71, 12, 'H01', 'Disponivel', NULL, 0),
	(72, 12, 'H02', 'Disponivel', NULL, 0),
	(73, 12, 'H03', 'Disponivel', NULL, 0),
	(74, 12, 'H04', 'Disponivel', NULL, 0),
	(75, 12, 'H05', 'Disponivel', NULL, 0),
	(76, 12, 'H06', 'Disponivel', NULL, 0),
	(77, 12, 'H07', 'Disponivel', NULL, 0),
	(78, 12, 'H08', 'Disponivel', NULL, 0),
	(79, 12, 'H09', 'Disponivel', NULL, 0),
	(80, 12, 'H10', 'Disponivel', NULL, 0),
	(81, 12, 'I01', 'Disponivel', NULL, 0),
	(82, 12, 'I02', 'Disponivel', NULL, 0),
	(83, 12, 'I03', 'Disponivel', NULL, 0),
	(84, 12, 'I04', 'Disponivel', NULL, 0),
	(85, 12, 'I05', 'Disponivel', NULL, 0),
	(86, 12, 'I06', 'Disponivel', NULL, 0),
	(87, 12, 'I07', 'Disponivel', NULL, 0),
	(88, 12, 'I08', 'Disponivel', NULL, 0),
	(89, 12, 'I09', 'Disponivel', NULL, 0),
	(90, 12, 'I10', 'Disponivel', NULL, 0),
	(91, 12, 'J01', 'Vendido', NULL, 0),
	(92, 12, 'J02', 'Disponivel', NULL, 0),
	(93, 12, 'J03', 'Disponivel', NULL, 0),
	(94, 12, 'J04', 'Disponivel', NULL, 0),
	(95, 12, 'J05', 'Vendido', 'Meia', 0),
	(96, 12, 'J06', 'Disponivel', NULL, 0),
	(97, 12, 'J07', 'Disponivel', NULL, 0),
	(98, 12, 'J08', 'Disponivel', NULL, 0),
	(99, 12, 'J09', 'Disponivel', NULL, 0),
	(100, 12, 'J10', 'Disponivel', NULL, 0);
/*!40000 ALTER TABLE `ingressos` ENABLE KEYS */;

-- Copiando estrutura para tabela tp1_cinema.preferencias
CREATE TABLE IF NOT EXISTS `preferencias` (
  `Nome` varchar(255) COLLATE utf8_bin NOT NULL,
  `Valor` varchar(255) COLLATE utf8_bin NOT NULL,
  `DDA` datetime NOT NULL,
  PRIMARY KEY (`Nome`),
  KEY `Nome` (`Nome`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Copiando dados para a tabela tp1_cinema.preferencias: 3 rows
/*!40000 ALTER TABLE `preferencias` DISABLE KEYS */;
INSERT INTO `preferencias` (`Nome`, `Valor`, `DDA`) VALUES
	('Cinema.nome', 'Cinema UnB - PJC', '2019-05-19 13:27:29'),
	('Cinema.preco', '23.0', '2019-05-21 11:59:56'),
	('Cinema.endereco', 'PJC 12', '2019-05-21 12:00:04');
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
) ENGINE=MyISAM AUTO_INCREMENT=13 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Copiando dados para a tabela tp1_cinema.sessoes: 1 rows
/*!40000 ALTER TABLE `sessoes` DISABLE KEYS */;
INSERT INTO `sessoes` (`SessaoID`, `SalaID`, `FilmeID`, `Data`, `Horario`) VALUES
	(12, 1, 1, '10', '10');
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
) ENGINE=MyISAM AUTO_INCREMENT=7 DEFAULT CHARSET=utf8 COLLATE=utf8_bin;

-- Copiando dados para a tabela tp1_cinema.usuarios: 2 rows
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` (`UsuarioID`, `CPF`, `Usuario`, `PWD`, `Tipo`, `DDC`, `DDM`, `Status`) VALUES
	(6, '234', 'alex', '0ec09ef9836da03f1add21e3ef607627e687e790', 'funcionario', '2019-05-19 13:01:37', '2019-05-19 13:01:37', 'ativo'),
	(5, '123', 'luan', '40bd001563085fc35165329ea1ff5c5ecbdbbeef', 'admin', '2019-05-19 13:01:12', '2019-05-19 13:01:12', 'ativo');
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;

/*!40101 SET SQL_MODE=IFNULL(@OLD_SQL_MODE, '') */;
/*!40014 SET FOREIGN_KEY_CHECKS=IF(@OLD_FOREIGN_KEY_CHECKS IS NULL, 1, @OLD_FOREIGN_KEY_CHECKS) */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
