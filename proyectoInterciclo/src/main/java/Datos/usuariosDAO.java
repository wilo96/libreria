package Datos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

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
	
	public List<Usuario> listarUsuarios() {
		String jpql = "SELECT usuario FROM Usuario usuario";
		Query q = em.createQuery(jpql, Usuario.class);
		List<Usuario> usuarios = q.getResultList();
		return usuarios;
	}
	
	public List<Usuario> listadoBuscar(String cedula) {
		System.out.println("cedulaaaaa"+cedula);
		Usuario us= buscar(cedula);
		List<Usuario> listUsuario = new ArrayList<Usuario>();
		listUsuario.add(us);
		return listUsuario;
	}

}
