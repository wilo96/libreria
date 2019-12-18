package servicios;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import controlador.categoriaControlador;
import controlador.libroControlador;
import modelo.Categoria;
import modelo.Libro;

@Path("/libros")
public class ServiciosLibros {
	
	@Inject
	private categoriaControlador lc;
	
	@Inject
	private libroControlador lic;
	
	@GET
	@Path("consultar")
	@Produces("application/json")
	public  List<Categoria> getCategorias(){
		return lc.listado();
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public respuestaLibros crearLibro(Libro libro)
	{
		respuestaLibros r = new respuestaLibros();
		try
		{
		r.setCodigo(0);
		r.setMensaje("Libro Insertado");
		lic.nuevoLibro(libro);
		}catch(Exception e)
		{
			r.setCodigo(99);
			r.setMensaje("Error Insertando Libro");
		}
		return r;
	}
	
}
