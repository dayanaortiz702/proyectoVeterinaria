package pe.edu.cibertec.action;

import java.util.ArrayList;
import java.util.List;

import com.opensymphony.xwork2.ActionSupport;

import pe.edu.cibertec.bean.TipoDocumentoBean;
import pe.edu.cibertec.dao.TipoDocumentoDAO;

public class TipoDocumentoAction extends ActionSupport{

	private List<TipoDocumentoBean> lst = new ArrayList<>();

	public String cargarTipoDoc(){
		System.out.println("Combo");
		TipoDocumentoDAO service = new TipoDocumentoDAO();
		
		try {
			lst = service.listarDocumento();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	public List<TipoDocumentoBean> getLst() {
		return lst;
	}

	public void setLst(List<TipoDocumentoBean> lst) {
		this.lst = lst;
	}
	
	

}
