CREATE DATABASE df;
USE df;
CREATE TABLE films(id INT NOT NULL AUTO_INCREMENT, name VARCHAR(50), category VARCHAR(20), PRIMARY KEY(id));
INSERT INTO films VALUES(NULL, 'Grinch',NULL);
INSERT INTO films VALUES (NULL, 'DDS',NULL);
INSERT INTO films VALUES (NULL, 'Back to the Future',NULL);
INSERT INTO films VALUES(NULL, 'Alice', NULL);
UPDATE films
	SET category = 
		CASE
			WHEN name = 'Grinch' AND id = 0 THEN 'comedy'
            WHEN name = 'DDS' THEN 'drama'
            WHEN name = 'Back to the Future' THEN 'fantasy'
            ELSE 'misc'
		END;
SELECT * FROM films;