CREATE TABLE `test`.`blog` (
  `id` INT NOT NULL AUTO_INCREMENT,
  `author` VARCHAR(45) NULL,
  `brief` VARCHAR(200) NULL,
  `content` VARCHAR(200) NULL,
  `source` VARCHAR(45) NULL,
--  `date` DATE NULL,
  PRIMARY KEY (`id`));