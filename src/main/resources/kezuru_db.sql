DROP DATABASE IF EXISTS `kezuru_db`;

CREATE DATABASE  IF NOT EXISTS `kezuru_db`;
USE `kezuru_db`;

--
-- Table structure for table `entry`
--

DROP TABLE IF EXISTS `entries`;
CREATE TABLE `entries` (
    `id` int(254) NOT NULL,
    `category` varchar(45) DEFAULT NULL,
    `author_id` varchar(45) DEFAULT NULL,
    `title` LONGTEXT DEFAULT NULL,
    `body` LONGTEXT DEFAULT NULL,
    `date` DATE NOT NULL,
    PRIMARY KEY (`id`)    
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;

INSERT INTO `entries` (`id`, `category`, `author_id`, `title`, `body`, `date`) VALUES
	(1, 'ramen', 'john', 'hellohellowelcome well', 'word words words', '2015-02-10 00:00:00');

DROP TABLE IF EXISTS `creators`;
CREATE TABLE `creators` (
`id` int(254) NOT NULL,
`username` varchar(50) NOT NULL,
`fullname` varchar(50) NOT NULL,
`passwordhash` LONGTEXT NOT NULL,
PRIMARY KEY (`username`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;