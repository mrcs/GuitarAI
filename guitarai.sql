-- phpMyAdmin SQL Dump
-- version 2.11.7
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: Nov 10, 2009 as 10:15 PM
-- Versão do Servidor: 5.0.51
-- Versão do PHP: 5.2.6

SET SQL_MODE="NO_AUTO_VALUE_ON_ZERO";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;

--
-- Banco de Dados: `guitarai`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `acorde`
--

CREATE TABLE IF NOT EXISTS `acorde` (
  `nome` varchar(20) NOT NULL,
  `sustenido` tinyint(1) NOT NULL,
  `bemol` tinyint(1) NOT NULL,
  `setima` tinyint(1) NOT NULL,
  `menor` tinyint(1) NOT NULL,
  `maj` tinyint(1) NOT NULL,
  `diagrama` varchar(20) NOT NULL,
  `nivel` int(11) NOT NULL,
  PRIMARY KEY  (`nome`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `acorde`
--

INSERT INTO `acorde` (`nome`, `sustenido`, `bemol`, `setima`, `menor`, `maj`, `diagrama`, `nivel`) VALUES
('A', 0, 0, 0, 0, 0, 'teste', 0);
