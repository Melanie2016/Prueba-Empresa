package ar.edu.unlam.tallerweb1.probando.dao;

import java.util.List;

import ar.edu.unlam.tallerweb1.probando.modelo.Empleado;

public interface EmpleadoDao {

	void cargaDeEmpleadosDao (Empleado empleado);

	List<Empleado> mostrarEmpleadosDao();

	
}
