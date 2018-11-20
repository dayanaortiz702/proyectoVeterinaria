package pe.edu.cibertec.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class TipoDocumentoDAO {
	public ResultSet listarTipoDoc() {
		Connection cn=null;
		PreparedStatement pstm=null;
		ResultSet rs=null;
	
			try {
				cn=MySqlConexion.getConnection();
				String sql="select idTipoDocumento, descripcion from tb_tipo_documento";
				pstm=cn.prepareStatement(sql);
				rs=pstm.executeQuery();
				
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			return rs;
	
	}
}
