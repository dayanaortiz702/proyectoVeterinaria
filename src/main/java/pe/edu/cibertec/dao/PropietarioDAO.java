package pe.edu.cibertec.dao;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class PropietarioDAO {
		
	MySqlConexion con = new MySqlConexion();
	
		public int registerPropietario(String nombre, String apellido,String telefono, String correo,String tipodoc, String numdoc) throws Exception {
			int i = 0;
			try {
				String sql = "INSERT INTO tb_propietario VALUES (null,?,?,?,?,?,?)";
				PreparedStatement ps = con.getConnection().prepareStatement(sql);
				ps.setString(1, nombre);
				ps.setString(2, apellido);
				ps.setString(3, telefono);
				ps.setString(4, correo);
				ps.setString(5, tipodoc);
				ps.setString(6, numdoc);


				
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
		public ResultSet reportPropietario() throws SQLException, Exception {
			ResultSet rs = null;
			try {
				String sql = "select*from tb_propietario";
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
		public ResultSet detallePropietario(String idpropietario) throws SQLException, Exception {
			ResultSet rs = null;
			try {
				String sql = "SELECT idPropietario,nombres,apellidos,telefono,correo,idTipoDocumento,nroDocumento from tb_propietario WHERE idPropietario=?";
				PreparedStatement ps = con.getConnection().prepareStatement(sql);
				ps.setString(1, idpropietario);
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
		public int updatePropietario( String nombre, String apellido, String telefono, String correo, String idTipo, String nroDoc, String idpropietario)
								  throws SQLException, Exception {
			
			con.getConnection().setAutoCommit(false);
			int i = 0;
			try {
				String sql = "UPDATE tb_propietario SET nombres=?, apellidos=?, telefono=?, correo=?,"
						+ "idTipoDocumento=?, nroDocumento=? WHERE idPropietario=?";

				
				PreparedStatement ps = con.getConnection().prepareStatement(sql);
				
				ps.setString(1, nombre);
				ps.setString(2, apellido);
				ps.setString(3, telefono);
				ps.setString(4, correo);
				ps.setString(5, idTipo);
				ps.setString(6, nroDoc);
				ps.setString(7, idpropietario);
				
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
		public int deletePropietario(String idpropietario) throws SQLException, Exception {
			con.getConnection().setAutoCommit(false);
			int i = 0;
			try {
				String sql = "DELETE FROM tb_propietario WHERE idPropietario=?";
				PreparedStatement ps = con.getConnection().prepareStatement(sql);
				ps.setString(1, idpropietario);
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
