package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Libro;

@Stateless
public class librosDAO {

	@Inject
	private EntityManager em;
	
	public void insertar(Libro libro) {
		em.persist(libro);
	}
	
	public void editar(Libro libro) {
		em.merge(libro);
	}
	
	public void eliminar(int codigo) {
		em.remove(buscar(codigo));
	}
	
	public Libro buscar(int codigo) {
		Libro l;
		l=em.find(Libro.class, codigo);
		return l;
	}

	public List<Libro> listarLibro() {
		String jpql = "SELECT l FROM libros l";
		Query q = em.createQuery(jpql, Libro.class);
		List<Libro> libro = q.getResultList();
		System.out.println("librosssssssssss"+libro.toString());
		return libro;
	}

}
