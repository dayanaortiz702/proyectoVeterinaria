package pe.edu.cibertec.bean;

import java.io.Serializable;

public class TipoPacienteBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 4852395589097306934L;
	private Integer idTipo;
	private String tipo;	
	
	public Integer getIdTipo() {
		return idTipo;
	}
	public void setIdTipo(Integer idTipo) {
		this.idTipo = idTipo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	
}
