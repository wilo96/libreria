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
public class direccionControlador {
	private Direccion direc;
	private List<Direccion> listaD;
	 
	@Inject
	private direccionesDAO ddao;
	
	@PostConstruct
	public void init() {
		direc = new Direccion();
		listaD= new ArrayList<Direccion>();
	}

	public Direccion getDirec() {
		return direc;
	}

	public void setDirec(Direccion direc) {
		this.direc = direc;
	}

	public List<Direccion> getListaD() {
		return listaD;
	}

	public void setListaD(List<Direccion> listaD) {
		this.listaD = listaD;
	}

	public direccionesDAO getDdao() {
		return ddao;
	}

	public void setDdao(direccionesDAO ddao) {
		this.ddao = ddao;
	}
	
	public List<Direccion> listado() {
		return ddao.listarDireccion();
	}
	
	public Direccion filtrar() {
		this.direc=ddao.buscar(this.direc.getId_usu_FK());
		 return ddao.buscar(this.direc.getId_usu_FK());
	}

	public String guardarDireccion() {
		System.out.println(direc);
		ddao.insertar(direc);
		return "blank";
	}
	
	public String editarDireccion() {
		ddao.editar(direc);
		return "blank";
	}
	
	public String eliminarDireccion(String cedula) {
		ddao.eliminar(cedula);
		return "blank";
	}
	
	public String Buscar() {
		Direccion d=ddao.buscar(direc.getId_usu_FK());
		listado();
		direc=d;
		return "blank";
	
}
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
public class direccionControlador {
	private Direccion direc;
	private List<Direccion> listaD;
	 
	@Inject
	private direccionesDAO ddao;
	
	@PostConstruct
	public void init() {
		direc = new Direccion();
		listaD= new ArrayList<Direccion>();
	}

	public Direccion getDirec() {
		return direc;
	}

	public void setDirec(Direccion direc) {
		this.direc = direc;
	}

	public List<Direccion> getListaD() {
		return listaD;
	}

	public void setListaD(List<Direccion> listaD) {
		this.listaD = listaD;
	}

	public direccionesDAO getDdao() {
		return ddao;
	}

	public void setDdao(direccionesDAO ddao) {
		this.ddao = ddao;
	}
	
	public List<Direccion> listado() {
		return ddao.listarDireccion();
	}
	
	public Direccion filtrar() {
		this.direc=ddao.buscar(this.direc.getId_usu_FK());
		 return ddao.buscar(this.direc.getId_usu_FK());
	}

	public String guardarDireccion() {
		System.out.println(direc);
		ddao.insertar(direc);
		return "blank";
	}
	
	public String editarDireccion() {
		ddao.editar(direc);
		return "blank";
	}
	
	public String eliminarDireccion(String cedula) {
		ddao.eliminar(cedula);
		return "blank";
	}
	
	public String Buscar() {
		Direccion d=ddao.buscar(direc.getId_usu_FK());
		listado();
		direc=d;
		return "blank";
	}
}
