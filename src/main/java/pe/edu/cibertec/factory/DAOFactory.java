package pe.edu.cibertec.factory;

import pe.edu.cibertec.dao.*;

public abstract class DAOFactory {
	public static final int MYSQL = 1;
	public static final int ORACLE = 2;
	
	//objetos daos
	public abstract IEmpleadoDAO getEmpleado();
	public abstract ITipoDocumentoDAO getDocumento();
	
	public static DAOFactory getFactory(int bd) {
		switch(bd) {
		case MYSQL:
			return new MySqlDAOFactory();
		}
		return null;
	}
	
}
