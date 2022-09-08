CREATE DATABASE Schedule;

USE Schedule;

CREATE TABLE Users(
Names				VARCHAR(255)	NOT NULL,
FirstLastName    	VARCHAR(255)	NOT NULL,
ID					VARCHAR(255)	NOT NULL,
Pass				VARCHAR(255)	NOT NULL,
CONSTRAINT PK_Users PRIMARY KEY(ID)
);

INSERT INTO Users VALUES ('Luis Angel','Valencia','5540280190','1234')

DELETE FROM Users 
WHERE ID = ''

SELECT 
U.Names				AS 'Nombre(s)',
U.FirstLastName		AS 'Apellido',
U.ID				AS 'Numero telefonico',
U.Pass				AS 'Contraseña'
FROM Users U
