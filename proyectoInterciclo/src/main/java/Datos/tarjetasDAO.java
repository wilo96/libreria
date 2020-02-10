package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Direcciones;
import modelo.Tarjetas;

@Stateless
public class tarjetasDAO {
	
	@Inject
	private EntityManager em;
	
	
	public void insertar(Tarjetas tarj) {
		em.persist(tarj);
	}
	
	public void editar(Tarjetas tarj) {
		em.merge(tarj);
	}
	
	public void eliminar(int id) {
		em.remove(buscar(id));
	}
	
	public Tarjetas buscar(int id) {
		Tarjetas t;
		t=em.find(Tarjetas.class, id);
		return t;
	}

	public List<Tarjetas> listarTarjetas(String cedu) {
		String jpql = "SELECT t FROM Tarjetas t where t.id_usuta_FK='"+cedu+"'";
		Query q = em.createQuery(jpql, Tarjetas.class);
		List<Tarjetas> ttarje = q.getResultList();
		System.out.println("tarjetasssss"+ttarje.toString());
		return ttarje;
	}

}
