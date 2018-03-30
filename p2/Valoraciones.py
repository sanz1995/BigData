

if __name__ == '__main__':

	peliculas = open('IMDB/titulos.tsv','r');
	valoraciones = open('IMDB/valoraciones.tsv','r');


	out = open('peliculasDB/valoraciones.tsv','w');
	#out2 = open('peliculasDB/genero_pelicula.tsv','w');

	#Saltar descripcion
	valoraciones.readline();
	peliculas.readline();

	line = valoraciones.readline()
	v = line.split("\t");

	for line in peliculas:

		pelicula = line.split("\t");

		if(pelicula[1]=="movie"):
			#Saltar valoraciones de series
			while((v[0] < pelicula[0]) & (len(line)!=0)):
				line = valoraciones.readline()
				v = line.split("\t");


			#encontrado
			if(v[0] == pelicula[0]):
				out.write(pelicula[0]+"	"+"r"+pelicula[0]+"	"+"g"+pelicula[0]+"	"+v[1]+"	"+v[2].replace("\n","")+"\n");
				
"""

				generos = pelicula[8].split(",");


				for g in generos:
					g = g.replace("\n","");
					if (g != "") & (g != "\N"):
						out2.write("g"+pelicula[0]+"\n");

"""



