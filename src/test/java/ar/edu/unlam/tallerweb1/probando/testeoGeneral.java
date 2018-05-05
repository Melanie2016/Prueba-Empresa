package ar.edu.unlam.tallerweb1.probando;

import static org.assertj.core.api.Assertions.assertThat;


import java.util.List;

import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;


import ar.edu.unlam.tallerweb1.probando.modelo.Empleado;
import ar.edu.unlam.tallerweb1.probando.modelo.Empresa;
import ar.edu.unlam.tallerweb1.probando.modelo.Sector;



public class testeoGeneral extends SpringTest{

	@Test
	@Transactional @Rollback(true)
	public void testQueCorroboreLaConexion() {
        assertThat(getSession().isConnected()).isTrue();

	}
	
	
	@Test
	@Transactional @Rollback(true)
	public void testQueSeCreeUnaEmpresaCorrectamente() {
		
		Empresa miEmpresa = new Empresa();
		miEmpresa.setRazonSocial("Adidas");
		
		getSession().save(miEmpresa);
		
		System.out.println(miEmpresa.toString());
		
		
//		assertThat(miEmpresa.getRazonSocial()).isEqualTo("Adidas");
		assertThat(miEmpresa.getIdEmpresa()).isEqualTo(1);
		
	}
	
	
	@Test
	@Transactional @Rollback(true)
	public void testQueSeCargueUnSectorDeUnaEmpresa() {
		
		Empresa miEmpresa = new Empresa();
		miEmpresa.setRazonSocial("Adidas");
		getSession().save(miEmpresa);

		Sector miSector = new Sector();
		miSector.setNombre("Recursos Humanos");
		miSector.setEmpresa(miEmpresa);
		getSession().save(miSector);
				
		
		assertThat(miSector.getEmpresa().getIdEmpresa()).isEqualTo(1);
		System.out.println(miSector.toString());
		
	}
	
	
	@Test
	@Transactional @Rollback(true)
	public void testQueSeCreeUnEmpleado() {
		
		Empleado miEmpleado = new Empleado();
		miEmpleado.setDni(12345678);
		miEmpleado.setNombre("Paola");
		getSession().save(miEmpleado);
		
		assertThat(miEmpleado.getIdEmpleado()).isEqualTo(1);
		System.out.println(miEmpleado.toString());
		
	}

	@Test
	@Transactional @Rollback(true)
	public void testQueSeMuestreUnEmpleadoConSuRespectivoSector() {
		
		Sector miSector = new Sector();
		miSector.setNombre("Recursos Humanos");
		getSession().save(miSector);
		
		
		Empleado miEmpleado = new Empleado();
		miEmpleado.setDni(12345678);
		miEmpleado.setNombre("Gonzalo");
		miEmpleado.setSector(miSector);
		getSession().save(miEmpleado);
		
	
		System.out.println(miEmpleado.toString());
		assertThat(miEmpleado.getSector().getNombre()).isEqualTo("Recursos Humanos");
	}
	
	
	@Test
	@Transactional @Rollback(true)
	public void testQueSeMuestreUnEmpleadoQuePertenezcaAUnSectorDeUnaEmpresa(){
		
		Empresa miEmpresa = new Empresa();
		miEmpresa.setRazonSocial("Adidas");
		getSession().save(miEmpresa);
		
		
		Sector miSector = new Sector();
		miSector.setNombre("Recursos Humanos");
		getSession().save(miSector);
		
		miSector.setEmpresa(miEmpresa);
		
		Empleado miEmpleado = new Empleado();
		miEmpleado.setDni(12345678);
		miEmpleado.setNombre("Anabella");
		miEmpleado.setSector(miSector);
		getSession().save(miEmpleado);
		
		System.out.println(miEmpleado.toString());
		
		assertThat(miEmpleado.getSector().getEmpresa().getRazonSocial()).isEqualTo("Adidas");
	
	}
	
	
	@Test
	@Transactional @Rollback(true)
	@SuppressWarnings("unchecked")
	public void testQueTraigaLosEmpleadosDeNombreJuan() {
		
		Empleado miEmpleado = new Empleado();
		miEmpleado.setNombre("Gonzalo");
		getSession().save(miEmpleado);
		
		Empleado miEmpleado1 = new Empleado();
		miEmpleado1.setNombre("Juan");
		getSession().save(miEmpleado1);
		
		Empleado miEmpleado2 = new Empleado();
		miEmpleado2.setNombre("Juan");
		getSession().save(miEmpleado2);
		
		
		Session miSession = getSession();
		List<Empleado> list =	
				miSession.createCriteria(Empleado.class)
				.add(Restrictions.eq("nombre","Juan"))
				.list();
				
//		ArrayList<String> array = new ArrayList<>();
//		for(String cadena : array){
//		  System.out.println(cadena);
//		}
		
		
		for(Empleado misE : list) {
			System.out.println(misE.getNombre());
		}
		
//		assertThat(list.size()).isEqualTo(2);
		
	}
	
	
	@Test
	@Transactional @Rollback(true)
	@SuppressWarnings("unchecked")
	public void todosLosEmpleadosDeUnSector() {
		
		Sector sector = new Sector();
		sector.setNombre("Ventas");
		getSession().save(sector);
		
		Empleado empleado = new Empleado();
		empleado.setNombre("Juan");
		empleado.setSector(sector);
		getSession().save(empleado);
		
		Empleado empleado2 = new Empleado();
		empleado2.setNombre("Gonzalo");
		empleado2.setSector(sector);
		getSession().save(empleado2);
		
		
		
		Session session = getSession();
		List<Empleado> list = 
			session.createCriteria(Empleado.class)
			.add(Restrictions.eq("sector",sector))
			.list();
	
		
		System.out.println(list);
//		assertThat(list.size()).isEqualTo(2);
	}
	
	
	@Test
	@Transactional @Rollback(true)
	@SuppressWarnings("unchecked")
	public void testQueMuestreLosEmpleadosDelSectorVentas() {
		
		Sector sector1 = new Sector();
		sector1.setNombre("Recursos Humanos");
		getSession().save(sector1);
		
		Sector sector2 = new Sector();
		sector2.setNombre("Ventas");
		getSession().save(sector2);
		
		
		Empleado empleado1 = new Empleado();
		empleado1.setDni(12345678);
		empleado1.setNombre("Paola");
		empleado1.setSector(sector1);
		getSession().save(empleado1);
		
		Empleado empleado2 = new Empleado();
		empleado2.setDni(12345677);
		empleado2.setNombre("Anabella");
		empleado2.setSector(sector2);
		getSession().save(empleado2);
		
		Empleado empleado3 = new Empleado();
		empleado3.setDni(12333333);
		empleado3.setNombre("Gonzalo");
		empleado3.setSector(sector2);
		getSession().save(empleado3);

//		Session session = getSession();
		List<Empleado> list = 
				getSession().createCriteria(Empleado.class)
				.createAlias("sector", "sectorBuscado")
				.add(Restrictions.eq("sectorBuscado.nombre","Ventas"))
				.list();
		
//		List<Empleado> list = 
//				getSession().createCriteria(Empleado.class)
//				.add(Restrictions.eq("sector.id",2L))
//				.list();
		
		
		assertThat(list.size()).isEqualTo(2);
		System.out.println(list);
		
	}
	
