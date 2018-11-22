package pe.edu.cibertec.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.edu.cibertec.bean.EmpleadoBean;
import pe.edu.cibertec.dao.IEmpleadoDAO;
import pe.edu.cibertec.dao.ITipoDocumentoDAO;
import pe.edu.cibertec.factory.DAOFactory;
import pe.edu.cibertec.factory.conectaDB;

public class EmpleadoDAOImpl implements IEmpleadoDAO{
	DAOFactory factoria = DAOFactory.getFactory(DAOFactory.MYSQL);
	ITipoDocumentoDAO dao = factoria.getDocumento();		
	conectaDB conexion = new conectaDB(); 
	
	@Override
	public int insertar(EmpleadoBean bean) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "INSERT INTO tb_empleado VALUES (null,?,?,?,?,?,?,?,?,?,?,?)";
			con = conexion.getConexion();
			
			int i = 1;			
			pstm = con.prepareStatement(sql);
			pstm.setString(i++, bean.getNombres());
			pstm.setString(i++, bean.getApellidos());
			pstm.setInt(i++, bean.getIdTipoDocumento());
			pstm.setString(i++, bean.getNroDocumento());	
			pstm.setString(i++, bean.getTelefono());	
			pstm.setString(i++, bean.getCorreo());	
			pstm.setString(i++, bean.getDireccion());	
			pstm.setString(i++, bean.getFecha_nac());	
			pstm.setString(i++, bean.getFecha_ingreso());	
			pstm.setInt(i++, bean.getIdCargo());	
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
	public int eliminar(int id) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "delete from tb_empleado where idEmpleado = ?";
			con = conexion.getConexion();
			
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
	public int actualizar(EmpleadoBean bean) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "update tb_empleado set nombres = ?, apellidos = ?, idTipoDocumento = ?,"
					+ "nroDocumento = ?, telefono = ?, correo = ?, direccion = ?, fecha_nac = ?,"
					+ "fecha_ingreso = ?, idCargo = ?, idUsuario = ? where idEmpleado = ?";
			con = conexion.getConexion();
			
			int i = 1;			
			pstm = con.prepareStatement(sql);
			pstm.setString(i++, bean.getNombres());
			pstm.setString(i++, bean.getApellidos());
			pstm.setInt(i++, bean.getIdTipoDocumento());
			pstm.setString(i++, bean.getNroDocumento());
			pstm.setString(i++, bean.getTelefono());
			pstm.setString(i++, bean.getCorreo());	
			pstm.setString(i++, bean.getDireccion());	
			pstm.setString(i++, bean.getFecha_nac());	
			pstm.setString(i++, bean.getFecha_ingreso());	
			pstm.setInt(i++, bean.getIdCargo());	
			pstm.setInt(i++, bean.getIdUsuario());
			pstm.setInt(i++, bean.getIdEmpleado());
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
	public List<EmpleadoBean> listarTodos() throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<EmpleadoBean> lista = new ArrayList<EmpleadoBean>();
		
		try {
			String sql = "select*from tb_empleado";
			con = conexion.getConexion();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			EmpleadoBean bean = null;
			
			while(rs.next()) {
				bean = new EmpleadoBean();
				bean.setIdEmpleado(rs.getInt("idEmpleado"));
				bean.setNombres(rs.getString("nombres"));
				bean.setApellidos(rs.getString("apellidos"));
				bean.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
				bean.setTipoDocumento(dao.consultarDocumentoPK(rs.getInt("idTipoDocumento")));
				bean.setNroDocumento(rs.getString("nroDocumento"));
				bean.setTelefono(rs.getString("telefono"));
				bean.setCorreo(rs.getString("correo"));
				bean.setDireccion(rs.getString("direccion"));
				bean.setFecha_nac(rs.getString("fecha_nac"));
				bean.setFecha_ingreso(rs.getString("fecha_ingreso"));
				bean.setIdCargo(rs.getInt("idCargo"));
				bean.setIdUsuario(rs.getInt("idUsuario"));
				
				lista.add(bean);
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
		
		return lista;
	}

	@Override
	public EmpleadoBean consultarEmpleadoPK(int codigo) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		EmpleadoBean bean = null;
		
		try {
			String sql = "select*from tb_empleado where idEmpleado = ?";
			con = conexion.getConexion();
			pstm = con.prepareStatement(sql);
			int i = 1;
			pstm.setInt(i++, codigo);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				bean = new EmpleadoBean();
				
				bean.setIdEmpleado(rs.getInt("idEmpleado"));
				bean.setNombres(rs.getString("nombres"));
				bean.setApellidos(rs.getString("apellidos"));
				bean.setIdTipoDocumento(rs.getInt("idTipoDocumento"));
				bean.setNroDocumento(rs.getString("nroDocumento"));
				bean.setTelefono(rs.getString("telefono"));
				bean.setCorreo(rs.getString("correo"));
				bean.setDireccion(rs.getString("direccion"));
				bean.setFecha_nac(rs.getString("fecha_nac"));
				bean.setFecha_ingreso(rs.getString("fecha_ingreso"));
				bean.setIdCargo(rs.getInt("idCargo"));
				bean.setIdUsuario(rs.getInt("idUsuario"));
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
