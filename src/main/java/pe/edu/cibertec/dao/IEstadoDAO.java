package pe.edu.cibertec.dao;

import java.util.List;

import pe.edu.cibertec.bean.EstadoBean;

public interface IEstadoDAO {
	public abstract int insertar(EstadoBean bean) throws Exception;
	public abstract int eliminar(int id) throws Exception;
	public abstract int actualizar(EstadoBean bean) throws Exception;
	public abstract List<EstadoBean> listarTodos() throws Exception;
	public abstract EstadoBean consultarEstadoPK(int codigo) throws Exception;
}
