package pe.edu.cibertec.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;

import pe.edu.cibertec.bean.PerfilBean;
import pe.edu.cibertec.service.PerfilService;
import pe.edu.cibertec.service.Impl.PerfilServiceImpl;

public class PerfilAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private PerfilService perfilService = new PerfilServiceImpl();
	private List<PerfilBean> grdPerfil;
	private PerfilBean registro = new PerfilBean();
	private int codigo;
	private String mensaje;
	private static final Log log = LogFactory.getLog(PerfilAction.class);
	
	public String execute(){
		log.info("En listar perfil");
		
		try {
			this.setGrdPerfil(perfilService.listarTodos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String nuevoPerfil() {
		log.info("En nuevo perfil");
		
		try {
			setRegistro(new PerfilBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String insertarPerfil() {
		log.info("En insertar perfil");
		try {
			perfilService.insertar(registro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return execute();
	}
	
	public String eliminarPerfil() {
		log.info("En eliminar perfil");
		
		try {
			perfilService.eliminar(codigo);
			setMensaje("Se eliminó perfil");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
	}
	
	public String editarPerfil() {
		log.info("En editar perfil");
		
		try {
			setRegistro(perfilService.consultarPerfilPK(codigo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String actualizarPerfil() {
		log.info("En actualizar perfil");
		
		try {
			perfilService.actualizar(getRegistro());
			setMensaje("Se actualizó perfil");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
		
	}

	public PerfilService getPerfilService() {
		return perfilService;
	}

	public void setPerfilService(PerfilService perfilService) {
		this.perfilService = perfilService;
	}

	public List<PerfilBean> getGrdPerfil() {
		return grdPerfil;
	}

	public void setGrdPerfil(List<PerfilBean> grdPerfil) {
		this.grdPerfil = grdPerfil;
	}

	public PerfilBean getRegistro() {
		return registro;
	}

	public void setRegistro(PerfilBean registro) {
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
