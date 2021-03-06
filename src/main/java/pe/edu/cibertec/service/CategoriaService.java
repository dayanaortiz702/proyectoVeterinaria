package pe.edu.cibertec.service;

import java.util.List;

import pe.edu.cibertec.bean.CategoriaBean;

public interface CategoriaService {
	public abstract int insertar(CategoriaBean bean) throws Exception;
	public abstract int eliminar(int id) throws Exception;
	public abstract int actualizar(CategoriaBean bean) throws Exception;
	public abstract List<CategoriaBean> listarTodos() throws Exception;
	public abstract CategoriaBean consultarCategoriaPK(int codigo) throws Exception;
}
