package cl.takeshi.beans;

import java.util.Date;

public class Ofertas {

	private int idoferta;
	private int idreclutador;
	private String fecha;
	private String titulo;
	private String descripcion;
	private Double salario;
	
	public Ofertas() {
		super();
	}

	public Ofertas(int idreclutador, String fecha, String titulo, String descripcion, Double salario) {
		super();
		this.idreclutador = idreclutador;
		this.fecha = fecha;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.salario = salario;
	}

	public Ofertas(int idoferta, int idreclutador, String fecha, String titulo, String descripcion, Double salario) {
		super();
		this.idoferta = idoferta;
		this.idreclutador = idreclutador;
		this.fecha = fecha;
		this.titulo = titulo;
		this.descripcion = descripcion;
		this.salario = salario;
	}

	public int getIdoferta() {
		return idoferta;
	}

	public int getIdreclutador() {
		return idreclutador;
	}

	public String getFecha() {
		return fecha;
	}

	public String getTitulo() {
		return titulo;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public Double getSalario() {
		return salario;
	}

	public void setIdoferta(int idoferta) {
		this.idoferta = idoferta;
	}

	public void setIdreclutador(int idreclutador) {
		this.idreclutador = idreclutador;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public void setSalario(Double salario) {
		this.salario = salario;
	}
	
	
	
}
