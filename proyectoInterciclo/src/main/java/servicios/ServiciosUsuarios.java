package servicios;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

import controlador.usuarioControlador;
import modelo.Usuario;

@Path("/Usuarios")
public class ServiciosUsuarios {
	@Inject
	private usuarioControlador uc;
	/*
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
	}*/
}
