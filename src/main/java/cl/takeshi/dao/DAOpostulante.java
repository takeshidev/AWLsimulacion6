package cl.takeshi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.takeshi.beans.Postulante;


public class DAOpostulante {

	private String SQL_CREAR ="INSERT INTO POSTULANTES (IDPOSTULANTE, NOMBRE, APELLIDO, RUT, EMAIL, RESUMEN) VALUES (?, ?, ?, ?, ?, ?)";
	private String SQL_ID ="SELECT MAX(postulantes.idpostulante) AS Max_IDPOSTULANTE FROM postulantes";
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	

	public int ingresarPostulante (Postulante p) {
		return template.update(SQL_CREAR,  new Object[]{
				p.getIdpostulante(),
				p.getNombre(),
				p.getApellido(),
				p.getRut(),
				p.getEmail(),
				p.getResumen()
		}
		);
		
	}
	
	
	
	public int indicePostulante() {
		Integer i = template.queryForObject(SQL_ID, int.class);
		return i;
	}
	
	
	public class PostulanteMapper implements RowMapper<Postulante>{
		public Postulante mapRow(ResultSet rs, int rowNum) throws SQLException{
			return new Postulante(
					rs.getInt("idpostulante"),
					rs.getString("nombre"),
					rs.getString("apellido"),
					rs.getString("rut"),
					rs.getString("email"),
					rs.getString("resumen")
					);
		}
	}
	
	
	
	
	
	
}
