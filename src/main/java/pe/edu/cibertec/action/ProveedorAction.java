package pe.edu.cibertec.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pe.edu.cibertec.bean.ProveedorBean;
import pe.edu.cibertec.dao.ProveedorDAO;

public class ProveedorAction extends ActionSupport{
	private static final long serialVersionUID = 2139116285823340125L;
	private String tipoDoc, documento, razonsocial, telefono, direccion;
	
	private String idProveedor;
	private String msg = "";
	ProveedorDAO admin = null;
	String submitType;
	ResultSet rs = null;
	ProveedorBean bean = null;
	List<ProveedorBean> beanList = null;
	private boolean noData = false;
	int ctr = 0;
	
	public String RegistrarProveedor() throws Exception {
		admin = new ProveedorDAO();

		try {
			ctr = admin.registerProveedor(tipoDoc, documento, razonsocial, telefono, direccion);
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
	
	public String ListarProveedor() throws Exception {
		admin = new ProveedorDAO();
		try {
			beanList = new ArrayList<ProveedorBean>();
			rs = admin.report();
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					bean = new ProveedorBean();
					bean.setIdProveedor(rs.getString("idProveedor"));
					bean.setIdTipoDocumento(rs.getString("idTipoDocumento"));
					bean.setNroDocumento(rs.getString("nroDocumento"));
					bean.setRazonSocial(rs.getString("razon_social"));
					bean.setTelefono(rs.getString("telefono"));
					bean.setDireccion(rs.getString("direccion"));
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
	
	public String EliminarProveedor() throws Exception {
		admin = new ProveedorDAO();
		try {
			int isDeleted = admin.deleteProveedor(idProveedor);
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
	
	public String ActualizarProveedor() throws Exception {
		admin = new ProveedorDAO();
		try {
			if (submitType.equals("updatedata")) {
				rs = admin.detalleProveedor(idProveedor.trim());
				if (rs != null) {
					while (rs.next()) {
						tipoDoc = rs.getString("idTipoDocumento");
						documento = rs.getString("nroDocumento");
						razonsocial = rs.getString("razon_social");
						telefono = rs.getString("telefono");
						direccion = rs.getString("direccion");
						idProveedor = rs.getString("idProveedor");
					}
				}
			} else {
				int i = admin.updateProveedor(tipoDoc, documento, razonsocial, telefono, 
										direccion, idProveedor);
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
	
	
	public String getIdProveedor() {
		return idProveedor;
	}

	public void setIdProveedor(String idProveedor) {
		this.idProveedor = idProveedor;
	}

	public ProveedorBean getBean() {
		return bean;
	}

	public void setBean(ProveedorBean bean) {
		this.bean = bean;
	}

	public String getTipoDoc() {
		return tipoDoc;
	}
	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}
	public String getDocumento() {
		return documento;
	}
	public void setDocumento(String documento) {
		this.documento = documento;
	}
	public String getRazonsocial() {
		return razonsocial;
	}
	public void setRazonsocial(String razonsocial) {
		this.razonsocial = razonsocial;
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
	
	public List<ProveedorBean> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<ProveedorBean> beanList) {
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
