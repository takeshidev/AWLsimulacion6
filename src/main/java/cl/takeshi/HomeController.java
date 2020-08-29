package cl.takeshi;

import java.net.URI;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import cl.takeshi.beans.Ofertas;
import cl.takeshi.beans.Postulaciones;
import cl.takeshi.beans.Postulante;
import cl.takeshi.beans.Reclutador;
import cl.takeshi.dao.DAOofertas;
import cl.takeshi.dao.DAOpostulaciones;
import cl.takeshi.dao.DAOpostulante;
import cl.takeshi.dao.DAOreclutador;



@Controller
public class HomeController {
	
	@Autowired
	DAOpostulante postulanteDAO;
	@Autowired
	DAOofertas ofertasDAO;
	@Autowired
	DAOpostulaciones postulacionesDAO;
	@Autowired
	DAOreclutador reclutadorDAO;
	
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public ModelAndView home() {
		System.out.println("--->>HOME");
			return new ModelAndView("index");
		}
	@RequestMapping(value="/postulantes", method = RequestMethod.GET)
	public ModelAndView postulantes() {
		System.out.println("--->>POSTULANTES");
		return new ModelAndView("redirect:/PostulanteCrear");
	}
	@RequestMapping(value="/PostulanteCrear", method = RequestMethod.GET)
	public ModelAndView PostulanteCrear() {
		System.out.println("--->>CREAR POSTULANTE");
		
		return new ModelAndView("PostulanteCrear");
	}
	@RequestMapping(value="/PostulanteCrear", method = RequestMethod.POST)
	public ModelAndView PostulanteSave(HttpServletRequest request,ModelMap model) {
		System.out.println("--->>GUARDANDO POSTULANTE");
		int indice = postulanteDAO.indicePostulante()+1;
		System.out.println(indice);
			
		Postulante p = new Postulante(
				indice,
				request.getParameter("nombre"),
				request.getParameter("apellido"),
				request.getParameter("rut"),
				request.getParameter("email"),
				request.getParameter("experiencia")
				);
		postulanteDAO.ingresarPostulante(p);
		
		List<Ofertas> ofertas = ofertasDAO.listaOfertas();
		
		model.addAttribute("idpostulante", p.getIdpostulante() );
		model.addAttribute("ofertas", ofertas);

		return new ModelAndView("OfertasReadAll", "model", model);
	}
	
	@RequestMapping(value="/Postular/{idoferta}/{idpostulante}", method = RequestMethod.GET)
	public ModelAndView Postular(@PathVariable int idoferta, @PathVariable int idpostulante) {
		System.out.println("--->>POSTULANDO oferta:"+idoferta+" postulante:"+idpostulante);
		
		Calendar cal = Calendar.getInstance();

		String fecha = cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DATE)+" "+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND); 
		System.out.println(fecha);
		
		Postulaciones p = new Postulaciones(idpostulante, idoferta, fecha);
		 
		postulacionesDAO.ingresarPostulacion(p);
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/test", method = RequestMethod.GET)
	public ModelAndView test() {
		System.out.println("--->>TEST");
		Calendar cal = Calendar.getInstance();

		String fecha = cal.get(Calendar.YEAR)+"-"+cal.get(Calendar.MONTH)+"-"+cal.get(Calendar.DATE)+" "+cal.get(Calendar.HOUR_OF_DAY)+":"+cal.get(Calendar.MINUTE)+":"+cal.get(Calendar.SECOND); 
		System.out.println(fecha);
		
		return new ModelAndView("redirect:/");
	}
	
	@RequestMapping(value="/reclutadores", method = RequestMethod.GET)
	public ModelAndView reclutadores() {
		System.out.println("--->>RECLUTADORES");
		return new ModelAndView("redirect:/ReclutadorCrear");
	}
	
	@RequestMapping(value="/ReclutadorCrear", method = RequestMethod.GET)
	public ModelAndView ReclutadorCrear() {
		System.out.println("--->>CREAR RECLUTADOR");
		
		return new ModelAndView("ReclutadorCrear");
	}
	
	@RequestMapping(value="/ReclutadorCrear", method = RequestMethod.POST)
	public ModelAndView ReclutadorSave(HttpServletRequest request,ModelMap model) {
		System.out.println("--->>GUARDANDO RECLUTADOR");
		int indice = reclutadorDAO.indiceReclutador()+1;
		System.out.println(indice);
				
		Reclutador r = new Reclutador( indice,
		request.getParameter("nombrefantasia"), request.getParameter("razonsocial"),
		request.getParameter("rut"), request.getParameter("email") );
		  
		reclutadorDAO.ingresarReclutador(r);
		  		  
		model.addAttribute("idreclutador", r.getIdreclutador() );
		 
		return new ModelAndView("OfertaCrear");
	}
	
	@RequestMapping(value="/OfertaCrear", method = RequestMethod.POST)
	public ModelAndView OfertaCrear(HttpServletRequest request) {
		System.out.println("--->>CREAR OFERTA - reclutador: ");
		int indice = ofertasDAO.indiceOferta()+1;
		System.out.println(indice);
				
		
		Ofertas o = new Ofertas(
				indice,
				Integer.parseInt(request.getParameter("idreclutador")),
				request.getParameter("fecha"),
				request.getParameter("titulo"),
				request.getParameter("descripcion"),
				(double) Integer.parseInt(request.getParameter("salario"))
				);
		
		ofertasDAO.ingresarOferta(o);
		
		return new ModelAndView("PostulacionesReadAll");
	}
	
	@RequestMapping(value="/PostulacionesReadAll", method = RequestMethod.GET)
	public ModelAndView PostulacionesReadAll() {
		System.out.println("--->>VER POSTULACIONES");
		
		return new ModelAndView("PostulacionesReadAll");
	}
	
	
}
