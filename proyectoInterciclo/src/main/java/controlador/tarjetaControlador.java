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
		this.tar=tdao.buscar(this.tar.getCodigo());
		return tdao.buscar(this.tar.getCodigo());
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
	
	public String editarTarjetas(Tarjetas t) {
		tdao.editar(t);
		return "ok";
	}
	
	public String eliminarTarjeta(int id) {
		tdao.eliminar(id);
		return "ok";
	}
	public List<Tarjetas> listado(String cedu) {
		return tdao.listarTarjetas(cedu);
	}
	public String Buscar(String cedu) {
		Tarjetas d=tdao.buscar(tar.getCodigo());
		listado(cedu);
		tar=d;
		return "ok";
	}

}
