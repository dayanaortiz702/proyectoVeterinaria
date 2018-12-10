package pe.edu.cibertec.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.opensymphony.xwork2.ActionSupport;
import pe.edu.cibertec.bean.DistritoBean;
import pe.edu.cibertec.service.DistritoService;
import pe.edu.cibertec.service.Impl.DistritoServiceImpl;

public class DistritoAction extends ActionSupport{
	
	private static final long serialVersionUID = 1L;
	private DistritoService distritoService = new DistritoServiceImpl();
	private List<DistritoBean> grdDistrito;
	private DistritoBean registro = new DistritoBean();
	private int codigo;
	private String mensaje;
	private static final Log log = LogFactory.getLog(DistritoAction.class);
	
	public String execute(){
		log.info("En listar distrito");
		
		try {
			this.setGrdDistrito(distritoService.listarTodos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String nuevoDistrito() {
		log.info("En nuevo distrito");
		
		try {
			setRegistro(new DistritoBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String insertarDistrito() {
		log.info("En insertar distrito");
		try {
			distritoService.insertar(registro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return execute();
	}
	
	public String eliminarDistrito() {
		log.info("En eliminar distrito");
		
		try {
			distritoService.eliminar(codigo);
			setMensaje("Se eliminó el distrito");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
	}
	
	public String editarDistrito() {
		log.info("En editar distrito");
		
		try {
			setRegistro(distritoService.consultarDistritoPK(codigo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String actualizarDistrito() {
		log.info("En actualizar distrito");
		
		try {
			distritoService.actualizar(getRegistro());
			setMensaje("Se actualizó el distrito");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
		
	}

	public DistritoService getDistritoService() {
		return distritoService;
	}

	public void setDistritoService(DistritoService distritoService) {
		this.distritoService = distritoService;
	}

	public List<DistritoBean> getGrdDistrito() {
		return grdDistrito;
	}

	public void setGrdDistrito(List<DistritoBean> grdDistrito) {
		this.grdDistrito = grdDistrito;
	}

	public DistritoBean getRegistro() {
		return registro;
	}

	public void setRegistro(DistritoBean registro) {
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
