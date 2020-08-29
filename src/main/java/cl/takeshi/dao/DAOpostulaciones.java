package cl.takeshi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.takeshi.beans.Postulaciones;

public class DAOpostulaciones {

	private String SQL_POSTULAR ="INSERT INTO POSTULACIONES (IDPOSTULANTE, IDOFERTA, FECHA) VALUES (?, ?, TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS'))";
	
	JdbcTemplate template;
	
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	public int ingresarPostulacion(Postulaciones p) {
		return template.update(SQL_POSTULAR, new Object[] {
				p.getIdpostulante(),
				p.getIdoferta(),
				p.getFecha()
		});
		
	}
	
	
	public class PostulacionesMapper implements RowMapper<Postulaciones>{
		public Postulaciones mapRow(ResultSet rs, int rowNum) throws SQLException{
			return new Postulaciones(
					rs.getInt("idpostulante"),
					rs.getInt("idoferta"),
					rs.getString("fecha")
					);
		}
	}
	
	
	
	
}
