package controlador;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

import Datos.librosDAO;
import modelo.Libro;
import modelo.Usuario;

@ManagedBean
public class libroControlador {
	private Libro libro;
	
	@Inject
	private librosDAO ldao;
	
	@PostConstruct
	public void init() {
		libro = new Libro();
	}
	
	public Libro getLibro() {
		return libro;
	}

	public void setLibro(Libro libro) {
		this.libro = libro;
	}
	
	public String guardarLibro() {
		System.out.println(libro);
		ldao.insertar(libro);
		return null;
	}
}
