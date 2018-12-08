package pe.edu.cibertec.service.Impl;

import java.util.List;

import pe.edu.cibertec.bean.HistoriaClinicaBean;
import pe.edu.cibertec.dao.IHistoriaClinicaDAO;
import pe.edu.cibertec.factory.DAOFactory;
import pe.edu.cibertec.service.HistoriaClinicaService;

public class HistoriaClinicaServiceImpl implements HistoriaClinicaService{
	DAOFactory factoria = DAOFactory.getFactory(DAOFactory.MYSQL);
	IHistoriaClinicaDAO dao = factoria.getHistoria();
	@Override
	public int insertar(HistoriaClinicaBean bean) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertar(bean);
	}
	@Override
	public int eliminar(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.eliminar(id);
	}
	@Override
	public int actualizar(HistoriaClinicaBean bean) throws Exception {
		// TODO Auto-generated method stub
		return dao.actualizar(bean);
	}
	@Override
	public List<HistoriaClinicaBean> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return dao.listarTodos();
	}
	@Override
	public HistoriaClinicaBean consultarHistoriaPK(int codigo) throws Exception {
		// TODO Auto-generated method stub
		return dao.consultarHistoriaPK(codigo);
	}	
}
