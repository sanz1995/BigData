LOAD DATA LOCAL INFILE 'actores.tsv' INTO TABLE Actor;
LOAD DATA LOCAL INFILE 'peliculas_genero.tsv' INTO TABLE Pelicula_Genero;
LOAD DATA LOCAL INFILE 'generos.tsv' INTO TABLE Genero;
LOAD DATA LOCAL INFILE 'peliculas.tsv' INTO TABLE Pelicula;
LOAD DATA LOCAL INFILE 'reparto.tsv' INTO TABLE Reparto;
LOAD DATA LOCAL INFILE 'actuacion.tsv' INTO TABLE Actuacion;
LOAD DATA LOCAL INFILE 'valoraciones.tsv' INTO TABLE Valoracion;

SET FOREIGN_KEY_CHECKS=1;