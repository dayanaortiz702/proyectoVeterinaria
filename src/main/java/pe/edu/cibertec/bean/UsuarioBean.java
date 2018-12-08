package pe.edu.cibertec.bean;

import java.io.Serializable;

public class UsuarioBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6449746185440521665L;
	
	private Integer idUsuario;
	private String usuario;
	private String clave;
	private Integer idEstado;
	private Integer idPerfil;
	
	private EstadoBean estado;
	private PerfilBean perfil;
	
	public PerfilBean getPerfil() {
		return perfil;
	}
	public void setPerfil(PerfilBean perfil) {
		this.perfil = perfil;
	}
	public EstadoBean getEstado() {
		return estado;
	}
	public void setEstado(EstadoBean estado) {
		this.estado = estado;
	}
	public Integer getIdUsuario() {
		return idUsuario;
	}
	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public Integer getIdEstado() {
		return idEstado;
	}
	public void setIdEstado(Integer idEstado) {
		this.idEstado = idEstado;
	}
	public Integer getIdPerfil() {
		return idPerfil;
	}
	public void setIdPerfil(Integer idPerfil) {
		this.idPerfil = idPerfil;
	}
	
	
	
}
