package pe.edu.cibertec.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;

import pe.edu.cibertec.bean.CargoBean;
import pe.edu.cibertec.service.CargoService;
import pe.edu.cibertec.service.Impl.CargoServiceImpl;

public class CargoAction extends ActionSupport{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private CargoService cargoService = new CargoServiceImpl();
	private List<CargoBean> grdDocumento;
	private CargoBean registro = new CargoBean();
	private int codigo;
	private String mensaje;
	private static final Log log = LogFactory.getLog(CargoAction.class);
	
	public String execute(){
		log.info("En listar cargo");
		
		try {
			this.setGrdDocumento(cargoService.listarTodos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String nuevoCargo() {
		log.info("En nuevo cargo");
		
		try {
			setRegistro(new CargoBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String insertarCargo() {
		log.info("En insertar cargo");
		try {
			cargoService.insertar(registro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return execute();
	}
	
	public String eliminarCargo() {
		log.info("En eliminar cargo");
		
		try {
			cargoService.eliminar(codigo);
			setMensaje("Se eliminó el cargo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
	}
	
	public String editarCargo() {
		log.info("En editar cargo");
		
		try {
			setRegistro(cargoService.consultarCargoPK(codigo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String actualizarCargo() {
		log.info("En actualizar cargo");
		
		try {
			cargoService.actualizar(getRegistro());
			setMensaje("Se actualizó el cargo");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
		
	}
	
	
	public List<CargoBean> getGrdDocumento() {
		return grdDocumento;
	}
	public void setGrdDocumento(List<CargoBean> grdDocumento) {
		this.grdDocumento = grdDocumento;
	}
	public CargoBean getRegistro() {
		return registro;
	}
	public void setRegistro(CargoBean registro) {
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
