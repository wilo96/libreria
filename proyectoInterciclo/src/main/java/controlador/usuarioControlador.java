package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import Datos.direccionesDAO;
import Datos.usuariosDAO;
import modelo.Usuarios;

@Stateless
public class usuarioControlador {
	//private String campoCedula;
	private String campoCedula;
	private Usuarios usuario;
	private List<Usuarios> listaU;
	
	@Inject
	private usuariosDAO udao;
	
	@PostConstruct
	public void init() {
	//	campoCedula=;
		usuario = new Usuarios();
		listaU= new ArrayList<Usuarios>();
	}
	
	public Usuarios getUsuario() {
		return usuario;
	}



	public void setUsuario(Usuarios usuario) {
		this.usuario = usuario;
	}



	public List<Usuarios> getListaU() {
		return listaU;
	}



	public void setListaU(List<Usuarios> listaU) {
		this.listaU = listaU;
	}



	public String getCampoCedula() {
		return campoCedula;
	}

	public void setCampoCedula(String campoCedula) {
		this.campoCedula = campoCedula;
	}
	public List<Usuarios> listado() {
		return udao.listarUsuario();
	}
	
	public Usuarios filtrar(String cedula) {
		System.out.println("filtrar "+cedula);
		this.usuario=udao.buscar(cedula);
		 return udao.buscar(cedula);
	}

	public Usuarios usuarioServicio(String cedula) {
		System.out.println("filtrar "+cedula);
		this.usuario=udao.buscar(cedula);
		 return udao.buscar(cedula);
	}	
	
	public String guardarUsuario() {
		System.out.println(usuario);
		udao.insertar(usuario);
		//ddao.insertar(dir);
		return null;
	}
	
	public String guardarUsuarioServicio(Usuarios usuarioo) {
		System.out.println(usuarioo);
		udao.insertar(usuarioo);
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
	
	
	public String BuscarLog(String correo, String contra) {
		List<Usuarios> u=udao.loginbus(correo, contra);
		String respuesta = String.valueOf(u.get(0));
		return respuesta;
	}
	
	
}
