package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Votos;

@Stateless
public class votosDAO {
	
	@Inject
	private EntityManager em;
	
	public String contar(Votos votos) {
		em.persist(votos);
		return "votado";
	}
	
	public List<Object[]> listaProdsOrden(){
		String sql = "SELECT l.titulo, SUM(v.conteo) FROM Votos v, Libros l where l.codigo=v.id_prod group by l.titulo order by SUM(v.conteo) desc";
		List<Object[]> resul = em.createQuery(sql).getResultList();
		
		return resul;
	}
	
	public List<Votos> ultimoReg() {
		String sql = "SELECT MAX(v.codigo) FROM Votos v";
		Query q = em.createQuery(sql, Integer.class);
		List<Votos> res=q.getResultList();
		return res;
	}

}
