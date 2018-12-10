package pe.edu.cibertec.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;

import pe.edu.cibertec.bean.DistritoBean;
import pe.edu.cibertec.bean.HistoriaClinicaBean;
import pe.edu.cibertec.bean.PacienteBean;
import pe.edu.cibertec.bean.PropietarioBean;
import pe.edu.cibertec.bean.TipoPacienteBean;
import pe.edu.cibertec.service.DistritoService;
import pe.edu.cibertec.service.HistoriaClinicaService;
import pe.edu.cibertec.service.PacienteService;
import pe.edu.cibertec.service.PropietarioService;
import pe.edu.cibertec.service.TipoPacienteService;
import pe.edu.cibertec.service.Impl.DistritoServiceImpl;
import pe.edu.cibertec.service.Impl.HistoriaClinicaServiceImpl;
import pe.edu.cibertec.service.Impl.PacienteServiceImpl;
import pe.edu.cibertec.service.Impl.PropietarioServiceImpl;
import pe.edu.cibertec.service.Impl.TipoPacienteServiceImpl;

public class HistoriaClinicaAction extends ActionSupport{

	private static final long serialVersionUID = 1L;
	private HistoriaClinicaService historiaService = new HistoriaClinicaServiceImpl();
	private TipoPacienteService tipoPacienteService = new TipoPacienteServiceImpl();
	private PacienteService pacienteService = new PacienteServiceImpl();
	private PropietarioService propietarioService = new PropietarioServiceImpl();
	private DistritoService distritoService = new DistritoServiceImpl();
	
	private List<HistoriaClinicaBean> grdHistoria;
	private List<TipoPacienteBean> cbTipoPaciente;
	private List<PacienteBean> cbPaciente;
	private List<PropietarioBean> cbPropietario;
	private List<DistritoBean> cbDistrito;
	
	private int rows;
	private HistoriaClinicaBean registro = new HistoriaClinicaBean();
	private int codigo;
	private String mensaje;
	
	private static final Log log = LogFactory.getLog(HistoriaClinicaAction.class);
	
	
	@Override
	public String execute(){
		log.info("En listar historias");
		
		try {
			this.setGrdHistoria(historiaService.listarTodos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	public String nuevoHistoria() {
		log.info("En nuevo historia");
		
		try {
			setCbTipoPaciente(tipoPacienteService.listarTodos());
			setCbPaciente(pacienteService.listarTodos());
			setCbPropietario(propietarioService.listarTodos());
			setCbDistrito(distritoService.listarTodos());
			setRegistro(new HistoriaClinicaBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String insertarHistoria() {
		log.info("En insertar historia");
		try {
			historiaService.insertar(registro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return execute();
	}
	
	public String eliminarHistoria() {
		log.info("En eliminar historia");
		
		try {
			historiaService.eliminar(codigo);
			setMensaje("Se eliminó historia");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
	}
	
	public String editarHistoria() {
		log.info("En editar historia");
		
		try {
			setCbTipoPaciente(tipoPacienteService.listarTodos());
			setCbPaciente(pacienteService.listarTodos());
			setCbPropietario(propietarioService.listarTodos());
			setCbDistrito(distritoService.listarTodos());
			setRegistro(historiaService.consultarHistoriaPK(codigo));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String actualizarHistoria() {
		log.info("En actualizar historia");
		
		try {
			historiaService.actualizar(getRegistro());
			setMensaje("Se actualizó historia");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
		
	}

	
	
	public TipoPacienteService getTipoPacienteService() {
		return tipoPacienteService;
	}

	public void setTipoPacienteService(TipoPacienteService tipoPacienteService) {
		this.tipoPacienteService = tipoPacienteService;
	}

	

	public List<HistoriaClinicaBean> getGrdHistoria() {
		return grdHistoria;
	}

	public void setGrdHistoria(List<HistoriaClinicaBean> grdHistoria) {
		this.grdHistoria = grdHistoria;
	}

	public List<TipoPacienteBean> getCbTipoPaciente() {
		return cbTipoPaciente;
	}

	public void setCbTipoPaciente(List<TipoPacienteBean> cbTipoPaciente) {
		this.cbTipoPaciente = cbTipoPaciente;
	}

	public List<PacienteBean> getCbPaciente() {
		return cbPaciente;
	}

	public void setCbPaciente(List<PacienteBean> cbPaciente) {
		this.cbPaciente = cbPaciente;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public HistoriaClinicaBean getRegistro() {
		return registro;
	}

	public void setRegistro(HistoriaClinicaBean registro) {
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

	public HistoriaClinicaService getHistoriaService() {
		return historiaService;
	}

	public void setHistoriaService(HistoriaClinicaService historiaService) {
		this.historiaService = historiaService;
	}

	public PacienteService getPacienteService() {
		return pacienteService;
	}

	public void setPacienteService(PacienteService pacienteService) {
		this.pacienteService = pacienteService;
	}

	public PropietarioService getPropietarioService() {
		return propietarioService;
	}

	public void setPropietarioService(PropietarioService propietarioService) {
		this.propietarioService = propietarioService;
	}

	public DistritoService getDistritoService() {
		return distritoService;
	}

	public void setDistritoService(DistritoService distritoService) {
		this.distritoService = distritoService;
	}

	public List<PropietarioBean> getCbPropietario() {
		return cbPropietario;
	}

	public void setCbPropietario(List<PropietarioBean> cbPropietario) {
		this.cbPropietario = cbPropietario;
	}

	public List<DistritoBean> getCbDistrito() {
		return cbDistrito;
	}

	public void setCbDistrito(List<DistritoBean> cbDistrito) {
		this.cbDistrito = cbDistrito;
	}
	
	
}
