package pe.edu.cibertec.service;

import java.util.List;

import pe.edu.cibertec.bean.PropietarioBean;

public interface PropietarioService {
	public abstract int insertar(PropietarioBean bean) throws Exception;
	public abstract int eliminar(int id) throws Exception;
	public abstract int actualizar(PropietarioBean bean) throws Exception;
	public abstract List<PropietarioBean> listarTodos() throws Exception;
	public abstract PropietarioBean consultarPropietarioPK(int codigo) throws Exception;
}
