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
-- Structure de la table `visite`
--

CREATE TABLE `visite` (
  `id` int NOT NULL,
  `praticien_id` int DEFAULT NULL,
  `visiteur_id` int DEFAULT NULL,
  `date_visite` datetime NOT NULL,
  `commentaire` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `visite`
--

INSERT INTO `visite` (`id`, `praticien_id`, `visiteur_id`, `date_visite`, `commentaire`) VALUES
(1, 1, 1, '2022-03-15 10:00:00', 'Bonne écoute et disponibilité'),
(2, 2, 2, '2022-02-10 14:00:00', 'Très professionnel et à l\'écoute'),
(3, 1, 3, '2022-01-05 16:30:00', 'Très satisfait de la consultation'),
(4, 1, 1, '2022-03-10 14:00:00', 'très bon cardio'),
(5, 2, 2, '2022-05-10 14:00:00', 'Aucun symptôme, parfait '),
(6, 3, 1, '2023-04-10 15:00:00', 'Petite grippe, rien d\'anormal'),
(7, 1, 2, '0203-01-10 11:00:00', 'Aucun élément perturbateur lors de la consultation'),
(8, 2, 3, '2022-07-10 17:00:00', 'Parfaite santé, rien à signaler');

--
-- Index pour les tables déchargées
--

--
-- Index pour la table `visite`
--
ALTER TABLE `visite`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_B09C8CBB2391866B` (`praticien_id`),
  ADD KEY `IDX_B09C8CBB7F72333D` (`visiteur_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `visite`
--
ALTER TABLE `visite`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `visite`
--
ALTER TABLE `visite`
  ADD CONSTRAINT `FK_B09C8CBB2391866B` FOREIGN KEY (`praticien_id`) REFERENCES `praticien` (`id`),
  ADD CONSTRAINT `FK_B09C8CBB7F72333D` FOREIGN KEY (`visiteur_id`) REFERENCES `visiteur` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
