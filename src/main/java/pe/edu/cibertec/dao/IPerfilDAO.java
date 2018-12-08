package pe.edu.cibertec.dao;

import java.util.List;

import pe.edu.cibertec.bean.PerfilBean;


public interface IPerfilDAO {
	public abstract int insertar(PerfilBean bean) throws Exception;
	public abstract int eliminar(int id) throws Exception;
	public abstract int actualizar(PerfilBean bean) throws Exception;
	public abstract List<PerfilBean> listarTodos() throws Exception;
	public abstract PerfilBean consultarPerfilPK(int codigo) throws Exception;
}
