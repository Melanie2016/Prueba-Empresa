package ar.edu.unlam.tallerweb1.probando.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.probando.dao.TurnoDao;
import ar.edu.unlam.tallerweb1.probando.modelo.Especialidad;
import ar.edu.unlam.tallerweb1.probando.modelo.Veterinario;

@Service("servicioTurno")
@Transactional
public class ServicioTurnoImpl implements ServicioTurno{

	@Inject
	private TurnoDao turnoDao;
	
	@Override
	public List<Especialidad> consultarEspecialidad(){
		return turnoDao.consultarEspecialidadDao();
	
	}
	
	@Override
	public List<Veterinario> listaDeVeterinarios(){
		return turnoDao.listaDeVeterinariosDao();
	
	}
	
	@Override
	public List<Especialidad> probandoNaN(){
		return turnoDao.probandoNaNDao();
	
	}
	
	@Override
	public List<Especialidad> consultarDisponibilidad(Especialidad especialidad){
		return turnoDao.consultarDisponibilidadDao(especialidad);
	
	}
}
