package pe.edu.cibertec.service.Impl;

import java.util.List;

import pe.edu.cibertec.bean.PacienteBean;
import pe.edu.cibertec.dao.IPacienteDAO;
import pe.edu.cibertec.factory.DAOFactory;
import pe.edu.cibertec.service.PacienteService;

public class PacienteServiceImpl implements PacienteService{
	DAOFactory factoria = DAOFactory.getFactory(DAOFactory.MYSQL);
	IPacienteDAO dao = factoria.getPaciente();
	@Override
	public int insertar(PacienteBean bean) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertar(bean);
	}
	@Override
	public int eliminar(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.eliminar(id);
	}
	@Override
	public int actualizar(PacienteBean bean) throws Exception {
		// TODO Auto-generated method stub
		return dao.actualizar(bean);
	}
	@Override
	public List<PacienteBean> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return dao.listarTodos();
	}
	@Override
	public PacienteBean consultarPacientePK(int codigo) throws Exception {
		// TODO Auto-generated method stub
		return dao.consultarPacientePK(codigo);
	}
	
}
