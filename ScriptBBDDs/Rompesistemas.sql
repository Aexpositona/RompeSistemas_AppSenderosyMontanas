DROP DATABASE IF EXISTS APPSenderosMontanas;
CREATE DATABASE IF NOT EXISTS APPSenderosMontanas;
USE APPSenderosMontanas;

/*------ CREACIÓN DE TABLAS ------*/

CREATE TABLE IF NOT EXISTS Federacion(
	idFederacion INT NOT NULL AUTO_INCREMENT,
    codigoFederacion VARCHAR(7) NOT NULL DEFAULT "" UNIQUE,
    nombreFederacion VARCHAR(50) NOT NULL DEFAULT "" UNIQUE,
    PRIMARY KEY (idFederacion)
);

CREATE TABLE IF NOT EXISTS Seguro(
	idSeguro INT NOT NULL UNIQUE,
	nombreSeguro VARCHAR(10) NOT NULL UNIQUE,
    precio DECIMAL(5,2) NOT NULL,
    PRIMARY KEY (idSeguro)
);

CREATE TABLE IF NOT EXISTS Socio(
	idSocio INT NOT NULL AUTO_INCREMENT,
    tipo INT NOT NULL DEFAULT 0,
    codigoSocio VARCHAR(7) NOT NULL DEFAULT "" UNIQUE,
    nombreSocio VARCHAR(50) NOT NULL DEFAULT "",
    nifSocio VARCHAR(9) NOT NULL DEFAULT "",
	PRIMARY KEY (idSocio)
);

