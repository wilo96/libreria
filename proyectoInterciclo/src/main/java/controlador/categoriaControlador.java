package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import Datos.categoriasDAO;
import modelo.Categoria;

@ManagedBean
@ViewScoped
public class categoriaControlador {
	private Categoria categoria;
	private List<Categoria> listaCa;
	
	@Inject
	private categoriasDAO cdao;
	
	@PostConstruct
	public void init() {
		categoria = new Categoria();
		listaCa= new ArrayList<Categoria>();
	}
	
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public List<Categoria> getListaCa() {
		return listaCa;
	}

	public void setListaCa(List<Categoria> listaCa) {
		this.listaCa = listaCa;
	}
	
	public List<Categoria> listado() {
		return cdao.listarCategoria();
	}
	
	public Categoria filtrar() {
		 return cdao.buscar(this.categoria.getCodigo());
	}

	
	public String guardarCategoria() {
		System.out.println(categoria);
		cdao.insertar(categoria);
		return null;
	}
	
	public String editarCategoria() {
		cdao.editar(categoria);
		return null;
	}
	
	public String eliminarCategoria(int codigo) {
		cdao.eliminar(codigo);
		return null;
	}
	
	public String Buscar() {
		Categoria c=cdao.buscar(categoria.getCodigo());
		listado();
		categoria=c;
		return null;
	}

}
