CREATE DATABASE GoodsDB;
USE GoodsDB;
CREATE TABLE tabl(namer VARCHAR(40), price INT);
INSERT INTO tabl VALUES ('Mixer',60);
INSERT INTO tabl VALUES('Blender',80);
UPDATE tabl SET price = 100 WHERE price = 80 AND NOT namer='Mixer';
SELECT * FROM tabl;
DROP DATABASE GoodsDB;