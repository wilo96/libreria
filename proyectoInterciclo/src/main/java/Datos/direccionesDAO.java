package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Direcciones;
import modelo.Usuarios;

@Stateless
public class direccionesDAO {
	
	@Inject
	private EntityManager em;
	
	
	public void insertar(Direcciones direcc) {
		em.persist(direcc);
	}
	
	public void editar(Direcciones direcc) {
		em.merge(direcc);
	}
	
	public void eliminar(String cedula) {
		em.remove(buscar(cedula));
	}
	
	public Direcciones buscar(String cedula) {
		Direcciones d;
		d=em.find(Direcciones.class, cedula);
		return d;
	}

	public List<Direcciones> listarDireccion() {
		String jpql = "SELECT d FROM Direcciones d";
		Query q = em.createQuery(jpql, Direcciones.class);
		List<Direcciones> ddirec = q.getResultList();
		System.out.println("direccionessssss"+ddirec.toString());
		return ddirec;
	}
}
