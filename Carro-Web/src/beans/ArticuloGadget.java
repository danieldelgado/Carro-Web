package beans;

/**
 * Clase ArticuloGadget que describe los metodos y atributos de un Objeto Gadget
 */
public class ArticuloGadget extends Articulo {

	private String comentario;
	
	/**
	 * Metodo getComentario para conseguir el atributo comentario
	 * @return String 
	 */
	public String getComentario() {
		if(comentario == null){
			this.comentario = "sin comentarios";
			return this.comentario;
		}else {
			return comentario;
		}
	}
	
	/**
	 * Metodo setComentario para establecer el atributo comentario
	 * @param  comentario
	 */
	public void setComentario(String comentario) {
		this.comentario = comentario;
	}
	
	
}
