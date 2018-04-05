package practica3;

import java.io.FileReader;
import java.sql.*;
import java.util.List;
import java.util.Properties;

import org.recommender101.data.DataModel;
import org.recommender101.data.DefaultDataLoader;
import org.recommender101.eval.impl.Recommender101Impl;
import org.recommender101.recommender.AbstractRecommender;
import org.recommender101.recommender.baseline.PopularityAndAverage;
import org.recommender101.tools.ClassInstantiator;

/**
 * Clase de prueba de conexión con una base de datos MySQL
 */
public class Main {
	
	static Connection conexion;

	public static void init(){
		
		// Se mete todo en un try por los posibles errores de MySQL
        try
        {
            // Se registra el Driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            
            // Se obtiene una conexión con la base de datos. Hay que
            // cambiar el usuario "root" y la clave "la_clave" por las
            // adecuadas a la base de datos que estemos usando.
            conexion = DriverManager.getConnection (
                "jdbc:mysql://localhost/peliculas","root", "Stephe20");
            
            
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
		
	}
	
	
	
	public static ResultSet select (String q) throws SQLException{
		

        // Se crea un Statement, para realizar la consulta
        Statement s = conexion.createStatement();
        
        return s.executeQuery (q);
       
		
	}
    
    /**
     * Método principal, instancia una clase PruebaMySQL
     *
     * @param args the command line arguments
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception 
    {
    	
    	
    	//Obtener todos los recomendadores
    	/**
    	
    	//Recommender101Impl rImp = new Recommender101Impl();
    	
    	
    	//List<AbstractRecommender> recs =rImp.loadRecommenders();
		
		*/
    	
    	
    	//Ejemplo de recomendación
    	
    	Recommender101Impl rImp = new Recommender101Impl();
    	PopularityAndAverage r = new PopularityAndAverage();
    	r.setDataModel(rImp.getDataModel());
		
		r.init();
		
		List<Integer> l = r.recommendItems(20);
		
		for (int i = 0;i<10;i++){
			if(l.size()>i){
				System.out.println(l.get(i));
				
			}
		}
		
		
		
		//Consulta a la base de datos de peliculas.
    	
    	/**
        init();
    	
    	ResultSet rs = select("select * from Pelicula;");
    	// Se recorre el ResultSet, mostrando por pantalla los resultados.
        while (rs.next())
        {
            System.out.println (rs.getString ("idPelicula") + " " + rs.getString (2)+ 
                " " + rs.getFloat(3));
        }
        
        // Se cierra la conexión con la base de datos.
        conexion.close();
        */
        
    }
    
}