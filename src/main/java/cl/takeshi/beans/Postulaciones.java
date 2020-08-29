package cl.takeshi.beans;

import java.util.Date;

public class Postulaciones {

	private int idpostulante;
	private int idoferta;
	private String fecha;
	
	public Postulaciones() {
		super();
	}
	public Postulaciones(int idpostulante, int idoferta, String fecha) {
		super();
		this.idpostulante = idpostulante;
		this.idoferta = idoferta;
		this.fecha = fecha;
	}
	public int getIdpostulante() {
		return idpostulante;
	}
	public int getIdoferta() {
		return idoferta;
	}
	public String getFecha() {
		return fecha;
	}
	public void setIdpostulante(int idpostulante) {
		this.idpostulante = idpostulante;
	}
	public void setIdoferta(int idoferta) {
		this.idoferta = idoferta;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	
	
}
