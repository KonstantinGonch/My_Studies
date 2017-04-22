CREATE DATABASE MerchandizeDB;
USE MerchandizeDB;
CREATE TABLE merch(namer VARCHAR(50), price INT);
INSERT INTO merch VALUES ('Blender', 30);
INSERT INTO merch VALUES ('Mixer',70);
INSERT INTO merch VALUES ('Mixer',60);
DELETE FROM merch WHERE actorstaffprice=60;
SELECT * FROM merch;