package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import Datos.direccionesDAO;
import Datos.usuariosDAO;
import modelo.Direcciones;
import modelo.Usuarios;

@ManagedBean
@ViewScoped
public class direccionControlador {
	private Direcciones direc;
	private List<Direcciones> listaD;
	 
	@Inject
	private direccionesDAO ddao;
	
	@PostConstruct
	public void init() {
		direc = new Direcciones();
		listaD= new ArrayList<Direcciones>();
	}

	public Direcciones getDirec() {
		return direc;
	}

	public void setDirec(Direcciones direc) {
		this.direc = direc;
	}

	public List<Direcciones> getListaD() {
		return listaD;
	}

	public void setListaD(List<Direcciones> listaD) {
		this.listaD = listaD;
	}

	public direccionesDAO getDdao() {
		return ddao;
	}

	public void setDdao(direccionesDAO ddao) {
		this.ddao = ddao;
	}
	
	public List<Direcciones> listado(String cedula) {
		return ddao.listarDireccion(cedula);
	}
	
	public Direcciones filtrar() {
		this.direc=ddao.buscar(this.direc.getId_usu_FK());
		 return ddao.buscar(this.direc.getId_usu_FK());
	}

	public String guardarDireccion(String callep, String calles, String numcaa, String ciud, String prov, String usu) {
		Direcciones dir = new Direcciones();
		dir.setCallePrinc(callep);
		dir.setCalleSec(calles);
		dir.setNumCasa(numcaa);
		dir.setCiudad(ciud);
		dir.setProvincia(prov);
		dir.setId_usu_FK(usu);
		System.out.println(dir.toString());
		ddao.insertar(dir);
		return "ok";
	}
	
	public String editarDireccion(Direcciones direcc) {
		ddao.editar(direcc);
		return "ok";
	}
	
	public String eliminarDireccion(int id) {
		ddao.eliminar(id);
		return "ok";
	}
	
	public String Buscar(String cedula) {
		Direcciones d=ddao.buscar(direc.getId_usu_FK());
		listado(cedula);
		direc=d;
		return "ok";
	}
	
}