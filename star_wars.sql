-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: localhost
-- Tempo de geração: 01/03/2024 às 17:19
-- Versão do servidor: 10.4.28-MariaDB
-- Versão do PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `star_wars`
--

-- --------------------------------------------------------

--
-- Estrutura para tabela `characters`
--

CREATE TABLE `characters` (
  `id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `species` varchar(50) DEFAULT NULL,
  `gender` enum('Male','Female','Other') DEFAULT NULL,
  `affiliation` varchar(50) DEFAULT NULL,
  `planet_of_origin` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Despejando dados para a tabela `characters`
--

INSERT INTO `characters` (`id`, `name`, `species`, `gender`, `affiliation`, `planet_of_origin`) VALUES
(1, 'Darth Vader', 'Human', 'Male', 'Sith', 'Tatooine'),
(2, 'Obi-Wan Kenobi', 'Human', 'Male', 'Jedi', 'Stewjon'),
(3, 'Yoda', 'Unknown', 'Male', 'Jedi', 'Unknown'),
(4, 'Chewbacca', 'Wookiee', 'Male', 'Rebel Alliance', 'Kashyyyk'),
(5, 'Anakin Skywalker', 'Human', 'Male', 'Jedi/Sith', 'Tatooine'),
(6, 'Padmé Amidala', 'Human', 'Female', 'Galactic Republic', 'Naboo'),
(7, 'Emperor Palpatine', 'Human', 'Male', 'Sith', 'Naboo'),
(8, 'Boba Fett', 'Human', 'Male', 'Bounty Hunters', 'Kamino'),
(9, 'C-3PO', 'Droid', 'Male', 'Rebel Alliance', 'Tatooine'),
(10, 'R2-D2', 'Droid', 'Male', 'Rebel Alliance', 'Naboo'),
(11, 'Lando Calrissian', 'Human', 'Male', 'Rebel Alliance', 'Socorro'),
(12, 'Kylo Ren', 'Human', 'Male', 'First Order', 'Chandrila'),
(13, 'Rey', 'Human', 'Female', 'Jedi', 'Jakku'),
(14, 'Finn', 'Human', 'Male', 'Rebel Alliance', 'Unknown'),
(15, 'Poe Dameron', 'Human', 'Male', 'Rebel Alliance', 'Yavin 4'),
(16, 'Mace Windu', 'Human', 'Male', 'Jedi', 'Haruun Kal'),
(17, 'Qui-Gon Jinn', 'Human', 'Male', 'Jedi', 'Unknown'),
(18, 'Count Dooku', 'Human', 'Male', 'Sith', 'Serenno');

--
-- Índices para tabelas despejadas
--

--
-- Índices de tabela `characters`
--
ALTER TABLE `characters`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT para tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `characters`
--
ALTER TABLE `characters`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=19;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
