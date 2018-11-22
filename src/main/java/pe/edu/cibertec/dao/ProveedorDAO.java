package pe.edu.cibertec.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pe.edu.cibertec.factory.conectaDB;

public class ProveedorDAO {
	conectaDB con = new conectaDB();
	
	public ResultSet report() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * from tb_proveedor";
			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (con.getConexion() != null) {
				con.getConexion().close();
			}
		}
	}

	// insert
	public int registerProveedor(String tipoDocumento, String nroDocumento, String razonSocial, String telefono,
			String direccion) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO tb_proveedor VALUES (null,?,?,?,?,?)";
			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			ps.setString(1, tipoDocumento);
			ps.setString(2, nroDocumento);
			ps.setString(3, razonSocial);
			ps.setString(4, telefono);
			ps.setString(5, direccion);

			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (con.getConexion() != null) {
				con.getConexion().close();
			}
		}
	}

	// Select
	public ResultSet detalleProveedor(String idproveedor) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * from tb_proveedor WHERE idProveedor=?";
			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			ps.setString(1, idproveedor);
			rs = ps.executeQuery();
			return rs;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		} finally {
			if (con.getConexion() != null) {
				con.getConexion().close();
			}
		}
	}

	// update
	public int updateProveedor(String idTipoDocumento, String nroDocumento, String razonSocial, String telefono,
			String direccion, String idproveedor) throws SQLException, Exception {
		
		con.getConexion().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "UPDATE tb_proveedor SET idTipoDocumento=?, nroDocumento=?, razon_social=?, "
									+ "telefono=?, direccion = ? WHERE idProveedor=?";
			
			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			
			
			ps.setString(1, idTipoDocumento);
			ps.setString(2, nroDocumento);
			ps.setString(3, razonSocial);				
			ps.setString(4, telefono);
			ps.setString(5, direccion);
			ps.setString(6, idproveedor);
			
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			con.getConexion().rollback();
			return 0;
		} finally {
			if (con.getConexion() != null) {
				con.getConexion().close();
			}
		}
	}

	// delete
	public int deleteProveedor(String idproveedor) throws SQLException, Exception {
		con.getConexion().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "DELETE FROM tb_proveedor WHERE idProveedor=?";
			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			ps.setString(1, idproveedor);
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			con.getConexion().rollback();
			return 0;
		} finally {
			if (con.getConexion() != null) {
				con.getConexion().close();
			}
		}
	}
}
