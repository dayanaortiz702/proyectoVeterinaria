package pe.edu.cibertec.service;

import java.util.List;

import pe.edu.cibertec.bean.EstadoBean;

public interface EstadoService {
	public abstract int insertar(EstadoBean bean) throws Exception;
	public abstract int eliminar(int id) throws Exception;
	public abstract int actualizar(EstadoBean bean) throws Exception;
	public abstract List<EstadoBean> listarTodos() throws Exception;
	public abstract EstadoBean consultarEstadoPK(int codigo) throws Exception;
}
