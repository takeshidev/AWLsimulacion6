package cl.takeshi.beans;

public class Reclutador {

	private int idreclutador;
	private String nombrefantasia;
	private String razonsocial;
	private String rut;
	private String email;
	public Reclutador() {
		super();
	}
	public Reclutador(int idreclutador, String nombrefantasia, String razonsocial, String rut, String email) {
		super();
		this.idreclutador = idreclutador;
		this.nombrefantasia = nombrefantasia;
		this.razonsocial = razonsocial;
		this.rut = rut;
		this.email = email;
	}
	public int getIdreclutador() {
		return idreclutador;
	}
	public String getNombrefantasia() {
		return nombrefantasia;
	}
	public String getRazonsocial() {
		return razonsocial;
	}
	public String getRut() {
		return rut;
	}
	public String getEmail() {
		return email;
	}
	public void setIdreclutador(int idreclutador) {
		this.idreclutador = idreclutador;
	}
	public void setNombrefantasia(String nombrefantasia) {
		this.nombrefantasia = nombrefantasia;
	}
	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
	}
	public void setRut(String rut) {
		this.rut = rut;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
