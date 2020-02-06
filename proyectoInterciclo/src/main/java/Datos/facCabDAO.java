package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.FacturaCabs;
import modelo.Votos;

@Stateless
public class facCabDAO {
	
	@Inject
	private EntityManager em;
	
	public void insertarFacCab(FacturaCabs facab) {
		System.out.println("Entro al DAO "+facab.toString());
		em.persist(facab);
	}
	//hice un rename de la clase facturacab a facturacabs
	public List<FacturaCabs> ultimoReg() {
		String sql = "SELECT MAX(f.codigo) FROM FacturaCabs f";
		Query q = em.createQuery(sql, Integer.class);
		List<FacturaCabs> res=q.getResultList();
		System.out.println("Esto devuelve el maximo valor "+res.toString());
		return res;
	}

}
