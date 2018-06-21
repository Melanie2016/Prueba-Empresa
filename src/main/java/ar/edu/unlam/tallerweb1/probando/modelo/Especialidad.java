package ar.edu.unlam.tallerweb1.probando.modelo;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn; 
import javax.persistence.ManyToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;



@Entity
public class Especialidad {

	@Id 
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private Long especialidadId;
	private String descripcion;
	private Float duracion;
	private Date diaDeAtencion;
	private Date turnoMañanaInicio;
	private Date turnoMañanaFinaliza;
	private Date turnoTardeInicio;
	private Date turnoTardeFinaliza;
	
	
	/*
	@ManyToMany(cascade = {CascadeType.ALL})
	@JoinTable(
			name="Especialidad_Veterinario",
			joinColumns = @JoinColumn (name="especialidadId"),
			inverseJoinColumns = @JoinColumn (name="veterinarioId")
			)
	private List<Veterinario> veterinario ;*/

	@ManyToMany(fetch = FetchType.EAGER)
    @Fetch(FetchMode.SELECT)
    @JoinTable(name="especialidad_veterinario",
    joinColumns = {@JoinColumn(name = "especialidad_id")},
    inverseJoinColumns = {@JoinColumn(name = "veterinario_id")})
    private List<Veterinario> veterinario = new ArrayList<>();
	
	// getters y setters 
	public Long getEspecialidadId() {
		return especialidadId;
	}

	public void setEspecialidadId(Long especialidadId) {
		this.especialidadId = especialidadId;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	public Float getDuracion() {
		return duracion;
	}

	public void setDuracion(Float duracion) {
		this.duracion = duracion;
	}

	public Date getDiaDeAtencion() {
		return diaDeAtencion;
	}

	public void setDiaDeAtencion(Date diaDeAtencion) {
		this.diaDeAtencion = diaDeAtencion;
	}

	public Date getTurnoMañanaInicio() {
		return turnoMañanaInicio;
	}

	public void setTurnoMañanaInicio(Date turnoMañanaInicio) {
		this.turnoMañanaInicio = turnoMañanaInicio;
	}

	public Date getTurnoMañanaFinaliza() {
		return turnoMañanaFinaliza;
	}

	public void setTurnoMañanaFinaliza(Date turnoMañanaFinaliza) {
		this.turnoMañanaFinaliza = turnoMañanaFinaliza;
	}

	public Date getTurnoTardeInicio() {
		return turnoTardeInicio;
	}

	public void setTurnoTardeInicio(Date turnoTardeInicio) {
		this.turnoTardeInicio = turnoTardeInicio;
	}

	public Date getTurnoTardeFinaliza() {
		return turnoTardeFinaliza;
	}

	public void setTurnoTardeFinaliza(Date turnoTardeFinaliza) {
		this.turnoTardeFinaliza = turnoTardeFinaliza;
	}

	public List<Veterinario> getVeterinario() {
		return veterinario;
	}

	public void setVeterinario(List<Veterinario> veterinario) {
		this.veterinario = veterinario;
	}

	
	
}
