package pe.edu.cibertec.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.edu.cibertec.bean.ProductoBean;
import pe.edu.cibertec.dao.ICategoriaDAO;
import pe.edu.cibertec.dao.IMarcaDAO;
import pe.edu.cibertec.dao.IProductoDAO;
import pe.edu.cibertec.dao.IProveedorDAO;
import pe.edu.cibertec.dao.IUnidadMedidaDAO;
import pe.edu.cibertec.factory.DAOFactory;
import pe.edu.cibertec.factory.conectaDB;

public class ProductoDAOImpl implements IProductoDAO{
	DAOFactory factoria = DAOFactory.getFactory(DAOFactory.MYSQL);	
	IMarcaDAO daoMarca = factoria.getMarca();
	ICategoriaDAO daoCategoria = factoria.getCategoria();
	IProveedorDAO daoProveedor = factoria.getProveedor();
	IUnidadMedidaDAO daoUnidad = factoria.getUnidadMedida();
	
	@Override
	public int insertar(ProductoBean bean) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "INSERT INTO tb_producto VALUES (null,?,?,?,?,?,?,?,?)";
			con = new conectaDB().getConexion();
			
			int i = 1;			
			pstm = con.prepareStatement(sql);
			pstm.setString(i++, bean.getDescripcion());
			pstm.setInt(i++, bean.getIdMarca());
			pstm.setDouble(i++, bean.getPrecioCompra());
			pstm.setInt(i++, bean.getIdCategoria());
			pstm.setInt(i++, bean.getIdProveedor());
			pstm.setInt(i++, bean.getIdUniMedida());
			pstm.setInt(i++, bean.getStockActual());
			pstm.setInt(i++, bean.getStockMinimo());
			
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
			String sql = "delete from tb_producto where idProducto = ?";
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
	public int actualizar(ProductoBean bean) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "update tb_producto set descripcion = ?, idMarca = ?, precio_compra = ?,"
					+ "idCategoria = ?, idProveedor = ?, idUniMedida = ?, stock_actual = ?, stock_minimo = ? where idProducto = ?";
			con = new conectaDB().getConexion();
			
			int i = 1;			
			pstm = con.prepareStatement(sql);
			pstm.setString(i++, bean.getDescripcion());
			pstm.setInt(i++, bean.getIdMarca());
			pstm.setDouble(i++, bean.getPrecioCompra());
			pstm.setInt(i++, bean.getIdCategoria());
			pstm.setInt(i++, bean.getIdProveedor());
			pstm.setInt(i++, bean.getIdUniMedida());
			pstm.setInt(i++, bean.getStockActual());
			pstm.setInt(i++, bean.getStockMinimo());
			pstm.setInt(i++, bean.getIdProducto());
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
	public List<ProductoBean> listarTodos() throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<ProductoBean> lista = new ArrayList<ProductoBean>();
		
		try {
			String sql = "select*from tb_producto";
			con = new conectaDB().getConexion();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			ProductoBean bean = null;
			
			while(rs.next()) {
				bean = new ProductoBean();
				bean.setIdProducto(rs.getInt("idProducto"));
				bean.setDescripcion(rs.getString("descripcion"));
				bean.setIdMarca(rs.getInt("idMarca"));
				bean.setPrecioCompra(rs.getDouble("precio_compra"));
				bean.setIdCategoria(rs.getInt("idCategoria"));
				bean.setIdProveedor(rs.getInt("idProveedor"));
				bean.setIdUniMedida(rs.getInt("idUniMedida"));
				bean.setStockActual(rs.getInt("stock_actual"));
				bean.setStockMinimo(rs.getInt("stock_minimo"));
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
	public ProductoBean consultarProductoPK(int codigo) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		ProductoBean bean = null;
		
		try {
			String sql = "select*from tb_producto where idProducto = ?";
			con = new conectaDB().getConexion();
			pstm = con.prepareStatement(sql);
			int i = 1;
			pstm.setInt(i++, codigo);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				bean = new ProductoBean();
				
				bean.setIdProducto(rs.getInt("idProducto"));
				bean.setDescripcion(rs.getString("descripcion"));
				bean.setIdMarca(rs.getInt("idMarca"));
				bean.setPrecioCompra(rs.getDouble("precio_compra"));
				bean.setIdCategoria(rs.getInt("idCategoria"));
				bean.setIdProveedor(rs.getInt("idProveedor"));
				bean.setIdUniMedida(rs.getInt("idUniMedida"));
				bean.setStockActual(rs.getInt("stock_actual"));
				bean.setStockMinimo(rs.getInt("stock_minimo"));
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
