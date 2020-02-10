package controlador;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import Datos.categoriasDAO;
import Datos.librosDAO;
import modelo.Libros;
import modelo.Usuarios;


@ManagedBean
@ViewScoped
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

	public Libros filtrar(int cod) {
		 return ldao.buscar(cod);
	}

	
	public String editarLibro() {
		ldao.editar(libro);
		return "blank";
	}
	
	public String editarLibros(Libros l) {
		ldao.editar(l);
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
