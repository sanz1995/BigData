

if __name__ == '__main__':


	peliculas = open('IMDB/titulos.tsv','r');
	reparto = open('IMDB/reparto.tsv','r');

	out = open('peliculasDB/reparto.tsv','w');
	out2 = open('peliculasDB/actuacion.tsv','w');

	castList = [];


	i = 0;




	reparto.readline();
	peliculas.readline();



	line = reparto.readline()
	r = line.split("\t");


	j = 0;

	for p in peliculas:

		pelicula = p.split("\t");

		j=j+1;

		if(j%10000==0):
			print(j);



		if(pelicula[1]=="movie"):

			while((r[0] < pelicula[0]) & (len(line)!=0)):
						line = reparto.readline();
						r = line.split("\t");




			while((r[0] == pelicula[0]) & (len(line)!=0)):

				castList.append(r[0]);

				if (("actress" in r[3]) | ("actor" in r[3])):
					out2.write("r"+r[0]+"	"+r[2]+"\n");
					i=i+1;

				line = reparto.readline();
				r = line.split("\t");





	for u in sorted(set(castList)):
		out.write("r"+u+"\n");


