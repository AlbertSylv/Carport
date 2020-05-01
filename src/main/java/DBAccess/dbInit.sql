CREATE DATABASE  IF NOT EXISTS `carport`;


USE `carport`;

DROP TABLE IF EXISTS `requests`;
DROP TABLE IF EXISTS `accounts`;
DROP TABLE IF EXISTS `stockToCategory`;
DROP TABLE IF EXISTS `categories`;
DROP TABLE IF EXISTS `stock`;
DROP TABLE IF EXISTS `roofcoating`;
DROP TABLE IF EXISTS `shedclothing`;


CREATE TABLE `stock` (
  `ref` VARCHAR(100) NOT NULL,
  `name` VARCHAR(45) NOT NULL,
  `length` INT NOT NULL,
  `amount` INT NOT NULL,
  `unit` VARCHAR(45) NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`ref`)
);

CREATE TABLE `roofcoating` (
  `roofID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`roofID`)
);

CREATE TABLE `shedclothing` (
  `shedID` INT not null AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`shedID`)
);

CREATE TABLE `categories` (
	`id` INT NOT NULL AUTO_INCREMENT,
    `name` VARCHAR(100) NOT NULL,
    PRIMARY KEY(`id`)
);

CREATE TABLE `stockToCategory` (
  `stockRef` VARCHAR(100) NOT NULL,
  `categoryId` INT NOT NULL,
  PRIMARY KEY (`stockRef`, `categoryId`),
  INDEX `categoryId_FK_idx` (`categoryId` ASC) VISIBLE,
  CONSTRAINT `stockRef_FK`
    FOREIGN KEY (`stockRef`)
    REFERENCES `stock` (`ref`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `categoryId_FK`
    FOREIGN KEY (`categoryId`)
    REFERENCES `categories` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
);

CREATE TABLE `accounts` (
	`email` VARCHAR(100) NOT NULL,
	`password` VARCHAR(100) NOT NULL,
	`role` ENUM('ADMIN', 'EMPLOYEE', 'CUSTOMER') NOT NULL DEFAULT 'CUSTOMER',
	`name` VARCHAR(100) NOT NULL,
	`address` VARCHAR(100) NOT NULL,
	`zipCity` VARCHAR(200) NOT NULL,
	`phone` VARCHAR(30) NOT NULL,
	PRIMARY KEY (`email`)
);

CREATE TABLE `requests` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`roofID` INT NOT NULL,
    `shedID` INT default 1,
	`width` INT NOT NULL,
	`length` INT NOT NULL,
	`shedWidth` INT default NULL,
	`shedLength` INT default NULL,
	`angle` INT default NULL,
	`note` VARCHAR(500) default NULL,
	`email` VARCHAR(100) NOT NULL,
	PRIMARY KEY(`id`),
	INDEX `emailFK_idx` (`email` ASC) VISIBLE,
	CONSTRAINT `emailFK`
		FOREIGN KEY (`email`)
		REFERENCES `accounts` (`email`)
		ON DELETE CASCADE
		ON UPDATE CASCADE,
    CONSTRAINT `shedidFK`
		FOREIGN KEY (`shedID`)
		REFERENCES `shedclothing` (`shedID`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION,
	CONSTRAINT `roofidFK`
		FOREIGN KEY (`roofID`)
		REFERENCES `roofcoating` (`roofID`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);

INSERT INTO `accounts` VALUES
('jegerenged@gmail.com','jegerenged','customer','otto','Lars Tyndskids Mark 69','42069', '12345678');


INSERT INTO `shedclothing` VALUES
(0,'Intet skur',0),
(0,'21X85 MM BLOKHUSBRÆDDER FYR MED VEKSELFALS',269),
(0,'29X142 MM SIBIRISK LÆRK KLINKBEKLÆDNING TP. AALBORG - RUSAVET',381);


INSERT INTO `roofcoating` VALUES
(0,'Plasttrapezplade', 34),
(0,'RØDE VINGETAGSTEN GL. DANSK FORBRUG', 261);
