package pe.edu.cibertec.bean;

import java.io.Serializable;

public class ProveedorBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -9154415703909363935L;
	private Integer idProveedor;
	private Integer idTipoDocumento;
	private String nroDocumento;
	private String razonSocial;
	private String telefono;
	private String direccion;
	
	private TipoDocumentoBean tipoDocumento;
	

	public TipoDocumentoBean getTipoDocumento() {
		return tipoDocumento;
	}
	public void setTipoDocumento(TipoDocumentoBean tipoDocumento) {
		this.tipoDocumento = tipoDocumento;
	}
	
	public Integer getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}
	public Integer getIdTipoDocumento() {
		return idTipoDocumento;
	}
	public void setIdTipoDocumento(Integer idTipoDocumento) {
		this.idTipoDocumento = idTipoDocumento;
	}
	public String getNroDocumento() {
		return nroDocumento;
	}
	public void setNroDocumento(String nroDocumento) {
		this.nroDocumento = nroDocumento;
	}
	public String getRazonSocial() {
		return razonSocial;
	}
	public void setRazonSocial(String razonSocial) {
		this.razonSocial = razonSocial;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	
	
}
