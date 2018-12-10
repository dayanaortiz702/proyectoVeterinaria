package pe.edu.cibertec.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;

import pe.edu.cibertec.bean.PropietarioBean;
import pe.edu.cibertec.bean.TipoDocumentoBean;
import pe.edu.cibertec.service.PropietarioService;
import pe.edu.cibertec.service.TipoDocumentoService;
import pe.edu.cibertec.service.Impl.PropietarioServiceImpl;
import pe.edu.cibertec.service.Impl.TipoDocumentoServiceImpl;


public class PropietarioAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private PropietarioService propietarioService = new PropietarioServiceImpl();
	private TipoDocumentoService tipoService = new TipoDocumentoServiceImpl();
	
	private List<PropietarioBean> grdPropietario;
	private List<TipoDocumentoBean> cbTipoDoc;
	
	private int rows;
	private PropietarioBean registro = new PropietarioBean();
	private int codigo;
	private String mensaje;
	
	private static final Log log = LogFactory.getLog(PropietarioAction.class);
	
	
	@Override
	public String execute(){
		log.info("En listar propietario");
		
		try {
			this.setGrdPropietario(propietarioService.listarTodos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	public String nuevoPropietario() {
		log.info("En nuevo propietario");
		
		try {
			setCbTipoDoc(tipoService.listarTodos());
			
			setRegistro(new PropietarioBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String insertarPropietario() {
		log.info("En insertar propietario");
		try {
			propietarioService.insertar(registro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return execute();
	}
	
	public String eliminarPropietario() {
		log.info("En eliminar propietario");
		
		try {
			propietarioService.eliminar(codigo);
			setMensaje("Se eliminó propietario");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
	}
	
	public String editarPropietario() {
		log.info("En editar Propietario");
		
		try {
			setCbTipoDoc(tipoService.listarTodos());
			
			setRegistro(new PropietarioBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String actualizarPropietario() {
		log.info("En actualizar Propietario");
		
		try {
			propietarioService.actualizar(getRegistro());
			setMensaje("Se actualizó Propietario");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
		
	}

	public PropietarioService getPropietarioService() {
		return propietarioService;
	}

	public void setPropietarioService(PropietarioService propietarioService) {
		this.propietarioService = propietarioService;
	}


	public TipoDocumentoService getTipoService() {
		return tipoService;
	}

	public void setTipoService(TipoDocumentoService tipoService) {
		this.tipoService = tipoService;
	}

	public List<PropietarioBean> getGrdPropietario() {
		return grdPropietario;
	}

	public void setGrdPropietario(List<PropietarioBean> grdPropietario) {
		this.grdPropietario = grdPropietario;
	}

	public List<TipoDocumentoBean> getCbTipoDoc() {
		return cbTipoDoc;
	}

	public void setCbTipoDoc(List<TipoDocumentoBean> cbTipoDoc) {
		this.cbTipoDoc = cbTipoDoc;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public PropietarioBean getRegistro() {
		return registro;
	}

	public void setRegistro(PropietarioBean registro) {
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
