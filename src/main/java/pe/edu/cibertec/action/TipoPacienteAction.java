package pe.edu.cibertec.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;

import pe.edu.cibertec.bean.TipoPacienteBean;
import pe.edu.cibertec.service.TipoPacienteService;
import pe.edu.cibertec.service.Impl.TipoPacienteServiceImpl;

public class TipoPacienteAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private TipoPacienteService tipoPacienteService = new TipoPacienteServiceImpl();
	private List<TipoPacienteBean> grdTipoPaciente;
	private TipoPacienteBean registro = new TipoPacienteBean();
	private int codigo;
	private String mensaje;
	private static final Log log = LogFactory.getLog(TipoPacienteAction.class);
	
	public String execute(){
		log.info("En listar tipo documento");
		
		try {
			this.setGrdTipoPaciente(tipoPacienteService.listarTodos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String nuevoTipoPaciente() {
		log.info("En nuevo tipo de paciente");
		
		try {
			setRegistro(new TipoPacienteBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String insertarTipoPaciente() {
		log.info("En insertar tipo paciente");
		try {
			tipoPacienteService.insertar(registro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return execute();
	}
	
	public String eliminarTipoPaciente() {
		log.info("En eliminar tipo paciente");
		
		try {
			tipoPacienteService.eliminar(codigo);
			setMensaje("Se eliminó el tipo paciente");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
	}
	
	public String editarTipoPaciente() {
		log.info("En editar tipo paciente");
		
		try {
			setRegistro(tipoPacienteService.consultarTipoPacientePK(codigo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String actualizarTipoPaciente() {
		log.info("En actualizar tipo paciente");
		
		try {
			tipoPacienteService.actualizar(getRegistro());
			setMensaje("Se actualizó el tipo de paciente");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
		
	}

	public TipoPacienteService getTipoPacienteService() {
		return tipoPacienteService;
	}

	public void setTipoPacienteService(TipoPacienteService tipoPacienteService) {
		this.tipoPacienteService = tipoPacienteService;
	}

	public List<TipoPacienteBean> getGrdTipoPaciente() {
		return grdTipoPaciente;
	}

	public void setGrdTipoPaciente(List<TipoPacienteBean> grdTipoPaciente) {
		this.grdTipoPaciente = grdTipoPaciente;
	}

	public TipoPacienteBean getRegistro() {
		return registro;
	}

	public void setRegistro(TipoPacienteBean registro) {
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
