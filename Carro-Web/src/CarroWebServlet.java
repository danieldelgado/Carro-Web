

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Articulo;
import beans.ArticuloGadget;

import web.CarroWeb;
import web.Manejador;

/**
 * Maneja el carro web para agregarle o quitarle articulos
 */
public class CarroWebServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private CarroWeb carroActual;
	private HttpSession session;
	private Articulo libro;
	private ArticuloGadget gadget;
	private String tipoGadget,tipoLibro;
	private String remover,removerTodo,agregar,completar;
	
	/**
 	 * Metodo init de la superclase HttpServlet
 	 * @param config la configuracion del servlet del tipo Servletconfig
 	 * @see Servletconfig para ver la configuracion del servlet
 	 * @see Manejador para ver como se realiza la conexion
 	 * @throws ServletException en caso de error con el servlet
 	 * @return void
 	 */
	public void init(ServletConfig config) throws ServletException {
		tipoGadget = "gadget";
		tipoLibro = "libro";
		agregar ="agregar";
		remover = "remover";
		removerTodo ="removerTodo";
		completar ="completar";
	}
 

	/**
	 * Es un metodo heredado de HttpServlet
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request,response);
	}

	/**
	 * Es un metodo heredado de HttpServlet
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session = request.getSession();
		carroActual = (CarroWeb) session.getAttribute("carro");
		carroActual.setUsuario(session.getAttribute("user").toString());
		
		if(request.getParameter("accion").equals(remover)){
			removerItem(request,response);
		}else if(request.getParameter("accion").equals(agregar)){
			agregarItem(request,response);
		}else if(request.getParameter("accion").equals(removerTodo)){
		    removerTodo(request,response);
		}else if(request.getParameter("accion").equals(completar)){
			completar(request,response);
		}
	}

	public void removerTodo(HttpServletRequest request,HttpServletResponse response) throws IOException{
		carroActual.RemueveTodo();
	    session.setAttribute("carro",carroActual);
	    response.sendRedirect("./pages/Carro/CarroWeb.jsp");
		
	}
	
	public void completar(HttpServletRequest request,HttpServletResponse response) throws IOException{
		System.out.println("entre a completar metodo");
		if(carroActual.CompletaCompra()){
			Boolean bool = true;
			session.setAttribute("buy", bool);
		}
		session.setAttribute("carro",carroActual);
	    response.sendRedirect("./pages/Carro/CarroWeb.jsp");
		
	}
	/*
	 * Metodo que remueve un item del carro de compras
	 * @param request la peticion generada al servidor
 	* @param response la respuesta que se generara por parte del servlet
 	* @throws IOException en caso de encontrar un error en E/S
	 * @return void
	 */
	public void removerItem(HttpServletRequest request,HttpServletResponse response) throws IOException{
		if(request.getParameter("tipo").equals(tipoGadget)){
			carroActual.Remueve(Gadget(request));
			session.setAttribute("carro",carroActual);
			response.sendRedirect("./pages/Carro/CarroWeb.jsp");
			
		}else if(request.getParameter("tipo").equals(tipoLibro)){
			carroActual.Remueve(Libro(request));
			session.setAttribute("carro",carroActual);
			response.sendRedirect("./pages/Carro/CarroWeb.jsp");
		}
	}
	/*
	 * Metodo que agrega un item al carro de compras
	 * @param request la peticion generada al servidor
 	* @param response la respuesta que se generara por parte del servlet
 	* @throws IOException en caso de encontrar un error en E/S
	 * @return void
	 */
	public void agregarItem(HttpServletRequest request,HttpServletResponse response) throws IOException{
		if(request.getParameter("tipo").equals(tipoGadget)){
			carroActual.Agrega(Gadget(request));
			session.setAttribute("carro",carroActual);
			response.sendRedirect("./pages/Articulos/Gadgets.jsp");
			
		}else if(request.getParameter("tipo").equals(tipoLibro)){
			
			carroActual.Agrega(Libro(request));
			session.setAttribute("carro",carroActual);
			response.sendRedirect("./pages/Articulos/Libros.jsp");
		}
	}
	/*
	 * Metodo que obtiene los datos del Gadget.
	 * @param request la peticion generada al servidor
	 * @return ArticuloGadget
	 */
	public ArticuloGadget Gadget(HttpServletRequest request){
		gadget = new ArticuloGadget();
		gadget.setNombre(request.getParameter("nombre"));
		gadget.setPrecio(Float.parseFloat(request.getParameter("precio")));
		gadget.setEstado(request.getParameter("estado"));
		gadget.setComentario(request.getParameter("comentario"));
		return gadget;
		
	}
	/*
	 * Metodo que obtiene los datos del Articulo Libro.
	 * @param request la peticion generada al servidor
	 * @return Articulo
	 */
	public Articulo Libro(HttpServletRequest request){
		libro = new Articulo();
		libro.setNombre(request.getParameter("nombre"));
		libro.setAutor(request.getParameter("autor"));
		libro.setPrecio(Float.parseFloat(request.getParameter("precio")));
		libro.setEstado(request.getParameter("estado"));
		return libro;
		
	}
}
