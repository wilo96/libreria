package controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import Datos.votosDAO;
import modelo.Votos;

@Stateless
public class votosControlador {
	private Votos votos;
	int codigoU;
	@Inject
	private votosDAO vd;
	
	@PostConstruct
	public void init() {
		votos = new Votos();
	}

	public Votos getVotos() {
		return votos;
	}

	public void setVotos(Votos votos) {
		this.votos = votos;
	}

	public votosDAO getVd() {
		return vd;
	}

	public void setVd(votosDAO vd) {
		this.vd = vd;
	}
	
	public List<Votos> ulReg(){
		return vd.ultimoReg();
	}
	
	public String guardarVoto(int libro) {
		Votos voto = new Votos();
		voto.setConteo(voto.getConteo()+1);
		

		try {
		codigoU=1+Integer.parseInt(ulReg().toString().substring(1,ulReg().toString().length()-1));
		}catch(Exception e) {
			codigoU=1;
		}
		voto.setId_prod(libro);
		voto.setCodigo(codigoU);
		System.out.println(voto.toString());
		return vd.contar(voto);

	}
	
	public List<Object[]> listaCompras(){
		return vd.listaProdsOrden();
	}
	

}
