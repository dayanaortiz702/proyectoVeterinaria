package pe.edu.cibertec.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import pe.edu.cibertec.bean.TipoPacienteBean;
import pe.edu.cibertec.dao.ITipoPacienteDAO;
import pe.edu.cibertec.factory.conectaDB;

public class TipoPacienteDAOImpl implements ITipoPacienteDAO{

	@Override
	public int insertar(TipoPacienteBean bean) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "INSERT INTO tb_tipo_paciente VALUES (null,?)";
			con = new conectaDB().getConexion();
			
			int i = 1;			
			pstm = con.prepareStatement(sql);
			pstm.setString(i++, bean.getTipo());
			
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
			String sql = "delete from tb_tipo_paciente where idCargo = ?";
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
	public int actualizar(TipoPacienteBean bean) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "update tb_tipo_paciente set nombre = ? where idCargo = ?";
			con = new conectaDB().getConexion();
			
			int i = 1;			
			pstm = con.prepareStatement(sql);
			pstm.setString(i++, bean.getTipo());
			pstm.setInt(i++, bean.getIdTipo());
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
	public List<TipoPacienteBean> listarTodos() throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<TipoPacienteBean> lista = new ArrayList<TipoPacienteBean>();
		
		try {
			String sql = "select*from tb_tipo_paciente";
			con = new conectaDB().getConexion();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			TipoPacienteBean bean = null;
			
			while(rs.next()) {
				bean = new TipoPacienteBean();
				bean.setIdTipo(rs.getInt("idTipo"));
				bean.setTipo(rs.getString("tipo"));
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
	public TipoPacienteBean consultarTipoPacientePK(int codigo) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		TipoPacienteBean bean = null;
		
		try {
			String sql = "select*from tb_tipo_paciente where idTipo = ?";
			con = new conectaDB().getConexion();
			pstm = con.prepareStatement(sql);
			int i = 1;
			pstm.setInt(i++, codigo);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				bean = new TipoPacienteBean();
				bean.setIdTipo(rs.getInt("idTipo"));
				bean.setTipo(rs.getString("tipo"));
				
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
