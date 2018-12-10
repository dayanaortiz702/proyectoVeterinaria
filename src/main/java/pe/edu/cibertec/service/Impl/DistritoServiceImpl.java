package pe.edu.cibertec.service.Impl;

import java.util.List;

import pe.edu.cibertec.bean.DistritoBean;
import pe.edu.cibertec.dao.IDistritoDAO;
import pe.edu.cibertec.factory.DAOFactory;
import pe.edu.cibertec.service.DistritoService;

public class DistritoServiceImpl implements DistritoService{
	DAOFactory factoria = DAOFactory.getFactory(DAOFactory.MYSQL);
	IDistritoDAO dao = factoria.getDistrito();
	
	@Override
	public int insertar(DistritoBean bean) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertar(bean);
	}
	@Override
	public int eliminar(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.eliminar(id);
	}
	@Override
	public int actualizar(DistritoBean bean) throws Exception {
		// TODO Auto-generated method stub
		return dao.actualizar(bean);
	}
	@Override
	public List<DistritoBean> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return dao.listarTodos();
	}
	@Override
	public DistritoBean consultarDistritoPK(int codigo) throws Exception {
		// TODO Auto-generated method stub
		return dao.consultarDistritoPK(codigo);
	}
	
}
