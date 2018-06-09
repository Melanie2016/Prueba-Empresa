package ar.edu.unlam.tallerweb1.probando.servicios;

import java.util.List;

import ar.edu.unlam.tallerweb1.probando.modelo.Empleado;

public interface ServicioEmpleado {
	
	void cargaDeEmpleados(Empleado empleado);
	
	List<Empleado> mostrarEmpleados();
	
}
