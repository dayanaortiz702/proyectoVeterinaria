package pe.edu.cibertec.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import pe.edu.cibertec.factory.conectaDB;

public class PacienteDAO {
	
	conectaDB con = new  conectaDB();
	
	public int registerPaciente(String nombre, String fecha_nacimiento, String fecha_ingreso, String sexo, String color,
			String particularidad, String peso, String frecuencia_cardiaca, String frecuencia_respiratoria,
			String color_mucosa, String turgencia_piel, String estado_reproductivo, String estado_vacuna, String estado_desparasitacion)
			
					throws Exception {
		int i = 1;
		try {
			String sql = "INSERT INTO tb_paciente VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";				

			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			
			ps.setString(1, nombre);
			ps.setString(2, fecha_nacimiento);
			ps.setString(3, fecha_ingreso);
			ps.setString(4, sexo);
			ps.setString(5, color);
			ps.setString(6, particularidad);
			ps.setString(7, peso);
			ps.setString(8, frecuencia_cardiaca);
			ps.setString(9, frecuencia_respiratoria);
			ps.setString(10,color_mucosa);
			ps.setString(11, turgencia_piel);
			ps.setString(12, estado_reproductivo);
			ps.setString(13, estado_vacuna);
			ps.setString(14, estado_desparasitacion);

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
	
	public ResultSet reportPaciente() throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * from tb_paciente";
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
	public ResultSet detallePaciente(String idPaciente) throws SQLException, Exception {
		ResultSet rs = null;
		try {
			String sql = "SELECT * from tb_paciente WHERE idPaciente=?";
			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			ps.setString(1, idPaciente);
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
	public int updatePaciente(String color,String particularidad, String peso,String turgencia_piel, String estado_reproductivo,String idPaciente) throws SQLException, Exception {

		con.getConexion().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "UPDATE tb_paciente SET   "
					+ "color=?, particularidad=?, peso=?, "
					+ " turgencia_piel=?, estado_reproductivo=? "
					+ "WHERE idPaciente=?";
		

			PreparedStatement ps = con.getConexion().prepareStatement(sql);

			ps.setString(1, color);
			ps.setString(2, particularidad);
			ps.setString(3, peso);
			ps.setString(4, turgencia_piel);
			ps.setString(5, estado_reproductivo);
			ps.setString(6, idPaciente);

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

	// method for delete the record
	public int deletePaciente(String idPaciente) throws SQLException, Exception {
		con.getConexion().setAutoCommit(false);
		int i = 0;
		try {
			String sql = "DELETE FROM tb_paciente WHERE idPaciente=?";
			PreparedStatement ps = con.getConexion().prepareStatement(sql);
			ps.setString(1, idPaciente);
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
