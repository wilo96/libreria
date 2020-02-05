package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import Datos.facCabDAO;
import modelo.FacturaCabs;
import modelo.FacturaDet;

@Stateless
public class facCabControlador {
	private FacturaCabs facab;
	public int codU;
	@Inject
	private facCabDAO fcd;
	
	@PostConstruct
	public void init() {
		facab = new FacturaCabs();
	}

	public FacturaCabs getFacab() {
		return facab;
	}

	public void setFacab(FacturaCabs facab) {
		this.facab = facab;
	}

	

	
	
	public List<FacturaCabs> ultReg(){
		return fcd.ultimoReg();
	}
	//modifique esta parte de guardarCabecera
	public String guardarCabecera(String codpers, int iddirec, int idtarj) {
		System.out.println(codpers+" "+iddirec+" "+idtarj);
		List<FacturaDet> fdl=new ArrayList<>();
		FacturaCabs fcab = new FacturaCabs();
		fcab.setId_usufc_FK(codpers);
		fcab.setId_direcc_FK(iddirec);
		fcab.setId_tarjet_FK(idtarj);
		System.out.println(fcab.getId_usufc_FK()+" "+fcab.getId_direcc_FK()+" "+fcab.getId_tarjet_FK());
		System.out.println((ultReg().toString().substring(1,ultReg().toString().length()-1)));
		try {
		codU=1+Integer.parseInt(ultReg().toString().substring(1,ultReg().toString().length()-1));
		fcab.setCodigo(codU);
		fcab.setId_faccab_fk(fdl);
		return fcd.insertarFacCab(fcab);
		}
		catch(Exception e) {
			fcab.setCodigo(1);
			fcab.setId_faccab_fk(fdl);
			System.out.println(fcab.toString());
			return fcd.insertarFacCab(fcab);
		}
		
		
	}

}
