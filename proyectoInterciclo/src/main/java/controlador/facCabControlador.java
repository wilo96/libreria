package controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import Datos.facCabDAO;
import modelo.FacturaCab;

@Stateless
public class facCabControlador {
	private FacturaCab facab;
	public int codU;
	@Inject
	private facCabDAO fcd;
	
	@PostConstruct
	public void init() {
		facab = new FacturaCab();
	}

	public FacturaCab getFacab() {
		return facab;
	}

	public void setFacab(FacturaCab facab) {
		this.facab = facab;
	}

	

	
	
	public List<FacturaCab> ultReg(){
		return fcd.ultimoReg();
	}
	
	public String guardarCabecera(String codpers, int iddirec, int idtarj) {
		FacturaCab fcab = new FacturaCab();
		fcab.setId_usufc_FK(codpers);
		fcab.setId_direcc_FK(iddirec);
		fcab.setId_tarjet_FK(idtarj);
		codU=1+Integer.parseInt(ultReg().toString().substring(1,ultReg().toString().length()-1));
		fcab.setCodigo(codU);
		return fcd.insertarFacCab(fcab);
	}

}
