CREATE DATABASE peliculas;

use peliculas;

CREATE TABLE Pelicula
(
	idPelicula		VARCHAR(25),
	nombre			VARCHAR(100),
	Duracion			FLOAT,
	Anio			INTEGER,
	PRIMARY KEY(idPelicula));


CREATE TABLE Actor
(
	id			VARCHAR(25),
	AñoNac			INTEGER,
	Nombre			VARCHAR(100),
	PRIMARY KEY(id));


CREATE TABLE Pelicula_Genero
(
	idGeneros			VARCHAR(25),
	PRIMARY KEY(idGeneros));

CREATE TABLE Genero
(
	idGeneros			VARCHAR(25),
	genero				VARCHAR(25),
	PRIMARY KEY(idGeneros,genero),
	FOREIGN KEY(idGeneros) REFERENCES Pelicula_Genero (idGeneros));


CREATE TABLE Reparto
(
	idReparto			VARCHAR(25),
	PRIMARY KEY(idReparto));


CREATE TABLE Valoracion
(
	idPelicula			VARCHAR(25),
	idReparto			VARCHAR(25)		NOT NULL,
	idGeneros			VARCHAR(25),
	ValoracionMedia			FLOAT		NOT NULL,
	NumVotos			INTEGER		NOT NULL,
	PRIMARY KEY(idPelicula),
	FOREIGN KEY(idPelicula) REFERENCES Pelicula (idPelicula),
	FOREIGN KEY(idReparto) REFERENCES Reparto (idReparto),
	FOREIGN KEY(idGeneros) REFERENCES Pelicula_Genero (idGeneros));
	#FOREIGN KEY(idActor) REFERENCES Actor (id));;;

CREATE TABLE Actuacion
(
	idReparto			VARCHAR(25),
	idActor			VARCHAR(25),
	PRIMARY KEY(idReparto,idActor),
	FOREIGN KEY(idReparto) REFERENCES Reparto (idReparto),
	FOREIGN KEY(idActor) REFERENCES Actor (id));


SET FOREIGN_KEY_CHECKS=0;

	




	#FOREIGN KEY(idReparto) REFERENCES Reparto (idReparto),
	#FOREIGN KEY(idActor) REFERENCES Actor (id));