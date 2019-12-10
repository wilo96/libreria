package controlador;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

import Datos.categoriasDAO;
import modelo.Categoria;

@ManagedBean
public class categoriaControlador {
	private Categoria categoria;
	
	@Inject
	private categoriasDAO cdao;
	
	@PostConstruct
	public void init() {
		categoria = new Categoria();
	}
	
	public Categoria getUsuario() {
		return categoria;
	}

	public void setUsuario(Categoria categoria) {
		this.categoria = categoria;
	}
	
	public String guardarCategoria() {
		System.out.println(categoria);
		cdao.insertar(categoria);
		return null;
	}
}
