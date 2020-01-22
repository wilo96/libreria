package controlador;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import Datos.categoriasDAO;
import Datos.librosDAO;
import modelo.Libro;
import modelo.Usuario;

@ManagedBean
@ViewScoped
public class libroControlador {
	private Libro libro;
	
	@Inject
	private librosDAO ldao;
	@Inject
	private categoriasDAO cdao;
	
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

	
	public String guardarLibro() {
		System.out.println(libro);
		ldao.insertar(libro);
		return null;
	}

	
	public String nuevoLibro(Libro libros) {
		System.out.println(libros);
		ldao.insertar(libros);
		return null;
	}


	/*
>>>>>>> branch 'master' of https://github.com/wilo96/libreria.git
	public Libro filtrar() {
		this.libro=ldao.buscar(this.libro.getCodigo());
		 return ldao.buscar(this.libro.getCodigo());
	}*/
	public Libro filtrar() {
		 return ldao.buscar(this.libro.getCodigo());
	}

	
	public String editarLibro() {
		ldao.editar(libro);
		return "blank";
	}
	
	public String eliminarLibro(int codigo) {
		ldao.eliminar(codigo);
		return "blank";
	}
	
	public String Buscar() {
		Libro l=ldao.buscar(libro.getCodigo());
		listado();
		libro=l;
		return "blank";
	}
	
}
