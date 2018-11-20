package pe.edu.cibertec.bean;

import java.io.Serializable;

public class UnidadMedidaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -7325197906524192896L;
	
	private Integer idUniMedida;
	private String descripcion;
	
	
	public Integer getIdUniMedida() {
		return idUniMedida;
	}
	public void setIdUniMedida(Integer idUniMedida) {
		this.idUniMedida = idUniMedida;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	

}
