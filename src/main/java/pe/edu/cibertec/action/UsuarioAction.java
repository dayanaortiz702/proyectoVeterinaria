package pe.edu.cibertec.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;

import pe.edu.cibertec.bean.EstadoBean;
import pe.edu.cibertec.bean.PerfilBean;
import pe.edu.cibertec.bean.UsuarioBean;
import pe.edu.cibertec.service.EstadoService;
import pe.edu.cibertec.service.PerfilService;
import pe.edu.cibertec.service.UsuarioService;
import pe.edu.cibertec.service.Impl.EstadoServiceImpl;
import pe.edu.cibertec.service.Impl.PerfilServiceImpl;
import pe.edu.cibertec.service.Impl.UsuarioServiceImpl;


public class UsuarioAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private UsuarioService usuarioService = new UsuarioServiceImpl();
	private PerfilService perfilService = new PerfilServiceImpl();
	private EstadoService estadoService = new EstadoServiceImpl();
	
	private List<UsuarioBean> grdUsuario;
	private List<PerfilBean> cbPerfil;
	private List<EstadoBean> cbEstado;
	
	private int rows;
	private UsuarioBean registro = new UsuarioBean();
	private int codigo;
	private String mensaje;
	
	private static final Log log = LogFactory.getLog(UsuarioAction.class);
	
	
	@Override
	public String execute(){
		log.info("En listar usuario");
		
		try {
			this.setGrdUsuario(usuarioService.listarTodos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	public String nuevoUsuario() {
		log.info("En nuevo usuario");
		
		try {
			setCbPerfil(perfilService.listarTodos());
			setCbEstado(estadoService.listarTodos());
			
			setRegistro(new UsuarioBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String insertarUsuario() {
		log.info("En insertar usuario");
		try {
			usuarioService.insertar(registro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return execute();
	}
	
	public String eliminarUsuario() {
		log.info("En eliminar usuario");
		
		try {
			usuarioService.eliminar(codigo);
			setMensaje("Se eliminó usuario");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
	}
	
	public String editarUsuario() {
		log.info("En editar usuario");
		
		try {
			setCbPerfil(perfilService.listarTodos());
			setCbEstado(estadoService.listarTodos());
			
			setRegistro(new UsuarioBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String actualizarUsuario() {
		log.info("En actualizar usuario");
		
		try {
			usuarioService.actualizar(getRegistro());
			setMensaje("Se actualizó usuario");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
		
	}

	public UsuarioService getUsuarioService() {
		return usuarioService;
	}

	public void setUsuarioService(UsuarioService usuarioService) {
		this.usuarioService = usuarioService;
	}

	public PerfilService getPerfilService() {
		return perfilService;
	}

	public void setPerfilService(PerfilService perfilService) {
		this.perfilService = perfilService;
	}

	public EstadoService getEstadoService() {
		return estadoService;
	}

	public void setEstadoService(EstadoService estadoService) {
		this.estadoService = estadoService;
	}

	public List<UsuarioBean> getGrdUsuario() {
		return grdUsuario;
	}

	public void setGrdUsuario(List<UsuarioBean> grdUsuario) {
		this.grdUsuario = grdUsuario;
	}

	public List<PerfilBean> getCbPerfil() {
		return cbPerfil;
	}

	public void setCbPerfil(List<PerfilBean> cbPerfil) {
		this.cbPerfil = cbPerfil;
	}

	public List<EstadoBean> getCbEstado() {
		return cbEstado;
	}

	public void setCbEstado(List<EstadoBean> cbEstado) {
		this.cbEstado = cbEstado;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public UsuarioBean getRegistro() {
		return registro;
	}

	public void setRegistro(UsuarioBean registro) {
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
