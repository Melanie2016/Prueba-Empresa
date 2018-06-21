package ar.edu.unlam.tallerweb1.probando.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.probando.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.probando.modelo.Veterinario;

public interface TurnoDao {

	List<Especialidad> consultarEspecialidadDao();
	
	List<Veterinario> listaDeVeterinariosDao();

	List<Especialidad> probandoNaNDao();

	List<Especialidad> consultarDisponibilidadDao(Especialidad especialidad);
	

}
