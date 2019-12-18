package servicios;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import controlador.libroControlador;
import modelo.Libro;

@Path("/libros")
public class ServiciosLibros {
	@Inject
	private libroControlador lc;
	
	@GET
	@Path("consultar")
	@Produces("application/json")
	public List<Libro> getLibros(){
		return (List<Libro>) lc.getLibro();
	}
}
