package pe.edu.cibertec.service;

import java.util.List;

import pe.edu.cibertec.bean.DistritoBean;

public interface DistritoService {
	public abstract int insertar(DistritoBean bean) throws Exception;
	public abstract int eliminar(int id) throws Exception;
	public abstract int actualizar(DistritoBean bean) throws Exception;
	public abstract List<DistritoBean> listarTodos() throws Exception;
	public abstract DistritoBean consultarDistritoPK(int codigo) throws Exception;
}
