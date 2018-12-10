package pe.edu.cibertec.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;

import pe.edu.cibertec.bean.PacienteBean;
import pe.edu.cibertec.service.PacienteService;
import pe.edu.cibertec.service.Impl.PacienteServiceImpl;

public class PacienteAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PacienteService pacienteService = new PacienteServiceImpl();
	private List<PacienteBean> grdPaciente;
	private PacienteBean registro = new PacienteBean();
	private int codigo;
	private String mensaje;
	private static final Log log = LogFactory.getLog(PacienteAction.class);
	
	public String execute(){
		log.info("En listar paciente");
		
		try {
			this.setGrdPaciente(pacienteService.listarTodos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String nuevoPaciente() {
		log.info("En nuevo paciente");
		
		try {
			setRegistro(new PacienteBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String insertarPaciente() {
		log.info("En insertar paciente");
		try {
			pacienteService.insertar(registro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return execute();
	}
	
	public String eliminarPaciente() {
		log.info("En eliminar paciente");
		
		try {
			pacienteService.eliminar(codigo);
			setMensaje("Se eliminó paciente");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
	}
	
	public String editarPaciente() {
		log.info("En editar paciente");
		
		try {
			setRegistro(pacienteService.consultarPacientePK(codigo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String actualizarPaciente() {
		log.info("En actualizar paciente");
		
		try {
			pacienteService.actualizar(getRegistro());
			setMensaje("Se actualizó paciente");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
		
	}

	public PacienteService getPacienteService() {
		return pacienteService;
	}

	public void setPacienteService(PacienteService pacienteService) {
		this.pacienteService = pacienteService;
	}

	public List<PacienteBean> getGrdPaciente() {
		return grdPaciente;
	}

	public void setGrdPaciente(List<PacienteBean> grdPaciente) {
		this.grdPaciente = grdPaciente;
	}

	public PacienteBean getRegistro() {
		return registro;
	}

	public void setRegistro(PacienteBean registro) {
		this.registro = registro;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	
}
