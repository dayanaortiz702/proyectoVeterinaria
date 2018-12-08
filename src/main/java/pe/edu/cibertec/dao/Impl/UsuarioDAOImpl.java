package pe.edu.cibertec.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.edu.cibertec.bean.UsuarioBean;
import pe.edu.cibertec.dao.IEstadoDAO;
import pe.edu.cibertec.dao.IPerfilDAO;
import pe.edu.cibertec.dao.IUsuarioDAO;
import pe.edu.cibertec.factory.DAOFactory;
import pe.edu.cibertec.factory.conectaDB;

public class UsuarioDAOImpl implements IUsuarioDAO{
	DAOFactory factoria = DAOFactory.getFactory(DAOFactory.MYSQL);
	IEstadoDAO daoEstado = factoria.getEstado();	
	IPerfilDAO daoPerfil = factoria.getPerfil();
	conectaDB conexion = new conectaDB(); 
	
	@Override
	public int insertar(UsuarioBean bean) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "INSERT INTO tb_usuario VALUES (null,?,?,?,?)";
			con = new conectaDB().getConexion();
			
			int i = 1;			
			pstm = con.prepareStatement(sql);
			pstm.setString(i++, bean.getUsuario());
			pstm.setString(i++, bean.getClave());
			pstm.setInt(i++, bean.getIdEstado());
			pstm.setInt(i++, bean.getIdPerfil());
			
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
			String sql = "delete from tb_usuario where idUsuario = ?";
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
	public int actualizar(UsuarioBean bean) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "update tb_usuario set usuario = ?, clave = ?, idEstado=?, idPerfil=? where idUsuario = ?";
			con = new conectaDB().getConexion();
			
			int i = 1;			
			pstm = con.prepareStatement(sql);
			pstm.setString(i++, bean.getUsuario());
			pstm.setString(i++, bean.getClave());
			pstm.setInt(i++, bean.getIdEstado());
			pstm.setInt(i++, bean.getIdPerfil());
			pstm.setInt(i++, bean.getIdUsuario());
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
	public List<UsuarioBean> listarTodos() throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<UsuarioBean> lista = new ArrayList<UsuarioBean>();
		
		try {
			String sql = "select*from tb_usuario";
			con = new conectaDB().getConexion();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			UsuarioBean bean = null;
			
			while(rs.next()) {
				bean = new UsuarioBean();
				bean.setIdUsuario(rs.getInt("idUsuario"));
				bean.setUsuario(rs.getString("usuario"));
				bean.setClave(rs.getString("clave"));
				bean.setIdEstado(rs.getInt("idEstado"));
				bean.setEstado(daoEstado.consultarEstadoPK(rs.getInt("idEstado")));
//				bean.setIdPerfil(rs.getInt("idPerfil"));
//				bean.setPerfil(daoPerfil.consultarPerfilPK(rs.getInt("idPerfil")));
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
	public UsuarioBean consultarUsuarioPK(int codigo) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		UsuarioBean bean = null;
		
		try {
			String sql = "select*from tb_usuario where idUsuario = ?";
			con = conexion.getConexion();
			pstm = con.prepareStatement(sql);
			int i = 1;
			pstm.setInt(i++, codigo);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				bean = new UsuarioBean();
				
				bean.setIdUsuario(rs.getInt("idUsuario"));
				bean.setUsuario(rs.getString("usuario"));
				bean.setClave(rs.getString("clave"));
				bean.setIdEstado(rs.getInt("idEstado"));
				bean.setIdPerfil(rs.getInt("idPerfil"));
			}
						
		} catch (Exception e) {
			System.out.println(e);
		}finally {
			try {
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
				if(con != null) con.close();
			} catch (Exception e2) {
				
			}
		}
		
		return bean;
	}

}
