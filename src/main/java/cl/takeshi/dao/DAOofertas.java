package cl.takeshi.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;

import cl.takeshi.beans.Ofertas;

public class DAOofertas {

	private String SQL_LISTA = "SELECT * FROM ofertas";
	private String SQL_INDICE = "SELECT MAX(ofertas.idoferta) AS Max_IDOFERTA FROM ofertas";
	private String SQL_CREAR = "INSERT INTO OFERTAS (IDOFERTA, IDRECLUTADOR, FECHA, TITULO, DESCRIPCION, SALARIO) VALUES (?, ?, TO_DATE(?, 'YYYY-MM-DD HH24:MI:SS'), ?, ?, ?)";
	
	JdbcTemplate template;
	public void setTemplate(JdbcTemplate template) {
		this.template = template;
	}
	
	
	public List<Ofertas> listaOfertas(){
		return template.query(SQL_LISTA, new OfertasMapper());
	}
	
	public int indiceOferta() {
		Integer i = template.queryForObject(SQL_INDICE, int.class);
		return i;
	}
	
	public int ingresarOferta(Ofertas o){
		return template.update(SQL_CREAR,  new Object[]{
				o.getIdoferta(),
				o.getIdreclutador(),
				o.getFecha(),
				o.getTitulo(),
				o.getDescripcion(),
				o.getSalario()
		}
		);
		
	}
	
	
	
	public class OfertasMapper implements RowMapper<Ofertas>{
		public Ofertas mapRow(ResultSet rs, int rowNum) throws SQLException{
			return new Ofertas(
					rs.getInt("idoferta"),
					rs.getInt("idreclutador"),
					rs.getString("fecha"),
					rs.getString("titulo"),
					rs.getString("descripcion"),
					rs.getDouble("salario")
					);
		}
	}
	
	
	
}
