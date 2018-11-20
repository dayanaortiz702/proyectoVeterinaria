package pe.edu.cibertec.action;


import java.sql.ResultSet;
import java.util.List;
import java.util.ArrayList;

import pe.edu.cibertec.bean.PropietarioBean;
import pe.edu.cibertec.bean.TipoDocumentoBean;
import pe.edu.cibertec.dao.PropietarioDAO;

import com.opensymphony.xwork2.ActionSupport;

public class PropietarioAction extends ActionSupport {
	
	
	private static final long serialVersionUID = 2139116285823340125L;
	
	private String nombres, apellidos, telefono, correo, tipoDoc, documento;
	private String idPropietario;
	private String msg = "";
	PropietarioDAO admin = null;
	PropietarioDAO admin1 = new PropietarioDAO();
	PropietarioDAO admin2 = new PropietarioDAO();
	PropietarioDAO admin3 = new PropietarioDAO();	
	
	private List<TipoDocumentoBean> lstTipoDoc;
	
	int ctr = 0;
	String submitType;
	
	ResultSet rs = null;
	PropietarioBean bean = null;
	List<PropietarioBean> beanList = null;
	private boolean noData = false;
	
	public String RegistrarPropietario() throws Exception {
		admin = new PropietarioDAO();

		try {
			ctr = admin.registerPropietario(nombres, apellidos, telefono, correo, tipoDoc, documento);
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
	

	public String ListarPropietario() throws Exception {
		try {
			beanList = new ArrayList<PropietarioBean>();
			rs = admin1.reportPropietario();
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					bean = new PropietarioBean();
					bean.setIdPropietario(rs.getInt("idPropietario"));
					bean.setNombres(rs.getString("nombres"));
					bean.setApellidos(rs.getString("apellidos"));
					bean.setTelefono(rs.getString("telefono"));
					bean.setCorreo(rs.getString("correo"));
					bean.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
					bean.setNroDocumento(rs.getString("nroDocumento"));
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
	
	
	public String EliminarPropietario() throws Exception {
		try {
			int isDeleted = admin2.deletePropietario(idPropietario);
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
	
	public String ActualizarPropietario() throws Exception {
		try {
			if (submitType.equals("updatedata")) {
				rs = admin3.detallePropietario(idPropietario.trim());
				if (rs != null) {
					while (rs.next()) {
						nombres = rs.getString("nombres");
						apellidos = rs.getString("apellidos");
						telefono = rs.getString("telefono");
						correo = rs.getString("correo");
						tipoDoc = rs.getString("idTipoDocumento");
						documento = rs.getString("nroDocumento");
						idPropietario = rs.getString("idPropietario");
					}
				}
			} else {
				int i = admin3.updatePropietario(telefono, correo, idPropietario);
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
	

	public List<TipoDocumentoBean> getLstTipoDoc() {
		return lstTipoDoc;
	}

	public void setLstTipoDoc(List<TipoDocumentoBean> lstTipoDoc) {
		this.lstTipoDoc = lstTipoDoc;
	}
	
	public String getNombres() {
		return nombres;
	}
	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
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
	public String getIdPropietario() {
		return idPropietario;
	}
	public void setIdPropietario(String idPropietario) {
		this.idPropietario = idPropietario;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
	
	public PropietarioBean getBean() {
		return bean;
	}

	public void setBean(PropietarioBean bean) {
		this.bean = bean;
	}

	public int getCtr() {
		return ctr;
	}
	public void setCtr(int ctr) {
		this.ctr = ctr;
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
	public List<PropietarioBean> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<PropietarioBean> beanList) {
		this.beanList = beanList;
	}
	public boolean isNoData() {
		return noData;
	}
	public void setNoData(boolean noData) {
		this.noData = noData;
	}
	

	
	
	
	
	
	
}
