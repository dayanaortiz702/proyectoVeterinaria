package pe.edu.cibertec.action;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.opensymphony.xwork2.ActionSupport;

import pe.edu.cibertec.bean.CategoriaBean;
import pe.edu.cibertec.bean.MarcaBean;
import pe.edu.cibertec.bean.ProductoBean;
import pe.edu.cibertec.bean.ProveedorBean;
import pe.edu.cibertec.bean.UnidadMedidaBean;
import pe.edu.cibertec.service.CategoriaService;
import pe.edu.cibertec.service.MarcaService;
import pe.edu.cibertec.service.ProductoService;
import pe.edu.cibertec.service.ProveedorService;
import pe.edu.cibertec.service.UnidadMedidaService;
import pe.edu.cibertec.service.Impl.CategoriaServiceImpl;
import pe.edu.cibertec.service.Impl.MarcaServiceImpl;
import pe.edu.cibertec.service.Impl.ProductoServiceImpl;
import pe.edu.cibertec.service.Impl.ProveedorServiceImpl;
import pe.edu.cibertec.service.Impl.UnidadMedidaServiceImpl;


public class ProductoAction extends ActionSupport{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private ProductoService productoService = new ProductoServiceImpl();
	private MarcaService marcaService = new MarcaServiceImpl();
	private CategoriaService categoriaService = new CategoriaServiceImpl();
	private ProveedorService proveedorService = new ProveedorServiceImpl();
	private UnidadMedidaService unidadService = new UnidadMedidaServiceImpl();
	
	private List<ProductoBean> grdProducto;
	private List<MarcaBean> cbMarca;
	private List<CategoriaBean> cbCategoria;
	private List<ProveedorBean> cbProveedor;
	private List<UnidadMedidaBean> cbUnidad;
	
	private int rows;
	private ProductoBean registro = new ProductoBean();
	private int codigo;
	private String mensaje;
	
	private static final Log log = LogFactory.getLog(ProductoAction.class);
	
	
	@Override
	public String execute(){
		log.info("En listar producto");
		
		try {
			this.setGrdProducto(productoService.listarTodos());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}

	public String nuevoProducto() {
		log.info("En nuevo producto");
		
		try {
			setCbMarca(marcaService.listarTodos());
			setCbCategoria(categoriaService.listarTodos());
			setCbProveedor(proveedorService.listarTodos());
			setCbUnidad(unidadService.listarTodos());
			setRegistro(new ProductoBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String insertarProducto() {
		log.info("En insertar Producto");
		try {
			productoService.insertar(registro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return execute();
	}
	
	public String eliminarProducto() {
		log.info("En eliminar Producto");
		
		try {
			productoService.eliminar(codigo);
			setMensaje("Se eliminó Producto");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
	}
	
	public String editarProducto() {
		log.info("En editar Producto");
		
		try {
			setCbMarca(marcaService.listarTodos());
			setCbCategoria(categoriaService.listarTodos());
			setCbProveedor(proveedorService.listarTodos());
			setCbUnidad(unidadService.listarTodos());
			setRegistro(new ProductoBean());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return SUCCESS;
	}
	
	public String actualizarProducto() {
		log.info("En actualizar Producto");
		
		try {
			productoService.actualizar(getRegistro());
			setMensaje("Se actualizó Producto");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return execute();
		
	}

	public ProductoService getProductoService() {
		return productoService;
	}

	public void setProductoService(ProductoService productoService) {
		this.productoService = productoService;
	}

	public MarcaService getMarcaService() {
		return marcaService;
	}

	public void setMarcaService(MarcaService marcaService) {
		this.marcaService = marcaService;
	}

	public CategoriaService getCategoriaService() {
		return categoriaService;
	}

	public void setCategoriaService(CategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	public ProveedorService getProveedorService() {
		return proveedorService;
	}

	public void setProveedorService(ProveedorService proveedorService) {
		this.proveedorService = proveedorService;
	}

	public UnidadMedidaService getUnidadService() {
		return unidadService;
	}

	public void setUnidadService(UnidadMedidaService unidadService) {
		this.unidadService = unidadService;
	}

	public List<ProductoBean> getGrdProducto() {
		return grdProducto;
	}

	public void setGrdProducto(List<ProductoBean> grdProducto) {
		this.grdProducto = grdProducto;
	}


	public List<MarcaBean> getCbMarca() {
		return cbMarca;
	}

	public void setCbMarca(List<MarcaBean> cbMarca) {
		this.cbMarca = cbMarca;
	}

	public List<CategoriaBean> getCbCategoria() {
		return cbCategoria;
	}

	public void setCbCategoria(List<CategoriaBean> cbCategoria) {
		this.cbCategoria = cbCategoria;
	}

	public List<ProveedorBean> getCbProveedor() {
		return cbProveedor;
	}

	public void setCbProveedor(List<ProveedorBean> cbProveedor) {
		this.cbProveedor = cbProveedor;
	}

	public List<UnidadMedidaBean> getCbUnidad() {
		return cbUnidad;
	}

	public void setCbUnidad(List<UnidadMedidaBean> cbUnidad) {
		this.cbUnidad = cbUnidad;
	}

	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}

	public ProductoBean getRegistro() {
		return registro;
	}

	public void setRegistro(ProductoBean registro) {
		this.registro = registro;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String getMensaje() {
		return mensaje;
	}

	public void setMensaje(String mensaje) {
		this.mensaje = mensaje;
	}

	
}
