package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.FacturaCabs;
import modelo.FacturaDets;

@Stateless
public class facDetDAO {
	@Inject
	private EntityManager em;
	
	public void insertarFacDet(FacturaDets facde) {
		System.out.println("Entramos en el DAO a ver que onda");
		System.out.println(facde.toString());
		em.persist(facde);
	}
	
	public List<FacturaDets> ultimoReg() {
		String sql = "SELECT MAX(f.codigo) FROM FacturaDets f";
		Query q = em.createQuery(sql, Integer.class);
		List<FacturaDets> res=q.getResultList();
		System.out.println("Esto devuelve el maximo valor "+res.toString());

		return res;
	}


}
