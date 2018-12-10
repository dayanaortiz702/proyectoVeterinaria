package pe.edu.cibertec.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;

import pe.edu.cibertec.bean.EstadoBean;
import pe.edu.cibertec.service.EstadoService;
import pe.edu.cibertec.service.Impl.EstadoServiceImpl;

public class EstadoAction extends ActionSupport{
	private static final long serialVersionUID = 1L;
	private EstadoService estadoService = new EstadoServiceImpl();
	private List<EstadoBean> grdEstado;
	private EstadoBean registro = new EstadoBean();
	private int codigo;
	private String mensaje;
	private static final Log log = LogFactory.getLog(EstadoAction.class);
	
	public String execute(){
		log.info("En listar estado");
		
		try {
			this.setGrdEstado(estadoService.listarTodos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String nuevoEstado() {
		log.info("En nuevo estado");
		
		try {
			setRegistro(new EstadoBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String insertarEstado() {
		log.info("En insertar estado");
		try {
			estadoService.insertar(registro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return execute();
	}
	
	public String eliminarEstado() {
		log.info("En eliminar estado");
		
		try {
			estadoService.eliminar(codigo);
			setMensaje("Se eliminó el estado");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
	}
	
	public String editarEstado() {
		log.info("En editar distrito");
		
		try {
			setRegistro(estadoService.consultarEstadoPK(codigo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String actualizarEstado() {
		log.info("En actualizar distrito");
		
		try {
			estadoService.actualizar(getRegistro());
			setMensaje("Se actualizó el distrito");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
		
	}

	public EstadoService getEstadoService() {
		return estadoService;
	}

	public void setEstadoService(EstadoService estadoService) {
		this.estadoService = estadoService;
	}

	public List<EstadoBean> getGrdEstado() {
		return grdEstado;
	}

	public void setGrdEstado(List<EstadoBean> grdEstado) {
		this.grdEstado = grdEstado;
	}

	public EstadoBean getRegistro() {
		return registro;
	}

	public void setRegistro(EstadoBean registro) {
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
