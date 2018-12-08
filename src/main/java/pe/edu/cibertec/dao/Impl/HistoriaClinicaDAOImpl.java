package pe.edu.cibertec.dao.Impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import pe.edu.cibertec.bean.HistoriaClinicaBean;
import pe.edu.cibertec.dao.IDistritoDAO;
import pe.edu.cibertec.dao.IHistoriaClinicaDAO;
import pe.edu.cibertec.dao.IPacienteDAO;
import pe.edu.cibertec.dao.IPropietarioDAO;
import pe.edu.cibertec.dao.ITipoPacienteDAO;
import pe.edu.cibertec.factory.DAOFactory;
import pe.edu.cibertec.factory.conectaDB;

public class HistoriaClinicaDAOImpl implements IHistoriaClinicaDAO{
	DAOFactory factoria = DAOFactory.getFactory(DAOFactory.MYSQL);	
	ITipoPacienteDAO daoTipoPaciente = factoria.getTipoPaciente();
	IPacienteDAO daoPaciente = factoria.getPaciente();
	IPropietarioDAO daoPropietario = factoria.getPropietario();
	IDistritoDAO daoDistrito = factoria.getDistrito();
	
	@Override
	public int insertar(HistoriaClinicaBean bean) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "INSERT INTO tb_historia_clinica VALUES (null,?,?,?,?,?,?)";
			con = new conectaDB().getConexion();
			
			int i = 1;			
			pstm = con.prepareStatement(sql);
			pstm.setString(i++, bean.getFecha());
			pstm.setString(i++, bean.getMotivoConsulta());
			pstm.setInt(i++, bean.getIdTipoPaciente());
			pstm.setInt(i++, bean.getIdPaciente());
			pstm.setInt(i++, bean.getIdPropietario());
			pstm.setInt(i++, bean.getIdDistrito());
			
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
			String sql = "delete from tb_historia_clinica where idFicha = ?";
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
	public int actualizar(HistoriaClinicaBean bean) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		
		int insertados = -1;
		try {
			String sql = "update tb_historia_clinica set fecha = ?, motivo_consulta=?, idTipo=?,"
					+ "idPaciente=?, idPropietario=?, idDistrito=? where idFicha = ?";
			con = new conectaDB().getConexion();
			
			int i = 1;			
			pstm = con.prepareStatement(sql);
			pstm.setString(i++, bean.getFecha());
			pstm.setString(i++, bean.getMotivoConsulta());
			pstm.setInt(i++, bean.getIdTipoPaciente());
			pstm.setInt(i++, bean.getIdPaciente());
			pstm.setInt(i++, bean.getIdPropietario());
			pstm.setInt(i++, bean.getIdDistrito());
			pstm.setInt(i++, bean.getIdFicha());
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
	public List<HistoriaClinicaBean> listarTodos() throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		
		List<HistoriaClinicaBean> lista = new ArrayList<HistoriaClinicaBean>();
		
		try {
			String sql = "select*from tb_historia_clinica";
			con = new conectaDB().getConexion();
			pstm = con.prepareStatement(sql);
			rs = pstm.executeQuery();
			HistoriaClinicaBean bean = null;
			
			while(rs.next()) {
				bean = new HistoriaClinicaBean();
				bean.setIdFicha(rs.getInt("idFicha"));
				bean.setFecha(rs.getString("fecha"));
				bean.setMotivoConsulta(rs.getString("motivo_consulta"));
				bean.setIdTipoPaciente(rs.getInt("idTipo"));
				//bean.setTipoPaciente(daoPaciente.consultarEstadoPK(rs.getInt("idEstado")));
//				bean.setIdPerfil(rs.getInt("idPerfil"));
//				bean.setPerfil(daoPerfil.consultarPerfilPK(rs.getInt("idPerfil")));
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
	public HistoriaClinicaBean consultarHistoriaPK(int codigo) throws Exception {
		Connection con = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;
		HistoriaClinicaBean bean = null;
		
		try {
			String sql = "select*from tb_historia_clinica where idFicha = ?";
			con = new conectaDB().getConexion();
			pstm = con.prepareStatement(sql);
			int i = 1;
			pstm.setInt(i++, codigo);
			rs = pstm.executeQuery();
			
			while(rs.next()) {
				bean = new HistoriaClinicaBean();
				
				bean.setIdFicha(rs.getInt("idFicha"));
				bean.setFecha(rs.getString("fecha"));
				bean.setMotivoConsulta(rs.getString("motivo_consulta"));
				bean.setIdTipoPaciente(rs.getInt("idTipo"));
				bean.setIdPaciente(rs.getInt("idPaciente"));
				bean.setIdPropietario(rs.getInt("idPropietario"));
				bean.setIdDistrito(rs.getInt("idDistrito"));
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
