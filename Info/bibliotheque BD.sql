-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Dec 03, 2016 at 04:41 AM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bibliotheque`
--

-- --------------------------------------------------------

--
-- Table structure for table `adherent`
--

CREATE TABLE `adherent` (
  `Login` varchar(20) NOT NULL,
  `MdpAdherent` text NOT NULL,
  `Prenom` text NOT NULL,
  `Nom` text NOT NULL,
  `Email` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `adherent`
--

INSERT INTO `adherent` (`Login`, `MdpAdherent`, `Prenom`, `Nom`, `Email`) VALUES
('seif', 'mdp', 'seif', 'abdennadher', 'm.abdennadher.seif@gmail.com');

-- --------------------------------------------------------

--
-- Table structure for table `employe`
--

CREATE TABLE `employe` (
  `Login` varchar(20) NOT NULL,
  `MdpEmploye` text NOT NULL,
  `Prenom` text NOT NULL,
  `Nom` text NOT NULL,
  `Email` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `employe`
--

INSERT INTO `employe` (`Login`, `MdpEmploye`, `Prenom`, `Nom`, `Email`) VALUES
('ff', 'ffg', 'a', 'a', 'a@g.c'),
('oumayma', '123.', 'oumayma', 'habouri', 'oumayma.habouri@gmail.com'),
('sdfsf', 'gfgd', 'gdfgd', 'jfyhf', 'fthfh');

-- --------------------------------------------------------

--
-- Table structure for table `emprunt`
--

CREATE TABLE `emprunt` (
  `IdLivreEmp` int(11) NOT NULL,
  `LoginAdherentEmp` varchar(20) NOT NULL,
  `DateEmprunt` date NOT NULL,
  `DateLimiteEmprunt` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `emprunt`
--

INSERT INTO `emprunt` (`IdLivreEmp`, `LoginAdherentEmp`, `DateEmprunt`, `DateLimiteEmprunt`) VALUES
(10, 'seif', '2016-11-17', '2016-12-01'),
(12, 'seif', '2016-12-03', '2016-12-17');

-- --------------------------------------------------------

--
-- Table structure for table `livre`
--

CREATE TABLE `livre` (
  `LivreId` int(11) NOT NULL,
  `Titre` text NOT NULL,
  `Auteur` text NOT NULL,
  `Editeur` text NOT NULL,
  `DateEdition` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `livre`
--

INSERT INTO `livre` (`LivreId`, `Titre`, `Auteur`, `Editeur`, `DateEdition`) VALUES
(1, 'A Game Of Thrones', 'George R. R. Martin', 'Pygmalion', '1998-01-01'),
(2, 'Orgueil et Préjugés', 'Jane Austen', 'T. Egerton', '1813-01-01'),
(10, 'vvvv', 'f', 'fj', '2016-11-16'),
(12, 'h', 'hh', 'hh', '2016-12-13'),
(13, 'azffddfsd', 'ds', 'sfdsf', '2016-12-05');

-- --------------------------------------------------------

--
-- Table structure for table `reservation`
--

CREATE TABLE `reservation` (
  `IdLivreRes` int(11) NOT NULL,
  `LoginAdherentRes` varchar(20) NOT NULL,
  `DateReservation` date NOT NULL,
  `DateLimiteReservation` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `reservation`
--

INSERT INTO `reservation` (`IdLivreRes`, `LoginAdherentRes`, `DateReservation`, `DateLimiteReservation`) VALUES
(2, 'seif', '2016-12-03', '2016-12-17');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `adherent`
--
ALTER TABLE `adherent`
  ADD PRIMARY KEY (`Login`);

--
-- Indexes for table `employe`
--
ALTER TABLE `employe`
  ADD PRIMARY KEY (`Login`);

--
-- Indexes for table `emprunt`
--
ALTER TABLE `emprunt`
  ADD PRIMARY KEY (`IdLivreEmp`,`LoginAdherentEmp`),
  ADD KEY `IdLivreEmp` (`IdLivreEmp`),
  ADD KEY `LoginAdherentEmp` (`LoginAdherentEmp`);

--
-- Indexes for table `livre`
--
ALTER TABLE `livre`
  ADD PRIMARY KEY (`LivreId`);

--
-- Indexes for table `reservation`
--
ALTER TABLE `reservation`
  ADD PRIMARY KEY (`IdLivreRes`,`LoginAdherentRes`),
  ADD KEY `LoginAdherentRes` (`LoginAdherentRes`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `livre`
--
ALTER TABLE `livre`
  MODIFY `LivreId` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=14;
--
-- Constraints for dumped tables
--

--
-- Constraints for table `emprunt`
--
ALTER TABLE `emprunt`
  ADD CONSTRAINT `emprunt_ibfk_1` FOREIGN KEY (`IdLivreEmp`) REFERENCES `livre` (`LivreId`) ON DELETE CASCADE,
  ADD CONSTRAINT `emprunt_ibfk_2` FOREIGN KEY (`LoginAdherentEmp`) REFERENCES `adherent` (`Login`) ON DELETE CASCADE;

--
-- Constraints for table `reservation`
--
ALTER TABLE `reservation`
  ADD CONSTRAINT `reservation_ibfk_1` FOREIGN KEY (`IdLivreRes`) REFERENCES `livre` (`LivreId`) ON DELETE CASCADE,
  ADD CONSTRAINT `reservation_ibfk_2` FOREIGN KEY (`LoginAdherentRes`) REFERENCES `adherent` (`Login`) ON DELETE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
