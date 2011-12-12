package web;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import beans.Usuario;
import beans.Articulo;
import beans.ArticuloGadget;

/**
 * Clase Datos para el mejor manejo de ellos.
 * @author ever
 *
 */
public class Datos {
	
	private Connection conn;
	private ResultSet rs2;
	private Manejador bd;
	private Usuario dummy;
	private PreparedStatement pst2;
	private Articulo item;
	private ArticuloGadget gadget;

	/**
	 * Constructor de la clase
	 */
	public Datos(){
		
		dummy = new Usuario();
		bd = new Manejador();
		conn = bd.abreBD();
	}
	
	/**
	 * Consigue los datos del usuario usando el parametro
	 * @param usuario
	 * @return
	 */
	public Usuario consigueDatosUsuario(String usuario) {
		
		try{

		pst2 = conn.prepareStatement("SELECT * FROM usuarios WHERE usuario=?");
		pst2.setString(1, usuario);
	    
		rs2 = pst2.executeQuery();
		System.out.println("hize el query");
		  if(rs2.next()){
			
			  dummy.setNombre(rs2.getString(1));
			  dummy.setApellidoPaterno(rs2.getString(2));
			  dummy.setApellidoMaterno(rs2.getString(3));
			  dummy.setEdad(rs2.getInt(4));
			  dummy.setCorreo(rs2.getString(5));
			  dummy.setUser(rs2.getString(6));
			  dummy.setTelefono(rs2.getString(7));
			  dummy.setCalle(rs2.getString(8));
			  dummy.setColonia(rs2.getString(9));
			  dummy.setCp(rs2.getString(10));
			  dummy.setNumero(rs2.getString(11));
			  dummy.setCredito(rs2.getFloat(12));
			  dummy.setAdmin(rs2.getBoolean(13));
		  }
		}catch(SQLException l){
			System.out.println(l.getMessage());
		}
		return dummy;
	}
	
	/**
	 * consigue los datos del articulo usando su nombre 
	 * @param nombre
	 * @return
	 */
	public Articulo consigueDatosArticulo(String nombre) {
				
		try{
		pst2 = conn.prepareStatement("SELECT * FROM libros WHERE nombre=?");
		pst2.setString(1, nombre);
		rs2 = pst2.executeQuery();
		  if(rs2.next()){
			  item.setNombre(rs2.getString(1));
			  item.setAutor(rs2.getString(2));
			  item.setPrecio(rs2.getFloat(3));
			  item.setEstado(rs2.getString(4));
		  }
		}catch(SQLException l){
			System.out.println(l.getMessage());
		}
		return item;
	}
	
	/**
	 * consigue los datos del gadget usando su nombre
	 * @param nombre
	 * @return
	 */
	public ArticuloGadget consigueDatosGadget(String nombre) {
		
		try{
		pst2 = conn.prepareStatement("SELECT * FROM gadgets WHERE nombre=?");
		pst2.setString(1, nombre);
		rs2 = pst2.executeQuery();
		  if(rs2.next()){
			  gadget.setNombre(rs2.getString(1));
			  gadget.setPrecio(rs2.getFloat(2));
			  gadget.setEstado(rs2.getString(3));
			  gadget.setComentario(rs2.getString(4));
		  }
		}catch(SQLException l){
			System.out.println(l.getMessage());
		}
		return gadget;
	}
	
	/**
	 * Consigue todos los articulos que estan en existencia
	 * @return
	 */
	public List<Articulo> consigueArticulos() {
			List<Articulo> listado = new ArrayList<Articulo>();
			try{
				pst2 = conn.prepareStatement("SELECT * FROM libros");
				rs2 = pst2.executeQuery();
			while(rs2.next()){
			  item = new Articulo();
			  item.setNombre(rs2.getString(1));
			  item.setAutor(rs2.getString(2));
			  item.setPrecio(rs2.getFloat(3));
			  item.setEstado(rs2.getString(4));
			  listado.add(item);  
		  }
		}catch(SQLException l){
			System.out.println(l.getMessage());
		}
			return listado;
			
		}
	
	/**
	 * Consigue todos los gadgets que hay en existencia
	 * @return
	 */
	public List<ArticuloGadget> consigueGadgets(){
			
			List<ArticuloGadget> listado = new ArrayList<ArticuloGadget>();
			try{
				pst2 = conn.prepareStatement("SELECT * FROM gadgets");
				rs2 = pst2.executeQuery();
			while(rs2.next()){
			  gadget = new ArticuloGadget();
			  gadget.setNombre(rs2.getString(1));
			  gadget.setPrecio(rs2.getFloat(2));
			  gadget.setEstado(rs2.getString(3));
			  gadget.setComentario(rs2.getString(4));
			  listado.add(gadget);  
		  }
		}catch(SQLException l){
			System.out.println(l.getMessage());
		}
			return listado;
	}	

	
}
