package pe.edu.cibertec.bean;

import java.io.Serializable;

public class HistoriaClinicaBean implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1657417712658968496L;
	
	private Integer idFicha;
	private String fecha;
	private String motivoConsulta;
	private Integer idTipoPaciente;
	private Integer idPaciente;
	private Integer idPropietario;
	private Integer idDistrito;
	
	private TipoPacienteBean tipoPaciente;
	private PacienteBean paciente;
	private PropietarioBean propietario;
	private DistritoBean distrito;
	
	
	
	public TipoPacienteBean getTipoPaciente() {
		return tipoPaciente;
	}
	public void setTipoPaciente(TipoPacienteBean tipoPaciente) {
		this.tipoPaciente = tipoPaciente;
	}
	public PacienteBean getPaciente() {
		return paciente;
	}
	public void setPaciente(PacienteBean paciente) {
		this.paciente = paciente;
	}
	public PropietarioBean getPropietario() {
		return propietario;
	}
	public void setPropietario(PropietarioBean propietario) {
		this.propietario = propietario;
	}
	public DistritoBean getDistrito() {
		return distrito;
	}
	public void setDistrito(DistritoBean distrito) {
		this.distrito = distrito;
	}
	public Integer getIdFicha() {
		return idFicha;
	}
	public void setIdFicha(Integer idFicha) {
		this.idFicha = idFicha;
	}
	public String getFecha() {
		return fecha;
	}
	public void setFecha(String fecha) {
		this.fecha = fecha;
	}
	public String getMotivoConsulta() {
		return motivoConsulta;
	}
	public void setMotivoConsulta(String motivoConsulta) {
		this.motivoConsulta = motivoConsulta;
	}
	public Integer getIdTipoPaciente() {
		return idTipoPaciente;
	}
	public void setIdTipoPaciente(Integer idTipoPaciente) {
		this.idTipoPaciente = idTipoPaciente;
	}
	public Integer getIdPaciente() {
		return idPaciente;
	}
	public void setIdPaciente(Integer idPaciente) {
		this.idPaciente = idPaciente;
	}
	public Integer getIdPropietario() {
		return idPropietario;
	}
	public void setIdPropietario(Integer idPropietario) {
		this.idPropietario = idPropietario;
	}
	public Integer getIdDistrito() {
		return idDistrito;
	}
	public void setIdDistrito(Integer idDistrito) {
		this.idDistrito = idDistrito;
	}
	
	

}
