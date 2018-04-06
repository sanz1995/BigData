package practica3;

import java.io.FileReader;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Scanner;

import org.recommender101.data.DataModel;
import org.recommender101.data.DefaultDataLoader;
import org.recommender101.eval.impl.Recommender101Impl;
import org.recommender101.eval.interfaces.EvaluationResult;
import org.recommender101.recommender.AbstractRecommender;
import org.recommender101.recommender.baseline.NearestNeighbors;
import org.recommender101.recommender.baseline.PopularityAndAverage;
import org.recommender101.recommender.baseline.Random;
import org.recommender101.recommender.extensions.contentbased.ContentBasedRecommender;
import org.recommender101.recommender.extensions.slopeone.SlopeOneRecommender;
import org.recommender101.recommender.extensions.weightedavg.WeightedAverageRecommender;
import org.recommender101.tools.ClassInstantiator;

/**
 * Clase de prueba de conexión con una base de datos MySQL
 */
public class Main {
	
	
	
	
	private static List<AbstractRecommender> list;
	
	private static Connection conexion;

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
                "jdbc:mysql://localhost/peliculas","root", "root");
            
            
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
	
	
	public static String getIdPelicula(int n){
		
		String s = String.valueOf(n);
		
		int num0s = 7 - s.length();
		
		
		for(int i = 0; i<num0s;i++){
			s = "0"+s;
		}
		return "tt"+s;
		
	}
    
    /**
     * Método principal, instancia una clase PruebaMySQL
     *
     * @param args the command line arguments
     * @throws Exception 
     */
    public static void main(String[] args) throws Exception 
    {
    	Scanner reader = new Scanner(System.in);
    	
    	
    	System.out.println("Introduce 0 para obtener metricas o 1 para obtener recomendación");
    	
    	int mode = reader.nextInt();
    	
    	if(mode==0){
    		Recommender101Impl r101 = new Recommender101Impl();
    		System.out.println("Realizando experimentos");
    		r101.runExperiments();
    		System.out.println("Mostrando resultados");
    		List<EvaluationResult> finalResult = r101.getLastResults();
    		System.out.println("hola");
    		r101.printSortedEvaluationResults(finalResult);
			
    	}else{
    		init();
        	
        	list = new ArrayList<AbstractRecommender>();
        	
        	
        	list.add(new PopularityAndAverage());
        	list.add(new NearestNeighbors());
        	list.add(new Random());
        	list.add(new ContentBasedRecommender());
        	list.add(new SlopeOneRecommender());
        	list.add(new WeightedAverageRecommender());
        	
        	
        	
        	//Ejemplo de recomendación
        	DataModel dm = new DataModel();
        	DefaultDataLoader ddl = new DefaultDataLoader();
        	
        	//ddl.setFilename("data/movielens/ratings.dat");
        	//ddl.setSeparatorString("::");
        	
        	ddl.loadData(dm);
        	
        	
        	System.out.println("Elige un algoritmo de recomendación");
        	System.out.println("0-PopularityAndAverage");
        	System.out.println("1-NearestNeighbors");
        	System.out.println("2-Random");
        	System.out.println("3-ContentBasedRecommender");
        	System.out.println("4-SlopeOneRecommender");
        	System.out.println("5-WeightedAverageRecommender");
        	
        	
        	AbstractRecommender r= list.get(reader.nextInt());
        	
        	
        	System.out.println("Introduce el id del usuario a recomendar");
        	int user = reader.nextInt();
        	
        	
        	r.setDataModel(dm);
    		r.init();
    		//r.getDataModel().algo();
    		List<Integer> l = r.recommendItems(user);
    		
    		System.out.println("Estas peliculas podrian interesar al usuario "+user);
    		
    		
    		
    		boolean seguir = true;
    		int i = 0;
    		
    		int p = 0;
    		
    		while(seguir && i<l.size()){
    			
    			String idPelicula = getIdPelicula(l.get(i));
    			
    			ResultSet rs = select("select * from Pelicula where idPelicula='"+idPelicula+"';");
    			
    			if(rs.next()){
    				System.out.println(rs.getString(2));
    				p++;
    				if(p>10){
    					seguir = false;
    				}
    			}
    			i++;
    				
    		}
    		conexion.close();
    	}
    	
    	
    	
    	
    }
    
    
    
}