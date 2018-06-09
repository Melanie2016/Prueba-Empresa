package ar.edu.unlam.tallerweb1.probando.controladores;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import ar.edu.unlam.tallerweb1.probando.modelo.Empleado;
import ar.edu.unlam.tallerweb1.probando.servicios.ServicioEmpleado;

@Controller
public class EmpresaController {

	@Inject
	private ServicioEmpleado servicioEmpleado;
	
	@RequestMapping(path = "/saludar", method = RequestMethod.GET)
	public ModelAndView irASaludar() {
		
		Empleado empleado = new Empleado();
		empleado.setNombre("Melanie");
		empleado.setDni(12345678);
		
		ModelMap  miModelo = new ModelMap();
		miModelo.put("empleado", empleado); // (clave unica , objeto q cree)
		
		return new ModelAndView("saludar",miModelo); // (vista,mapa)

	}
	
	@RequestMapping(path = "/", method = RequestMethod.GET)
	public ModelAndView irASaludarrrr() {
				
		return new ModelAndView(new RedirectView("saludar") ) ; // (vista,mapa)

	}
	
	@RequestMapping(path = "/home", method = RequestMethod.GET)
	public ModelAndView bienvenidos() {
		
		Empleado empleado = new Empleado();
		empleado.setNombre("Melanie");
		empleado.setDni(12345678);
		
		ModelMap  miModelo = new ModelMap();
		miModelo.put("empleado", empleado); // (clave unica , objeto q cree)
		
		return new ModelAndView("home",miModelo); // (vista,mapa)

	}
	
	@RequestMapping(value="home/amigo",method=RequestMethod.GET)
	public ModelAndView irHomeAmigo(
	@RequestParam(value="FirstName")String nombre,
	@RequestParam(value="LastName")String apellido) {
		String msj1 ="El nombre ingresado es: "+nombre ;
		String msj2 ="El apellido es: "+apellido;
		
		ModelMap model=new ModelMap();
		model.put("mensaje1", msj1);
		model.put("mensaje2", msj2);
		
		return new ModelAndView("mensaje",model);
	}
	
	@RequestMapping(value="home/amiga/nombre/{nombre}/apellido/{apellido}",method=RequestMethod.GET)
	public ModelAndView irHomeAmigo2(@PathVariable String nombre ,@PathVariable String apellido){
		String msj1 ="El nombre ingresado es: "+nombre ;
		String msj2 ="El apellido es: "+apellido;
		
		ModelMap model=new ModelMap();
		model.put("mensaje1", msj1);
		model.put("mensaje2", msj2);
		
		return new ModelAndView("mensaje",model);
	}
	

	
	
	// probando servicios 
	
	
	// Cargar empleado
	@RequestMapping(path="/home/formularioEmpleado",method=RequestMethod.GET)
	public ModelAndView formularioEmpleado() {
		
		Empleado empleado = new Empleado();
		ModelMap modelo = new ModelMap();
		modelo.put("misEmpleados",empleado);
		
		return new ModelAndView("formEmpleados",modelo);
	}
	
	@RequestMapping(path="/home/validarEmpleados",method=RequestMethod.POST)
	public ModelAndView irAValidarEmpleados(@ModelAttribute ("misEmpleados") Empleado empleado) {
		
		ModelMap modelo = new ModelMap();
		
		servicioEmpleado.cargaDeEmpleados(empleado);
		
		//Empleado empleadoACargar= servicioEmpleado.cargaDeEmpleados(empleado);
		
		modelo.put("empleado", servicioEmpleado);
			
		return new ModelAndView("correcto",modelo);
	}
	
	
	
	//Recuperar empleado
	
	/*
	@RequestMapping(path="/home/recuperarEmpleados", method=RequestMethod.GET)
	
	public ModelAndView mostrarEmpleadoIngresado() {
		
		Empleado empleado = servicioEmpleado.mostrarEmpleados();
		
		ModelMap modelo = new ModelMap();
		modelo.put("empleado", empleado.getNombre());
		
		return new ModelAndView("correcto2",modelo);
		
	}
	*/
	
	
	
	@RequestMapping(path="/home/listaDeEmpleados", method=RequestMethod.GET)
	public ModelAndView irAListaDeEmpleados() {
		
		ModelMap modelo = new ModelMap();
		List<Empleado> empleadosList = servicioEmpleado.mostrarEmpleados();
		modelo.put("empleado", empleadosList);
		return new ModelAndView("ListaDeEmpleados",modelo);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
}





/* si quiero recuperar personas ej: 
 * List<Persona> persMayorDeEdad = SP.buscarPersonasMayoresDeEdad();
 * 
 * 
 * en el paquete de daos solo queda .save get y criterias 
 * 
 * */
