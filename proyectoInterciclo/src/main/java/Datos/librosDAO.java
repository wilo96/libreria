package Datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

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
		em.remove(leer(codigo));
	}
	
	public Libro leer(int codigo) {
		em.find(Libro.class, codigo);
		return null;
	}
}
