package pe.edu.cibertec.service.Impl;

import java.util.List;

import pe.edu.cibertec.bean.CategoriaBean;
import pe.edu.cibertec.dao.ICategoriaDAO;
import pe.edu.cibertec.factory.DAOFactory;
import pe.edu.cibertec.service.CategoriaService;

public class CategoriaServiceImpl implements CategoriaService{
	DAOFactory factoria = DAOFactory.getFactory(DAOFactory.MYSQL);
	ICategoriaDAO dao = factoria.getCategoria();	
	
	@Override
	public int insertar(CategoriaBean bean) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertar(bean);
	}

	@Override
	public int eliminar(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.eliminar(id);
	}

	@Override
	public int actualizar(CategoriaBean bean) throws Exception {
		// TODO Auto-generated method stub
		return dao.actualizar(bean);
	}

	@Override
	public List<CategoriaBean> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return dao.listarTodos();
	}

	@Override
	public CategoriaBean consultarCategoriaPK(int codigo) throws Exception {
		// TODO Auto-generated method stub
		return dao.consultarCategoriaPK(codigo);
	}

}
