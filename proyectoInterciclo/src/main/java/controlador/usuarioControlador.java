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
	private String campoCedula;
	private Usuario usuario;
	private List<Usuario> listaU;
	
	@Inject
	private usuariosDAO udao;
	
	@PostConstruct
<<<<<<< Upstream, based on branch 'master' of https://github.com/wilo96/libreria.git
<<<<<<< Upstream, based on branch 'master' of https://github.com/wilo96/libreria.git
	public void init() {	
=======
	public void init() {
	//	campoCedula=;
>>>>>>> 48f9c36 litar
=======
	public void init() {	
>>>>>>> f8508a5 buscar usuario vista
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



<<<<<<< Upstream, based on branch 'master' of https://github.com/wilo96/libreria.git
<<<<<<< Upstream, based on branch 'master' of https://github.com/wilo96/libreria.git
	public String getCampoCedula() {
		return campoCedula;
	}

	public void setCampoCedula(String campoCedula) {
		this.campoCedula = campoCedula;
	}

=======
>>>>>>> 48f9c36 litar
=======
	public String getCampoCedula() {
		return campoCedula;
	}

	public void setCampoCedula(String campoCedula) {
		this.campoCedula = campoCedula;
	}

>>>>>>> f8508a5 buscar usuario vista
	public List<Usuario> listado() {
		return udao.listarUsuario();
	}
	
	public Usuario filtrar() {
<<<<<<< Upstream, based on branch 'master' of https://github.com/wilo96/libreria.git
<<<<<<< Upstream, based on branch 'master' of https://github.com/wilo96/libreria.git
<<<<<<< Upstream, based on branch 'master' of https://github.com/wilo96/libreria.git
		System.out.println("filtrar "+this.campoCedula);
		this.usuario=udao.buscar(this.usuario.getCedula());
		 return udao.buscar(this.usuario.getCedula());
=======
		return this.usuario=udao.buscar(this.usuario.getCedula());
>>>>>>> 2f25540 Actualizacion de Clases
=======
		System.out.println("filtrar "+this.usuario.getCedula());
		 return udao.buscar(this.usuario.getCedula());
>>>>>>> 48f9c36 litar
=======
		System.out.println("filtrar "+this.campoCedula);
		 return udao.buscar(this.campoCedula);
>>>>>>> f8508a5 buscar usuario vista
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
		Usuario u=udao.buscar(this.campoCedula);
		listado();
		usuario=u;
		return null;
	}

}
