-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Hôte : localhost
-- Généré le : lun. 24 avr. 2023 à 11:44
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
-- Structure de la table `messenger_messages`
--

CREATE TABLE `messenger_messages` (
  `id` bigint NOT NULL,
  `body` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `headers` longtext COLLATE utf8mb4_unicode_ci NOT NULL,
  `queue_name` varchar(190) COLLATE utf8mb4_unicode_ci NOT NULL,
  `created_at` datetime NOT NULL,
  `available_at` datetime NOT NULL,
  `delivered_at` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

-- --------------------------------------------------------

--
-- Structure de la table `praticien`
--

CREATE TABLE `praticien` (
  `id` int NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `prenom` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `mail` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `telephone` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `rue` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `code_postal` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `ville` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `coeff_notoriete` decimal(5,2) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `praticien`
--

INSERT INTO `praticien` (`id`, `nom`, `prenom`, `mail`, `telephone`, `rue`, `code_postal`, `ville`, `coeff_notoriete`) VALUES
(1, 'Dupont', 'Pierre', 'pierre.dupont@mail.com', '0102030405', 'Rue de la Paix', '75001', 'Paris', '4.25'),
(2, 'Martin', 'Sophie', 'sophie.martin@mail.com', '0607080910', 'Rue de Rivoli', '75004', 'Paris', '3.75'),
(3, 'Lefebvre', 'Julie', 'julie.lefebvre@mail.com', '0601020304', 'Avenue des Champs-Elysées', '75008', 'Paris', '4.50'),
(4, 'Dumont', 'François', 'francois.dumont@mail.com', '0607080910', 'Rue du Faubourg Saint-Honoré', '75008', 'Paris', '3.00'),
(5, 'Leroy', 'Lucie', 'lucie.leroy@mail.com', '0102030405', 'Rue de la République', '69002', 'Lyon', '4.00');

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

-- --------------------------------------------------------

--
-- Structure de la table `visiteur`
--

CREATE TABLE `visiteur` (
  `id` int NOT NULL,
  `username` varchar(180) COLLATE utf8mb4_unicode_ci NOT NULL,
  `roles` json NOT NULL,
  `password` varchar(255) COLLATE utf8mb4_unicode_ci NOT NULL,
  `nom` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `prenom` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `telephone` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `mail` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `matricule` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Déchargement des données de la table `visiteur`
--

INSERT INTO `visiteur` (`id`, `username`, `roles`, `password`, `nom`, `prenom`, `telephone`, `mail`, `matricule`) VALUES
(1, 'admin', '[]', '$2y$13$NLd8EF2IC9CbNCeWVbCw8ev.g2BkB8HOvOsJVRI9W9u0iZRO4YdK.', 'Allard', 'Kazuki', '0651761323', 'kazutor73@gmail.com', 'MA123'),
(2, 'visiteur1', '[]', '$2y$13$hAfMVElhAh1Mdms9tv1pqO7/Lq2XaO.kuw5wt00moAiXTyyBx8Z.q', 'Jone', 'Doe', '0432349543', 'JoneDoe@gmail.com', 'MX345'),
(3, 'visiteur2', '[]', '$2y$13$iCqwxowCYllTW0jE7Xm/yeRbqL9YWV2KhpoWybD6k7JQoHFTh9AXG', 'Alice', 'Conrade', '09876454', 'AliceConrade@gmail.com', 'SP98');

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
-- Index pour la table `messenger_messages`
--
ALTER TABLE `messenger_messages`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_75EA56E0FB7336F0` (`queue_name`),
  ADD KEY `IDX_75EA56E0E3BD61CE` (`available_at`),
  ADD KEY `IDX_75EA56E016BA31DB` (`delivered_at`);

--
-- Index pour la table `praticien`
--
ALTER TABLE `praticien`
  ADD PRIMARY KEY (`id`);

--
-- Index pour la table `visite`
--
ALTER TABLE `visite`
  ADD PRIMARY KEY (`id`),
  ADD KEY `IDX_B09C8CBB2391866B` (`praticien_id`),
  ADD KEY `IDX_B09C8CBB7F72333D` (`visiteur_id`);

--
-- Index pour la table `visiteur`
--
ALTER TABLE `visiteur`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UNIQ_4EA587B8F85E0677` (`username`);

--
-- Index pour la table `visiteur_praticien`
--
ALTER TABLE `visiteur_praticien`
  ADD PRIMARY KEY (`visiteur_id`,`praticien_id`),
  ADD KEY `IDX_298AC7497F72333D` (`visiteur_id`),
  ADD KEY `IDX_298AC7492391866B` (`praticien_id`);

--
-- AUTO_INCREMENT pour les tables déchargées
--

--
-- AUTO_INCREMENT pour la table `messenger_messages`
--
ALTER TABLE `messenger_messages`
  MODIFY `id` bigint NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT pour la table `praticien`
--
ALTER TABLE `praticien`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT pour la table `visite`
--
ALTER TABLE `visite`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- AUTO_INCREMENT pour la table `visiteur`
--
ALTER TABLE `visiteur`
  MODIFY `id` int NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- Contraintes pour les tables déchargées
--

--
-- Contraintes pour la table `visite`
--
ALTER TABLE `visite`
  ADD CONSTRAINT `FK_B09C8CBB2391866B` FOREIGN KEY (`praticien_id`) REFERENCES `praticien` (`id`),
  ADD CONSTRAINT `FK_B09C8CBB7F72333D` FOREIGN KEY (`visiteur_id`) REFERENCES `visiteur` (`id`);

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
