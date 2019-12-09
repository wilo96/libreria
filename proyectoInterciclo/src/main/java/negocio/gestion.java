package negocio;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import Datos.librosDAO;
import modelo.Libro;

public class gestion {
	librosDAO ldao=new librosDAO();
	/*
	public boolean insertarLibro(String descripcion, double precio, int descuento, int categoria, String imagen) {
		libros lib=new libros();
		lib.setDescripcion(descripcion);
		lib.setPrecio(precio);
		lib.setDescuento(descuento);
		lib.setCategoria(categoria);
		lib.setImagen(imagen);
		ldao.insertarLibro(lib);
		return true;
	}
	
	public boolean actualizarLibro(String descripcion, double precio, int descuento, int categoria, String imagen) {
		libros lib=new libros();
		lib.setDescripcion(descripcion);
		lib.setPrecio(precio);
		lib.setDescuento(descuento);
		lib.setCategoria(categoria);
		lib.setImagen(imagen);
		ldao.actualizarLibro(lib);
		return true;
	}
	
	public boolean eliminarLibro(int codigo) {
		libros lib=new libros();
		lib.setCodigo(codigo);
		ldao.eliminarLibro(lib);
		return true;
	}
	
	public ArrayList<libros> listarLibro() {
		ArrayList<libros> lista=new ArrayList<>();
	    lista=ldao.listarLibro();
	    return lista;
	}
	
	public ArrayList<libros> buscarLibro(int codigo) {
		ArrayList<libros> lista=new ArrayList<>();
	    lista=ldao.buscarLibro(codigo);
	    return lista;
	}
	*/
}
