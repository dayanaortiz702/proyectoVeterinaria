package pe.edu.cibertec.service;

import java.util.List;

import pe.edu.cibertec.bean.PerfilBean;

public interface PerfilService {
	public abstract int insertar(PerfilBean bean) throws Exception;
	public abstract int eliminar(int id) throws Exception;
	public abstract int actualizar(PerfilBean bean) throws Exception;
	public abstract List<PerfilBean> listarTodos() throws Exception;
	public abstract PerfilBean consultarPerfilPK(int codigo) throws Exception;
}
