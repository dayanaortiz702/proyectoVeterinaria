package pe.edu.cibertec.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;

import pe.edu.cibertec.bean.ProveedorBean;
import pe.edu.cibertec.bean.TipoDocumentoBean;
import pe.edu.cibertec.service.ProveedorService;
import pe.edu.cibertec.service.TipoDocumentoService;
import pe.edu.cibertec.service.Impl.ProveedorServiceImpl;
import pe.edu.cibertec.service.Impl.TipoDocumentoServiceImpl;


public class ProveedorAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProveedorService proveedorService = new ProveedorServiceImpl();
	private TipoDocumentoService tipoService = new TipoDocumentoServiceImpl();
	
	private List<ProveedorBean> grdProveedor;
	private List<TipoDocumentoBean> cbTipoDoc;
	
	private int rows;
	private ProveedorBean registro = new ProveedorBean();
	private int codigo;
	private String mensaje;
	
	private static final Log log = LogFactory.getLog(ProveedorAction.class);
	
	
	@Override
	public String execute(){
		log.info("En listar proveedor");
		
		try {
			this.setGrdProveedor(proveedorService.listarTodos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	public String nuevoProveedor() {
		log.info("En nuevo proveedor");
		
		try {
			setCbTipoDoc(tipoService.listarTodos());
			
			setRegistro(new ProveedorBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String insertarProveedor() {
		log.info("En insertar Proveedor");
		try {
			proveedorService.insertar(registro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return execute();
	}
	
	public String eliminarProveedor() {
		log.info("En eliminar Proveedor");
		
		try {
			proveedorService.eliminar(codigo);
			setMensaje("Se eliminó propietario");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
	}
	
	public String editarProveedor() {
		log.info("En editar Proveedor");
		
		try {
			setCbTipoDoc(tipoService.listarTodos());
			
			setRegistro(new ProveedorBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String actualizarProveedor() {
		log.info("En actualizar Proveedor");
		
		try {
			proveedorService.actualizar(getRegistro());
			setMensaje("Se actualizó Proveedor");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
		
	}

	public ProveedorService getProveedorService() {
		return proveedorService;
	}

	public void setProveedorService(ProveedorService proveedorService) {
		this.proveedorService = proveedorService;
	}

	public TipoDocumentoService getTipoService() {
		return tipoService;
	}

	public void setTipoService(TipoDocumentoService tipoService) {
		this.tipoService = tipoService;
	}

	public List<ProveedorBean> getGrdProveedor() {
		return grdProveedor;
	}

	public void setGrdProveedor(List<ProveedorBean> grdProveedor) {
		this.grdProveedor = grdProveedor;
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

	public ProveedorBean getRegistro() {
		return registro;
	}

	public void setRegistro(ProveedorBean registro) {
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
