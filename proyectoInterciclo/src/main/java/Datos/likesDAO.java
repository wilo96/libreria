package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Likes;

@Stateless
public class likesDAO {
	
	private EntityManager em;
	
	public String nuevolike(Likes like) {
		em.persist(like);
		return "ok";
	}
	
	public List<Object[]> listaLikes(){
		System.out.println("Esta aqui");
		String sql = "SELECT b.titulo, count(l.id_lib_FK) FROM Likes l, Libros b where l.id_lib_FK=b.codigo group by b.codigo";
		List<Object[]> res = em.createQuery(sql).getResultList();
		System.out.println(res.toString());
		return res;
	}

}
