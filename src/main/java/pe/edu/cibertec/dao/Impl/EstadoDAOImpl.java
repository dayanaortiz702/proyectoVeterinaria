package pe.edu.cibertec.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.edu.cibertec.bean.EstadoBean;
import pe.edu.cibertec.dao.IEstadoDAO;
import pe.edu.cibertec.factory.conectaDB;

public class EstadoDAOImpl implements IEstadoDAO{

	@Override
	public int insertar(EstadoBean bean) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "INSERT INTO tb_estado VALUES (null,?)";
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
			String sql = "delete from tb_estado where idEstado = ?";
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
	public int actualizar(EstadoBean bean) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "update tb_estado set descripcion = ? where idEstado = ?";
			con = new conectaDB().getConexion();
			
			int i = 1;			
			pstm = con.prepareStatement(sql);
			pstm.setString(i++, bean.getDescripcion());
			pstm.setInt(i++, bean.getIdEstado());
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
	public List<EstadoBean> listarTodos() throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<EstadoBean> lista = new ArrayList<EstadoBean>();
		
		try {
			String sql = "select*from tb_estado";
			con = new conectaDB().getConexion();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			EstadoBean bean = null;
			
			while(rs.next()) {
				bean = new EstadoBean();
				bean.setIdEstado(rs.getInt("idEstado"));
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
	public EstadoBean consultarEstadoPK(int codigo) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		EstadoBean bean = null;
		
		try {
			String sql = "select*from tb_estado where idEstado = ?";
			con = new conectaDB().getConexion();
			pstm = con.prepareStatement(sql);
			int i = 1;
			pstm.setInt(i++, codigo);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				bean = new EstadoBean();
				bean.setIdEstado(rs.getInt("idEstado"));
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
