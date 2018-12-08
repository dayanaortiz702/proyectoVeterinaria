package pe.edu.cibertec.factory;

import pe.edu.cibertec.dao.ICargoDAO;
import pe.edu.cibertec.dao.ICategoriaDAO;
import pe.edu.cibertec.dao.IDistritoDAO;
import pe.edu.cibertec.dao.IEmpleadoDAO;
import pe.edu.cibertec.dao.IEstadoDAO;
import pe.edu.cibertec.dao.IHistoriaClinicaDAO;
import pe.edu.cibertec.dao.IMarcaDAO;
import pe.edu.cibertec.dao.IPacienteDAO;
import pe.edu.cibertec.dao.IPerfilDAO;
import pe.edu.cibertec.dao.IProductoDAO;
import pe.edu.cibertec.dao.IPropietarioDAO;
import pe.edu.cibertec.dao.IProveedorDAO;
import pe.edu.cibertec.dao.ITipoDocumentoDAO;
import pe.edu.cibertec.dao.ITipoPacienteDAO;
import pe.edu.cibertec.dao.IUnidadMedidaDAO;
import pe.edu.cibertec.dao.IUsuarioDAO;
import pe.edu.cibertec.dao.Impl.CargoDAOImpl;
import pe.edu.cibertec.dao.Impl.CategoriaDAOImpl;
import pe.edu.cibertec.dao.Impl.DistritoDAOImpl;
import pe.edu.cibertec.dao.Impl.EmpleadoDAOImpl;
import pe.edu.cibertec.dao.Impl.EstadoDAOImpl;
import pe.edu.cibertec.dao.Impl.HistoriaClinicaDAOImpl;
import pe.edu.cibertec.dao.Impl.MarcaDAOImpl;
import pe.edu.cibertec.dao.Impl.PacienteDAOImpl;
import pe.edu.cibertec.dao.Impl.PerfilDAOImpl;
import pe.edu.cibertec.dao.Impl.ProductoDAOImpl;
import pe.edu.cibertec.dao.Impl.PropietarioDAOImpl;
import pe.edu.cibertec.dao.Impl.ProveedorDAOImpl;
import pe.edu.cibertec.dao.Impl.TipoDocumentoDAOImpl;
import pe.edu.cibertec.dao.Impl.TipoPacienteDAOImpl;
import pe.edu.cibertec.dao.Impl.UnidadMedidaDAOImpl;
import pe.edu.cibertec.dao.Impl.UsuarioDAOImpl;

public class MySqlDAOFactory extends DAOFactory{

	@Override
	public IEmpleadoDAO getEmpleado() {
		return new EmpleadoDAOImpl();
	}

	@Override
	public ITipoDocumentoDAO getDocumento() {
		return new TipoDocumentoDAOImpl();
	}

	@Override
	public ICargoDAO getCargo() {
		return new CargoDAOImpl();
	}

	@Override
	public IUsuarioDAO getUsuario() {
		return new UsuarioDAOImpl();
	}

	@Override
	public IEstadoDAO getEstado() {
		return new EstadoDAOImpl();
	}

	@Override
	public IPerfilDAO getPerfil() {
		return new PerfilDAOImpl();
	}

	@Override
	public ICategoriaDAO getCategoria() {
		return new CategoriaDAOImpl();
	}

	@Override
	public IDistritoDAO getDistrito() {
		return new DistritoDAOImpl();
	}

	@Override
	public IHistoriaClinicaDAO getHistoria() {
		return new HistoriaClinicaDAOImpl();
	}

	@Override
	public IMarcaDAO getMarca() {
		return new MarcaDAOImpl();
	}

	@Override
	public IPacienteDAO getPaciente() {
		return new PacienteDAOImpl();
	}

	@Override
	public IProductoDAO getProducto() {
		return new ProductoDAOImpl();
	}

	@Override
	public IPropietarioDAO getPropietario() {
		return new PropietarioDAOImpl();
	}

	@Override
	public IProveedorDAO getProveedor() {
		return new ProveedorDAOImpl();
	}

	@Override
	public ITipoPacienteDAO getTipoPaciente() {
		return new TipoPacienteDAOImpl();
	}

	@Override
	public IUnidadMedidaDAO getUnidadMedida() {
		return new UnidadMedidaDAOImpl();
	}


	
}
