package pe.edu.cibertec.service;

import java.util.List;

import pe.edu.cibertec.bean.MarcaBean;

public interface MarcaService {
	public abstract int insertar(MarcaBean bean) throws Exception;
	public abstract int eliminar(int id) throws Exception;
	public abstract int actualizar(MarcaBean bean) throws Exception;
	public abstract List<MarcaBean> listarTodos() throws Exception;
	public abstract MarcaBean consultarMarcaPK(int codigo) throws Exception;
}
