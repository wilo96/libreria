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
import modelo.Libros;
import controlador.usuarioControlador;
import modelo.Usuarios;

@Path("/libros")
public class ServiciosLibros {
	
	@Inject
	private categoriaControlador cc;
	
	@Inject
	private libroControlador lc;

	@Inject
	private usuarioControlador uc;

	@GET
	@Path("consultar")
	@Produces("application/json")
	public  List<Categoria> getCategorias(){
		System.out.println("Esta entrando");
		return cc.listado();
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public respuestaLibros crearLibro(Libros libro)
	{
		respuestaLibros r = new respuestaLibros();
		try
		{
		r.setCodigo(0);
		r.setMensaje("Libro Insertado");
		lc.nuevoLibro(libro);
		}catch(Exception e)
		{
			r.setCodigo(99);
			r.setMensaje("Error Insertando Libro");
		}
		return r;
	}

	@GET
	@Path("/listLibros")
	@Produces("application/json")
	public List<Libros> getLibros(){
		return lc.listado();
	}
	
	@GET
	@Path("/listUsuarios")
	@Produces("application/json")
	public List<Usuarios> getUsuarios(){
		return uc.listado();
	}
	
	
	
	
}
