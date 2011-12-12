package beans;

/**
 * Clase Articulo que describe los metodos y atributos de un Objeto Libro
 * 
 */
public class Articulo {

	protected String nombre;
	private String autor;
	protected float  precio;
	protected String estado;
	
	/**
	 * Metodo getNombre para conseguir el atributo nombre
	 * @return String
	 */
	public String getNombre() {
		if(nombre == null){
			nombre = "Sin nombre especificado";
			return nombre;	
		}else{
			return nombre;
		}
	}
	
	/**
	 * Metodo setNombre para establecer el atributo nombre
	 * @param  nombre
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	/**
	 * Metodo getNombre para conseguir el atributo nombre
	 * @return String
	 */
	public String getAutor() {
		if(autor == null){
			autor = "Sin autor especificado";
			return autor;	
		}else{
			return autor;
		}
	}
	/**
	 * Metodo setAutor para establecer el atributo autor
	 * @param  autor
	 */
	public void setAutor(String autor) {
		this.autor = autor;
	}
	/**
	 * Metodo getEstado para conseguir el atributo estado
	 * @return String
	 */
	public String getEstado() {
		if(estado == null ){
			estado = "regular";
			return estado;	
		}else{
			return estado;
		}
	}
	
	/**
	 * Metodo setEstado para establecer el atributo Estado
	 * @param  estado
	 */
	public void setEstado(String estado) {
		if(estado == "bueno"){
			this.estado = estado;
		}else if(estado == "malo"){
			this.estado = estado;
		}else if(estado == "regular"){
			this.estado = estado;
		}
	}
	
	/**
	 * Metodo getPrecio para conseguir el atributo precio
	 * @return float
	 */
	public float getPrecio() {
		return precio;
	}
	/**
	 * Metodo setNombre para establecer el atributo nombre
	 * @param  precio
	 */
	public void setPrecio(float precio) {
		this.precio = precio;
	}
	/**
	 * Metodo que llena el objeto con datos de un objeto que recibe
	 * @param   obj
	 * @return String
	 */
	public Articulo llenaDatos(Object obj)  {

		if(obj instanceof Articulo){
			Articulo UserObject = (Articulo)obj;
				
				setNombre(UserObject.getNombre());
				setAutor(UserObject.getAutor());
				setPrecio(UserObject.getPrecio());
				setEstado(UserObject.getEstado());

			
				return UserObject;
		
		}else{

			return this;
		}
	}
}
