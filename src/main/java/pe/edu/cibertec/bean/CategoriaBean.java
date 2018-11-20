package pe.edu.cibertec.bean;

import java.io.Serializable;

public class CategoriaBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5653033091949830915L;
	
	private Integer idCategoria;
	private String categoria;
	
	public int getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(int idCategoria) {
		this.idCategoria = idCategoria;
	}
	public String getCategoria() {
		return categoria;
	}
	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}
	
	
	
}
