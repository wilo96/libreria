package controlador;

import java.util.List;

import javax.annotation.ManagedBean;
import javax.annotation.PostConstruct;
import javax.inject.Inject;

import Datos.librosDAO;
import modelo.Libro;

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
	
	public List<Libro> listado() {
		return ldao.listarLibro();
	}
	
	public Libro filtrar() {
		 return ldao.buscar(this.libro.getCodigo());
	}

	public String guardarUsuario() {
		System.out.println(libro);
		ldao.insertar(libro);
		return null;
	}
	
	public String editarUsuario() {
		ldao.editar(libro);
		return null;
	}
	
	public String eliminarUsuario(int codigo) {
		ldao.eliminar(codigo);
		return null;
	}
	
	public String Buscar() {
		Libro l=ldao.buscar(libro.getCodigo());
		listado();
		libro=l;
		return null;
	}
}
