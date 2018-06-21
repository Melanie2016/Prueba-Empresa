package ar.edu.unlam.tallerweb1.probando.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unlam.tallerweb1.probando.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.probando.modelo.Veterinario;
import ar.edu.unlam.tallerweb1.probando.servicios.ServicioTurno;

@Controller
public class VeterinariaControlller {
	
	@Inject
	private ServicioTurno servicioTurno;
	
	
	//http://localhost:8080/veterinaria/turno
	@RequestMapping(path="/turno",method=RequestMethod.GET)
	public ModelAndView sacarTurno() {
		
		ModelMap model =new ModelMap();
	//	Turno turno = new Turno(); 
		List<Especialidad> especialidadList = servicioTurno.consultarEspecialidad();
		List<Veterinario> veterinariosList = servicioTurno.listaDeVeterinarios();
		
		model.put("especialidades", especialidadList);
		model.put("veterinarios", veterinariosList);
		
		return new ModelAndView ("turno",model);
	}
	
	
	
	@RequestMapping(path="/turno/consultarFecha")
	public ModelAndView irAConsultarFecha(){
		ModelMap model =new ModelMap();
		List<Especialidad> especialidadList = servicioTurno.probandoNaN();

		model.put("especialidades", especialidadList);
		
		return new ModelAndView ("disponibilidad",model);
	}
	
	
	
	@RequestMapping(path="/consultarDisp",method=RequestMethod.POST)
	public ModelAndView irAConsultarFecha(@ModelAttribute ("especialidades") Especialidad especialidad) {
				
		ModelMap model =new ModelMap();
		List<Especialidad> especialidadList = servicioTurno.consultarDisponibilidad(especialidad);

		model.put("especialidades", especialidadList);
				
		return new ModelAndView ("disponibilidad",model);
	}
		
			
	
	
	
	
	
	
	
	
	
	
}
