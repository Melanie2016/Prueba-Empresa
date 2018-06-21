package ar.edu.unlam.tallerweb1.probando.modelo;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;


@Entity
public class Veterinario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long veterinarioId;
	private String nombre;
	private String apellido;

	/*
	@ManyToMany(mappedBy = "Veterinario")
	private Collection<Especialidad> especialidad = new ArrayList<>();*/
	
	@ManyToMany(mappedBy = "veterinario")
	private Collection<Especialidad> especialidad = new ArrayList<>();
	
	
	//getters y setters
	public Long getVeterinarioId() {
		return veterinarioId;
	}
	public void setVeterinarioId(Long veterinarioId) {
		this.veterinarioId = veterinarioId;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	
	
	
}
