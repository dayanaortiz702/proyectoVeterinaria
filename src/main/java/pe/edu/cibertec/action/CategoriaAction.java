package pe.edu.cibertec.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;

import pe.edu.cibertec.bean.CategoriaBean;
import pe.edu.cibertec.service.CategoriaService;
import pe.edu.cibertec.service.Impl.CategoriaServiceImpl;

public class CategoriaAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CategoriaService categoriaService = new CategoriaServiceImpl();
	private List<CategoriaBean> grdCategoria;
	private CategoriaBean registro = new CategoriaBean();
	private int codigo;
	private String mensaje;
	private static final Log log = LogFactory.getLog(CategoriaAction.class);
	
	public String execute(){
		log.info("En listar categoria");
		
		try {
			this.setGrdCategoria(categoriaService.listarTodos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String nuevoCategoria() {
		log.info("En nuevo categoria");
		
		try {
			setRegistro(new CategoriaBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String insertarCategoria() {
		log.info("En insertar categoria");
		try {
			categoriaService.insertar(registro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return execute();
	}
	
	public String eliminarCategoria() {
		log.info("En eliminar categoria");
		
		try {
			categoriaService.eliminar(codigo);
			setMensaje("Se eliminó categoria");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
	}
	
	public String editarCategoria() {
		log.info("En editar categoria");
		
		try {
			setRegistro(categoriaService.consultarCategoriaPK(codigo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String actualizarCategoria() {
		log.info("En actualizar categoria");
		
		try {
			categoriaService.actualizar(getRegistro());
			setMensaje("Se actualizó el categoria");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
		
	}

	public CategoriaService getCategoriaService() {
		return categoriaService;
	}

	public void setCategoriaService(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	public List<CategoriaBean> getGrdCategoria() {
		return grdCategoria;
	}

	public void setGrdCategoria(List<CategoriaBean> grdCategoria) {
		this.grdCategoria = grdCategoria;
	}

	public CategoriaBean getRegistro() {
		return registro;
	}

	public void setRegistro(CategoriaBean registro) {
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
