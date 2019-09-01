package ar.edu.unlam.tallerweb1.controladores;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ControladorPersona {

	@RequestMapping(path = "saludo", method = RequestMethod.GET)
	public ModelAndView holaMundo() {
		return new ModelAndView("mensaje");
	}

	@RequestMapping(path = "/mostrar", method = RequestMethod.GET)
	public ModelAndView mostrar() {

		ModelMap modelo = new ModelMap();

		String nombre = "Andres";
		String apellido = "Borgeat";

		modelo.put("nombre", nombre);
		modelo.put("apellido", apellido);
		
		return new ModelAndView("mostrar", modelo);
	}
	
	@RequestMapping(path="/hola/amigo", method=RequestMethod.GET)
	public ModelAndView holaAmigo(@RequestParam("nombre") String nombre){
		
		ModelMap modelo = new ModelMap();
		String mensaje = nombre + " con cara de tontooo a las 3";
		
		modelo.put("mensaje", mensaje);
		return new ModelAndView("saludar", modelo);
	}
}
