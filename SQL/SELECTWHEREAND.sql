CREATE DATABASE MerchandizeDB;
USE MerchandizeDB;
CREATE TABLE Merch (namem VARCHAR(50), price INT);
INSERT INTO Merch VALUES ('Blender', 70);
INSERT INTO Merch VALUES ('Mixer', 50);
INSERT INTO Merch VALUES ('TV', 100);
INSERT INTO Merch VALUES ('XBox', 360);
INSERT INTO Merch VALUES ('Golden Nugget', 5000);
SELECT namem FROM MERCH WHERE price>90 and price<500;
DROP DATABASE MerchandizeDB;