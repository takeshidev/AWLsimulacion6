package cl.takeshi.beans;

public class Postulante {

	
	private int idpostulante;
	private String nombre;
	private String apellido;
	private String rut;
	private String email;
	private String resumen;
	
	public Postulante() {
		super();
	}

	public Postulante(String nombre, String apellido, String rut, String email, String resumen) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
		this.email = email;
		this.resumen = resumen;
	}

	public Postulante(int idpostulante, String nombre, String apellido, String rut, String email, String resumen) {
		super();
		this.idpostulante = idpostulante;
		this.nombre = nombre;
		this.apellido = apellido;
		this.rut = rut;
		this.email = email;
		this.resumen = resumen;
	}

	public int getIdpostulante() {
		return idpostulante;
	}

	public String getNombre() {
		return nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public String getRut() {
		return rut;
	}

	public String getEmail() {
		return email;
	}

	public String getResumen() {
		return resumen;
	}

	public void setIdpostulante(int idpostulante) {
		this.idpostulante = idpostulante;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public void setRut(String rut) {
		this.rut = rut;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setResumen(String resumen) {
		this.resumen = resumen;
	}
		
}
