package pe.edu.cibertec.dao;

import java.util.List;

import pe.edu.cibertec.bean.TipoPacienteBean;

public interface ITipoPacienteDAO {
	public abstract int insertar(TipoPacienteBean bean) throws Exception;
	public abstract int eliminar(int id) throws Exception;
	public abstract int actualizar(TipoPacienteBean bean) throws Exception;
	public abstract List<TipoPacienteBean> listarTodos() throws Exception;
	public abstract TipoPacienteBean consultarTipoPacientePK(int codigo) throws Exception;
}
