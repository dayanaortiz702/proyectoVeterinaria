package pe.edu.cibertec.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import com.opensymphony.xwork2.ActionSupport;
import pe.edu.cibertec.bean.TipoDocumentoBean;
import pe.edu.cibertec.service.TipoDocumentoService;
import pe.edu.cibertec.service.Impl.TipoDocumentoServiceImpl;

public class TipoDocumentoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private TipoDocumentoService documentoService = new TipoDocumentoServiceImpl();
	private List<TipoDocumentoBean> grdDocumento;
	private TipoDocumentoBean registro = new TipoDocumentoBean();
	private int codigo;
	private String mensaje;
	private static final Log log = LogFactory.getLog(TipoDocumentoAction.class);
	
	public String execute(){
		log.info("En listar tipo documento");
		
		try {
			this.setGrdDocumento(documentoService.listarTodos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String nuevoDocumento() {
		log.info("En nuevo tipo de documento");
		
		try {
			setRegistro(new TipoDocumentoBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String insertarDocumento() {
		log.info("En insertar Documento");
		try {
			documentoService.insertar(registro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return execute();
	}
	
	public String eliminarDocumento() {
		log.info("En eliminar Documento");
		
		try {
			documentoService.eliminar(codigo);
			setMensaje("Se eliminó el Documento");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
	}
	
	public String editarDocumento() {
		log.info("En editar Documento");
		
		try {
			setRegistro(documentoService.consultarDocumentoPK(codigo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String actualizarUsuario() {
		log.info("En actualizar documento");
		
		try {
			documentoService.actualizar(getRegistro());
			setMensaje("Se actualizó el documento");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
		
	}

	public TipoDocumentoService getDocumentoService() {
		return documentoService;
	}

	public void setDocumentoService(TipoDocumentoService documentoService) {
		this.documentoService = documentoService;
	}

	public List<TipoDocumentoBean> getGrdDocumento() {
		return grdDocumento;
	}

	public void setGrdDocumento(List<TipoDocumentoBean> grdDocumento) {
		this.grdDocumento = grdDocumento;
	}

	public TipoDocumentoBean getRegistro() {
		return registro;
	}

	public void setRegistro(TipoDocumentoBean registro) {
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

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	
	
	
}
