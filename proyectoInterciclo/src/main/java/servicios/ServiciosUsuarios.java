package servicios;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import controlador.usuarioControlador;
import modelo.Usuarios;

@Path("/Usuarios")
public class ServiciosUsuarios {
	@Inject
	private usuarioControlador uc;
	
	@GET
	@Path("/buscarusu")
	@Produces("application/json")
	public String BuscarUsuario(@QueryParam("correo") String correo, @QueryParam("contra") String contra) {
		return uc.BuscarLog(correo, contra);
	}
	
	@GET
	@Path("/nuevousu")
	@Produces("application/json")
	public String registrarUsuarioMovil(@QueryParam("cedula") String cedu,@QueryParam("nombres") String nomb,@QueryParam("correo") String correo,@QueryParam("contra") String contra,@QueryParam("telef") String telf) {
		Usuarios usuarioo = new Usuarios();
		usuarioo.setCedula(cedu);
		usuarioo.setAdministrador("NO");
		usuarioo.setContrasenia(contra);
		usuarioo.setCorreo(correo);
		usuarioo.setNombres(nomb);
		usuarioo.setTelefono(telf);
		return uc.guardarUsuarioServicioM(usuarioo);
	}
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
