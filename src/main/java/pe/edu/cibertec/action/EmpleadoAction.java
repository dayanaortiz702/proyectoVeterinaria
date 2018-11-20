package pe.edu.cibertec.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pe.edu.cibertec.bean.EmpleadoBean;
import pe.edu.cibertec.bean.TipoDocumentoBean;
import pe.edu.cibertec.dao.EmpleadoDAO;
import pe.edu.cibertec.dao.TipoDocumentoDAO;

public class EmpleadoAction extends ActionSupport{

	private static final long serialVersionUID = 5461821555136363885L;
	
	private String nombres, apellidos, tipodoc, documento, telefono, correo, direccion, fecha_nac, fecha_ingreso,
					idcargo, idusuario;
	private String idEmpleado;
	private String msg = "";
	
	private List<EmpleadoBean> beanList = null;
	private List<TipoDocumentoBean> tipoList = new ArrayList<>();
	private List<String> listaPrueba;
	public List<TipoDocumentoBean> getTipoList() {
		return tipoList;
	}

	public void setTipoList(List<TipoDocumentoBean> tipoList) {
		this.tipoList = tipoList;
	}

	public TipoDocumentoDAO getAdminTipo() {
		return adminTipo;
	}

	public void setAdminTipo(TipoDocumentoDAO adminTipo) {
		this.adminTipo = adminTipo;
	}

	private ResultSet rs = null;
	private EmpleadoBean bean;
	private boolean noData = false;
	EmpleadoDAO adminRegister = null;
	EmpleadoDAO adminReport;
	EmpleadoDAO adminUpdate;
	TipoDocumentoDAO adminTipo;
	int ctr = 0;
	String submitType;
	

	@Override
	public String execute() throws Exception {
		adminRegister = new EmpleadoDAO();

		try {
			ctr = adminRegister.registerEmpleado(nombres, apellidos, tipodoc, documento, telefono, correo, direccion,
										fecha_nac, fecha_ingreso, idcargo, idusuario);
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

	public List<String> getListaPrueba() {
		return listaPrueba;
	}

	public void setListaPrueba(List<String> listaPrueba) {
		this.listaPrueba = listaPrueba;
	}

	public String listadoEmpleados() throws Exception {
		try {
			adminReport = new EmpleadoDAO();
			beanList = new ArrayList<EmpleadoBean>();
			rs = adminReport.report();
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					bean = new EmpleadoBean();
					bean.setIdEmpleado(rs.getInt("idEmpleado"));
					bean.setNombres(rs.getString("nombres"));
					bean.setApellidos(rs.getString("apellidos"));
					bean.setIdTipoDocumento(rs.getString("idTipoDocumento"));
					bean.setNroDocumento(rs.getString("nroDocumento"));
					bean.setTelefono(rs.getString("telefono"));
					bean.setCorreo(rs.getString("correo"));
					bean.setDireccion(rs.getString("direccion"));
					bean.setFecha_nac(rs.getString("fecha_nac"));
					bean.setFecha_ingreso(rs.getString("fecha_ingreso"));
					bean.setIdCargo(rs.getInt("idCargo"));
					bean.setIdUsuario(rs.getInt("idUsuario"));
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
	
	public String EliminarEmpleado() throws Exception {
		adminReport = new EmpleadoDAO();
		try {
			int isDeleted = adminReport.deleteEmpleado(idEmpleado);
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
	
	public String ActualizarEmpleado() throws Exception {
		adminUpdate = new EmpleadoDAO();
		try {
			if (submitType.equals("updatedata")) {
				rs = adminUpdate.detalleEmpleado(idEmpleado.trim());
				if (rs != null) {
					while (rs.next()) {
					
						nombres = rs.getString("nombres");
						apellidos = rs.getString("apellidos");
						tipodoc = rs.getString("idTipoDocumento");
						documento = rs.getString("nroDocumento");
						telefono = rs.getString("telefono");
						correo = rs.getString("correo");	
						direccion = rs.getString("direccion");
						fecha_nac = rs.getString("fecha_nac");
						fecha_ingreso = rs.getString("fecha_ingreso");
						idcargo = rs.getString("idCargo");	
						idusuario = rs.getString("idUsuario");
						idEmpleado = rs.getString("idEmpleado");
					}
				}
			} else {
				int i = adminUpdate.updateEmpleado(nombres, apellidos, tipodoc, documento, telefono, correo, direccion,
						fecha_nac, fecha_ingreso, idcargo, idusuario, idEmpleado);
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

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
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

	public String getIdcargo() {
		return idcargo;
	}

	public void setIdcargo(String idcargo) {
		this.idcargo = idcargo;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}



	public EmpleadoDAO getAdminRegister() {
		return adminRegister;
	}

	public void setAdminRegister(EmpleadoDAO adminRegister) {
		this.adminRegister = adminRegister;
	}

	public EmpleadoDAO getAdminReport() {
		return adminReport;
	}

	public void setAdminReport(EmpleadoDAO adminReport) {
		this.adminReport = adminReport;
	}

	public int getCtr() {
		return ctr;
	}

	public void setCtr(int ctr) {
		this.ctr = ctr;
	}

	public String getDireccion() {
		return direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getFecha_nac() {
		return fecha_nac;
	}

	public void setFecha_nac(String fecha_nac) {
		this.fecha_nac = fecha_nac;
	}

	public String getFecha_ingreso() {
		return fecha_ingreso;
	}

	public void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}

	public String getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(String idusuario) {
		this.idusuario = idusuario;
	}

	public List<EmpleadoBean> getBeanList() {
		return beanList;
	}

	public void setBeanList(List<EmpleadoBean> beanList) {
		this.beanList = beanList;
	}

	public ResultSet getRs() {
		return rs;
	}

	public void setRs(ResultSet rs) {
		this.rs = rs;
	}

	public EmpleadoBean getBean() {
		return bean;
	}

	public void setBean(EmpleadoBean bean) {
		this.bean = bean;
	}

	public boolean isNoData() {
		return noData;
	}

	public void setNoData(boolean noData) {
		this.noData = noData;
	}

	public String getTipodoc() {
		return tipodoc;
	}

	public void setTipodoc(String tipodoc) {
		this.tipodoc = tipodoc;
	}

	public String getIdEmpleado() {
		return idEmpleado;
	}

	public void setIdEmpleado(String idEmpleado) {
		this.idEmpleado = idEmpleado;
	}

	public String getSubmitType() {
		return submitType;
	}

	public void setSubmitType(String submitType) {
		this.submitType = submitType;
	}

	public EmpleadoDAO getAdminUpdate() {
		return adminUpdate;
	}

	public void setAdminUpdate(EmpleadoDAO adminUpdate) {
		this.adminUpdate = adminUpdate;
	}

	

	
}
