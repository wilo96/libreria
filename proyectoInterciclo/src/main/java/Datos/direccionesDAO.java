package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Direccion;
import modelo.Usuario;

@Stateless
public class direccionesDAO {
	@Inject
	private EntityManager em;
	
	
	public void insertar(Direccion direcc) {
		em.persist(direcc);
	}
	
	public void editar(Direccion direcc) {
		em.merge(direcc);
	}
	
	public void eliminar(String cedula) {
		em.remove(buscar(cedula));
	}
	
	public Direccion buscar(String cedula) {
		Direccion d;
		d=em.find(Direccion.class, cedula);
		return d;
	}

	public List<Direccion> listarDireccion() {
		String jpql = "SELECT d FROM direcciones d";
		Query q = em.createQuery(jpql, Direccion.class);
		List<Direccion> ddirec = q.getResultList();
		System.out.println("direccionessssss"+ddirec.toString());
		return ddirec;
	}
}
