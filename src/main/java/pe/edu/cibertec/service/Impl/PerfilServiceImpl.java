package pe.edu.cibertec.service.Impl;

import java.util.List;

import pe.edu.cibertec.bean.PerfilBean;
import pe.edu.cibertec.dao.IPerfilDAO;
import pe.edu.cibertec.factory.DAOFactory;
import pe.edu.cibertec.service.PerfilService;

public class PerfilServiceImpl implements PerfilService{
	DAOFactory factoria = DAOFactory.getFactory(DAOFactory.MYSQL);
	IPerfilDAO dao = factoria.getPerfil();
	
	@Override
	public int insertar(PerfilBean bean) throws Exception {
		return dao.insertar(bean);
	}

	@Override
	public int eliminar(int id) throws Exception {
		return dao.eliminar(id);
	}

	@Override
	public int actualizar(PerfilBean bean) throws Exception {
		return dao.actualizar(bean);
	}

	@Override
	public List<PerfilBean> listarTodos() throws Exception {
		return dao.listarTodos();
	}

	@Override
	public PerfilBean consultarPerfilPK(int codigo) throws Exception {
		return dao.consultarPerfilPK(codigo);
	}

}
