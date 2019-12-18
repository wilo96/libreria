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
<<<<<<< HEAD
import modelo.Categoria;
=======
import controlador.usuarioControlador;
>>>>>>> branch 'master' of https://github.com/wilo96/libreria.git
import modelo.Libro;
import modelo.Usuario;

@Path("/libros")
public class ServiciosLibros {
	
	@Inject
	private categoriaControlador cc;
	
	@Inject
	private libroControlador lc;
<<<<<<< HEAD

=======
	@Inject
	private usuarioControlador uc;
>>>>>>> branch 'master' of https://github.com/wilo96/libreria.git
	
	@GET
<<<<<<< HEAD
	@Path("consultar")
	@Produces("application/json")
	public  List<Categoria> getCategorias(){
		return cc.listado();
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
		lc.nuevoLibro(libro);
		}catch(Exception e)
		{
			r.setCodigo(99);
			r.setMensaje("Error Insertando Libro");
		}
		return r;
	}

	@GET
	@Path("listLibros")
=======
	@Path("/listLibros")
>>>>>>> branch 'master' of https://github.com/wilo96/libreria.git
	@Produces("application/json")
	public List<Libro> getLibros(){
		return lc.listado();
	}
	
	@GET
	@Path("/listUsuarios")
	@Produces("application/json")
	public List<Usuario> getUsuarios(){
		return uc.listado();
	}
	
	@POST
	@Path("/logging")
	@Produces("application/json")
	@Consumes("application/json")
	public respuestaLogging logging(Usuario usuario) {
		respuestaLogging r=new respuestaLogging();
		try {
			Usuario u=uc.usuarioServicio(usuario.getCedula());
			if(usuario.getContrasenia().equals(u.getContrasenia())) {
				r.setId(1);
				r.setRespuesta("Se a logueado correctamente");
			}else {
				r.setId(2);
				r.setRespuesta("Contraseña incorrecta");
			}
		} catch (Exception e) {
			r.setId(3);
			r.setRespuesta("Error ocurrido en el logging");
		}
		return r;
	}
}
