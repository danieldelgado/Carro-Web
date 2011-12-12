package beans;

/**
 * Clase  que contiene la estructura de los usuarios
 */
public class Usuario {

	private String user;
 	private String password;
	private String nombre;
 	private String apellidoMaterno;
 	private String apellidoPaterno;
 	private int edad;
 	private String correo;
 	private String telefono;
 	private String calle;
 	private String colonia;
 	private String cp;
 	private String numero;
 	private float credito;
 	private Boolean admin;
 	


	/**
	 * @return user
	 */
	public String getUser() {
		if(user == null){
			user = "Usuario";
			return user;
		}else{
			return user;	
		}
	}


	/**
	 * @param  user nuevo string para user
	 */
	public void setUser(String user) {
		this.user = user;
	}


	/**
	 * @return the password
	 */
	public String getPassword() {
		if(password == null){
			password = "default";
			return password;
		}else{
			return password;
		}
	}


	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}


	/**
	 * @return the nombre
	 */
	public String getNombre() {
		if(nombre == null){
			 nombre = "Nombre";
			return nombre;
		}else{
			return nombre;	
		}
	}


	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	/**
	 * @return the apellidoMaterno
	 */
	public String getApellidoMaterno() {
		if(apellidoMaterno == null){
			 apellidoMaterno = "Apellido Materno";
			return apellidoMaterno;
		}else{
			return apellidoMaterno;	
		}
	}


	/**
	 * @param apellidoMaterno the apellidoMaterno to set
	 */
	public void setApellidoMaterno(String apellidoMaterno) {
		this.apellidoMaterno = apellidoMaterno;
	}


	/**
	 * @return the apellidoPaterno
	 */
	public String getApellidoPaterno() {
		if(apellidoPaterno == null){
			 apellidoPaterno = "Apellido Paterno";
			return apellidoPaterno;
		}else{
			return apellidoPaterno;	
		}
	}


	/**
	 * @param apellidoPaterno the apellidoPaterno to set
	 */
	public void setApellidoPaterno(String apellidoPaterno) {
		this.apellidoPaterno = apellidoPaterno;
	}


	/**
	 * @return the edad
	 */
	public int getEdad() {
			return edad;
	}


	/**
	 * @param edad the edad to set
	 */
	public void setEdad(int edad) {
		this.edad = edad;
	}


	/**
	 * @return the correo
	 */
	public String getCorreo() {
		if(correo == null){
			 correo = "Correo@ejemplo.com";
			return correo;
		}else{
			return correo;	
		}
	}


	/**
	 * @param correo the correo to set
	 */
	public void setCorreo(String correo) {
		this.correo = correo;
	}


	/**
	 * @return the telefono
	 */
	public String getTelefono() {
		if(telefono == null){
			 telefono = "55-55-55-55";
			return telefono;
		}else{
			return telefono;	
		}
	}


	/**
	 * @param telefono the telefono to set
	 */
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}


	/**
	 * @return the calle
	 */
	public String getCalle() {
		if(calle == null){
			 calle = "Calle";
			return calle;
		}else{
			return calle;	
		}
	}


	/**
	 * @param calle the calle to set
	 */
	public void setCalle(String calle) {
		this.calle = calle;
	}


	/**
	 * @return the colonia
	 */
	public String getColonia() {
		if(colonia == null){
			colonia = "Colonia";
			return colonia;
		}else{
			return colonia;	
		}
	}


	/**
	 * @param colonia the colonia to set
	 */
	public void setColonia(String colonia) {
		this.colonia = colonia;
	}


	/**
	 * @return the cp
	 */
	public String getCp() {
		if(cp == null){
			 cp = "Codigo postal";
			return cp;
		}else{
			return cp;	
		}
	}


	/**
	 * @param cp the cp to set
	 */
	public void setCp(String cp) {
		this.cp = cp;
	}


	/**
	 * @return the numero
	 */
	public String getNumero() {
		if(numero == null){
			 numero = "#numero";
			return numero;
		}else{
			return numero;	
		}
	}


	/**
	 * @param numero the numero to set
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}


	/**
	 * @return the credito
	 */
	public float getCredito() {
		return credito;
	}


	/**
	 * @param credito the credito to set
	 */
	public void setCredito(float credito) {
		this.credito = credito;
	}

	/**
	 * @return the admin
	 */
	public Boolean getAdmin() {
		if(admin == null){
			return false;
		}else{
			return this.admin;
		}
	}


	/**
	 * @param admin the admin to set
	 */
	public void setAdmin(Boolean admin) {
		if(admin == null){
			this.admin = false;	
		}else{
			this.admin = admin;
		}	
	}
	
	/**
	 *@param obj para extraerle los datos
	 *@return Usuario
	 */
	public Usuario llenaDatos(Object obj) throws NumberFormatException {
		if(obj instanceof javax.servlet.http.HttpServletRequest){
		
			javax.servlet.http.HttpServletRequest request = (javax.servlet.http.HttpServletRequest)obj;
			setUser(request.getParameter("usuario"));
			setPassword(request.getParameter("password"));
			setNombre(request.getParameter("nombre"));
			setApellidoMaterno(request.getParameter("apellidoMaterno"));
			setApellidoPaterno(request.getParameter("apellidoPaterno"));
			setCorreo(request.getParameter("correo"));
			setTelefono(request.getParameter("telefono"));
			setCalle(request.getParameter("calle"));
			setColonia(request.getParameter("colonia"));
			setCp(request.getParameter("cp"));
			setNumero(request.getParameter("numero"));
			setAdmin(Boolean.parseBoolean(request.getParameter("admin")));
			setCredito(Float.parseFloat(request.getParameter("credito")));
			setEdad(Integer.parseInt(request.getParameter("edad")));

			return this;
		
		}else if(obj instanceof beans.Usuario){
			beans.Usuario UserObject = (beans.Usuario)obj;
				
				setUser(UserObject.getUser());
				setPassword(UserObject.getPassword());
				setNombre(UserObject.getNombre());
				setApellidoMaterno(UserObject.getApellidoMaterno());
				setApellidoPaterno(UserObject.getApellidoPaterno());
				setCorreo(UserObject.getCorreo());
				setTelefono(UserObject.getTelefono());
				setCalle(UserObject.getCalle());
				setColonia(UserObject.getColonia());
				setCp(UserObject.getCp());
				setNumero(UserObject.getNumero());
				setCredito(UserObject.getCredito());
				setEdad(UserObject.getEdad());
				setAdmin(UserObject.getAdmin());
			
				return UserObject;
		
		}else{

			return this;
		}
	}
}
