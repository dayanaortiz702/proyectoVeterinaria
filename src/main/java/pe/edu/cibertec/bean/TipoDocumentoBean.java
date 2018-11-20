package pe.edu.cibertec.bean;

import java.io.Serializable;

public class TipoDocumentoBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5810593477739184372L;
	private Integer idTipoDocumento;
	private String descripcion;
	
	
	public Integer getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}