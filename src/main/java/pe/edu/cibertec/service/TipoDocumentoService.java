package pe.edu.cibertec.service;

import java.util.List;

import pe.edu.cibertec.bean.TipoDocumentoBean;

public interface TipoDocumentoService {
	public abstract List<TipoDocumentoBean> listarTodos() throws Exception;
	public abstract TipoDocumentoBean consultarDocumentoPK(int codigo) throws Exception;
}
