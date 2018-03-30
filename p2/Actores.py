
if __name__ == '__main__':
    file = open('IMDB/nombres.tsv','r');

    out = open('peliculasDB/actores.tsv','w');

    for line in file:
    	words = line.split("\t");

    	if (("actress" in words[4]) | ("actor" in words[4])):
	    	id = words[0];

	    	nombre = words[1];
	    	fecha = words[2];

	    	out.write(id+"	"+fecha+"	"+nombre+"\n");
