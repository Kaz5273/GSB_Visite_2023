-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : lun. 24 avr. 2023 à 11:43
-- Version du serveur : 8.0.27
-- Version de PHP : 8.1.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données : `gsb_frais_symfony_visite`
--

-- --------------------------------------------------------

--
-- Structure de la table `visiteur_praticien`
--

CREATE TABLE `visiteur_praticien` (
  `visiteur_id` int NOT NULL,
  `praticien_id` int NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `visiteur_praticien`
--

INSERT INTO `visiteur_praticien` (`visiteur_id`, `praticien_id`) VALUES
(1, 1),
(1, 2),
(2, 1),
(2, 3),
(3, 1),
(3, 2);

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `visiteur_praticien`
--
ALTER TABLE `visiteur_praticien`
  ADD PRIMARY KEY (`visiteur_id`,`praticien_id`),
  ADD KEY `IDX_298AC7497F72333D` (`visiteur_id`),
  ADD KEY `IDX_298AC7492391866B` (`praticien_id`);

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `visiteur_praticien`
--
ALTER TABLE `visiteur_praticien`
  ADD CONSTRAINT `FK_298AC7492391866B` FOREIGN KEY (`praticien_id`) REFERENCES `praticien` (`id`) ON DELETE CASCADE,
  ADD CONSTRAINT `FK_298AC7497F72333D` FOREIGN KEY (`visiteur_id`) REFERENCES `visiteur` (`id`) ON DELETE CASCADE;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
