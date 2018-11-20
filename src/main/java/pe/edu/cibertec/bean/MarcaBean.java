package pe.edu.cibertec.bean;

import java.io.Serializable;

public class MarcaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7609200253623462540L;
	private Integer idMarca;
	private String descripcion;
	
	public Integer getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
