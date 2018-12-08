package pe.edu.cibertec.bean;

import java.io.Serializable;

public class PacienteBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 2035067851803416310L;
	private Integer idPaciente;
	private String nombre;
	private String fecha_nacimiento;
	private String fecha_ingreso;
	private String sexo;
	private String color;
	private String particularidad;
	private Double peso;
	private Double frecuencia_cardiaca;
	private Double frecuencia_respiratoria;
	private String color_mucosa;
	private String turgencia_piel;
	private String estado_reproductivo;
	private String estado_vacuna;
	private String estado_desparasitacion;
	
	
	
	public Integer getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getFecha_ingreso() {
		return fecha_ingreso;
	}
	public void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getParticularidad() {
		return particularidad;
	}
	public void setParticularidad(String particularidad) {
		this.particularidad = particularidad;
	}
	
	public Double getPeso() {
		return peso;
	}
	public void setPeso(Double peso) {
		this.peso = peso;
	}
	public Double getFrecuencia_cardiaca() {
		return frecuencia_cardiaca;
	}
	public void setFrecuencia_cardiaca(Double frecuencia_cardiaca) {
		this.frecuencia_cardiaca = frecuencia_cardiaca;
	}
	public Double getFrecuencia_respiratoria() {
		return frecuencia_respiratoria;
	}
	public void setFrecuencia_respiratoria(Double frecuencia_respiratoria) {
		this.frecuencia_respiratoria = frecuencia_respiratoria;
	}
	public String getColor_mucosa() {
		return color_mucosa;
	}
	public void setColor_mucosa(String color_mucosa) {
		this.color_mucosa = color_mucosa;
	}
	public String getTurgencia_piel() {
		return turgencia_piel;
	}
	public void setTurgencia_piel(String turgencia_piel) {
		this.turgencia_piel = turgencia_piel;
	}
	public String getEstado_reproductivo() {
		return estado_reproductivo;
	}
	public void setEstado_reproductivo(String estado_reproductivo) {
		this.estado_reproductivo = estado_reproductivo;
	}
	public String getEstado_vacuna() {
		return estado_vacuna;
	}
	public void setEstado_vacuna(String estado_vacuna) {
		this.estado_vacuna = estado_vacuna;
	}
	public String getEstado_desparasitacion() {
		return estado_desparasitacion;
	}
	public void setEstado_desparasitacion(String estado_desparasitacion) {
		this.estado_desparasitacion = estado_desparasitacion;
	}
	
	

}
