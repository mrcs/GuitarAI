-- phpMyAdmin SQL Dump
-- version 2.11.7
-- http://www.phpmyadmin.net
--
-- Servidor: localhost
-- Tempo de Geração: Nov 12, 2009 as 04:55 PM
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
  `basica` tinyint(1) NOT NULL,
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

INSERT INTO `acorde` (`nome`, `basica`, `sustenido`, `bemol`, `setima`, `menor`, `maj`, `diagrama`, `nivel`) VALUES
('Bbmaj7', 0, 0, 1, 1, 0, 1, '01x230', 10),
('Emaj7', 0, 0, 0, 1, 0, 1, '0x6440', 10),
('Db', 0, 0, 1, 0, 0, 0, 'x43121', 10),
('Ab7', 0, 0, 1, 1, 0, 0, 'xx1112', 9),
('Cmaj7', 0, 0, 0, 1, 0, 1, 'x35453', 9),
('Bmaj', 0, 0, 0, 0, 0, 1, 'x24442', 9),
('Abmaj', 0, 0, 1, 0, 0, 1, '466544', 9),
('Eb7', 0, 0, 1, 1, 0, 0, 'x11323', 9),
('Gmaj7', 0, 0, 0, 1, 0, 1, '3x0032', 8),
('Eb', 0, 0, 1, 0, 0, 0, 'xx1343', 8),
('Dbmaj', 0, 0, 1, 0, 0, 1, 'xx3121', 8),
('Ebmaj7', 0, 0, 1, 1, 0, 1, '001333', 8),
('Gmaj', 0, 0, 0, 0, 0, 1, '320003', 8),
('D#7', 0, 1, 0, 1, 0, 0, 'xx1323', 7),
('F#', 0, 1, 0, 0, 0, 0, 'xx4322', 7),
('G#m', 0, 1, 0, 0, 1, 0, 'xx0444', 7),
('F#m7', 0, 1, 0, 1, 1, 0, '2x2220', 7),
('C#m7', 0, 1, 0, 1, 1, 0, 'x46454', 7),
('F#m', 0, 1, 0, 0, 1, 0, '244222', 6),
('G#7', 0, 1, 0, 1, 0, 0, 'xx1112', 6),
('D#m', 0, 1, 0, 0, 1, 0, 'xx4342', 6),
('C#m', 0, 1, 0, 0, 1, 0, 'x46654', 6),
('A#7', 0, 1, 0, 1, 0, 0, 'xx3334', 6),
('C#7', 0, 1, 0, 1, 0, 0, 'x4342x', 5),
('F#7', 0, 1, 0, 1, 0, 0, '242322', 5),
('G#m7', 0, 1, 0, 1, 1, 0, '4x4440', 5),
('G7', 0, 0, 0, 1, 0, 0, '320001', 5),
('Cm', 0, 0, 0, 0, 1, 0, 'x35543', 5),
('F', 1, 0, 0, 0, 0, 0, '133211', 4),
('Dm7', 0, 0, 0, 1, 1, 0, 'x57565', 4),
('Bm7', 0, 0, 0, 1, 1, 0, 'x24232', 4),
('Gm7', 0, 0, 0, 1, 1, 0, '003333', 4),
('Gm', 0, 0, 0, 0, 1, 0, '355333', 4),
('C7', 0, 0, 0, 1, 0, 0, 'x32310', 3),
('Em7', 0, 0, 0, 1, 1, 0, '0x000x', 3),
('B', 1, 0, 0, 0, 0, 0, 'x24442', 3),
('A7', 0, 0, 0, 1, 0, 0, 'x02223', 3),
('D7', 0, 0, 0, 1, 0, 0, 'x00212', 3),
('E', 1, 0, 0, 0, 0, 0, '033200', 2),
('Fm7', 0, 0, 0, 1, 1, 0, 'xx3141', 2),
('D', 1, 0, 0, 0, 0, 0, 'xx0232', 2),
('Fm', 0, 0, 0, 0, 1, 0, 'xx4222', 2),
('B7', 0, 0, 0, 1, 0, 0, 'x21202', 2),
('Bm', 0, 0, 0, 0, 1, 0, '224432', 1),
('Am', 0, 0, 0, 0, 1, 0, 'x02210', 1),
('E7', 0, 0, 0, 1, 0, 0, '022130', 1),
('C', 1, 0, 0, 0, 0, 0, 'x32010', 1),
('F7', 0, 0, 0, 1, 0, 0, 'xx3545', 1),
('Am7', 0, 0, 0, 1, 1, 0, 'x02213', 0),
('A', 1, 0, 0, 0, 0, 0, '002220', 0),
('Em', 0, 0, 0, 0, 1, 0, '022000', 0),
('Dm', 0, 0, 0, 0, 1, 0, 'x00231', 0),
('G', 1, 0, 0, 0, 0, 0, '320033', 0),
('Bb', 0, 0, 1, 0, 0, 0, 'x13331', 10),
('Bbm', 0, 0, 1, 0, 1, 0, '113321', 10),
('Bb7', 0, 0, 1, 1, 0, 0, '013131', 11),
('Amaj', 0, 0, 0, 0, 0, 1, 'x02220', 11),
('Dmaj', 0, 0, 0, 0, 0, 1, 'x00232', 11),
('Fmaj7', 0, 0, 0, 1, 0, 1, '133210', 11),
('F#maj', 0, 1, 0, 0, 0, 1, '244322', 11),
('Fmaj', 0, 0, 0, 0, 0, 1, '133211', 12),
('Bbmaj', 0, 0, 1, 0, 0, 1, 'x13331', 12),
('Ebmaj', 0, 0, 1, 0, 0, 1, 'xx5343', 12),
('Cmaj', 0, 0, 0, 0, 0, 1, 'x32010', 12),
('Emaj', 0, 0, 0, 0, 0, 1, '022100', 12),
('Ab', 0, 0, 1, 0, 0, 0, 'xx6544', 13),
('Dbmaj7', 0, 0, 1, 1, 0, 1, 'x33121', 13);
