package pe.edu.cibertec.service.Impl;

import java.util.List;

import pe.edu.cibertec.bean.EstadoBean;
import pe.edu.cibertec.dao.IEstadoDAO;
import pe.edu.cibertec.factory.DAOFactory;
import pe.edu.cibertec.service.EstadoService;

public class EstadoServiceImpl implements EstadoService{
	DAOFactory factoria = DAOFactory.getFactory(DAOFactory.MYSQL);
	IEstadoDAO dao = factoria.getEstado();
	
	@Override
	public int insertar(EstadoBean bean) throws Exception {
		return dao.insertar(bean);
	}

	@Override
	public int eliminar(int id) throws Exception {
		return dao.eliminar(id);
	}

	@Override
	public int actualizar(EstadoBean bean) throws Exception {
		return dao.actualizar(bean);
	}

	@Override
	public List<EstadoBean> listarTodos() throws Exception {
		return dao.listarTodos();
	}

	@Override
	public EstadoBean consultarEstadoPK(int codigo) throws Exception {
		return dao.consultarEstadoPK(codigo);
	}

}
