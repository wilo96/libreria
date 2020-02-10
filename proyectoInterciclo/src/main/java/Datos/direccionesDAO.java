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
	
	public void eliminar(int id) {
		Direcciones d = em.find(Direcciones.class, id);
		em.remove(d);
	}
	
	public Direcciones buscar(String cedula) {
		Direcciones d;
		d=em.find(Direcciones.class, cedula);
		return d;
	}

	public List<Direcciones> listarDireccion(String cedula) {
		String jpql = "SELECT d FROM Direcciones d where d.id_usu_FK='"+cedula+"'";
		Query q = em.createQuery(jpql, Direcciones.class);
		List<Direcciones> ddirec = q.getResultList();
		System.out.println("direccionessssss"+ddirec.toString());
		return ddirec;
	}
}
