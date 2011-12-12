
import java.io.IOException;

import javax.servlet.*;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Usuario;

import web.CarroWeb;
import web.Datos;
import web.Manejador;

/**
 * Clase Verificador que accesa a la base de datos
 * y verifica si el usuario existe.
 */
public class Verificador extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	private Connection conn;
	private ResultSet rs;
	private String usuario;
	private String password;
 	private Boolean valida;
 	private Manejador bd;
 	private PreparedStatement pst;
 	private HttpSession session;
 	private Datos datos;
 	private Usuario dummy;
 	private CarroWeb carro;
 
 	/**
 	 * Metodo init de la superclase HttpServlet para iniciar una conexion con la base de datos
 	 * @param config la configuracion del servlet del tipo Servletconfig
 	 * @see Servletconfig para ver la configuracion del servlet
 	 * @see Manejador para ver como se realiza la conexion
 	 * @throws ServletException en caso de error con el servlet
 	 * @return void
 	 */
	public void init(ServletConfig config) throws ServletException {
		bd = new Manejador();
		try{
		conn = bd.abreBD();
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		datos = new Datos();
	}

	/**
	 * Es llamado cuando el sevlet deja de estar en uso, cierra la conexion con la base de datos.
	 * Utiliza una llamada a el metodo destroy de la superclase HTTPSERVLET
	 * @return void
	 * @see HttpServlet para localizar el metodo destroy
	 */
	public void destroy() {
		super.destroy();
		System.out.println("Cerrando la conexion...");
		try{
			conn.close();
		}catch(SQLException ex){
			System.out.println("No se pudo cerrar la conexion!");
			System.out.println(ex.getMessage());
		}
	}

	/**
 	* Es llamado automaticamente cuando la pagina que lo llamo utilizo el metodo POST
 	* @param request la peticion generada al servidor
 	* @param response la respuesta que se generara por parte del servlet
 	* @throws ServletException en caso de no encontrar un error con el servlet
 	* @throws IOException en caso de encontrar un error en E/S
 	* @return void
 	*/
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.usuario = request.getParameter("usuario");
		carro = CarroWeb.getInstance();
		this.password = request.getParameter("password");
		if(validaDatos(response)){
			response.sendRedirect("./pages/Log/UsuarioDesconocido.html");	
		} else {
			session = creaNuevaSesion(request);
			dummy = datos.consigueDatosUsuario(usuario);
			carro.setUsuario(usuario);
			session.setAttribute("carro", carro);
			session.setAttribute("user", this.usuario);
			session.setAttribute("admin", dummy.getAdmin());
			response.sendRedirect("./fakeindex.jsp");
			
		}

	}

	public HttpSession creaNuevaSesion(HttpServletRequest req){
		HttpSession s = req.getSession(false);
		if(s != null){
			s.invalidate();	
		}
		return req.getSession(true);
	}
	
	/**
	 * Valida los datos para confirmar si estan en uso o no estan registrados en la base de datos
	 * @param resp la respuesta que se generara por parte del servlet
	 * @return true si el username esta libre o false si esta en uso
	 * @throws IOException en caso de encontrar un error en E/S
	 * @see HttpServletResponse 
	 */
	public Boolean validaDatos(HttpServletResponse resp) throws IOException{

		try{
			
			pst = conn.prepareStatement("SELECT user,AES_DECRYPT(password,?) FROM cuentas WHERE user=? AND password=AES_ENCRYPT(?,?)");
		    pst.setString(1, bd.getEncryp());
			pst.setString(2, usuario);
			pst.setString(3, password);
		    pst.setString(4, bd.getEncryp());

		    rs = pst.executeQuery();
		    
			valida = (!rs.next()) ? true : false;
			  
		}catch(SQLException exe){
			web.Error.despliegaError(resp,exe.getMessage());
		}
		return valida;
	}
	
		
	}
	
