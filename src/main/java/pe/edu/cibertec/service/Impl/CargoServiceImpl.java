package pe.edu.cibertec.service.Impl;

import java.util.List;

import pe.edu.cibertec.bean.CargoBean;
import pe.edu.cibertec.dao.ICargoDAO;
import pe.edu.cibertec.factory.DAOFactory;
import pe.edu.cibertec.service.CargoService;

public class CargoServiceImpl implements CargoService{
	DAOFactory factoria = DAOFactory.getFactory(DAOFactory.MYSQL);
	ICargoDAO dao = factoria.getCargo();	

	@Override
	public int insertar(CargoBean bean) throws Exception {
		return dao.insertar(bean);
	}

	@Override
	public int eliminar(int id) throws Exception {
		return dao.eliminar(id);
	}

	@Override
	public int actualizar(CargoBean bean) throws Exception {
		return dao.actualizar(bean);
	}

	@Override
	public List<CargoBean> listarTodos() throws Exception {
		return dao.listarTodos();
	}

	@Override
	public CargoBean consultarCargoPK(int codigo) throws Exception {
		return dao.consultarCargoPK(codigo);
	}

}
