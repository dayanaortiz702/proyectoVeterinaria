package pe.edu.cibertec.dao;

import java.util.List;

import pe.edu.cibertec.bean.EmpleadoBean;

public interface IEmpleadoDAO {
	public abstract int insertar(EmpleadoBean bean) throws Exception;
	public abstract int eliminar(int id) throws Exception;
	public abstract int actualizar(EmpleadoBean bean) throws Exception;
	public abstract List<EmpleadoBean> listarTodos() throws Exception;
	public abstract EmpleadoBean consultarEmpleadoPK(int codigo) throws Exception;
}
