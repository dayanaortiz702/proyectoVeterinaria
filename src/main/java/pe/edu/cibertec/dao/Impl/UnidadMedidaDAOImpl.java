package pe.edu.cibertec.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.edu.cibertec.bean.UnidadMedidaBean;
import pe.edu.cibertec.dao.IUnidadMedidaDAO;
import pe.edu.cibertec.factory.conectaDB;

public class UnidadMedidaDAOImpl implements IUnidadMedidaDAO{

	@Override
	public int insertar(UnidadMedidaBean bean) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "INSERT INTO tb_unidad_medida VALUES (null,?)";
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
			String sql = "delete from tb_unidad_medida where idUnidadMedida = ?";
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
	public int actualizar(UnidadMedidaBean bean) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "update tb_unidad_medida set descripcion = ? where idUniMedida = ?";
			con = new conectaDB().getConexion();
			
			int i = 1;			
			pstm = con.prepareStatement(sql);
			pstm.setString(i++, bean.getDescripcion());
			pstm.setInt(i++, bean.getIdUniMedida());
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
	public List<UnidadMedidaBean> listarTodos() throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<UnidadMedidaBean> lista = new ArrayList<UnidadMedidaBean>();
		
		try {
			String sql = "select*from tb_unidad_medida";
			con = new conectaDB().getConexion();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			UnidadMedidaBean bean = null;
			
			while(rs.next()) {
				bean = new UnidadMedidaBean();
				bean.setIdUniMedida(rs.getInt("idUniMedida"));
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
	public UnidadMedidaBean consultarUnidadMedidaPK(int codigo) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		UnidadMedidaBean bean = null;
		
		try {
			String sql = "select*from tb_unidad_medida where idUniMedida = ?";
			con = new conectaDB().getConexion();
			pstm = con.prepareStatement(sql);
			int i = 1;
			pstm.setInt(i++, codigo);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				bean = new UnidadMedidaBean();
				bean.setIdUniMedida(rs.getInt("idUniMedida"));
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

}
