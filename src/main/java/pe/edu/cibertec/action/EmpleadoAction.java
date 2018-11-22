package pe.edu.cibertec.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;

import pe.edu.cibertec.bean.EmpleadoBean;
import pe.edu.cibertec.bean.TipoDocumentoBean;
import pe.edu.cibertec.dao.Impl.EmpleadoDAOImpl;
import pe.edu.cibertec.dao.Impl.TipoDocumentoDAOImpl;
import pe.edu.cibertec.service.EmpleadoService;
import pe.edu.cibertec.service.TipoDocumentoService;
import pe.edu.cibertec.service.Impl.EmpleadoServiceImpl;
import pe.edu.cibertec.service.Impl.TipoDocumentoServiceImpl;

public class EmpleadoAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private EmpleadoDAOImpl empleadoService = new EmpleadoDAOImpl();
	private TipoDocumentoDAOImpl documentoService = new TipoDocumentoDAOImpl();
	private List<EmpleadoBean> grdEmpleados;
	private List<TipoDocumentoBean> cbDocumento;
	private int rows;
	private EmpleadoBean registro = new EmpleadoBean();
	private int codigo;
	private String mensaje;
	
	private static final Log log = LogFactory.getLog(EmpleadoAction.class);

	

	@Override
	public String execute(){
		log.info("En listar empleados");
		
		try {
			this.setGrdEmpleados(empleadoService.listarTodos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	public String nuevoEmpleado() {
		log.info("En nuevo Empleado");
		
		try {
			setCbDocumento(documentoService.listarTodos());
			setRegistro(new EmpleadoBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String insertarEmpleado() {
		log.info("En insertar empleado");
		try {
			empleadoService.insertar(registro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return execute();
	}
	
	public String eliminarEmpleado() {
		log.info("En eliminar empleado");
		
		try {
			empleadoService.eliminar(codigo);
			setMensaje("Se eliminó el empleado");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
	}
	
	public String editarEmpleado() {
		log.info("En editar empleado");
		
		try {
			setCbDocumento(documentoService.listarTodos());
			setRegistro(empleadoService.consultarEmpleadoPK(codigo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String actualizarUsuario() {
		log.info("En actualizar usuario");
		
		try {
			empleadoService.actualizar(getRegistro());
			setMensaje("Se actualizó el usuario");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
		
	}

	public List<EmpleadoBean> getGrdEmpleados() {
		return grdEmpleados;
	}


	public void setGrdEmpleados(List<EmpleadoBean> grdEmpleados) {
		this.grdEmpleados = grdEmpleados;
	}


	public List<TipoDocumentoBean> getCbDocumento() {
		return cbDocumento;
	}


	public void setCbDocumento(List<TipoDocumentoBean> cbDocumento) {
		this.cbDocumento = cbDocumento;
	}


	public int getRows() {
		return rows;
	}


	public void setRows(int rows) {
		this.rows = rows;
	}


	public EmpleadoBean getRegistro() {
		return registro;
	}


	public void setRegistro(EmpleadoBean registro) {
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
