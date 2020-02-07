package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import Datos.facCabDAO;
import modelo.FacturaCabs;
import modelo.FacturaDets;

@Stateless
public class facCabControlador {
	private FacturaCabs facab;
	public int codU;
	public int con;
	@Inject
	private facCabDAO fcd;
	
	@PostConstruct
	public void init() {
		facab = new FacturaCabs();
		con=1;
	}

	public FacturaCabs getFacab() {
		return facab;
	}

	public void setFacab(FacturaCabs facab) {
		this.facab = facab;
	}

	

	
	

	//modifique esta parte de guardarCabecera
	public String guardarCabecera(String idPers, int iddirec, int idtarj) {
		int co=0;
		//System.out.println(codpers+" "+iddirec+" "+idtarj);
		List<FacturaDets> fdl=new ArrayList<>();
		List<FacturaCabs> ulreg= new ArrayList<>();
		//FacturaCabs fcab = new FacturaCabs();
		facab.setId_usufc_FK(idPers);
		facab.setId_direcc_FK(iddirec);
		facab.setId_tarjet_FK(idtarj);
		try {
			ulreg=fcd.ultimoReg();
			String codigo=ulreg.toString().substring(1,ulreg.toString().length()-1);
			if(codigo.equals("null")) {
				System.out.println("Estamos con un null");
				facab.setCodigo(1);
			}
			else {
				co=Integer.parseInt(codigo);
				facab.setCodigo(co+1);
			}
			
		}catch(Exception e)
		{
			facab.setCodigo(1);
			//ulreg.add(fcab);
		}
		//System.out.println("Esta aqui "+ulreg.toString());
		System.out.println("Pasamos aqui seteando "+facab.toString());
		//System.out.println(fcab.getId_usufc_FK()+" "+fcab.getId_direcc_FK()+" "+fcab.getId_tarjet_FK());
		//System.out.println((ultReg().toString().substring(1,ultReg().toString().length()-1)));
		
			//fcab.setCodigo(1);
			//fcab.setId_faccab_fk(fdl);
			//System.out.println(fcab.toString());
			//return fcd.insertarFacCab(fcab);
	
		//codU=1+Integer.parseInt(ultReg().toString().substring(1,ultReg().toString().length()-1));
		//fcab.setCodigo(codU);
		//fcab.setId_faccab_fk(fdl);
		//facab.setId_faccab_fk(fdl);
		if(con==1)
		{
			System.out.println("Si es 1 el contador");
			System.out.println(facab.toString());
		fcd.insertarFacCab(facab);
		con++;
		}
		
			return String.valueOf(co);
		
		
		
	}

}
