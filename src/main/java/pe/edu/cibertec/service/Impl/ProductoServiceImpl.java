package pe.edu.cibertec.service.Impl;

import java.util.List;

import pe.edu.cibertec.bean.ProductoBean;
import pe.edu.cibertec.dao.IProductoDAO;
import pe.edu.cibertec.factory.DAOFactory;
import pe.edu.cibertec.service.ProductoService;

public class ProductoServiceImpl implements ProductoService{
	DAOFactory factoria = DAOFactory.getFactory(DAOFactory.MYSQL);
	IProductoDAO dao = factoria.getProducto();
	@Override
	public int insertar(ProductoBean bean) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertar(bean);
	}
	@Override
	public int eliminar(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.eliminar(id);
	}
	@Override
	public int actualizar(ProductoBean bean) throws Exception {
		// TODO Auto-generated method stub
		return dao.actualizar(bean);
	}
	@Override
	public List<ProductoBean> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return dao.listarTodos();
	}
	@Override
	public ProductoBean consultarProductoPK(int codigo) throws Exception {
		// TODO Auto-generated method stub
		return dao.consultarProductoPK(codigo);
	}
	
	
}
