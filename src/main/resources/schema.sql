CREATE DATABASE IF NOT EXISTS polishsite;

USE polishsite;

# drop table if exists users;

CREATE TABLE IF NOT EXISTS users (
     id INT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(50) NOT NULL,
     surname VARCHAR(50) NOT NULL,
     email VARCHAR(100) NOT NULL UNIQUE,
     password_hash VARCHAR(255) NOT NULL
) ENGINE = InnoDB;
