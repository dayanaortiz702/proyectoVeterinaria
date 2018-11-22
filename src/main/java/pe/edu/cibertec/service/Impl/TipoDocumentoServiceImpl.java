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

}
