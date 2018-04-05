
links = open ("links.csv")
coma = ','
dic = {}
ropen = open("ratings.csv")
out = open("valoraciones.csv",'w')
out2 = open("usuarios.csv",'w')
usulist = []

for l in links:
    #print(l)
    lpart = l.split(',')
    #{idmovielens: idimdb}
    dic[lpart[0]] = lpart[1]
    #print(len(dic))
no = 0
cont = 0
print("Escribir")
for i in ropen:
    cont = cont +1
    if (cont % 10000 == 0):
        print(cont)
    if no ==0:
        no = 1
    else:
        #print(i)

        words = i.split(',')
        key = words[1]
        if key in dic:
            #userId, imdbmovieID, rating
            out.write(words[0]+'	'+'tt'+dic[key]+'	'+'rtt'+dic[key]+'	'+'gtt'+dic[key]+'	'+words[2]+'\n')
            #print(dic[key])

cont = 1
print("Usuarios")
while cont < 270897:
    out2.write(str(cont)+'\n')
    cont = cont +1

out.close()
out2.close()
