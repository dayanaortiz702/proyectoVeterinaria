package pe.edu.cibertec.service;

import java.util.List;

import pe.edu.cibertec.bean.UnidadMedidaBean;

public interface UnidadMedidaService {
	public abstract int insertar(UnidadMedidaBean bean) throws Exception;
	public abstract int eliminar(int id) throws Exception;
	public abstract int actualizar(UnidadMedidaBean bean) throws Exception;
	public abstract List<UnidadMedidaBean> listarTodos() throws Exception;
	public abstract UnidadMedidaBean consultarUnidadMedidaPK(int codigo) throws Exception;
}
