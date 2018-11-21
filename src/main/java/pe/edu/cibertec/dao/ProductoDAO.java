package pe.edu.cibertec.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import pe.edu.cibertec.bean.ProductoBean;

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
		
		public List<ProductoBean> listarAll(){
			List<ProductoBean> lista = new ArrayList<ProductoBean>();
			
			
			try {
				Connection cn = con.getConnection();
				String sql = "SELECT * from tb_producto";
				PreparedStatement ps = con.getConnection().prepareStatement(sql);
				ResultSet rs = ps.executeQuery();
				
				while(rs.next()) {
					ProductoBean producto = new ProductoBean();
					producto.setIdProducto(rs.getInt(1));
					producto.setDescripcion(rs.getString(2));
					producto.setIdMarca(rs.getInt(3));
					producto.setPrecioCompra(rs.getDouble(4));
					producto.setIdCategoria(rs.getInt(5));
					producto.setIdProveedor(rs.getInt(6));
					producto.setIdUniMedida(rs.getInt(7));
					producto.setStockActual(rs.getInt(8));
					producto.setStockMinimo(rs.getInt(9));
					lista.add(producto);
				}
				rs.close();
				ps.close();
				cn.close();
				
			} catch (Exception e) {
				e.printStackTrace();
			}
			return lista;
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
								  String idcategoria, String idProveedor, String idunidad,
								  String stock_a, String stock_m, String idproducto)
								  throws SQLException, Exception {
		
			con.getConnection().setAutoCommit(false);
			int i = 0;
			try {
				String sql = "UPDATE tb_producto SET descripcion=?, idMarca=?, precio_compra=?, "
												  + "idCategoria=?, idProveedor=?, idUniMedida=?,"
												  + "stock_actual=?, stock_minimo=? WHERE idProducto=?";
				
				PreparedStatement ps = con.getConnection().prepareStatement(sql);
								
				ps.setString(1, descripcion);
				ps.setString(2, idMarca);
				ps.setString(3, precio);
				ps.setString(4, idcategoria);
				ps.setString(5, idProveedor);
				ps.setString(6, idunidad);
				ps.setString(7, stock_a);
				ps.setString(8, stock_m);
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
