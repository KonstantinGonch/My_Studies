CREATE DATABASE dataj;
USE dataj;
CREATE TABLE workers( name VARCHAR(40), post VARCHAR(40), w_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY);
CREATE TABLE professions (prof VARCHAR(40), prof_id INT NOT NULL AUTO_INCREMENT PRIMARY KEY);
INSERT INTO workers VALUES ('Sam', 'director', NULL);
INSERT INTO workers VALUES ('John', 'manager', NULL);
INSERT INTO workers VALUES ('Margot', 'scientist', NULL);
INSERT INTO workers VALUES ('Jenna', 'scientist', NULL);
INSERT INTO workers VALUES ('Cielo', 'manager', NULL);
INSERT INTO professions (prof) SELECT post FROM workers GROUP BY post ORDER BY post DESC;
SELECT * FROM professions; 
DROP DATABASE dataj;