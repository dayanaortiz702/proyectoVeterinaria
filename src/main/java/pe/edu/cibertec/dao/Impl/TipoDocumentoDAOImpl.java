package pe.edu.cibertec.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.edu.cibertec.bean.TipoDocumentoBean;
import pe.edu.cibertec.dao.ITipoDocumentoDAO;
import pe.edu.cibertec.factory.conectaDB;

public class TipoDocumentoDAOImpl implements ITipoDocumentoDAO{

	@Override
	public List<TipoDocumentoBean> listarTodos() throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<TipoDocumentoBean> lista = new ArrayList<TipoDocumentoBean>();
		
		try {
			String sql = "select*from tb_tipo_documento";
			con = new conectaDB().getConexion();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			TipoDocumentoBean bean = null;
			
			while(rs.next()) {
				bean = new TipoDocumentoBean();
				bean.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
				bean.setDescripcion(rs.getString("descripcion"));
				lista.add(bean);
			}
						
		} catch (Exception e) {
			System.out.println(e);
		}finally {
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
				if(con != null) con.close();
			
		}
		
		return lista;
	}

	@Override
	public TipoDocumentoBean consultarDocumentoPK(int codigo) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		TipoDocumentoBean bean = null;
		
		try {
			String sql = "select*from tb_tipo_documento where idTipoDocumento = ?";
			con = new conectaDB().getConexion();
			pstm = con.prepareStatement(sql);
			int i = 1;
			pstm.setInt(i++, codigo);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				bean = new TipoDocumentoBean();
				bean.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
				bean.setDescripcion(rs.getString("descripcion"));
				
			}
						
		} catch (Exception e) {
			System.out.println(e);
		}finally {
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
				if(con != null) con.close();
			
		}
		
		return bean;
	}

	@Override
	public int insertar(TipoDocumentoBean bean) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "INSERT INTO tb_tipo_documento VALUES (null,?)";
			con = new conectaDB().getConexion();
			
			int i = 1;			
			pstm = con.prepareStatement(sql);
			pstm.setString(i++, bean.getDescripcion());
			
			insertados = pstm.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) pstm.close();
			} catch (Exception e2) {}
			try {
				if(con != null) con.close();
			} catch (Exception e2) {
				
			}
		}
		return insertados;
	}

	@Override
	public int eliminar(int id) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "delete from tb_tipo_documento where idTipoDocumento = ?";
			con = new conectaDB().getConexion();
			
			int i = 1;			
			pstm = con.prepareStatement(sql);
			pstm.setInt(i++, id);		
			insertados = pstm.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) pstm.close();
			} catch (Exception e2) {}
			try {
				if(con != null) con.close();
			} catch (Exception e2) {
				
			}
		}
		return insertados;
	}

	@Override
	public int actualizar(TipoDocumentoBean bean) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "update tb_tipo_documento set descripcion = ? where idTipoDocumento = ?";
			con = new conectaDB().getConexion();
			
			int i = 1;			
			pstm = con.prepareStatement(sql);
			pstm.setString(i++, bean.getDescripcion());
			pstm.setInt(i++, bean.getIdTipoDocumento());
			insertados = pstm.executeUpdate();
		
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(pstm != null) pstm.close();
			} catch (Exception e2) {}
			try {
				if(con != null) con.close();
			} catch (Exception e2) {
				
			}
		}
		return insertados;
	}

}
