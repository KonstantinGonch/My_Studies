CREATE DATABASE WorkersDB;
USE WorkersDB;
CREATE TABLE wrks (fname VARCHAR(40) NOT NULL, sname VARCHAR(40) NOT NULL, salary INT NOT NULL DEFAULT 0);
INSERT INTO wrks VALUES('Jenna', 'Angel', 4000);
INSERT INTO wrks VALUES ('Margot' 'Cuvier', 10000);
SELECT * FROM wrks WHERE fname = 'Jenna';