CREATE TABLE IF NOT EXISTS Federado(
	idSocio  INT NOT NULL AUTO_INCREMENT,
    idFederacion INT NOT NULL,
	PRIMARY KEY (idSocio),
    FOREIGN KEY (idSocio) REFERENCES Socio (idSocio) 
		ON UPDATE CASCADE
        ON DELETE RESTRICT,
    FOREIGN KEY (idFederacion) REFERENCES Federacion(idFederacion) 
		ON UPDATE CASCADE
        ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS Estandar(
	idSocio INT NOT NULL AUTO_INCREMENT,
    idSeguro INT NOT NULL,
    PRIMARY KEY (idSocio),
    FOREIGN KEY  (idSocio) REFERENCES Socio (idSocio)
		ON UPDATE CASCADE
        ON DELETE RESTRICT,
    FOREIGN KEY  (idSeguro) REFERENCES Seguro (idSeguro)
		ON UPDATE CASCADE
        ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS Infantil(
	idSocio INT NOT NULL AUTO_INCREMENT,
    idSocioTutor INT NOT NULL,
    PRIMARY KEY (idSocio),
    FOREIGN KEY (idSocio) REFERENCES Socio (idSocio)
		ON UPDATE CASCADE
        ON DELETE RESTRICT,
	FOREIGN KEY (idSocioTutor) REFERENCES Socio (idsocio)
		ON UPDATE CASCADE
        ON DELETE RESTRICT
);

CREATE TABLE IF NOT EXISTS Excursion(
	idExcursion INT NOT NULL AUTO_INCREMENT,
    codigoExcursion VARCHAR(10) NOT NULL DEFAULT "" UNIQUE,
    descripcion VARCHAR(255) NOT NULL,
    fecha DATE NOT NULL,
    duracion INT NOT NULL,
    precio FLOAT NOT NULL,
    PRIMARY KEY (idExcursion)
);

CREATE TABLE IF NOT EXISTS Inscripcion(
	idInscripcion INT NOT NULL AUTO_INCREMENT,
    codigoInscripcion VARCHAR(7) NOT NULL DEFAULT "" UNIQUE,
    fechaInscripcion DATE NOT NULL,
    idSocio INT NOT NULL,
    idExcursion INT NOT NULL,
    PRIMARY KEY (idInscripcion),
    FOREIGN KEY  (idSocio) REFERENCES Socio (idSocio)
		ON UPDATE CASCADE
        ON DELETE RESTRICT,
	FOREIGN KEY (idExcursion) REFERENCES Excursion (idExcursion)
		ON UPDATE CASCADE
        ON DELETE RESTRICT
);

/*------ Inserción de seguros ------*/
INSERT INTO Seguro (idSeguro, nombreSeguro, precio)
VALUES (1,'Básico', 100.00), (2,'Completo', 200.00);
SELECT * FROM Seguro;

-- Función para definir código alfanumérico tipos de socio
DROP FUNCTION IF EXISTS gen_codigo;
DELIMITER //
CREATE FUNCTION gen_codigo (tipo INT, id INT)
RETURNS VARCHAR(7)
	DETERMINISTIC
    CONTAINS SQL
		BEGIN
			DECLARE codigo_socio VARCHAR(7);
            DECLARE encabezado VARCHAR(3);
            DECLARE relleno VARCHAR(4);
            SET encabezado = 
            CASE 
				WHEN tipo = 1 THEN "EXC"
                WHEN tipo = 2 THEN "INS"
                WHEN tipo = 3 THEN "SOC"
                WHEN tipo = 4 THEN "FED"
                ELSE ""
			END;
            SET relleno =
            CASE 
				WHEN id < 10 THEN "000"
                WHEN id >= 10 AND id < 100 THEN "00"
                WHEN id >= 100 AND id < 1000 THEN "0"
                ELSE ""
			END;
			SET codigo_socio = CONCAT(encabezado, relleno, id);
            RETURN codigo_socio;
		END;//
DELIMITER ;

-- Procedimiento para insertar Federación 
DROP PROCEDURE IF EXISTS InsertarFederacion;
DELIMITER $$
CREATE PROCEDURE InsertarFederacion(nombre VARCHAR(50))
	BEGIN 
		INSERT INTO Federacion(nombreFederacion)
        VALUES (nombre);
        
		SET @ultimo_id = LAST_INSERT_ID();
		
		UPDATE Federacion SET codigoFederacion = gen_codigo(4, @ultimo_id) WHERE idFederacion = @ultimo_id;
        
        SELECT "Federación añadida." AS Resultado,
			fe.idFederacion,
            fe.codigoFederacion,
            fe.nombreFederacion
        FROM Federacion fe
        WHERE fe.idFederacion = @ultimo_id;
        
	END;$$
DELIMITER ;

-- Procedimiento para insertar usuario Estandar
DROP PROCEDURE IF EXISTS InsertarEstandar;
DELIMITER $$
CREATE PROCEDURE InsertarEstandar(nombre VARCHAR(50), nif VARCHAR(9), seguro INT)
	BEGIN 
		INSERT INTO Socio(tipo, nombreSocio, nifSocio)
        VALUES (1, nombre, nif);
        
		SET @ultimo_id = LAST_INSERT_ID();

        INSERT INTO Estandar(idSocio, idSeguro)
		VALUES (@ultimo_id, seguro);
		
		UPDATE Socio SET codigoSocio = gen_codigo(3, @ultimo_id) WHERE idSocio = @ultimo_id;
        
        SELECT "Usuario Estandar añadido." AS Resultado,
			so.idSocio,
            so.codigoSocio,
            so.nombreSocio,
            so.nifSocio,
            se.nombreSeguro,
            se.precio
        FROM Socio so
        JOIN Estandar e ON so.idSocio = e.idSocio
        JOIN Seguro se ON e.idSeguro = se.idSeguro
        WHERE so.idSocio = @ultimo_id;
        
	END;$$
DELIMITER ;

-- Procedimiento para insertar usuario Federado
DROP PROCEDURE IF EXISTS InsertarFederado;
DELIMITER $$
CREATE PROCEDURE InsertarFederado(nombre VARCHAR(50), nif VARCHAR(9), federacion INT)
	BEGIN 
		INSERT INTO Socio(tipo, nombreSocio, nifSocio)
        VALUES (2, nombre, nif);
        
		SET @ultimo_id = LAST_INSERT_ID();

        INSERT INTO Federado(idSocio, idFederacion)
		VALUES (@ultimo_id, federacion);
		
		UPDATE Socio SET codigoSocio = gen_codigo(3, @ultimo_id) WHERE idSocio = @ultimo_id;
        
        SELECT "Usuario Federado añadido." AS Resultado,
			so.idSocio,
            so.codigoSocio,
            so.nombreSocio,
            so.nifSocio,
            fe.nombreFederacion
        FROM Socio so
        JOIN Federado fedo ON so.idSocio = fedo.idSocio
        JOIN Federacion fe ON fe.idFederacion = fedo.idFederacion
        WHERE so.idSocio = @ultimo_id;
        
	END;$$
DELIMITER ;

-- Procedimiento para insertar usuario Infantil
DROP PROCEDURE IF EXISTS InsertarInfantil;
DELIMITER $$
CREATE PROCEDURE InsertarInfantil(nombre VARCHAR(50), nif VARCHAR(9), socioTutor INT)
	BEGIN 
		INSERT INTO Socio(tipo, nombreSocio, nifSocio)
        VALUES (3, nombre, nif);
        
		SET @ultimo_id = LAST_INSERT_ID();

        INSERT INTO Infantil(idSocio, idSocioTutor)
		VALUES (@ultimo_id, socioTutor);
		
		UPDATE Socio SET codigoSocio = gen_codigo(3, @ultimo_id) WHERE idSocio = @ultimo_id;
        
        SELECT "Usuario Infantil añadido." AS Resultado,
			so.idSocio,
            so.codigoSocio,
            so.nombreSocio,
            so.nifSocio,
            (SELECT s.nombreSocio FROM socio s WHERE s.idSocio = i.idSocioTutor) AS Socio_Tutor
        FROM Socio so
        JOIN Infantil i ON so.idSocio = i.idSocio
        WHERE so.idSocio = @ultimo_id;
        
	END;$$
DELIMITER ;

-- Procedimiento para insertar Excursión
DROP PROCEDURE IF EXISTS InsertarExcursion;
DELIMITER $$
CREATE PROCEDURE InsertarExcursion(descripcion VARCHAR(255), fecha DATE, duracion INT, precio DECIMAL(5,2))
	BEGIN 
		INSERT INTO Excursion(descripcion, fecha, duracion, precio)
        VALUES (descripcion, fecha, duracion, precio);
        
		SET @ultimo_id = LAST_INSERT_ID();

		UPDATE Excursion SET codigoExcursion = gen_codigo(1, @ultimo_id) WHERE idExcursion = @ultimo_id;
        
        SELECT "Excursión añadida." AS Resultado,
			ex.idExcursion,
            ex.codigoExcursion,
            ex.descripcion, 
            ex.fecha, 
            ex.duracion, 
            ex.precio
        FROM Excursion ex
        WHERE ex.idExcursion = @ultimo_id;
        
	END;$$
DELIMITER ;

-- Procedimiento para insertar Inscripción
DROP PROCEDURE IF EXISTS InsertarInscripcion;
DELIMITER $$
CREATE PROCEDURE InsertarInscripcion(fechaInscripcion DATE, idSocio INT, idExcursion INT)
	BEGIN 
		INSERT INTO Inscripcion(fechaInscripcion, idSocio, idExcursion)
        VALUES (fechaInscripcion, idSocio, idExcursion);
        
		SET @ultimo_id = LAST_INSERT_ID();

		UPDATE Inscripcion SET codigoInscripcion = gen_codigo(2, @ultimo_id) WHERE idInscripcion = @ultimo_id;
        
        SELECT "Inscripción añadida." AS Resultado,
			i.idInscripcion,
            i.codigoInscripcion,
            i.fechaInscripcion, 
            s.nombreSocio, 
            ex.descripcion
        FROM Inscripcion i
        JOIN Excursion ex ON i.idExcursion = ex.idExcursion
        JOIN Socio s ON i.idSocio = s.idSocio
        WHERE ex.idExcursion = @ultimo_id;
        
	END;$$
DELIMITER ;

-- Insertar y comprobar federaciones
CALL InsertarFederacion("Federación de montes");
CALL InsertarFederacion("Federación de ríos");
CALL InsertarFederacion("Federación de montañas");

SELECT * FROM Federacion;

/*---- Insertar y comprobar Socios ----*/

-- Estandar
CALL InsertarEstandar("Juan", "1234590A", 1);
CALL InsertarEstandar("Luis", "1234590B", 2);
CALL InsertarEstandar("Ana", "1234590C", 1);
CALL InsertarEstandar("Marcos", "1234590D", 2);
-- Federados
CALL InsertarFederado("Pedro", "23213312A", 1);
CALL InsertarFederado("Marc", "84736189B", 2);
CALL InsertarFederado("Pedro", "87637489V", 3);
-- Infantiles
CALL InsertarInfantil("Aitor", "83736182A", 1);
CALL InsertarInfantil("Alan", "83736182B", 2);
CALL InsertarInfantil("Alejandro", "83736182C", 3);

SELECT s.idSocio, s.tipo, s.codigoSocio, s.nombreSocio, s.nifSocio, e.idSeguro, f.idFederacion, i.idSocioTutor
FROM Socio s 
LEFT JOIN Estandar e ON s.idSocio = e.idSocio
LEFT JOIN Federado f ON s.idSocio = f.idSocio
LEFT JOIN Infantil i ON s.idSocio = i.idSocio
WHERE s.idSocio <> 0
GROUP BY s.idSocio;

-- Insertar y comprobar Excursiones
CALL InsertarExcursion('Salida al monte.' , '2024-4-1' , 5 , 50.00);
CALL InsertarExcursion('Salida al rio.' , '2024-8-30' , 3 , 60.00);
CALL InsertarExcursion('Salida a la montaña.' , '2024-10-3' , 7 , 70.00);

SELECT * FROM Excursion;

-- Insertar y comprobar Inscripciones
CALL InsertarInscripcion('2024-4-1', 1, 1);
CALL InsertarInscripcion('2024-2-28', 2, 2);
CALL InsertarInscripcion('2024-1-3', 3, 3);

SELECT * 
FROM Inscripcion i
LEFT JOIN Socio s ON i.idSocio = s.idSocio
LEFT JOIN Excursion ex ON i.idExcursion = ex.idExcursion;

-- Borrar registros para pruebas
DELETE FROM Federacion WHERE idFederacion <> 0;
DELETE FROM Socio WHERE idSocio <> 0;
DELETE FROM Estandar WHERE idEstandar <> 0;
DELETE FROM Federado WHERE idFederado <> 0;
DELETE FROM Infantil WHERE idInfantil <> 0;
DELETE FROM Excursion WHERE idExcursion <> 0;
DELETE FROM Inscripcion WHERE idInscripcion <> 0;

-- DROP DATABASE APPSenderosMontanas;


