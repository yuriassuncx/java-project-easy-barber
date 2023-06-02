CREATE DATABASE barbearia;

USE barbearia;

CREATE TABLE `user` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `email` VARCHAR(50) NOT NULL UNIQUE,
    `password` VARCHAR(50) NOT NULL,
    `created_at` TIMESTAMP DEFAULT NOW()
);

CREATE TABLE `admin` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL,
    `email` VARCHAR(50) NOT NULL UNIQUE,
    `password` VARCHAR(50) NOT NULL,
    `created_at` TIMESTAMP DEFAULT NOW()
);

CREATE TABLE `barber` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `name` VARCHAR(50) NOT NULL
);

CREATE TABLE `schedule` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `user_id` INT NOT NULL,
    `barber_id` INT NOT NULL,
    `service` VARCHAR(50) NOT NULL,
    `scheduled_data` VARCHAR(50) NOT NULL,
    `scheduled_hour` VARCHAR(50) NOT NULL,
    `description` VARCHAR(150),
    `price` INT NOT NULL,
    `status` BOOLEAN NOT NULL DEFAULT FALSE,
    `created_at` TIMESTAMP DEFAULT NOW(),
    
    UNIQUE (`scheduled_data`, `scheduled_hour`, `barber_id`),
    FOREIGN KEY (`user_id`) REFERENCES `user`(`id`) ON UPDATE CASCADE,
    FOREIGN KEY (`barber_id`) REFERENCES `barber`(`id`) ON UPDATE CASCADE
);

CREATE TABLE `service` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `cut_type` VARCHAR(50) NOT NULL,
    `price` INT NOT NULL
);

CREATE TABLE `feedback` (
	`id` INT PRIMARY KEY AUTO_INCREMENT,
    `barber_id` INT NOT NULL,
	`user_id` INT NOT NULL,
    `is_liked` BOOLEAN NOT NULL,
    `description` VARCHAR(35) NOT NULL,
    `created_at` TIMESTAMP DEFAULT NOW(),
    
    FOREIGN KEY (`barber_id`) REFERENCES `barber`(`id`),
	FOREIGN KEY (`user_id`) REFERENCES `user`(`id`)
);

ALTER TABLE `feedback` ADD CONSTRAINT `unique_user_barber_feedback` UNIQUE (user_id, barber_id);

INSERT INTO `user`(`name`, `email`, `password`) VALUES ("teste", "teste", "teste");
INSERT INTO `user`(`name`, `email`, `password`) VALUES ("teste2", "teste2", "teste2");

INSERT INTO `barber`(`name`) VALUES ("barbeiro1");
INSERT INTO `barber`(`name`) VALUES ("barbeiro2");
INSERT INTO `barber`(`name`) VALUES ("barbeiro3");

INSERT INTO `feedback`(`barber_id`, `user_id`, `is_liked`, `description`) VALUES (3, 1, true, "Habilidade");
INSERT INTO `feedback`(`barber_id`, `user_id`, `is_liked`, `description`) VALUES (3, 2, true, "Habilidade");
INSERT INTO `feedback`(`barber_id`, `user_id`, `is_liked`, `description`) VALUES (2, 1, true, "Gentileza");
INSERT INTO `feedback`(`barber_id`, `user_id`, `is_liked`, `description`) VALUES (1, 2, false, "Não gostei");
