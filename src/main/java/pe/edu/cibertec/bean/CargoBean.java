package pe.edu.cibertec.bean;

import java.io.Serializable;

public class CargoBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8890086058181689533L;
	private Integer idCargo;
	private String nombre;
	
	public Integer getIdCargo() {
		return idCargo;
	}
	public void setIdCargo(Integer idCargo) {
		this.idCargo = idCargo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
}