	@Test
	@Transactional @Rollback(true)
	@SuppressWarnings("unchecked")
	public void testQueMuestreLosEmpleadosDeUnaEmpresa() {

		Empresa empresa1 = new Empresa();
		empresa1.setRazonSocial("Pepsi");
		getSession().save(empresa1);
		
		Empresa empresa2 = new Empresa();
		empresa2.setRazonSocial("Coca-Cola");
		getSession().save(empresa2);
		
		Sector sector1 = new Sector();
		sector1.setNombre("Ventas");
		sector1.setEmpresa(empresa1);
		getSession().save(sector1);
		
		Sector sector2 = new Sector();
		sector2.setNombre("Ventas");
		sector2.setEmpresa(empresa2);
		getSession().save(sector2);
		
		Empleado empleado1 = new Empleado();
		empleado1.setDni(111111111);
		empleado1.setNombre("Martin");
		empleado1.setSector(sector1);
		getSession().save(empleado1);
		
		Empleado empleado2 = new Empleado();
		empleado2.setDni(111111111);
		empleado2.setNombre("Gonzalo");
		empleado2.setSector(sector1);
		getSession().save(empleado2);
		
		List<Empleado> list =
				getSession().createCriteria(Empleado.class)
				.add(Restrictions.eq("sector",empresa1))
				.list();
		
		System.out.println(list);
		assertThat(list.size()).isEqualTo(2);
	}
	
	
	@Test
	@Transactional @Rollback(true)
	@SuppressWarnings("unchecked")
	public void testQueMuestreLosEmpleadosDeLaEmpresaPepsi() {

		Empresa empresa1 = new Empresa();
		empresa1.setRazonSocial("Pepsi");
		
		Empresa empresa2 = new Empresa();
		empresa2.setRazonSocial("Coca-Cola");
		
		Sector sector1 = new Sector();
		sector1.setNombre("Ventas");
		sector1.setEmpresa(empresa1);
		
		Sector sector2 = new Sector();
		sector2.setNombre("Ventas");
		sector2.setEmpresa(empresa2);
		
		Empleado empleado1 = new Empleado();
		empleado1.setDni(111111111);
		empleado1.setNombre("Martin");
		empleado1.setSector(sector1);
		
		Empleado empleado2 = new Empleado();
		empleado2.setDni(111111111);
		empleado2.setNombre("Gonzalo");
		empleado2.setSector(sector1);
	
		
		getSession().save(empresa1);
		getSession().save(empresa2);
		getSession().save(sector1);
		getSession().save(sector2);
		getSession().save(empleado1);
		getSession().save(empleado2);
		
		
		List<Empleado> list =
				getSession().createCriteria(Empleado.class,"empleado")
				.createAlias("empleado.sector", "sectorBuscado")
				.createAlias("sectorBuscado.empresa", "empresaBuscada")
				.add(Restrictions.eq("empresaBuscada.razonSocial","pepsi"))
				.list();
		
		System.out.println(list);
		//assertThat(list.size()).isEqualTo(2);

	}
	
	public void testQueMuestreLosEmpleadosDelSectorVentasDeLaEmpresaArcor() {
	
	}
	
	
	
	
	
}