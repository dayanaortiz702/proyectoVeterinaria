package pe.edu.cibertec.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ProductoDAO {
	MySqlConexion con = new MySqlConexion();
	
	public int registerProducto(String descripcion, String idMarca, String preciocompra, String idCategoria, 
			String idProveedor, String idUnidad, String stockActual, String stockMinimo) throws Exception {
		int i = 0;
		try {
			String sql = "INSERT INTO tb_producto VALUES (null,?,?,?,?,?,?,?,?)";
			PreparedStatement ps = con.getConnection().prepareStatement(sql);
			ps.setString(1, descripcion);
			ps.setString(2, idMarca);
			ps.setString(3, preciocompra);
			ps.setString(4, idCategoria);
			ps.setString(5, idProveedor);
			ps.setString(6, idUnidad);
			ps.setString(7, stockActual);
			ps.setString(8, stockMinimo);
			
			i = ps.executeUpdate();
			return i;
		} catch (Exception e) {
			e.printStackTrace();
			return i;
		} finally {
			if (con.getConnection() != null) {
			con.getConnection().close();
			}
		}
	}
		
		// LIST
		public ResultSet report() throws SQLException, Exception {
		ResultSet rs = null;
			try {
				String sql = "SELECT * from tb_producto";
				PreparedStatement ps = con.getConnection().prepareStatement(sql);
				rs = ps.executeQuery();
				return rs;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			} finally {
				if (con.getConnection() != null) {
				con.getConnection().close();
				}
			}
		}
		
		// select
		public ResultSet detalleProducto(String idproducto) throws SQLException, Exception {
		ResultSet rs = null;
			try {
				String sql = "SELECT * from tb_producto WHERE idProducto=?";
				PreparedStatement ps = con.getConnection().prepareStatement(sql);
				ps.setString(1, idproducto);
				rs = ps.executeQuery();
				return rs;
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			} finally {
				if (con.getConnection() != null) {
					con.getConnection().close();
				}
			}
		}
		
		// update
		public int updateProducto(String descripcion, String idMarca, String precio, 
								  String idProveedor,  String idproducto)
								  throws SQLException, Exception {
		
			con.getConnection().setAutoCommit(false);
			int i = 0;
			try {
				String sql = "UPDATE tb_producto SET descripcion=?, idMarca=?, precio_compra=?, "
										+ "idProveedor=? WHERE idProducto=?";
				
				PreparedStatement ps = con.getConnection().prepareStatement(sql);
				
				
				ps.setString(1, descripcion);
				ps.setString(2, idMarca);
				ps.setString(3, precio);				
				ps.setString(5, idProveedor);
				ps.setString(9, idproducto);
				
				i = ps.executeUpdate();
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				con.getConnection().rollback();
				return 0;
			} finally {
				if (con.getConnection() != null) {
					con.getConnection().close();
				}
			}
		}
		
		// DELETE
		public int deleteProducto(String idproducto) throws SQLException, Exception {
			con.getConnection().setAutoCommit(false);
			int i = 0;
			try {
				String sql = "DELETE FROM tb_producto WHERE idProducto=?";
				PreparedStatement ps = con.getConnection().prepareStatement(sql);
				ps.setString(1, idproducto);
				i = ps.executeUpdate();
				return i;
			} catch (Exception e) {
				e.printStackTrace();
				con.getConnection().rollback();
				return 0;
			} finally {
				if (con.getConnection() != null) {
					con.getConnection().close();
				}
			}
		}
}
