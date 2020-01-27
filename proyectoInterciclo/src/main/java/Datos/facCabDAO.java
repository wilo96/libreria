package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.FacturaCab;
import modelo.Votos;

@Stateless
public class facCabDAO {
	
	@Inject
	private EntityManager em;
	
	public String insertarFacCab(FacturaCab facab) {
		em.persist(facab);
		return "Cabecera Lista";
	}
	
	public List<FacturaCab> ultimoReg() {
		String sql = "SELECT MAX(f.codigo) FROM FacturaCab f";
		Query q = em.createQuery(sql, Integer.class);
		List<FacturaCab> res=q.getResultList();
		return res;
	}

}
