package Datos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Libro;
import modelo.Usuario;

@Stateless
public class usuariosDAO {
	 
	@Inject
	private EntityManager em;
	
	public void insertar(Usuario usuario) {
		em.persist(usuario);
	}
	
	public void editar(Usuario usuario) {
		em.merge(usuario);
	}
	
	public void eliminar(String cedula) {
		em.remove(buscar(cedula));
	}
	
	public Usuario buscar(String cedula) {
		Usuario u;
		u=em.find(Usuario.class, cedula);
		return u;
	}

	public List<Usuario> listarUsuario() {
		String jpql = "SELECT u FROM usuarios u";
		Query q = em.createQuery(jpql, Usuario.class);
		List<Usuario> usuario = q.getResultList();
		System.out.println("usuariosssssssssss"+usuario.toString());
		return usuario;
	}

}
