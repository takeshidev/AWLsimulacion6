package cl.takeshi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.takeshi.beans.Postulante;
import cl.takeshi.beans.Reclutador;

public class DAOreclutador {

	
	private String SQL_RECLUTADOR ="INSERT INTO RECLUTADORES (IDRECLUTADOR, NOMBREFANTASIA, RAZONSOCIAL, RUT, EMAIL) VALUES (?, ?, ?, ?, ?)";
	private String SQL_INDICE ="SELECT MAX(reclutadores.idreclutador) AS Max_IDRECLUTADOR FROM reclutadores";
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int indiceReclutador() {
		Integer i = template.queryForObject(SQL_INDICE, int.class);
		return i;
	}
	

	public int ingresarReclutador (Reclutador r) {
		return template.update(SQL_RECLUTADOR,  new Object[]{
				r.getIdreclutador(),
				r.getNombrefantasia(),
				r.getRazonsocial(),
				r.getRut(),
				r.getEmail()
		}
		);
		
	}
	
	
	public class ReclutadorMapper implements RowMapper<Reclutador>{
		public Reclutador mapRow(ResultSet rs, int rowNum) throws SQLException{
			return new Reclutador(
					rs.getInt("idreclutador"),
					rs.getString("nombrefantasia"),
					rs.getString("razonsocial"),
					rs.getString("rut"),
					rs.getString("email")
					);
		}
	}
	
}
