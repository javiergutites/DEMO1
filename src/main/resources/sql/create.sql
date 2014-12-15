/* DROPS */
DROP TABLE IF EXISTS `profiles_roles`;
DROP TABLE IF EXISTS `profiles`;
DROP TABLE IF EXISTS `roles`;
DROP TABLE IF EXISTS `users`;
DROP TABLE IF EXISTS `companies`;

/* CREATES */
CREATE TABLE `companies` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `name` varchar(128) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;

CREATE TABLE `profiles` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `roles` (
  `name` varchar(255) NOT NULL,
  PRIMARY KEY (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `profiles_roles` (
  `profiles` varchar(255) NOT NULL,
  `roles` varchar(255) NOT NULL,
  PRIMARY KEY (`profiles`,`roles`),
  KEY `FKD75F86286B5F2969` (`roles`),
  KEY `FKD75F862866AC679D` (`profiles`),
  CONSTRAINT `FKD75F862866AC679D` FOREIGN KEY (`profiles`) REFERENCES `profiles` (`name`),
  CONSTRAINT `FKD75F86286B5F2969` FOREIGN KEY (`roles`) REFERENCES `roles` (`name`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

CREATE TABLE `users` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `active` bit(1) NOT NULL,
  `comments` varchar(255) DEFAULT NULL,
  `creation_date` datetime DEFAULT NULL,
  `email` varchar(255) DEFAULT NULL,
  `name` varchar(255) DEFAULT NULL,
  `username` varchar(255) DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `surname` varchar(255) DEFAULT NULL,
  `company` int(11) NOT NULL,
  `profile` varchar(255) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `username` (`username`),
  KEY `FK6A68E082629AB04` (`company`),
  KEY `FK6A68E088FF8455C` (`profile`),
  CONSTRAINT `FK6A68E088FF8455C` FOREIGN KEY (`profile`) REFERENCES `profiles` (`name`),
  CONSTRAINT `FK6A68E082629AB04` FOREIGN KEY (`company`) REFERENCES `companies` (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
