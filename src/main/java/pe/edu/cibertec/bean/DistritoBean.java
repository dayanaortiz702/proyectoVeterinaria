package pe.edu.cibertec.bean;

import java.io.Serializable;

public class DistritoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4087062525476738020L;

	private Integer idDistrito;
	private String nombre;
	
	
	public Integer getIdDistrito() {
		return idDistrito;
	}
	public void setIdDistrito(Integer idDistrito) {
		this.idDistrito = idDistrito;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	
}
