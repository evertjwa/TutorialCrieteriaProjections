-- phpMyAdmin SQL Dump
-- version 3.3.9
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: Mar 12, 2014 as 11:14 PM
-- Versão do Servidor: 5.1.53
-- Versão do PHP: 5.3.4

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `projections`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `employees`
--

DROP TABLE IF EXISTS `employees`;
CREATE TABLE IF NOT EXISTS `employees` (
  `ID` bigint(20) NOT NULL AUTO_INCREMENT,
  `CITY` varchar(255) DEFAULT NULL,
  `COUNTRY` varchar(255) DEFAULT NULL,
  `FIRST_NAME` varchar(255) DEFAULT NULL,
  `SALARY` int(11) DEFAULT NULL,
  `STATE` varchar(255) DEFAULT NULL,
  `SURNAME` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=MyISAM  DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `employees`
--

INSERT INTO `employees` (`ID`, `CITY`, `COUNTRY`, `FIRST_NAME`, `SALARY`, `STATE`, `SURNAME`) VALUES
(1, 'Porto Alegre', 'Brasil', 'Ana Maria', 1500, 'RS', 'de Souza'),
(2, 'Florianopolis', 'Brasil', 'Marta', 1250, 'SC', 'Soares'),
(3, 'Campinas', 'Brasil', 'Julio Cesar', 3100, 'SP', 'da Silva'),
(4, 'Rio de Janeiro', 'Brasil', 'Pedro', 3500, 'RJ', 'Fagundes'),
(5, 'Belo Horizonte', 'Brasil', 'Maria', 2750, 'MG', 'de Souza Castro'),
(6, 'Santa Maria', 'Brasil', 'Ana Lucia', 3500, 'RS', 'Pereira'),
(7, 'Porto Alegre', 'Brasil', 'Cristiano', 1990, 'RS', 'Martins'),
(8, 'Rio de Janeiro', 'Brasil', 'Carlos Andre', 2600, 'RJ', 'da Silva'),
(9, 'São Paulo', 'Brasil', 'Mirian', 2420, 'SP', 'Gouveia'),
(10, 'Porto Alegre', 'Brasil', 'Marco Antonio', 1500, 'RS', 'de Souza'),
(11, 'Santos', 'Brasil', 'Janaina', 1250, 'SP', 'Soares'),
(12, 'Campinas', 'Brasil', 'Maria Rita', 3550, 'SP', 'da Silva'),
(13, 'Rio de Janeiro', 'Brasil', 'Guilherme', 3500, 'RJ', 'Santos Fagundes'),
(14, 'Ipatinga', 'Brasil', 'Mirdes', 2500, 'MG', 'Castro Pereira'),
(15, 'Porto Alegre', 'Brasil', 'Victor', 3500, 'RS', 'Ramos Neves'),
(16, 'Porto Alegre', 'Brasil', 'Cristian', 1990, 'RJ', 'Vidal Silva'),
(17, 'Rio de Janeiro', 'Brasil', 'Andre', 2600, 'RJ', ' Matos Mello'),
(18, 'São Paulo', 'Brasil', 'Matilda', 1990, 'SP', 'Gouveia Campos');
