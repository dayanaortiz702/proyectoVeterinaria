package pe.edu.cibertec.service.Impl;

import java.util.List;

import pe.edu.cibertec.bean.EmpleadoBean;
import pe.edu.cibertec.dao.IEmpleadoDAO;
import pe.edu.cibertec.factory.DAOFactory;
import pe.edu.cibertec.service.EmpleadoService;

public class EmpleadoServiceImpl implements EmpleadoService{
	DAOFactory factoria = DAOFactory.getFactory(DAOFactory.MYSQL);
	IEmpleadoDAO dao = factoria.getEmpleado();
	@Override
	public int insertar(EmpleadoBean bean) throws Exception {
		return dao.insertar(bean);
	}
	@Override
	public int eliminar(int id) throws Exception {
		return dao.eliminar(id);
	}
	@Override
	public int actualizar(EmpleadoBean bean) throws Exception {
		return dao.actualizar(bean);
	}
	@Override
	public List<EmpleadoBean> listarTodos() throws Exception {
		return dao.listarTodos();
	}
	@Override
	public EmpleadoBean consultarEmpleadoPK(int codigo) throws Exception {
		return dao.consultarEmpleadoPK(codigo);
	}	
	
	
}
