package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import Datos.direccionesDAO;
import Datos.usuariosDAO;
import modelo.Direccion;
import modelo.Usuario;

@ManagedBean
@ViewScoped
public class usuarioControlador {
	private String campoCedula;
	private Usuario usuario;
	private Direccion dir;
	private List<Usuario> listaU;
	
	@Inject
	private usuariosDAO udao;
	
	@Inject
	private direccionesDAO ddao;
	
	@PostConstruct
	public void init() {	
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



	public String getCampoCedula() {
		return campoCedula;
	}

	public void setCampoCedula(String campoCedula) {
		this.campoCedula = campoCedula;
	}

	public List<Usuario> listado() {
		return udao.listarUsuario();
	}
	
	public Usuario filtrar() {
<<<<<<< Upstream, based on branch 'master' of https://github.com/wilo96/libreria.git
		System.out.println("filtrar "+this.campoCedula);
		this.usuario=udao.buscar(this.usuario.getCedula());
		 return udao.buscar(this.usuario.getCedula());
=======
		return this.usuario=udao.buscar(this.usuario.getCedula());
>>>>>>> 2f25540 Actualizacion de Clases
	}

	public String guardarUsuario() {
		System.out.println(usuario);
		//System.out.println(usuario.getCedula());
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
		Usuario u=udao.buscar(this.campoCedula);
		listado();
		usuario=u;
		return null;
	}

}
