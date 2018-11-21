package test;

import java.sql.SQLException;
import java.util.List;

import pe.edu.cibertec.bean.ProductoBean;
import pe.edu.cibertec.bean.ProveedorBean;
import pe.edu.cibertec.dao.ProductoDAO;
import pe.edu.cibertec.dao.PropietarioDAO;
import pe.edu.cibertec.dao.ProveedorDAO;

public class MainTest {
	 public static void main(String[] args) throws SQLException, Exception {
		 ProductoDAO dao = new ProductoDAO();
		 ProveedorDAO dao2 = new ProveedorDAO();
		 PropietarioDAO dao3 = new PropietarioDAO();
//		
//			List<ProductoBean> lst = dao.listarAll();	
//			System.out.println("----------------------------------------------");
//			for(ProductoBean objCategoria : lst){
//				System.out.println("ID: "+objCategoria.getIdProducto()+" Nombre: "+objCategoria.getIdUniMedida());
//			}
		 	
			
//			ProveedorBean bean = new ProveedorBean();
//			bean.setDireccion("calle los brillantes");
//			
//			dao2.updateProveedor("3", "12345678912", "Empresa Anonima Cerrada", "123456", "los brillantes 123", "1");			

		 dao3.reportPropietario();
	 
	 }
}
