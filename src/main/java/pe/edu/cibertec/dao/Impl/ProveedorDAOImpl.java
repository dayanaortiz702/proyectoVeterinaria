package pe.edu.cibertec.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.edu.cibertec.bean.ProveedorBean;
import pe.edu.cibertec.dao.IProveedorDAO;
import pe.edu.cibertec.factory.conectaDB;

public class ProveedorDAOImpl implements IProveedorDAO{

	@Override
	public int insertar(ProveedorBean bean) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "INSERT INTO tb_proveedor VALUES (null,?,?,?,?,?)";
			con = new conectaDB().getConexion();
			
			int i = 1;			
			pstm = con.prepareStatement(sql);
			pstm.setInt(i++, bean.getIdTipoDocumento());
			pstm.setString(i++, bean.getNroDocumento());
			pstm.setString(i++, bean.getRazonSocial());
			pstm.setString(i++, bean.getTelefono());
			pstm.setString(i++, bean.getDireccion());
			
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
			String sql = "delete from tb_proveedor where idProveedor = ?";
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
	public int actualizar(ProveedorBean bean) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "update tb_proveedor set idTipoDocumento = ?, nroDocumento = ?, razon_social = ?,"
					+ "telefono = ?, direccion = ? where idProveedor = ?";
			con = new conectaDB().getConexion();
			
			int i = 1;			
			pstm = con.prepareStatement(sql);
			pstm.setInt(i++, bean.getIdTipoDocumento());
			pstm.setString(i++, bean.getNroDocumento());
			pstm.setString(i++, bean.getRazonSocial());
			pstm.setString(i++, bean.getTelefono());
			pstm.setString(i++, bean.getDireccion());
			pstm.setInt(i++, bean.getIdProveedor());
			
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
	public List<ProveedorBean> listarTodos() throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<ProveedorBean> lista = new ArrayList<ProveedorBean>();
		
		try {
			String sql = "select*from tb_proveedor";
			con = new conectaDB().getConexion();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			ProveedorBean bean = null;
			
			while(rs.next()) {
				bean = new ProveedorBean();
				bean.setIdProveedor(rs.getInt("idProveedor"));
				bean.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
				bean.setNroDocumento(rs.getString("nroDocumento"));
				bean.setRazonSocial(rs.getString("razon_social"));
				bean.setTelefono(rs.getString("telefono"));
				bean.setDireccion(rs.getString("direccion"));
				
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
	public ProveedorBean consultarProveedorPK(int codigo) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ProveedorBean bean = null;
		
		try {
			String sql = "select*from tb_proveedor where idProveedor = ?";
			con = new conectaDB().getConexion();
			pstm = con.prepareStatement(sql);
			int i = 1;
			pstm.setInt(i++, codigo);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				bean = new ProveedorBean();
				
				bean.setIdProveedor(rs.getInt("idProveedor"));
				bean.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
				bean.setNroDocumento(rs.getString("nroDocumento"));
				bean.setRazonSocial(rs.getString("razon_social"));
				bean.setTelefono(rs.getString("telefono"));
				bean.setDireccion(rs.getString("direccion"));
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
