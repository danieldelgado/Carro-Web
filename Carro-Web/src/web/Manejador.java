package web;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase manejador para abrir la base de datos
 * @author ever
 *
 */
public class Manejador {

	
	private String bdDriver, dataSource;
	private String bdName, user, pass;
	private Connection conn;
	private String encryp;

	/**
	 * Constructor de la clase
	 */
	public Manejador(){
		dataSource="//localhost/web"; 
		bdName="jdbc:mysql:" + dataSource;
		bdDriver="com.mysql.jdbc.Driver";
		user="";
		pass=""; 
		encryp = "";
	}
	
	/**
	 * Metodo para abrir la conexion con la base de datos
	 * @return Connection la conexion con la bd
	 */
	public Connection abreBD() {
		
		try{
			  
			  Class.forName(bdDriver);
		} catch(ClassNotFoundException ex){
			System.out.println("Error al cargar el driver");
			System.out.println(ex.getMessage());
		}
		
		try{
			conn = DriverManager.getConnection(bdName,user,pass);
			
		}catch(SQLException sql){
			System.out.println("Error al establecer la conexion con la BD");
			System.out.println(sql.getMessage());
		
		}
		return conn;
	}
	
	/**
	 * para obtener la clave de encriptacion
	 * @return
	 */
	public String getEncryp(){
		return encryp;
	}

	/**
	 * cierra la conexion con la bd
	 * @param conn
	 */
	public void Cierra(Connection conn){
		try{
			conn.close();
		}catch(SQLException sqex){
			System.out.println("No se pudo cerrar la conexion con la base de datos!");
			System.out.println(sqex.getMessage());
		}
	}
	
}
	
