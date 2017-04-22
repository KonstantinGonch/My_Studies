CREATE DATABASE df;
USE df;
CREATE TABLE workers(id INT NOT NULL AUTO_INCREMENT, name VARCHAR(40), PRIMARY KEY(id));
INSERT INTO workers VALUES(NULL, 'Jenna');
INSERT INTO workers VALUES(NULL, 'Serge');
INSERT INTO workers VALUES(NULL, 'Aegis');
SELECT * FROM workers ORDER BY name;