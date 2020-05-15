CREATE DATABASE  IF NOT EXISTS `carport`;


USE `carport`;

DROP TABLE IF EXISTS `requests`;
DROP TABLE IF EXISTS `accounts`;
DROP TABLE IF EXISTS `roof coating`;
DROP TABLE IF EXISTS `shed clothing`;
DROP TABLE IF EXISTS `wood`;
DROP TABLE IF EXISTs `stocktocategory`;
DROP TABLE IF EXISTs `categories`;
DROP TABLE IF EXISTs `stock`;
DROP TABLE IF EXISTS `roofcoating`;
DROP TABLE IF EXISTS `tiltedroofcoating`;
DROP TABLE IF EXISTS `shedclothing`;



CREATE TABLE `roofcoating` (
  `roofID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`roofID`)
);

CREATE TABLE `tiltedroofcoating` (
  `tiltedroofID` INT NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`tiltedroofID`)
);

CREATE TABLE `shedclothing` (
  `shedID` INT not null AUTO_INCREMENT,
  `name` VARCHAR(100) NOT NULL,
  `price` INT NOT NULL,
  PRIMARY KEY (`shedID`)
);



CREATE TABLE `accounts` (
	`email` VARCHAR(100) NOT NULL,
	`password` VARCHAR(100) NOT NULL,
	`role` ENUM('admin', 'employee', 'customer') NOT NULL DEFAULT 'customer',
	`name` VARCHAR(100) NOT NULL,
	`address` VARCHAR(100) NOT NULL,
	`zipCity` VARCHAR(200) NOT NULL,
	`phone` VARCHAR(30) NOT NULL,
	PRIMARY KEY (`email`)
);

CREATE TABLE `requests` (
	`id` INT NOT NULL AUTO_INCREMENT,
	`roofID` INT default 1,
	`tiltedroofID` int default 1,
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
		ON UPDATE NO ACTION,
	CONSTRAINT `tiltedroofidFK`
		FOREIGN KEY (`tiltedroofID`)
		REFERENCES `tiltedroofcoating` (`tiltedroofID`)
		ON DELETE NO ACTION
		ON UPDATE NO ACTION
);

INSERT INTO `accounts` VALUES
('jegerenged@gmail.com','jegerenged','customer','otto','Lars Tyndskids Mark 69','42069', '12345678'),
('arbejd@mail.com','1234','employee','Karl','Lars Tykskids Mark 69','3000', '22345678');


INSERT INTO `shedclothing` VALUES
(0,'Intet skur',0),
(0,'21X85 MM BLOKHUSBRÆDDER FYR MED VEKSELFALS',269),
(0,'29X142 MM SIBIRISK LÆRK KLINKBEKLÆDNING TP. AALBORG - RUSAVET',381);


INSERT INTO `roofcoating` VALUES
(0,'Tag med rejsning', 0),
(0,'Plasttrapezplade', 34);


INSERT INTO `tiltedroofcoating` VALUES
(0,'Fladt tag', 0),
(0,'RØDE VINGETAGSTEN GL. DANSK FORBRUG', 261);

CREATE TABLE `wood` (
  `type` VARCHAR(100) NOT NULL,
  `name` VARCHAR(100) NOT NULL,
  `pricePrM` INT NOT NULL,
  PRIMARY KEY (`type`)
);

INSERT INTO `wood` VALUES
('Pæl','97X97 MM FULDKANTET FYR IMPR. NTR/A TRYKIMPRÆGNERET',41.95),
('Spær','47X200 MM SPÆRTRÆ C18 HØVLET TIL 45X195MM',46.95),
('Regel','45X95 MM SIBIRISK LÆRK REGEL KVARTA, HØVLET 4 SIDER M/AFR. KANTER',59.95),
('UniversalBeslag','Højre og venstre universal beslag 190 mm',45),
('Vindskede','25X150 MM VTA TRYKIMPRÆGNERET',45),
('LøsholteBeslag','Vinkelbeslag til løsholter',5),
('BræddeBolt','Varmgalvaniseret bræddebolt 10x120mm og firkantskive 40x40x11mm',20),
('Lægte','38x73 mm. taglægte T1 ',18);