package pe.edu.cibertec.factory;

import pe.edu.cibertec.dao.*;

public abstract class DAOFactory {
	public static final int MYSQL = 1;
	public static final int ORACLE = 2;
	
	//objetos daos
	public abstract ICargoDAO getCargo();
	public abstract ICategoriaDAO getCategoria();
	public abstract IDistritoDAO getDistrito();
	public abstract IEmpleadoDAO getEmpleado();
	public abstract IEstadoDAO getEstado();
	public abstract IHistoriaClinicaDAO getHistoria();
	public abstract IMarcaDAO getMarca();
	public abstract IPacienteDAO getPaciente();
	public abstract IPerfilDAO getPerfil();
	public abstract IProductoDAO getProducto();
	public abstract IPropietarioDAO getPropietario();
	public abstract IProveedorDAO getProveedor();
	public abstract ITipoDocumentoDAO getDocumento();
	public abstract ITipoPacienteDAO getTipoPaciente();
	public abstract IUnidadMedidaDAO getUnidadMedida();
	public abstract IUsuarioDAO getUsuario();
	
	public static DAOFactory getFactory(int bd) {
		switch(bd) {
		case MYSQL:
			return new MySqlDAOFactory();
		}
		return null;
	}
	
}
