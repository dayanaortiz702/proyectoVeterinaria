package pe.edu.cibertec.service.Impl;

import java.util.List;

import pe.edu.cibertec.bean.PropietarioBean;
import pe.edu.cibertec.dao.IHistoriaClinicaDAO;
import pe.edu.cibertec.dao.IPropietarioDAO;
import pe.edu.cibertec.factory.DAOFactory;
import pe.edu.cibertec.service.PropietarioService;

public class PropietarioServiceImpl implements PropietarioService{
	DAOFactory factoria = DAOFactory.getFactory(DAOFactory.MYSQL);
	IPropietarioDAO dao = factoria.getPropietario();
	@Override
	public int insertar(PropietarioBean bean) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertar(bean);
	}
	@Override
	public int eliminar(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.eliminar(id);
	}
	@Override
	public int actualizar(PropietarioBean bean) throws Exception {
		// TODO Auto-generated method stub
		return dao.actualizar(bean);
	}
	@Override
	public List<PropietarioBean> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return dao.listarTodos();
	}
	@Override
	public PropietarioBean consultarPropietarioPK(int codigo) throws Exception {
		// TODO Auto-generated method stub
		return dao.consultarPropietarioPK(codigo);
	}
}	
