package pe.edu.cibertec.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.edu.cibertec.bean.PacienteBean;
import pe.edu.cibertec.dao.IPacienteDAO;
import pe.edu.cibertec.factory.conectaDB;

public class PacienteDAOImpl implements IPacienteDAO{

	@Override
	public int insertar(PacienteBean bean) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "INSERT INTO tb_paciente VALUES (null,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
			con = new conectaDB().getConexion();
			
			int i = 1;			
			pstm = con.prepareStatement(sql);
			pstm.setString(i++, bean.getNombre());
			pstm.setString(i++, bean.getFecha_nacimiento());
			pstm.setString(i++, bean.getFecha_ingreso());
			pstm.setString(i++, bean.getSexo());
			pstm.setString(i++, bean.getColor());
			pstm.setString(i++, bean.getParticularidad());
			pstm.setDouble(i++, bean.getPeso());
			pstm.setDouble(i++, bean.getFrecuencia_cardiaca());
			pstm.setDouble(i++, bean.getFrecuencia_respiratoria());
			pstm.setString(i++, bean.getColor_mucosa());
			pstm.setString(i++, bean.getTurgencia_piel());
			pstm.setString(i++, bean.getEstado_reproductivo());
			pstm.setString(i++, bean.getEstado_vacuna());
			pstm.setString(i++, bean.getEstado_desparasitacion());
			
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
			String sql = "delete from tb_paciente where idPaciente = ?";
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
	public int actualizar(PacienteBean bean) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "update tb_paciente set nombre = ?, fecha_nacimiento=?, fecha_ingreso=?,"
					+ "color=?, particularidad=?, peso=?, frecuencia_cardiaca=?, frecuencia_respiratoria=?,"
					+ "color_mucosa=?, turgencia_piel=?, estado_reproductivo=?, estado_vacuna=?,"
					+ "estado_desparasitacion=? where idPaciente = ?";
			con = new conectaDB().getConexion();
			
			int i = 1;			
			pstm = con.prepareStatement(sql);
			pstm.setString(i++, bean.getNombre());
			pstm.setString(i++, bean.getFecha_nacimiento());
			pstm.setString(i++, bean.getFecha_ingreso());
			pstm.setString(i++, bean.getSexo());
			pstm.setString(i++, bean.getColor());
			pstm.setString(i++, bean.getParticularidad());
			pstm.setDouble(i++, bean.getPeso());
			pstm.setDouble(i++, bean.getFrecuencia_cardiaca());
			pstm.setDouble(i++, bean.getFrecuencia_respiratoria());
			pstm.setString(i++, bean.getColor_mucosa());
			pstm.setString(i++, bean.getTurgencia_piel());
			pstm.setString(i++, bean.getEstado_reproductivo());
			pstm.setString(i++, bean.getEstado_vacuna());
			pstm.setString(i++, bean.getEstado_desparasitacion());
			pstm.setInt(i++, bean.getIdPaciente());
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
	public List<PacienteBean> listarTodos() throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<PacienteBean> lista = new ArrayList<PacienteBean>();
		
		try {
			String sql = "select*from tb_paciente";
			con = new conectaDB().getConexion();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			PacienteBean bean = null;
			
			while(rs.next()) {
				bean = new PacienteBean();
				
				bean.setIdPaciente(rs.getInt("idPaciente"));
				bean.setNombre(rs.getString("nombre"));
				bean.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
				bean.setFecha_ingreso(rs.getString("fecha_ingreso"));
				bean.setSexo(rs.getString("sexo"));
				bean.setColor(rs.getString("color"));
				bean.setParticularidad(rs.getString("particularidad"));
				bean.setPeso(rs.getDouble("peso"));
				bean.setFrecuencia_cardiaca(rs.getDouble("frecuencia_cardiaca"));
				bean.setFrecuencia_respiratoria(rs.getDouble("frecuencia_respiratoria"));
				bean.setColor_mucosa(rs.getString("color_mucosa"));
				bean.setTurgencia_piel(rs.getString("turgencia_piel"));
				bean.setEstado_reproductivo(rs.getString("estado_reproductivo"));
				bean.setEstado_vacuna(rs.getString("estado_vacuna"));
				bean.setEstado_desparasitacion(rs.getString("estado_desparasitacion"));
								
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
	public PacienteBean consultarPacientePK(int codigo) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		PacienteBean bean = null;
		
		try {
			String sql = "select*from tb_paciente where idPaciente = ?";
			con = new conectaDB().getConexion();
			pstm = con.prepareStatement(sql);
			int i = 1;
			pstm.setInt(i++, codigo);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				bean = new PacienteBean();
				bean.setIdPaciente(rs.getInt("idPaciente"));
				bean.setNombre(rs.getString("nombre"));
				bean.setFecha_nacimiento(rs.getString("fecha_nacimiento"));
				bean.setFecha_ingreso(rs.getString("fecha_ingreso"));
				bean.setSexo(rs.getString("sexo"));
				bean.setColor(rs.getString("color"));
				bean.setParticularidad(rs.getString("particularidad"));
				bean.setPeso(rs.getDouble("peso"));
				bean.setFrecuencia_cardiaca(rs.getDouble("frecuencia_cardiaca"));
				bean.setFrecuencia_respiratoria(rs.getDouble("frecuencia_respiratoria"));
				bean.setColor_mucosa(rs.getString("color_mucosa"));
				bean.setTurgencia_piel(rs.getString("turgencia_piel"));
				bean.setEstado_reproductivo(rs.getString("estado_reproductivo"));
				bean.setEstado_vacuna(rs.getString("estado_vacuna"));
				bean.setEstado_desparasitacion(rs.getString("estado_desparasitacion"));
				
			}
						
		} catch (Exception e) {
			System.out.println(e);
		}finally {
				if(rs != null) rs.close();
				if(pstm != null) pstm.close();
				if(con != null) con.close();
			
		}
		
		return bean;
	}

}
