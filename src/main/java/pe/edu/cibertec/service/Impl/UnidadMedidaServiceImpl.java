package pe.edu.cibertec.service.Impl;

import java.util.List;

import pe.edu.cibertec.bean.UnidadMedidaBean;
import pe.edu.cibertec.dao.IHistoriaClinicaDAO;
import pe.edu.cibertec.dao.IUnidadMedidaDAO;
import pe.edu.cibertec.factory.DAOFactory;
import pe.edu.cibertec.service.UnidadMedidaService;

public class UnidadMedidaServiceImpl implements UnidadMedidaService	{
	DAOFactory factoria = DAOFactory.getFactory(DAOFactory.MYSQL);
	IUnidadMedidaDAO dao = factoria.getUnidadMedida();
	@Override
	public int insertar(UnidadMedidaBean bean) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertar(bean);
	}
	@Override
	public int eliminar(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.eliminar(id);
	}
	@Override
	public int actualizar(UnidadMedidaBean bean) throws Exception {
		// TODO Auto-generated method stub
		return dao.actualizar(bean);
	}
	@Override
	public List<UnidadMedidaBean> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return dao.listarTodos();
	}
	@Override
	public UnidadMedidaBean consultarUnidadMedidaPK(int codigo) throws Exception {
		// TODO Auto-generated method stub
		return dao.consultarUnidadMedidaPK(codigo);
	}
	
	
}
