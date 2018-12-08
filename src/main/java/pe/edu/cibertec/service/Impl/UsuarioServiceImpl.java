package pe.edu.cibertec.service.Impl;

import java.util.List;

import pe.edu.cibertec.bean.UsuarioBean;
import pe.edu.cibertec.dao.IUsuarioDAO;
import pe.edu.cibertec.factory.DAOFactory;
import pe.edu.cibertec.service.UsuarioService;

public class UsuarioServiceImpl implements UsuarioService{
	DAOFactory factoria = DAOFactory.getFactory(DAOFactory.MYSQL);
	IUsuarioDAO dao = factoria.getUsuario();	
	
	@Override
	public int insertar(UsuarioBean bean) throws Exception {
		return dao.insertar(bean);
	}

	@Override
	public int eliminar(int id) throws Exception {
		return dao.eliminar(id);
	}

	@Override
	public int actualizar(UsuarioBean bean) throws Exception {
		return dao.actualizar(bean);
	}

	@Override
	public List<UsuarioBean> listarTodos() throws Exception {
		return dao.listarTodos();
	}

	@Override
	public UsuarioBean consultarUsuarioPK(int codigo) throws Exception {
		return dao.consultarUsuarioPK(codigo);
	}

}
