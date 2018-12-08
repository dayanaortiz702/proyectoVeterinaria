package pe.edu.cibertec.service;

import java.util.List;

import pe.edu.cibertec.bean.CargoBean;

public interface CargoService {
	public abstract int insertar(CargoBean bean) throws Exception;
	public abstract int eliminar(int id) throws Exception;
	public abstract int actualizar(CargoBean bean) throws Exception;
	public abstract List<CargoBean> listarTodos() throws Exception;
	public abstract CargoBean consultarCargoPK(int codigo) throws Exception;
}
