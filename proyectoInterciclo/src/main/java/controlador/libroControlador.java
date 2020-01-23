package controlador;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;

import Datos.categoriasDAO;
import Datos.librosDAO;
import modelo.Libros;
import modelo.Usuarios;

//@ManagedBean
//@ViewScoped
@Stateless
public class libroControlador {
	private Libros libro;
	
	@Inject
	private librosDAO ldao;
	@Inject
	private categoriasDAO cdao;
	
	@PostConstruct
	public void init() {
		libro = new Libros();
	}
	
	public Libros getLibro() {
		return libro;
	}

	public void setLibro(Libros libro) {
		this.libro = libro;
	}

	public List<Libros> listado() {
		return ldao.listarLibro();
	}

	
	public String guardarLibro() {
		System.out.println(libro);
		ldao.insertar(libro);
		return null;
	}

	
	public String nuevoLibro(Libros libros) {
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
	public Libros filtrar() {
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
		Libros l=ldao.buscar(libro.getCodigo());
		listado();
		libro=l;
		return "blank";
	}
	
}
