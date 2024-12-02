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

CREATE TABLE IF NOT EXISTS healthtable (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    q1registered BOOLEAN NOT NULL,
    q2queries TEXT NOT NULL
)