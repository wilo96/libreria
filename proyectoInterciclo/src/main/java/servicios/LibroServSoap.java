package servicios;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import controlador.categoriaControlador;
import controlador.libroControlador;
import controlador.usuarioControlador;
import modelo.Categoria;
import modelo.Libro;
import modelo.Usuario;

@WebService
public class LibroServSoap {
	@Inject
	private categoriaControlador cc;
	
	@Inject
	private libroControlador lc;

	@Inject
	private usuarioControlador uc;

	@WebMethod
	public  List<Categoria> getCategorias(){
		return cc.listado();
	}
	
	@WebMethod
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

	@WebMethod
	public List<Libro> getLibros(){
		return lc.listado();
	}
	
	@WebMethod
	public List<Usuario> getUsuarios(){
		return uc.listado();
	}
	
	@WebMethod
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
