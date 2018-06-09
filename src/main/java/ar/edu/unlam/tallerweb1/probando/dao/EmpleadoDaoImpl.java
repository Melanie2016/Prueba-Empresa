package ar.edu.unlam.tallerweb1.probando.dao;

import java.util.List;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import ar.edu.unlam.tallerweb1.probando.modelo.Empleado;

@Repository("empleadoDao")
public class EmpleadoDaoImpl implements EmpleadoDao{
	
	@Inject
	private SessionFactory sessionFactory;
	
	@Override
	public void cargaDeEmpleadosDao( Empleado empleado) {
		final Session session = sessionFactory.getCurrentSession();
		session.save(empleado);
	}

	/* lista si los llamo por id- FUNCIONA CORRECTAMENTE
	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> mostrarEmpleadosDao(){
		
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Empleado.class)
				.add(Restrictions.eq("idEmpleado", 1L))
				.list();
	}
	*/
	/* si llamo segun un nombre en particular - FUNCIONA CORRECTAMENTE
	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> mostrarEmpleadosDao(){
		
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Empleado.class)
				.add(Restrictions.eq("nombre", "Martin"))
				.list();
	}
	*/
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Empleado> mostrarEmpleadosDao(){
		
		final Session session = sessionFactory.getCurrentSession();
		return session.createCriteria(Empleado.class)
				.add(Restrictions.isNotNull("nombre"))
				.list();
	}
	




}


