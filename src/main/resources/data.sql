CREATE DATABASE IF NOT EXISTS polishsite;

USE polishsite;

drop table if exists users;

CREATE TABLE IF NOT EXISTS users (
                                     id INT AUTO_INCREMENT PRIMARY KEY,
                                     name VARCHAR(50) NOT NULL,
                                     surname VARCHAR(50) NOT NULL,
                                     email VARCHAR(100) NOT NULL UNIQUE,
                                     password_hash VARCHAR(255) NOT NULL,
                                     role VARCHAR(255) NOT NULL,
                                     is_active BOOLEAN NOT NULL DEFAULT TRUE
) ENGINE = InnoDB;


CREATE TABLE IF NOT EXISTS health_survey_responses (
                                                       id BIGINT AUTO_INCREMENT PRIMARY KEY,
                                                       name VARCHAR(255),
                                                       email VARCHAR(255),
                                                       location VARCHAR(255),
                                                       gp_registered VARCHAR(255),
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

DROP TABLE IF EXISTS news;

CREATE TABLE IF NOT EXISTS news (
                                    title TEXT NOT NULL,
                                    content TEXT NOT NULL,
                                    date DATE NOT NULL,
                                    link TEXT NOT NULL,
                                    imgUrl TEXT NOT NULL
) ENGINE=InnoDB;

CREATE TABLE IF NOT EXISTS skills (
                                      name TEXT NOT NULL,
                                      description TEXT NOT NULL,
                                      link TEXT NOT NULL,
                                      duration INT(11) NULL DEFAULT NULL,
                                      expiryDate DATE NULL DEFAULT NULL
) ENGINE=InnoDB;

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


DROP TABLE IF EXISTS survey_responses;
CREATE TABLE IF NOT EXISTS survey_responses (
                                                id INT AUTO_INCREMENT PRIMARY KEY,
                                                name VARCHAR(255),
                                                email VARCHAR(255),
                                                question1 VARCHAR(255),
                                                question2 VARCHAR(255),
                                                question3 VARCHAR(255),
                                                question4 VARCHAR(255),
                                                question5 VARCHAR(255),
                                                question6 VARCHAR(255),
                                                question7 VARCHAR(255),
                                                question8 VARCHAR(255),
                                                question9 VARCHAR(255),
                                                question10 VARCHAR(255)
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

CREATE TABLE IF NOT EXISTS organisations (
                                             name TEXT NOT NULL,
                                             description TEXT NOT NULL,
                                             logo TEXT NOT NULL
) ENGINE=InnoDB;



INSERT INTO eventss (title, date, location, category, description, image_url)
VALUES
    ('Music Festival', '2024-12-01', 'Cardiff', 'Music Festival', 'A music festival in Cardiff featuring various artists.', 'https://cdn.cnn.com/cnnnext/dam/assets/181018143148-krakow-2-super-tease.jpg'),
    ('Art Exhibition', '2024-12-05', 'Swansea', 'Art or Cultural', 'An art exhibition showcasing modern and classic art in Swansea.', 'https://api.culture.pl/sites/default/files/images/imported/HISTORIA/EN/Polish_independence/zaslubiny_polski_z_morzem.jpg'),
    ('Food Festival', '2024-12-10', 'Newport', 'Food or Drink Event', 'A food festival in Newport offering a wide range of cuisines and drinks.', 'https://1.bp.blogspot.com/-SMfBCbqIRVw/WQeJ84XsJ6I/AAAAAAACJ-U/vrT-1o3hwMcTzQIzUuVkwbZqtV6Req00gCLcB/s1600/ca423901817b8b8187c9e9316481b30e.jpg');




