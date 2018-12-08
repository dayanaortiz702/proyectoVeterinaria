package pe.edu.cibertec.dao;

import java.util.List;
import pe.edu.cibertec.bean.TipoDocumentoBean;

public interface ITipoDocumentoDAO {
	public abstract int insertar(TipoDocumentoBean bean) throws Exception;
	public abstract int eliminar(int id) throws Exception;
	public abstract int actualizar(TipoDocumentoBean bean) throws Exception;
	public abstract List<TipoDocumentoBean> listarTodos() throws Exception;
	public abstract TipoDocumentoBean consultarDocumentoPK(int codigo) throws Exception;
}
