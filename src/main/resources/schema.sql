CREATE DATABASE IF NOT EXISTS polishsite;

USE polishsite;

drop table if exists users;

CREATE TABLE IF NOT EXISTS users (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(50) NOT NULL,
    surname VARCHAR(50) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password_hash VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL DEFAULT 'User'
) ENGINE = InnoDB;

CREATE TABLE IF NOT EXISTS healthtable (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) NOT NULL,
    location VARCHAR(255) NOT NULL,
    q1registered BOOLEAN NOT NULL,
    q2queries TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS work_information (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description TEXT,
    link VARCHAR(255),
    job_type VARCHAR(50),
    expiry_date DATE
);

drop table if exists rights_FAQs;
drop table if exists sub_rights;
drop table if exists rights;

create table if not exists rights(
    title_id INT AUTO_INCREMENT PRIMARY KEY,
    title VARCHAR(255) NOT NULL,
    description TEXT
);

create table if not exists sub_rights(
    sub_title_id INT AUTO_INCREMENT PRIMARY KEY,
    sub_title VARCHAR(255) NOT NULL,
    description TEXT,
    title_id int,
    FOREIGN KEY (title_id) REFERENCES rights(title_id)
);

CREATE TABLE IF NOT EXISTS resources (
    name TEXT NOT NULL,
    description TEXT NOT NULL,
    access TEXT NOT NULL,
    link TEXT NULL DEFAULT NULL,
    address TEXT NULL DEFAULT NULL,
    phone TEXT NULL DEFAULT NULL
) ENGINE = InnoDB;


DROP TABLE IF EXISTS housing_replies;
DROP TABLE IF EXISTS housing_questionnaire;

CREATE TABLE IF NOT EXISTS housing_questionnaire (
     id BIGINT AUTO_INCREMENT PRIMARY KEY,
     name VARCHAR(100),
     email VARCHAR(100),
     message TEXT NOT NULL
);

CREATE TABLE IF NOT EXISTS housing_replies (
   id BIGINT AUTO_INCREMENT PRIMARY KEY,
   name VARCHAR(100),
   message TEXT NOT NULL,
   question_id BIGINT,
   FOREIGN KEY (question_id) REFERENCES housing_questionnaire(id) ON DELETE CASCADE
);




CREATE TABLE IF NOT EXISTS survey_responses (
    id INT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    gender VARCHAR(50),
    reason_for_seeking_work VARCHAR(255),
    education_level VARCHAR(100),
    comfort_with_language VARCHAR(100),
    work_environment VARCHAR(100),
    team_preference VARCHAR(100),
    skills_experience VARCHAR(100),
    work_schedule VARCHAR(100),
    desired_industry VARCHAR(100),
    job_stability VARCHAR(100),
    job_impact_on_life VARCHAR(255)
)ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS housing_questionnaire (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255),
    email VARCHAR(255),
    message TEXT NOT NULL
) ENGINE = InnoDB;

create table if not exists rights_FAQs(
    que_id INT AUTO_INCREMENT PRIMARY KEY,
    que VARCHAR(255) NOT NULL,
    answer TEXT,
    title_id int,
    FOREIGN KEY (title_id) REFERENCES rights(title_id)
);

