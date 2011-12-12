

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.PreparedStatement;
import java.sql.Connection;



import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.Usuario;

import web.Manejador;


/*
 * Clase Registro que ingresa un nuevo usuario a la base de datos
 */
public class Registro extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private Usuario dummy;
 	private Connection conn;
 	private PreparedStatement pst,pst2;
 	private Manejador bd;
 	private HttpSession session;


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
		conn = bd.abreBD();
		dummy = new Usuario();
	}
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	doPost(request,response);
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
		session = request.getSession();
		try{ 
		dummy = (Usuario)dummy.llenaDatos(session.getAttribute("bean"));
		}catch(NumberFormatException e){
			web.Error.despliegaError(response,"La edad o el credito que ingresaste no son validos");
		}finally{
		agregarUsuario(response);
		session.removeAttribute("nuevousuario");
		session.removeAttribute("bean");
		session.setAttribute("nuevousuario",dummy.getUser());
		response.sendRedirect("./pages/Registro/RegistroExitoso.html");
		}
	}
	
	/**
	 * Se agregan los datos a la base de datos 
	 * @param resp la respuesta que se generara por parte del servlet
	 * @return void
	 * @throws IOException en caso de encontrar un error en E/S
	 * @see HttpServletResponse 
	 */
	public void agregarUsuario(HttpServletResponse resp) throws IOException{
		
		try{
			  
		    pst = conn.prepareStatement("INSERT INTO usuarios VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?)");
				    pst.setString(1, dummy.getNombre());
				    pst.setString(2, dummy.getApellidoPaterno());
				    pst.setString(3, dummy.getApellidoMaterno());
				    pst.setInt(4, dummy.getEdad());
				    pst.setString(5, dummy.getCorreo());
				    pst.setString(6, dummy.getUser());
				    pst.setString(7, dummy.getTelefono());
				    pst.setString(8, dummy.getCalle());
				    pst.setString(9, dummy.getColonia());
				    pst.setString(10, dummy.getCp());
				    pst.setString(11, dummy.getNumero());
				    pst.setFloat(12, dummy.getCredito());
				    pst.setBoolean(13, dummy.getAdmin());
				    
		 
		  pst.execute();
		  
	  	pst2 = conn.prepareStatement("INSERT INTO cuentas VALUES(?,AES_ENCRYPT(?,?))");
		 			pst2.setString(1, dummy.getUser());
		  			pst2.setString(2, dummy.getPassword());
		  			pst2.setString(3, bd.getEncryp());
        pst2.execute();
        
		}
		catch(Exception e)
		{
		   StringBuffer buffer = new StringBuffer();
		  	buffer.append("<html>\n");
		  	buffer.append("<head>\n");
		  	buffer.append("<title>P&aacute;gina de Error</title>\n");
		  	buffer.append("</head>\n");
		  	buffer.append("<body>\n");
		  	buffer.append("<h1>Lo sentimos aparecio una exepcion<h1>");
		  	buffer.append("Errores: "+e.getMessage()+"\n");
		  	buffer.append("</body>\n");
		  	buffer.append("</html>");
		  	
		  	resp.setContentType("text/html");
		  	resp.setContentLength(buffer.length());
		  	PrintWriter salida = new PrintWriter(resp.getOutputStream());
		  	salida.println(buffer.toString());
		  	salida.close();
	
		}
	}
}