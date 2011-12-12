package web;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
/**
 * Clase Error para cuando ocurra algo inesperado en los servlets
 * @author ever
 *
 */
public class Error {

	public static StringBuffer buffer;
	public static PrintWriter salida;
	
	/**
	 * Obtiene el tipo de error y despliega una pagina con el contenido del mismo
	 * @param resp
	 * @param ex
	 * @throws IOException
	 */
	public static HttpServletResponse despliegaError(HttpServletResponse resp,String ex) throws IOException{
	
	buffer = new StringBuffer();
  	buffer.append("<html>\n");
  	buffer.append("<head>\n");
  	buffer.append("<title>P&aacute;gina de Error</title>\n");
  	buffer.append("</head>\n");
  	buffer.append("<body>\n");
  	buffer.append("<h1>Lo sentimos aparecio una error inesperado</h1>");
  	buffer.append(ex);
  	buffer.append("<br/>");
  	buffer.append("<input type=\"button\" value=\"Volver\" onclick = \"location='./fakeindex.jsp'\" />");
  	buffer.append("</body>\n");
  	buffer.append("</html>");
  	
  	resp.setContentType("text/html");
  	resp.setContentLength(buffer.length());
  	salida = new PrintWriter(resp.getOutputStream());
  	salida.println(buffer.toString());
  	salida.close();
  	
  	return resp;
	}
}
