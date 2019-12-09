package controlador;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import Datos.usuariosDAO;
import modelo.Usuario;

@ManagedBean
public class usuarioControlador {
	
	private Usuario usuario;
	
	@Inject
	private usuariosDAO udao;
	
	@PostConstruct
	public void init() {
		usuario = new Usuario();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public String guardarUsuario() {
		System.out.println(usuario);
		udao.insertar(usuario);
		return null;
	}
}
