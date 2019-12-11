package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import Datos.direccionesDAO;
import Datos.usuariosDAO;
import modelo.Usuario;

@ManagedBean
@ViewScoped
public class usuarioControlador {
	//private String campoCedula;
	private Usuario usuario;
	private List<Usuario> listaU;
	
	@Inject
	private usuariosDAO udao;
	
	@PostConstruct
	public void init() {
	//	campoCedula=;
		usuario = new Usuario();
		listaU= new ArrayList<Usuario>();
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



	public List<Usuario> listado() {
		return udao.listarUsuario();
	}
	
	public Usuario filtrar() {
		System.out.println("filtrar "+this.usuario.getCedula());
		 return udao.buscar(this.usuario.getCedula());
	}

	public String guardarUsuario() {
		System.out.println(usuario);
		udao.insertar(usuario);
		//ddao.insertar(dir);
		return null;
	}
	
	public String editarUsuario() {
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
