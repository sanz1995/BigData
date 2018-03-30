CREATE DATABASE peliculas;

use peliculas;


CREATE TABLE Pelicula
(
	nombre			VARCHAR(250),
	Duracion			FLOAT		NOT NULL,
	Anio			INTEGER		NOT NULL,
	FechaEstreno			DATE		NOT NULL,
	PRIMARY KEY(nombre));


CREATE TABLE Actor
(
	dni			VARCHAR(250),
	FechaNac			DATE		NOT NULL,
	Nombre			VARCHAR(250),
	PRIMARY KEY(dni));


CREATE TABLE EmpresaProduccion
(
	nombre			VARCHAR(250),
	PRIMARY KEY(nombre));


CREATE TABLE Usuario
(
	dni			VARCHAR(250),
	Nombre			VARCHAR(250)		NOT NULL		UNIQUE,
	PRIMARY KEY(dni));


CREATE TABLE Genero
(
	nombre			VARCHAR(250),
	PRIMARY KEY(nombre));


CREATE TABLE Reparto
(
	idReparto			INTEGER,
	PRIMARY KEY(idReparto));


CREATE TABLE Valoracion
(
	idPelicula			VARCHAR(250),
	idUsuario			VARCHAR(250),
	idReparto			INTEGER		NOT NULL,
	idGenero			VARCHAR(250)		NOT NULL,
	idEmpresa			VARCHAR(250)		NOT NULL,
	Valoracion			FLOAT		NOT NULL,
	Fecha			DATE		NOT NULL,
	PRIMARY KEY(idPelicula, idUsuario),
	FOREIGN KEY(idPelicula) REFERENCES Pelicula (nombre),
	FOREIGN KEY(idUsuario) REFERENCES Usuario (dni),
	FOREIGN KEY(idReparto) REFERENCES Reparto (idReparto),
	FOREIGN KEY(idGenero) REFERENCES Genero (nombre),
	FOREIGN KEY(idEmpresa) REFERENCES EmpresaProduccion (nombre));

CREATE TABLE Actuacion
(
	idReparto			INTEGER,
	idActor			VARCHAR(250),
	PRIMARY KEY(idReparto, idActor),
	FOREIGN KEY(idReparto) REFERENCES Reparto (idReparto),
	FOREIGN KEY(idActor) REFERENCES Actor (dni));

