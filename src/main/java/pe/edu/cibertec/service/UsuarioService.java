package pe.edu.cibertec.service;

import java.util.List;

import pe.edu.cibertec.bean.UsuarioBean;


public interface UsuarioService {
	public abstract int insertar(UsuarioBean bean) throws Exception;
	public abstract int eliminar(int id) throws Exception;
	public abstract int actualizar(UsuarioBean bean) throws Exception;
	public abstract List<UsuarioBean> listarTodos() throws Exception;
	public abstract UsuarioBean consultarUsuarioPK(int codigo) throws Exception;
}
