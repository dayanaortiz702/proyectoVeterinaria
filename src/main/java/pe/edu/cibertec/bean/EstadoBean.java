package pe.edu.cibertec.bean;

import java.io.Serializable;

public class EstadoBean implements Serializable{	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer idEstado;
	private String descripcion;
	
	public Integer getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
	
}
