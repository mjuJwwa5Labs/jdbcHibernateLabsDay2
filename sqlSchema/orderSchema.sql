-- MySQL Workbench Synchronization
-- Generated: 2018-02-10 10:30
-- Model: New Model
-- Version: 1.0
-- Project: Name of the project
-- Author: juszc

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='TRADITIONAL,ALLOW_INVALID_DATES';

CREATE TABLE IF NOT EXISTS `order`.`Customer` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `login` VARCHAR(45) NOT NULL,
  `first_name` VARCHAR(200) NOT NULL,
  `last_name` VARCHAR(200) NOT NULL,
  `type` VARCHAR(10) NOT NULL,
  `address_id` INT(10) UNSIGNED NULL DEFAULT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `login_UNIQUE` (`login` ASC),
  INDEX `fk_customer_address_idx` (`address_id` ASC),
  CONSTRAINT `fk_customer_address`
    FOREIGN KEY (`address_id`)
    REFERENCES `order`.`Address` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `order`.`Address` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `street` VARCHAR(100) NOT NULL,
  `city` VARCHAR(100) NOT NULL,
  `postal` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`id`))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `order`.`Order` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `customer_id` INT(10) UNSIGNED NULL DEFAULT NULL,
  `status` VARCHAR(10) NOT NULL,
  `creation_date` TIMESTAMP NOT NULL,
  PRIMARY KEY (`id`),
  INDEX `fk_order_customer_idx` (`customer_id` ASC),
  CONSTRAINT `fk_order_customer`
    FOREIGN KEY (`customer_id`)
    REFERENCES `order`.`Customer` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `order`.`Product` (
  `id` INT(10) UNSIGNED NOT NULL AUTO_INCREMENT,
  `name` VARCHAR(45) NOT NULL,
  `price` DECIMAL NOT NULL,
  `category` VARCHAR(10) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE INDEX `name_UNIQUE` (`name` ASC))
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;

CREATE TABLE IF NOT EXISTS `order`.`OrderItems` (
  `order_id` INT(10) UNSIGNED NOT NULL,
  `product_id` INT(10) UNSIGNED NOT NULL,
  `quantity` INT(10) UNSIGNED NOT NULL,
  PRIMARY KEY (`order_id`, `product_id`),
  INDEX `fk_orde_items_product_idx` (`product_id` ASC),
  CONSTRAINT `fk_order_items_order`
    FOREIGN KEY (`order_id`)
    REFERENCES `order`.`Order` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_orde_items_product`
    FOREIGN KEY (`product_id`)
    REFERENCES `order`.`Product` (`id`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB
DEFAULT CHARACTER SET = utf8;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;