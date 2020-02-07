package controlador;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import Datos.facDetDAO;
import modelo.FacturaCabs;
import modelo.FacturaDets;

@Stateless
public class facDetControlador {
	private FacturaDets fade;
	private carritoControlador cac;
	public int codU;
	
	@Inject
	private facDetDAO fdd;
	
	@PostConstruct
	public void init() {
		fade = new FacturaDets();
		cac = new carritoControlador();
	}

	public FacturaDets getFade() {
		return fade;
	}

	public void setFade(FacturaDets fade) {
		this.fade = fade;
	}
	
	public List<FacturaDets> ultReg(){
		return fdd.ultimoReg();
	}
	//este metodo fue modificado para que salga el generar compra
	public String guardarDetalle(int codlib, int facab, int canti, int descu, double precio, double subtot, double total) {
		int co=0;
		List<FacturaDets> ulreg = new ArrayList<>();
		FacturaDets fcde = new FacturaDets();
		fcde.setId_faccab_fk(facab);
		fcde.setId_facd_FK(codlib);
		fcde.setCant(canti);
		fcde.setDescuentoLib(descu);
		fcde.setPrecioLib(precio);
		fcde.setSubt(subtot);
		fcde.setTotal(total);
		try {
			ulreg=fdd.ultimoReg();
			String codigo=ulreg.toString().substring(1,ulreg.toString().length()-1);
			if(codigo.equals("null")) {
				System.out.println("Estamos con un null");
				fcde.setCodigo(1);
				System.out.println("Damos el valor de 1");
			}
			else {
				co=Integer.parseInt(codigo);
				fcde.setCodigo(co+1);
			}
			
		}catch(Exception e)
		{
			fcde.setCodigo(1);
			//ulreg.add(fcab);
		}
		fdd.insertarFacDet(fcde);
		return "ok";
	}
}
