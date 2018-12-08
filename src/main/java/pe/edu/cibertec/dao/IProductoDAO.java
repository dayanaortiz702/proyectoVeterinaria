package pe.edu.cibertec.dao;

import java.util.List;

import pe.edu.cibertec.bean.ProductoBean;

public interface IProductoDAO {
	public abstract int insertar(ProductoBean bean) throws Exception;
	public abstract int eliminar(int id) throws Exception;
	public abstract int actualizar(ProductoBean bean) throws Exception;
	public abstract List<ProductoBean> listarTodos() throws Exception;
	public abstract ProductoBean consultarProductoPK(int codigo) throws Exception;
}
