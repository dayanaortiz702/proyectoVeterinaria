package pe.edu.cibertec.dao;

import java.util.List;

import pe.edu.cibertec.bean.PacienteBean;

public interface IPacienteDAO {
	public abstract int insertar(PacienteBean bean) throws Exception;
	public abstract int eliminar(int id) throws Exception;
	public abstract int actualizar(PacienteBean bean) throws Exception;
	public abstract List<PacienteBean> listarTodos() throws Exception;
	public abstract PacienteBean consultarPacientePK(int codigo) throws Exception;
}
