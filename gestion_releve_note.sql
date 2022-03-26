-- phpMyAdmin SQL Dump
-- version 5.0.2
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le : Dim 12 déc. 2021 à 20:54
-- Version du serveur :  8.0.21
-- Version de PHP : 7.4.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gestion_releve_note`
--

-- --------------------------------------------------------

--
-- Structure de la table `classe`
--

DROP TABLE IF EXISTS `classe`;
CREATE TABLE IF NOT EXISTS `classe` (
  `IdClasse` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `NomClasse` varchar(50) NOT NULL,
  `IdSection` varchar(50) NOT NULL,
  PRIMARY KEY (`IdClasse`),
  KEY `IdSection` (`IdSection`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `classe`
--

INSERT INTO `classe` (`IdClasse`, `NomClasse`, `IdSection`) VALUES
('3', '2 GT 3', '1'),
('20', '1 GEC 1', '20'),
('1', '2 GT 1', '1');

-- --------------------------------------------------------

--
-- Structure de la table `etudiant`
--

DROP TABLE IF EXISTS `etudiant`;
CREATE TABLE IF NOT EXISTS `etudiant` (
  `IdEtudiant` varchar(50) NOT NULL,
  `NomEtudiant` varchar(50) NOT NULL,
  `PrenomEtudiant` varchar(50) NOT NULL,
  `IdClasse` varchar(50) NOT NULL,
  PRIMARY KEY (`IdEtudiant`),
  KEY `IdClasse` (`IdClasse`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `etudiant`
--

INSERT INTO `etudiant` (`IdEtudiant`, `NomEtudiant`, `PrenomEtudiant`, `IdClasse`) VALUES
('1', 'Salhi', 'Fares', '3'),
('5', 'Klay', 'bbj', '1'),
('6', 'sawsen', 'saw', '1'),
('10', 'GGG', 'ddd', '1'),
('12', 'MMMM', 'NNN', '1'),
('20', 'Salah', 'Ali', '20');

-- --------------------------------------------------------

--
-- Structure de la table `matiere`
--

DROP TABLE IF EXISTS `matiere`;
CREATE TABLE IF NOT EXISTS `matiere` (
  `IdMatiere` varchar(50) NOT NULL,
  `NomMatiere` varchar(50) NOT NULL,
  `CoefMatiere` float NOT NULL,
  PRIMARY KEY (`IdMatiere`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `matiere`
--

INSERT INTO `matiere` (`IdMatiere`, `NomMatiere`, `CoefMatiere`) VALUES
('1', 'Java', 2),
('2', 'Dev web', 1.5);

-- --------------------------------------------------------

--
-- Structure de la table `note`
--

DROP TABLE IF EXISTS `note`;
CREATE TABLE IF NOT EXISTS `note` (
  `IdEtudiant` varchar(50) NOT NULL,
  `IdMatiere` varchar(50) NOT NULL,
  `ValeurNote` float DEFAULT NULL,
  `TypeNote` varchar(20) NOT NULL,
  PRIMARY KEY (`IdEtudiant`,`IdMatiere`,`TypeNote`) USING BTREE,
  KEY `IdMatiere` (`IdMatiere`),
  KEY `IdEtudiant` (`IdEtudiant`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `note`
--

INSERT INTO `note` (`IdEtudiant`, `IdMatiere`, `ValeurNote`, `TypeNote`) VALUES
('1', '1', 15, 'DS'),
('5', '5', 20, 'DS'),
('5', '2', 10, 'DS'),
('5', '1', 12, 'DS'),
('10', '1', 20, 'DS'),
('10', '1', 15, 'Examen'),
('12', '2', 10, 'DS'),
('5', '2', 12, 'Examen'),
('1', '1', 20, 'Examen'),
('20', '1', 9, 'DS'),
('5', '1', 14, 'Examen');

-- --------------------------------------------------------

--
-- Structure de la table `section`
--

DROP TABLE IF EXISTS `section`;
CREATE TABLE IF NOT EXISTS `section` (
  `IdSection` varchar(50) NOT NULL,
  `NomSection` varchar(50) NOT NULL,
  PRIMARY KEY (`IdSection`)
) ENGINE=MyISAM DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;

--
-- Déchargement des données de la table `section`
--

INSERT INTO `section` (`IdSection`, `NomSection`) VALUES
('20', 'GEC');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
