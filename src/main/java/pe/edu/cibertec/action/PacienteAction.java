package pe.edu.cibertec.action;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.edu.cibertec.bean.PacienteBean;
import pe.edu.cibertec.dao.PacienteDAO;

import com.opensymphony.xwork2.ActionSupport;

public class PacienteAction extends ActionSupport{

	private static final long serialVersionUID = 2139116285823340125L;
	
	private String nombre, fecha_nacimiento, fecha_ingreso, sexo, color, particularidad, peso,frecuencia_cardiaca,
			frecuencia_respiratoria, color_mucosa, turgencia_piel, estado_reproductivo, estado_vacuna, estado_desparasitacion;
	private String idPaciente;
	private String msg = "";
	
	PacienteDAO admin = null;

	String submitType;
	
	ResultSet rs = null;
	PacienteBean bean = null;
	List<PacienteBean> beanList = null;
	
	private boolean noData = false;
	int ctr = 0;
	
	public String RegistrarPaciente() throws Exception {
		admin = new PacienteDAO();

		try {
			ctr = admin.registerPaciente(nombre, fecha_nacimiento, fecha_ingreso, sexo, color, particularidad, peso,
										 frecuencia_cardiaca, frecuencia_respiratoria, color_mucosa, turgencia_piel, 
										 estado_reproductivo, estado_vacuna, estado_desparasitacion);
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
	
	public String ListarPaciente() throws Exception {
		admin = new PacienteDAO();
		try {
			beanList = new ArrayList<PacienteBean>();
			rs = admin.reportPaciente();
			int i = 0;
			if (rs != null) {
				while (rs.next()) {
					i++;
					bean = new PacienteBean();
					bean.setIdPaciente(rs.getInt("idPaciente"));
					bean.setNombre(rs.getString("nombre"));
					bean.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
					bean.setFecha_ingreso(rs.getString("fecha_ingreso"));
					bean.setSexo(rs.getString("sexo"));
					bean.setColor(rs.getString("color"));
					bean.setParticularidad(rs.getString("particularidad"));
					bean.setPeso(rs.getString("peso"));		
					bean.setFrecuencia_cardiaca(rs.getString("frecuencia_cardiaca"));
					bean.setFrecuencia_respiratoria(rs.getString("frecuencia_respiratoria"));
					bean.setColor_mucosa(rs.getString("color_mucosa"));
					bean.setTurgencia_piel(rs.getString("turgencia_piel"));
					bean.setEstado_reproductivo(rs.getString("estado_reproductivo"));	
					bean.setEstado_vacuna(rs.getString("estado_vacuna"));
					bean.setEstado_desparasitacion(rs.getString("estado_desparasitacion"));
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
	
	
	public String EliminarPaciente() throws Exception {
		admin = new PacienteDAO();
		try {
			int isDeleted = admin.deletePaciente(idPaciente);
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
	
	public String ActualizarPaciente() throws Exception {
		admin = new PacienteDAO();
		try {
			if (submitType.equals("updatedata")) {
				rs = admin.detallePaciente(idPaciente);
				if (rs != null) {
					while (rs.next()) {
						
						color = rs.getString("color");
						particularidad = rs.getString("particularidad");
						peso = rs.getString("peso");			
						turgencia_piel = rs.getString("turgencia_piel");
						estado_reproductivo = rs.getString("estado_reproductivo");
						idPaciente = rs.getString("idPaciente");
					}
				}
			} else {
				int i = admin.updatePaciente(color, particularidad, peso, 
						 turgencia_piel, estado_reproductivo, idPaciente );
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

	
	
	public String getFrecuencia_cardiaca() {
		return frecuencia_cardiaca;
	}

	public void setFrecuencia_cardiaca(String frecuencia_cardiaca) {
		this.frecuencia_cardiaca = frecuencia_cardiaca;
	}

	public String getFrecuencia_respiratoria() {
		return frecuencia_respiratoria;
	}

	public void setFrecuencia_respiratoria(String frecuencia_respiratoria) {
		this.frecuencia_respiratoria = frecuencia_respiratoria;
	}

	public String getColor_mucosa() {
		return color_mucosa;
	}

	public void setColor_mucosa(String color_mucosa) {
		this.color_mucosa = color_mucosa;
	}

	public String getEstado_vacuna() {
		return estado_vacuna;
	}

	public void setEstado_vacuna(String estado_vacuna) {
		this.estado_vacuna = estado_vacuna;
	}

	public String getEstado_desparasitacion() {
		return estado_desparasitacion;
	}

	public void setEstado_desparasitacion(String estado_desparasitacion) {
		this.estado_desparasitacion = estado_desparasitacion;
	}

	public PacienteBean getBean() {
		return bean;
	}

	public void setBean(PacienteBean bean) {
		this.bean = bean;
	}

	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getFecha_nacimiento() {
		return fecha_nacimiento;
	}
	public void setFecha_nacimiento(String fecha_nacimiento) {
		this.fecha_nacimiento = fecha_nacimiento;
	}
	public String getFecha_ingreso() {
		return fecha_ingreso;
	}
	public void setFecha_ingreso(String fecha_ingreso) {
		this.fecha_ingreso = fecha_ingreso;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public String getParticularidad() {
		return particularidad;
	}
	public void setParticularidad(String particularidad) {
		this.particularidad = particularidad;
	}
	public String getPeso() {
		return peso;
	}
	public void setPeso(String peso) {
		this.peso = peso;
	}
	public String getTurgencia_piel() {
		return turgencia_piel;
	}
	public void setTurgencia_piel(String turgencia_piel) {
		this.turgencia_piel = turgencia_piel;
	}
	public String getEstado_reproductivo() {
		return estado_reproductivo;
	}
	public void setEstado_reproductivo(String estado_reproductivo) {
		this.estado_reproductivo = estado_reproductivo;
	}
	public String getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(String idPaciente) {
		this.idPaciente = idPaciente;
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
	public List<PacienteBean> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<PacienteBean> beanList) {
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

