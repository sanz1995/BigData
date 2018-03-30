select a.nombre, AVG(v.ValoracionMedia) 
from Actuacion act, Valoracion v, Actor a
where act.idReparto=v.idReparto AND act.idActor = a.id
group by a.id 
order by AVG(v.ValoracionMedia) 
desc limit 20;



	select a.nombre, AVG(v.ValoracionMedia) from Actor a INNER JOIN Actuacion act ON a.id=act.idActor INNER JOIN Reparto r ON r.idReparto=act.idReparto INNER JOIN Valoracion v ON v.idReparto=r.idReparto
	group by a.id 
	order by AVG(v.ValoracionMedia) 
	desc limit 20;






select p.nombre, v.ValoracionMedia, v.NumVotos  
from Pelicula p, Valoracion v
where p.idPelicula=v.idPelicula
order by v.NumVotos desc
limit 20;

select p.nombre, v.ValoracionMedia, v.NumVotos  
from Pelicula p INNER JOIN Valoracion v on p.idPelicula=v.idPelicula
order by v.NumVotos desc
limit 20;





select g.genero, AVG(v.ValoracionMedia) 
from Valoracion v INNER JOIN Pelicula_Genero pg on v.idGeneros=pg.idGeneros INNER JOIN Genero g on pg.idGeneros=g.idGeneros
group by g.genero
order by AVG(v.ValoracionMedia) desc;




#En los años 90
select g.genero,count(*) 
from Pelicula p INNER JOIN Valoracion v ON p.idPelicula=v.idPelicula INNER JOIN Pelicula_Genero pg on v.idGeneros=pg.idGeneros INNER JOIN Genero g on pg.idGeneros=g.idGeneros
where p.Anio>1989 AND p.Anio<2000
group by g.genero
order by count(*) desc;






