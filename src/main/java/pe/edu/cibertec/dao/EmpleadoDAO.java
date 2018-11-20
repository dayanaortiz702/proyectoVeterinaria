package pe.edu.cibertec.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class EmpleadoDAO {
	MySqlConexion con = new MySqlConexion();
	// method for save user data in database
		public int registerEmpleado(String nombre, String apellido, String tipodoc, String numdoc, 
									String telefono, String correo, String direccion, String fecha_nac,
									String fecha_ingreso, String idcargo, String idusuario) throws Exception {
			int i = 0;
			try {
				String sql = "INSERT INTO tb_empleado VALUES (null,?,?,?,?,?,?,?,?,?,?,?)";
				PreparedStatement ps = con.getConnection().prepareStatement(sql);
				ps.setString(1, nombre);
				ps.setString(2, apellido);
				ps.setString(3, tipodoc);
				ps.setString(4, numdoc);
				ps.setString(5, telefono);
				ps.setString(6, correo);
				ps.setString(7, direccion);
				ps.setString(8, fecha_nac);
				ps.setString(9, fecha_ingreso);
				ps.setString(10, idcargo);
				ps.setString(11, idusuario);
				
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

		// method for fetch saved user data
		public ResultSet report() throws SQLException, Exception {
			ResultSet rs = null;
			try {
				String sql = "SELECT * from tb_empleado";
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

		// method for fetch old data to be update
		public ResultSet detalleEmpleado(String idempleado) throws SQLException, Exception {
			ResultSet rs = null;
			try {
				String sql = "SELECT * from tb_empleado WHERE idEmpleado=?";
				PreparedStatement ps = con.getConnection().prepareStatement(sql);
				ps.setString(1, idempleado);
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

		// method for update new data in database
		public int updateEmpleado(String nombre, String apellido, String tipodoc, String numdoc, 
								  String telefono, String correo, String direccion, String fecha_nac,
								  String fecha_ingreso, String idcargo, String idusuario, String idempleado)
								  throws SQLException, Exception {
			
			con.getConnection().setAutoCommit(false);
			int i = 0;
			try {
				String sql = "UPDATE tb_empleado SET nombres=?, apellidos=?, idTipoDocumento=?, "
												+ "nroDocumento=?,telefono=?, correo=?, direccion=?,"
												+ "fecha_nac=?, fecha_ingreso=?, idCargo=?, idUsuario=? WHERE idEmpleado=?";
				
				PreparedStatement ps = con.getConnection().prepareStatement(sql);
				
				ps.setString(1, nombre);
				ps.setString(2, apellido);
				ps.setString(3, tipodoc);
				ps.setString(4, numdoc);
				ps.setString(5, telefono);
				ps.setString(6, correo);
				ps.setString(7, direccion);
				ps.setString(8, fecha_nac);
				ps.setString(9, fecha_ingreso);
				ps.setString(10, idcargo);
				ps.setString(11, idusuario);
				ps.setString(12, idempleado);
				
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

		// method for delete the record
		public int deleteEmpleado(String idempleado) throws SQLException, Exception {
			con.getConnection().setAutoCommit(false);
			int i = 0;
			try {
				String sql = "DELETE FROM tb_empleado WHERE idEmpleado=?";
				PreparedStatement ps = con.getConnection().prepareStatement(sql);
				ps.setString(1, idempleado);
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

