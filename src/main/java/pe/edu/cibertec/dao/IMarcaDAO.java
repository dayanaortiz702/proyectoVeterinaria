package pe.edu.cibertec.dao;

import java.util.List;

import pe.edu.cibertec.bean.MarcaBean;

public interface IMarcaDAO {
	public abstract int insertar(MarcaBean bean) throws Exception;
	public abstract int eliminar(int id) throws Exception;
	public abstract int actualizar(MarcaBean bean) throws Exception;
	public abstract List<MarcaBean> listarTodos() throws Exception;
	public abstract MarcaBean consultarMarcaPK(int codigo) throws Exception;
}
