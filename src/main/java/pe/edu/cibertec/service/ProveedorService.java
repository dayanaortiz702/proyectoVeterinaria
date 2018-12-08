package pe.edu.cibertec.service;

import java.util.List;

import pe.edu.cibertec.bean.ProveedorBean;


public interface ProveedorService {
	public abstract int insertar(ProveedorBean bean) throws Exception;
	public abstract int eliminar(int id) throws Exception;
	public abstract int actualizar(ProveedorBean bean) throws Exception;
	public abstract List<ProveedorBean> listarTodos() throws Exception;
	public abstract ProveedorBean consultarProveedorPK(int codigo) throws Exception;
}
