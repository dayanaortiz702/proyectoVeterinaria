package pe.edu.cibertec.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.edu.cibertec.bean.PropietarioBean;
import pe.edu.cibertec.dao.IPropietarioDAO;
import pe.edu.cibertec.factory.conectaDB;

public class PropietarioDAOImpl implements IPropietarioDAO{

	@Override
	public int insertar(PropietarioBean bean) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "INSERT INTO tb_propietario VALUES (null,?,?,?,?,?,?)";
			con = new conectaDB().getConexion();
			
			int i = 1;			
			pstm = con.prepareStatement(sql);
			pstm.setString(i++, bean.getNombres());
			pstm.setString(i++, bean.getApellidos());
			pstm.setString(i++, bean.getTelefono());
			pstm.setString(i++, bean.getCorreo());
			pstm.setInt(i++, bean.getIdTipoDocumento());
			pstm.setString(i++, bean.getNroDocumento());
			
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
			String sql = "delete from tb_propietario where idPropietario = ?";
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
	public int actualizar(PropietarioBean bean) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "update tb_propietario set nombres = ?, apellidos = ?, telefono = ?,"
					+ "correo = ?, idTipoDocumento = ?, nroDocumento = ? where idPropietario = ?";
			con = new conectaDB().getConexion();
			
			int i = 1;			
			pstm = con.prepareStatement(sql);
			pstm.setString(i++, bean.getNombres());
			pstm.setString(i++, bean.getApellidos());
			pstm.setString(i++, bean.getTelefono());
			pstm.setString(i++, bean.getCorreo());
			pstm.setInt(i++, bean.getIdTipoDocumento());
			pstm.setString(i++, bean.getNroDocumento());
			pstm.setInt(i++, bean.getIdPropietario());
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
	public List<PropietarioBean> listarTodos() throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<PropietarioBean> lista = new ArrayList<PropietarioBean>();
		
		try {
			String sql = "select*from tb_propietario";
			con = new conectaDB().getConexion();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			PropietarioBean bean = null;
			
			while(rs.next()) {
				bean = new PropietarioBean();
				bean.setIdPropietario(rs.getInt("idPropietario"));
				bean.setNombres(rs.getString("nombres"));
				bean.setApellidos(rs.getString("apellidos"));
				bean.setTelefono(rs.getString("telefono"));
				bean.setCorreo(rs.getString("correo"));
				bean.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
				bean.setNroDocumento(rs.getString("nroDocumento"));
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
	public PropietarioBean consultarPropietarioPK(int codigo) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		PropietarioBean bean = null;
		
		try {
			String sql = "select*from tb_propietario where idPropietario = ?";
			con = new conectaDB().getConexion();
			pstm = con.prepareStatement(sql);
			int i = 1;
			pstm.setInt(i++, codigo);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				bean = new PropietarioBean();
				
				bean.setIdPropietario(rs.getInt("idPropietario"));
				bean.setNombres(rs.getString("nombres"));
				bean.setApellidos(rs.getString("apellidos"));
				bean.setTelefono(rs.getString("telefono"));
				bean.setCorreo(rs.getString("correo"));
				bean.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
				bean.setNroDocumento(rs.getString("nroDocumento"));
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
