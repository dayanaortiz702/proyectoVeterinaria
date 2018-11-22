package pe.edu.cibertec.factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conectaDB {
	public Connection getConexion() {
		Connection cn = null;
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			cn = DriverManager.getConnection("jdbc:mysql://localhost:3306/bd_veterinaria", "root", "mysql");
			return cn;
		} catch (SQLException e) {
			e.printStackTrace();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return cn;
		
	}
}
