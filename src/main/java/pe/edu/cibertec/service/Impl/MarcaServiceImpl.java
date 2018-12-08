package pe.edu.cibertec.service.Impl;

import java.util.List;

import pe.edu.cibertec.bean.MarcaBean;
import pe.edu.cibertec.dao.IMarcaDAO;
import pe.edu.cibertec.factory.DAOFactory;
import pe.edu.cibertec.service.MarcaService;

public class MarcaServiceImpl implements MarcaService{
	DAOFactory factoria = DAOFactory.getFactory(DAOFactory.MYSQL);
	IMarcaDAO dao = factoria.getMarca();

	@Override
	public int insertar(MarcaBean bean) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertar(bean);
	}

	@Override
	public int eliminar(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.eliminar(id);
	}

	@Override
	public int actualizar(MarcaBean bean) throws Exception {
		// TODO Auto-generated method stub
		return dao.actualizar(bean);
	}

	@Override
	public List<MarcaBean> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return dao.listarTodos();
	}

	@Override
	public MarcaBean consultarMarcaPK(int codigo) throws Exception {
		// TODO Auto-generated method stub
		return dao.consultarMarcaPK(codigo);
	}

}
