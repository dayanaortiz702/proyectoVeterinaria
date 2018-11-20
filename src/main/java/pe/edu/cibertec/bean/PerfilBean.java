package pe.edu.cibertec.bean;

import java.io.Serializable;

public class PerfilBean implements Serializable{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7239608766720570688L;
	private Integer idPerfil;
	private String perfil;
	private String descripcion;
	
	
	
	public Integer getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
	public String getPerfil() {
		return perfil;
	}
	public void setPerfil(String perfil) {
		this.perfil = perfil;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	
	
}
