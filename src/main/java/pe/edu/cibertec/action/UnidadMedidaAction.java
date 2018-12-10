package pe.edu.cibertec.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;

import pe.edu.cibertec.bean.UnidadMedidaBean;
import pe.edu.cibertec.service.UnidadMedidaService;
import pe.edu.cibertec.service.Impl.UnidadMedidaServiceImpl;

public class UnidadMedidaAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private UnidadMedidaService unidadService = new UnidadMedidaServiceImpl();
	private List<UnidadMedidaBean> grdUnidad;
	private UnidadMedidaBean registro = new UnidadMedidaBean();
	private int codigo;
	private String mensaje;
	private static final Log log = LogFactory.getLog(UnidadMedidaAction.class);
	
	public String execute(){
		log.info("En listar unidad medida");
		
		try {
			this.setGrdUnidad(unidadService.listarTodos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String nuevoUnidad() {
		log.info("En nuevo unidad medida");
		
		try {
			setRegistro(new UnidadMedidaBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String insertarUnidad() {
		log.info("En insertar unidad medida");
		try {
			unidadService.insertar(registro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return execute();
	}
	
	public String eliminarUnidad() {
		log.info("En eliminar unidad medida");
		
		try {
			unidadService.eliminar(codigo);
			setMensaje("Se eliminó unidad medida");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
	}
	
	public String editarUnidad() {
		log.info("En editar unidad medida");
		
		try {
			setRegistro(unidadService.consultarUnidadMedidaPK(codigo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String actualizarUnidad() {
		log.info("En actualizar unidad medida");
		
		try {
			unidadService.actualizar(getRegistro());
			setMensaje("Se actualizó unidad medida");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
		
	}

	public UnidadMedidaService getUnidadService() {
		return unidadService;
	}

	public void setUnidadService(UnidadMedidaService unidadService) {
		this.unidadService = unidadService;
	}

	public List<UnidadMedidaBean> getGrdUnidad() {
		return grdUnidad;
	}

	public void setGrdUnidad(List<UnidadMedidaBean> grdUnidad) {
		this.grdUnidad = grdUnidad;
	}

	public UnidadMedidaBean getRegistro() {
		return registro;
	}

	public void setRegistro(UnidadMedidaBean registro) {
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
