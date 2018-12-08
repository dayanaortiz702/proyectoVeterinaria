package pe.edu.cibertec.service;

import java.util.List;

import pe.edu.cibertec.bean.HistoriaClinicaBean;


public interface HistoriaClinicaService {
	public abstract int insertar(HistoriaClinicaBean bean) throws Exception;
	public abstract int eliminar(int id) throws Exception;
	public abstract int actualizar(HistoriaClinicaBean bean) throws Exception;
	public abstract List<HistoriaClinicaBean> listarTodos() throws Exception;
	public abstract HistoriaClinicaBean consultarHistoriaPK(int codigo) throws Exception;
}
