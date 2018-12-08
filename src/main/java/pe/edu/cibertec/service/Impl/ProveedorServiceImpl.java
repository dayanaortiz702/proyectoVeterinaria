package pe.edu.cibertec.service.Impl;

import java.util.List;

import pe.edu.cibertec.bean.ProveedorBean;
import pe.edu.cibertec.dao.IHistoriaClinicaDAO;
import pe.edu.cibertec.dao.IProveedorDAO;
import pe.edu.cibertec.factory.DAOFactory;
import pe.edu.cibertec.service.ProveedorService;

public class ProveedorServiceImpl implements ProveedorService{
	DAOFactory factoria = DAOFactory.getFactory(DAOFactory.MYSQL);
	IProveedorDAO dao = factoria.getProveedor();
	@Override
	public int insertar(ProveedorBean bean) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertar(bean);
	}
	@Override
	public int eliminar(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.eliminar(id);
	}
	@Override
	public int actualizar(ProveedorBean bean) throws Exception {
		// TODO Auto-generated method stub
		return dao.actualizar(bean);
	}
	@Override
	public List<ProveedorBean> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return dao.listarTodos();
	}
	@Override
	public ProveedorBean consultarProveedorPK(int codigo) throws Exception {
		// TODO Auto-generated method stub
		return dao.consultarProveedorPK(codigo);
	}
}
