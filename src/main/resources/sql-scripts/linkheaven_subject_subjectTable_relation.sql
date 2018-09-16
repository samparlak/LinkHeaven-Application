CREATE DATABASE  IF NOT EXISTS `mylist` ;
USE `mylist`;

SET FOREIGN_KEY_CHECKS = 0;

DROP TABLE IF EXISTS `subject_table`;
CREATE TABLE `subject_table` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `header` varchar(45) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY(`header`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

DROP TABLE IF EXISTS `subject`;
CREATE TABLE `subject` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `header` varchar(45) DEFAULT NULL,
  `link` varchar(250) DEFAULT NULL,
  `note` varchar(250) DEFAULT NULL,
  `date` datetime DEFAULT NULL,
	`subject_table_id` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY(`header`),
  KEY `FK_SUBJECT_TABLE_ID_idx` (`subject_table_id`),
  CONSTRAINT `FK_SUBJECT_TABLE`  FOREIGN KEY (`subject_table_id`) REFERENCES `subject_table`(`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

    
SET FOREIGN_KEY_CHECKS = 1;


