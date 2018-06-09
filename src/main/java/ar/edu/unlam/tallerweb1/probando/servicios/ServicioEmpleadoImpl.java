package ar.edu.unlam.tallerweb1.probando.servicios;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ar.edu.unlam.tallerweb1.probando.dao.EmpleadoDao;
import ar.edu.unlam.tallerweb1.probando.modelo.Empleado;

@Service("servicioEmpleado")
@Transactional
public class ServicioEmpleadoImpl implements ServicioEmpleado {
	
	@Inject
	private EmpleadoDao servicioEmpleadoDao;
	
	@Override 
	public void cargaDeEmpleados(Empleado empleado) {
		 servicioEmpleadoDao.cargaDeEmpleadosDao(empleado);
	}
	
	@Override
	public List<Empleado> mostrarEmpleados(){
		return servicioEmpleadoDao.mostrarEmpleadosDao();
		
	}

}
