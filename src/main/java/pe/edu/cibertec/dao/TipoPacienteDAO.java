package pe.edu.cibertec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import pe.edu.cibertec.factory.conectaDB;

public class TipoPacienteDAO {

	public ResultSet listarTipoPaciente() {
		
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
	
			try {
				cn= new conectaDB().getConexion();
				String sql="select idTipo, tipo from tb_tipo_paciente";
				pstm=cn.prepareStatement(sql);
				rs=pstm.executeQuery();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return rs;
	
	}
	
	
}
