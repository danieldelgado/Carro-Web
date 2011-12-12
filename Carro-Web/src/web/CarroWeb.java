package web;


import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;
import beans.Articulo;
import beans.ArticuloGadget;
import beans.Usuario;

/**
 * Clase CarroWeb que manipula los objetos que se compraran
 * @author ever
 *
 */
public class CarroWeb {

	
	private static CarroWeb cw = new CarroWeb();
	private List<Articulo> listadoLibros;
	private Iterator<Articulo> iteraArticulo;
	private List<ArticuloGadget> listadoGadgets;
	private Iterator<ArticuloGadget> iteraGadget;
	float total;
	private Float nuevaCantidad,viejaCantidad;
	private Boolean resultado;
	private RemovedorDatos rm;
	private String usuario;

	public static CarroWeb getInstance(){
		if(cw == null){
			cw = new CarroWeb();
		}
		return cw;
	}
	/**
	 * Constructor privado para uso del singleton
	 */
	private CarroWeb(){
		listadoLibros = new ArrayList<Articulo>();
		listadoGadgets = new ArrayList<ArticuloGadget>();
		total = 0;
	}
	
	
	/**
	 * 
	 * @return List<Articulo> listado de libros del carro
	 */
	public List<Articulo> getListadoLibros() {
		return listadoLibros;
	}
	/**
	 * @return List<ArticuloGadgets> listado de gadgets del carro
	 */
	public List<ArticuloGadget> getListadoGadgets() {
		return listadoGadgets;
	}

	/**
	 * agrega un usuario al carro 
	 * @param usuario
	 */
	public void setUsuario(String usuario){
		this.usuario = usuario;
	}
	/**
	 * agrega un libro al carro
	 * @param libro
	 */
	public void Agrega(Articulo libro){
		Boolean noExiste = true;
		if(!listadoLibros.isEmpty()){
			for(iteraArticulo = listadoLibros.iterator(); iteraArticulo.hasNext();){
				Articulo item = iteraArticulo.next();
				if(item.getNombre().contentEquals(libro.getNombre())){
					noExiste = false; 
				}
			}
		}
		if(noExiste){
			listadoLibros.add(libro);
		}
	}
	/**
	 * agrega un gadget al carro
	 * @param gadget
	 */
	public void Agrega(ArticuloGadget gadget){
		Boolean noExiste = true;
		if(!listadoGadgets.isEmpty()){
			for(iteraGadget = listadoGadgets.iterator(); iteraGadget.hasNext();){
				Articulo item = iteraGadget.next();
				if(item.getNombre().contentEquals(gadget.getNombre())){
					noExiste = false; 
				}
			}
		}
		if(noExiste){
			listadoGadgets.add(gadget);
		}
	}

	
	/**
	 * remueve un libro del carro
	 * @param libro
	 */
	public void Remueve(Articulo libro){
		Boolean Existe = false;
		int index = 0;
		int borrar = 0;
		if(!listadoLibros.isEmpty()){
			for(iteraArticulo = listadoLibros.iterator(); iteraArticulo.hasNext();){
				Articulo item = iteraArticulo.next();
				index++;
				if(item.getNombre().contentEquals(libro.getNombre())){
					Existe = true;
					borrar = index-1; 
				}
			}
		}
		if(Existe){
			listadoLibros.remove(borrar);
		}
	}
	/**
	 * remueve un gadget del carro
	 * @param gadget
	 */
	public void Remueve(ArticuloGadget gadget){
		Boolean Existe = false;
		int index = 0;
		int borrar = 0;
		if(!listadoGadgets.isEmpty()){
			for(iteraGadget = listadoGadgets.iterator(); iteraGadget.hasNext();){
				ArticuloGadget item = iteraGadget.next();
				index++;
				if(item.getNombre().contentEquals(gadget.getNombre())){
					Existe = true;
					borrar = index-1; 
				}
			}
		}
		if(Existe){
			listadoGadgets.remove(borrar);
		}
	}
	
	/**
	 * remueve todos los articulos del carro
	 */
	public void RemueveTodo(){
			listadoGadgets.clear();
			listadoLibros.clear();
	}
	
	/**
	 * Obtiene el costo total de los articulos del carro
	 * @return total la suma de los precios de los articulos
	 */
	public float getTotal(){
		total = calcularTotal();
		return total;
	}
	public float calcularTotal(){
		ArticuloGadget gadget = null;
		Articulo libro = null;
		float t = 0;
		
		if(!listadoGadgets.isEmpty()){
			for(iteraGadget = listadoGadgets.iterator(); iteraGadget.hasNext();){
				gadget = iteraGadget.next();
				t += gadget.getPrecio();
			}
		}
		
		if(!listadoLibros.isEmpty()){
			for(iteraArticulo = listadoLibros.iterator(); iteraArticulo.hasNext();){
				libro = iteraArticulo.next();
				t += libro.getPrecio();
			}
		}	
	  return t;
	}
	/**
	 * Completa la compra de los articulos del carro
	 * @param credito
	 * @return
	 */
	public Boolean CompletaCompra(){
		total = getTotal();
		System.out.println("Consigo el total.. es "+total);
		viejaCantidad = creditoUsuario();
		System.out.println("Consigo la cantidad del usuario que es  "+viejaCantidad);
		
		if(total >= viejaCantidad){
			System.out.println("no alcanza");
			resultado = false;
		}else{
			rm = new RemovedorDatos();
			System.out.println("creo remover de datos");
			nuevaCantidad = ( viejaCantidad - total );
			System.out.println("hago la resta y quedan: "+nuevaCantidad);
			rm.RestaCredito(nuevaCantidad, usuario);
			System.out.println("modifico la cantidad del usuario");
			/**/
			if(!listadoGadgets.isEmpty()){
				for(iteraGadget = listadoGadgets.iterator(); iteraGadget.hasNext();){
					ArticuloGadget item = iteraGadget.next();
						rm.RemueveGadget(item);
						System.out.println("quito de la base de datos "+item.getNombre());
				}
			}
			/**/
			 
			if(!listadoLibros.isEmpty()){
				for(iteraArticulo = listadoLibros.iterator(); iteraArticulo.hasNext();){
					Articulo item = iteraArticulo.next();
						rm.RemueveLibro(item);
						System.out.println("Quito de la bd "+item.getNombre());
					}
			}
			System.out.println("salgo en true");
			RemueveTodo();
			resultado = true;
		}
	return resultado;
	}

	public float creditoUsuario(){
		Datos datosUsuario = new Datos();
		Usuario user = new Usuario();
		 user = datosUsuario.consigueDatosUsuario(usuario);
		return user.getCredito();
	}
}

