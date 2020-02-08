package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import Datos.tarjetasDAO;
import modelo.Direcciones;
import modelo.Tarjetas;

@ManagedBean
@ViewScoped
public class tarjetaControlador {
	private Tarjetas tar;
	private List<Tarjetas> listaT;
	
	@Inject
	private tarjetasDAO tdao;
	
	@PostConstruct
	public void init() {
		tar = new Tarjetas();
		listaT = new ArrayList<Tarjetas>();
	}

	public Tarjetas getTar() {
		return tar;
	}

	public void setTar(Tarjetas tar) {
		this.tar = tar;
	}

	public List<Tarjetas> getListaT() {
		return listaT;
	}

	public void setListaT(List<Tarjetas> listaT) {
		this.listaT = listaT;
	}

	public tarjetasDAO getTdao() {
		return tdao;
	}

	public void setTdao(tarjetasDAO tdao) {
		this.tdao = tdao;
	}
	
	public Tarjetas filtrarTar() {
		this.tar=tdao.buscar(this.tar.getId_usuta_FK());
		return tdao.buscar(this.tar.getId_usuta_FK());
	}
	
	public String guardarTarjetas(String codigver, String numTarj, String empTarj, String cedula) {
		Tarjetas tarj = new Tarjetas();
		tarj.setCodVerif(codigver);
		tarj.setNumTarj(numTarj);
		tarj.setEmpTarj(empTarj);;
		tarj.setId_usuta_FK(cedula);;
		System.out.println(tarj.toString());
		tdao.insertar(tarj);
		return "ok";
	}
	
	public String editarTarjetas() {
		tdao.editar(tar);
		return "ok";
	}
	
	public String eliminarTarjeta(String cedula) {
		tdao.eliminar(cedula);
		return "ok";
	}
	public List<Tarjetas> listado() {
		return tdao.listarTarjetas();
	}
	public String Buscar() {
		Tarjetas d=tdao.buscar(tar.getId_usuta_FK());
		listado();
		tar=d;
		return "ok";
	}

}
