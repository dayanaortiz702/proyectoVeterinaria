package pe.edu.cibertec.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pe.edu.cibertec.bean.ProductoBean;
import pe.edu.cibertec.dao.ProductoDAO;

public class ProductoAction extends ActionSupport{
	private static final long serialVersionUID = 2139116285823340125L;
	private String descripcion, idMarca, precio_compra, idCategoria, idProveedor, idUnidad, stock_actual, stock_minimo;
	String idProducto;
	private String msg = "";
	
	ProductoDAO admin = null;

	String submitType;
	
	ResultSet rs = null;
	ProductoBean bean = null;
	List<ProductoBean> beanList = null;
	private boolean noData = false;
	int ctr = 0;

	public String RegistrarProducto() throws Exception {
		admin = new ProductoDAO();

		try {
			ctr = admin.registerProducto(descripcion, idMarca, precio_compra, idCategoria, idProveedor, idUnidad, stock_actual, stock_minimo);
			if (ctr > 0) {
				msg = "Registration Successfull";
			} else {
				msg = "Some error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "REGISTER";
	}
	
	public String ListarProducto() throws Exception {
		admin = new ProductoDAO();
		try {
			beanList = new ArrayList<ProductoBean>();
			rs = admin.report();
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					bean = new ProductoBean();
					bean.setIdProducto(rs.getInt(1));
					bean.setDescripcion(rs.getString(2));
					bean.setIdMarca(rs.getInt(3));
					bean.setPrecioCompra(rs.getDouble(4));
					bean.setIdCategoria(rs.getInt(5));
					bean.setIdProveedor(rs.getInt(6));
					bean.setIdUniMedida(rs.getInt(7));
					bean.setStockActual(rs.getInt(8));
					bean.setStockMinimo(rs.getInt(9));
					beanList.add(bean);
				}
			}
			if (i == 0) {
				noData = false;
			} else {
				noData = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "REPORT";
	}
	
	public String ActualizarProducto() throws Exception {
		
		admin = new ProductoDAO();
		try {
			if (submitType.equals("updatedata")) {
				rs = admin.detalleProducto(idProducto.trim());
				if (rs != null) {
					while (rs.next()) {
						descripcion = rs.getString("descripcion");
						idMarca = rs.getString("idMarca");
						precio_compra = rs.getString("precio_compra");
						idCategoria = rs.getString("idCategoria");
						idProveedor = rs.getString("idProveedor");
						idUnidad = rs.getString("idUniMedida");
						stock_actual = rs.getString("stock_actual");
						stock_minimo = rs.getString("stock_minimo");
						idProducto = rs.getString("idProducto");
					}
				}
			} else {
				int i = admin.updateProducto(descripcion, idMarca, precio_compra, idCategoria, idProveedor, 
											 idUnidad, stock_actual, stock_minimo, idProducto);
				if (i > 0) {
					msg = "Record Updated Successfuly";
				} else {
					msg = "error";
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return "UPDATE";
	}
	
	public String EliminarProducto() throws Exception {
		admin = new ProductoDAO();
		try {
			int isDeleted = admin.deleteProducto(idProducto);
			if (isDeleted > 0) {
				msg = "Record deleted successfully";
			} else {
				msg = "Some error";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "DELETE";
	}

	

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public String getIdMarca() {
		return idMarca;
	}

	public void setIdMarca(String idMarca) {
		this.idMarca = idMarca;
	}

	public String getPrecio_compra() {
		return precio_compra;
	}

	public void setPrecio_compra(String precio_compra) {
		this.precio_compra = precio_compra;
	}

	public String getIdCategoria() {
		return idCategoria;
	}

	public void setIdCategoria(String idCategoria) {
		this.idCategoria = idCategoria;
	}

	public String getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}

	public String getIdUnidad() {
		return idUnidad;
	}

	public void setIdUnidad(String idUnidad) {
		this.idUnidad = idUnidad;
	}

	public String getStock_actual() {
		return stock_actual;
	}

	public void setStock_actual(String stock_actual) {
		this.stock_actual = stock_actual;
	}

	public String getStock_minimo() {
		return stock_minimo;
	}

	public void setStock_minimo(String stock_minimo) {
		this.stock_minimo = stock_minimo;
	}

	public String getIdProducto() {
		return idProducto;
	}

	public void setIdProducto(String idProducto) {
		this.idProducto = idProducto;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public ProductoBean getBean() {
		return bean;
	}

	public void setBean(ProductoBean bean) {
		this.bean = bean;
	}

	public List<ProductoBean> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<ProductoBean> beanList) {
		this.beanList = beanList;
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public int getCtr() {
		return ctr;
	}

	public void setCtr(int ctr) {
		this.ctr = ctr;
	}

	
	
}
