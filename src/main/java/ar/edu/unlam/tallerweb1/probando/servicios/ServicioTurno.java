package ar.edu.unlam.tallerweb1.probando.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.probando.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.probando.modelo.Veterinario;

public interface ServicioTurno {
	
	List<Especialidad> consultarEspecialidad();
	
	List<Veterinario> listaDeVeterinarios();
	
	List<Especialidad> probandoNaN();

	List<Especialidad> consultarDisponibilidad(Especialidad especialidad);
	
}
