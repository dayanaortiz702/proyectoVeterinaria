package pe.edu.cibertec.dao;

import java.util.List;

import pe.edu.cibertec.bean.DistritoBean;

public interface IDistritoDAO {
	public abstract int insertar(DistritoBean bean) throws Exception;
	public abstract int eliminar(int id) throws Exception;
	public abstract int actualizar(DistritoBean bean) throws Exception;
	public abstract List<DistritoBean> listarTodos() throws Exception;
	public abstract DistritoBean consultarDistritoPK(int codigo) throws Exception;
}
