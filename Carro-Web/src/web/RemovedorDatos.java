package web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import beans.ArticuloGadget;
import beans.Articulo;

/**
 * Clase removedor de datos para el manejor de la base da datos y su eliminacion de datos
 * @author ever
 *
 */
public class RemovedorDatos {

	private Connection conn;
	private PreparedStatement pst;
	private Manejador bd;
	
	/**
	 * constructor de la clase
	 */
	public RemovedorDatos(){
		bd = new Manejador();
		conn = bd.abreBD();
	}
	
	/**
	 * remueve un gadget de la base de datos
	 * @param gadget
	 */
	public void RemueveGadget(ArticuloGadget gadget){
		try {
			pst = conn.prepareStatement("DELETE FROM gadgets where nombre=?");
			pst.setString(1, gadget.getNombre());
			pst.executeUpdate();
			System.out.println("borre el "+gadget.getNombre());
		} catch (SQLException e) {
			System.out.println("No puedo borrar eso.");
			e.printStackTrace();
		}
	}
	
	/**
	 * remueve un libro de la base de datos
	 * @param libro
	 */
	public void RemueveLibro(Articulo libro){
		try {
			pst = conn.prepareStatement("DELETE FROM libros where nombre=?");
			pst.setString(1, libro.getNombre());
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("No puedo borrar eso.");
			e.printStackTrace();
		}
	}
	/**
	 * resta el credito del usuario a partir de la cantidad que se le pase como parametro
	 * @param cantidad
	 * @param usuario
	 */
	public void RestaCredito(float cantidad, String usuario){
		try {
			pst = conn.prepareStatement("UPDATE usuarios set credito=? where usuario=?");
			pst.setFloat(1, cantidad);
			pst.setString(2, usuario);
			pst.executeUpdate();
		} catch (SQLException e) {
			System.out.println("No puedo borrar eso.");
			e.printStackTrace();
		}		
	}
	
}

