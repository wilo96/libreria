package Datos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Categoria;

@Stateless
public class categoriasDAO {
	@Inject
	private EntityManager em;
	
	public void insertar(Categoria categoria) {
		em.persist(categoria);
	}
	
	public void editar(Categoria categoria) {
		em.merge(categoria);
	}
	
	public void eliminar(int codigo) {
		em.remove(buscar(codigo));
	}
	
	public Categoria buscar(int codigo) {
		Categoria c;
		c=em.find(Categoria.class, codigo);
		return c;
	}
	
	public List<Categoria> listarCategoria() {
		String jpql = "SELECT categoria FROM Categoria categoria";
		Query q = em.createQuery(jpql, Categoria.class);
		List<Categoria> categoria = q.getResultList();
		return categoria;
	}
	
	public List<Categoria> listadoBuscar(int codigo) {
		System.out.println("cedulaaaaa"+codigo);
		Categoria ca= buscar(codigo);
		List<Categoria> listCategoria = new ArrayList<Categoria>();
		listCategoria.add(ca);
		return listCategoria;
	}
}
