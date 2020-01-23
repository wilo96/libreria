package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Libros;

@Stateless
public class librosDAO {

	@Inject
	private EntityManager em;
	
	public void insertar(Libros libro) {
		em.persist(libro);
	}
	
	public void editar(Libros libro) {
		em.merge(libro);
	}
	
	public void eliminar(int codigo) {
		em.remove(buscar(codigo));
	}
	
	public Libros buscar(int codigo) {
		System.out.println("dao "+codigo);
		Libros l;
		l=em.find(Libros.class, codigo);
		return l;
	}

	public List<Libros> listarLibro() {
		String jpql = "SELECT l FROM libros l";
		Query q = em.createQuery(jpql, Libros.class);
		List<Libros> libro = q.getResultList();
		System.out.println("librosssssssssss"+libro.toString());
		return libro;
	}

}
