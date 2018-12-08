package pe.edu.cibertec.service.Impl;

import java.util.List;

import pe.edu.cibertec.bean.TipoPacienteBean;
import pe.edu.cibertec.dao.IHistoriaClinicaDAO;
import pe.edu.cibertec.dao.ITipoPacienteDAO;
import pe.edu.cibertec.factory.DAOFactory;
import pe.edu.cibertec.service.TipoPacienteService;

public class TipoPacienteServiceImpl implements TipoPacienteService{
	DAOFactory factoria = DAOFactory.getFactory(DAOFactory.MYSQL);
	ITipoPacienteDAO dao = factoria.getTipoPaciente();
	@Override
	public int insertar(TipoPacienteBean bean) throws Exception {
		// TODO Auto-generated method stub
		return dao.insertar(bean);
	}
	@Override
	public int eliminar(int id) throws Exception {
		// TODO Auto-generated method stub
		return dao.eliminar(id);
	}
	@Override
	public int actualizar(TipoPacienteBean bean) throws Exception {
		// TODO Auto-generated method stub
		return dao.actualizar(bean);
	}
	@Override
	public List<TipoPacienteBean> listarTodos() throws Exception {
		// TODO Auto-generated method stub
		return dao.listarTodos();
	}
	@Override
	public TipoPacienteBean consultarTipoPacientePK(int codigo) throws Exception {
		// TODO Auto-generated method stub
		return dao.consultarTipoPacientePK(codigo);
	}
}
