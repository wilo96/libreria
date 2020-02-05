package controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import Datos.facDetDAO;
import modelo.FacturaCabs;
import modelo.FacturaDet;

@Stateless
public class facDetControlador {
	private FacturaDet fade;
	public int codU;
	
	@Inject
	private facDetDAO fdd;
	
	@PostConstruct
	public void init() {
		fade = new FacturaDet();
	}

	public FacturaDet getFade() {
		return fade;
	}

	public void setFade(FacturaDet fade) {
		this.fade = fade;
	}
	
	public List<FacturaDet> ultReg(){
		return fdd.ultimoReg();
	}
	
	public String guardarDetalle(int codlib, int facab, int canti, int descu, double precio, double subtot, double total) {
		FacturaDet fcde = new FacturaDet();
		fcde.setId_faccab_fk(facab);
		fcde.setId_facd_FK(codlib);
		fcde.setCant(canti);
		fcde.setDescuentoLib(descu);
		fcde.setPrecioLib(precio);
		fcde.setSubt(subtot);
		fcde.setTotal(total);
		codU=1+Integer.parseInt(ultReg().toString().substring(1,ultReg().toString().length()-1));
		fcde.setCodigo(codU);
		return fdd.insertarFacDet(fcde);
	}
}
