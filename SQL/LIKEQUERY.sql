CREATE DATABASE NamesDB;
USE NamesDB;
CREATE TABLE nems(namer VARCHAR (40));
INSERT INTO nems VALUES ('rim');
INSERT INTO nems VALUES ('vim');
INSERT INTO nems VALUES ('beam');
INSERT INTO nems VALUES ('dream');
INSERT INTO nems VALUES ('trim');

SELECT * FROM nems WHERE namer LIKE '%im';
SELECT * FROM nems WHERE namer LIKE '_im';
DROP DATABASE NamesDB;