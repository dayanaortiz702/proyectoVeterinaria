package pe.edu.cibertec.bean;

import java.io.Serializable;

public class ProductoBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 6689975047977130168L;
	
	private Integer idProducto;
	private String descripcion;
	private Integer idMarca;
	private Double precioCompra;
	private Integer idCategoria;
	private Integer idProveedor;
	private Integer idUniMedida;
	private Integer stockActual;
	private Integer stockMinimo;
	
	public Integer getIdProducto() {
		return idProducto;
	}
	public void setIdProducto(Integer idProducto) {
		this.idProducto = idProducto;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public Integer getIdMarca() {
		return idMarca;
	}
	public void setIdMarca(Integer idMarca) {
		this.idMarca = idMarca;
	}
	public Double getPrecioCompra() {
		return precioCompra;
	}
	public void setPrecioCompra(Double precioCompra) {
		this.precioCompra = precioCompra;
	}
	public Integer getIdCategoria() {
		return idCategoria;
	}
	public void setIdCategoria(Integer idCategoria) {
		this.idCategoria = idCategoria;
	}
	public Integer getIdProveedor() {
		return idProveedor;
	}
	public void setIdProveedor(Integer idProveedor) {
		this.idProveedor = idProveedor;
	}
	public Integer getIdUniMedida() {
		return idUniMedida;
	}
	public void setIdUniMedida(Integer idUniMedida) {
		this.idUniMedida = idUniMedida;
	}
	public Integer getStockActual() {
		return stockActual;
	}
	public void setStockActual(Integer stockActual) {
		this.stockActual = stockActual;
	}
	public Integer getStockMinimo() {
		return stockMinimo;
	}
	public void setStockMinimo(Integer stockMinimo) {
		this.stockMinimo = stockMinimo;
	}
	
	
}
