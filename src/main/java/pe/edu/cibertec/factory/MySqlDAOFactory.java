package pe.edu.cibertec.factory;

import pe.edu.cibertec.dao.IEmpleadoDAO;
import pe.edu.cibertec.dao.ITipoDocumentoDAO;
import pe.edu.cibertec.dao.Impl.EmpleadoDAOImpl;
import pe.edu.cibertec.dao.Impl.TipoDocumentoDAOImpl;

public class MySqlDAOFactory extends DAOFactory{

	@Override
	public IEmpleadoDAO getEmpleado() {
		return new EmpleadoDAOImpl();
	}

	@Override
	public ITipoDocumentoDAO getDocumento() {
		return new TipoDocumentoDAOImpl();
	}


	
}
