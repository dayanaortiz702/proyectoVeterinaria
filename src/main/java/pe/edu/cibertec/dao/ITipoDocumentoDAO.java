package pe.edu.cibertec.dao;

import java.util.List;

import pe.edu.cibertec.bean.TipoDocumentoBean;

public interface ITipoDocumentoDAO {
	public abstract List<TipoDocumentoBean> listarTodos() throws Exception;
	public abstract TipoDocumentoBean consultarDocumentoPK(int codigo) throws Exception;
}
