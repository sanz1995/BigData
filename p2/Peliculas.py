
if __name__ == '__main__':

	file = open('IMDB/titulos.tsv','r');

	out = open('peliculasDB/peliculas.tsv','w');
	out2 = open('peliculasDB/peliculas_genero.tsv','w');
	out3 = open('peliculasDB/generos.tsv','w');

	genresList = [];

	for line in file:

		words = line.split("\t");
		
		if ("movie" in words[1]):
		
			out.write(words[0]+"	"+words[2]+"	"+words[7]+"	"+words[5]+"\n");
			out2.write("g"+words[0]+"\n");

			genres = words[8].split(",");
			for g in genres:
				g=g.replace(" ","");
				g=g.replace("\n","");
				if ((g != "") & (g != "\N")):
					out3.write("g"+words[0]+"	"+g+"\n");
				#	genresList.append(g);

	#for g in genresList:
	#	out2.write(g+"\n");

"""

if __name__ == '__main__':

	file = open('IMDB/titulos.tsv','r');

	out = open('peliculasDB/peliculas.tsv','w');
	out2 = open('peliculasDB/generos.tsv','w');

	genresList = [];

	for line in file:

		words = line.split("\t");
		
		if ("movie" in words[1]):
		
			out.write(words[0]+"	"+words[2]+"	"+words[7]+"	"+words[5]+"\n");

			genres = words[8].split(",");
			for g in genres:
				g=g.replace(" ","");
				g=g.replace("\n","");
				if ((g not in genresList) & (g != "\N")):
					genresList.append(g);

	for g in genresList:
		out2.write(g+"\n");

"""