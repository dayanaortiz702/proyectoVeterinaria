package pe.edu.cibertec.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;

import pe.edu.cibertec.bean.MarcaBean;
import pe.edu.cibertec.service.MarcaService;
import pe.edu.cibertec.service.Impl.MarcaServiceImpl;


public class MarcaAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MarcaService marcaService = new MarcaServiceImpl();
	private List<MarcaBean> grdMarca;
	private MarcaBean registro = new MarcaBean();
	private int codigo;
	private String mensaje;
	private static final Log log = LogFactory.getLog(MarcaAction.class);
	
	public String execute(){
		log.info("En listar Marca");
		
		try {
			this.setGrdMarca(marcaService.listarTodos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String nuevoMarca() {
		log.info("En nuevo marca");
		
		try {
			setRegistro(new MarcaBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String insertarMarca() {
		log.info("En insertar marca");
		try {
			marcaService.insertar(registro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return execute();
	}
	
	public String eliminarMarca() {
		log.info("En eliminar distrito");
		
		try {
			marcaService.eliminar(codigo);
			setMensaje("Se eliminó marca");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
	}
	
	public String editarMarca() {
		log.info("En editar marca");
		
		try {
			setRegistro(marcaService.consultarMarcaPK(codigo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String actualizarMarca() {
		log.info("En actualizar marca");
		
		try {
			marcaService.actualizar(getRegistro());
			setMensaje("Se actualizó marca");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
		
	}

	public MarcaService getMarcaService() {
		return marcaService;
	}

	public void setMarcaService(MarcaService marcaService) {
		this.marcaService = marcaService;
	}

	public List<MarcaBean> getGrdMarca() {
		return grdMarca;
	}

	public void setGrdMarca(List<MarcaBean> grdMarca) {
		this.grdMarca = grdMarca;
	}

	public MarcaBean getRegistro() {
		return registro;
	}

	public void setRegistro(MarcaBean registro) {
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
