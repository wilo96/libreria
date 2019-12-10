package controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import Datos.usuariosDAO;
import modelo.Usuario;

@ManagedBean
@ViewScoped
public class usuarioControlador {
	
	private Usuario usuario;
	private List<Usuario> listaU;
	
	@Inject
	private usuariosDAO udao;
	
	@PostConstruct
	public void init() {
		usuario = new Usuario();
		listaU = udao.listarUsuarios();
	}
	
	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
	
	public List<Usuario> getListaU() {
		return listaU;
	}

	public void setListaU(List<Usuario> listaU) {
		this.listaU = listaU;
	}
	
	public String listado() {
		listaU = udao.listarUsuarios();
		return null;
	}
	
	public String filtrar() {
		listaU = udao.listadoBuscar(usuario.getCedula());
		return null;
	}

	
	public String guardarUsuario() {
		System.out.println(usuario);
		udao.insertar(usuario);
		return null;
	}
	
	public String editarUsuario() {
		System.out.println();
		udao.editar(usuario);
		return null;
	}
	
	public String eliminarUsuario(String cedula) {
		udao.eliminar(cedula);
		return null;
	}
	
	public String Buscar() {
		Usuario u=udao.buscar(usuario.getCedula());
		listado();
		usuario=u;
		return null;
	}

}
