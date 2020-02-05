package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.FacturaCabs;
import modelo.FacturaDet;

@Stateless
public class facDetDAO {
	@Inject
	private EntityManager em;
	
	public String insertarFacDet(FacturaDet facde) {
		em.persist(facde);
		return "Detalle Listo";
	}
	
	public List<FacturaDet> ultimoReg() {
		String sql = "SELECT MAX(f.codigo) FROM FacturaDet f";
		Query q = em.createQuery(sql, Integer.class);
		List<FacturaDet> res=q.getResultList();
		return res;
	}

}
