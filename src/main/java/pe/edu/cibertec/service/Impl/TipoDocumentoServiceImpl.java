package pe.edu.cibertec.service.Impl;

import java.util.List;

import pe.edu.cibertec.bean.TipoDocumentoBean;
import pe.edu.cibertec.dao.ITipoDocumentoDAO;
import pe.edu.cibertec.factory.DAOFactory;
import pe.edu.cibertec.service.TipoDocumentoService;

public class TipoDocumentoServiceImpl implements TipoDocumentoService{
	DAOFactory factoria = DAOFactory.getFactory(DAOFactory.MYSQL);
	ITipoDocumentoDAO dao = factoria.getDocumento();	
	
	@Override
	public List<TipoDocumentoBean> listarTodos() throws Exception {
		return dao.listarTodos();
	}

	@Override
	public TipoDocumentoBean consultarDocumentoPK(int codigo) throws Exception {
		return dao.consultarDocumentoPK(codigo);
	}

	@Override
	public int insertar(TipoDocumentoBean bean) throws Exception {
		return dao.insertar(bean);
	}

	@Override
	public int eliminar(int id) throws Exception {
		return dao.eliminar(id);
	}

	@Override
	public int actualizar(TipoDocumentoBean bean) throws Exception {
		return dao.actualizar(bean);
	}

}
