package Datos;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Libros;
import modelo.Usuarios;

@Stateless
public class usuariosDAO {
	 
	@Inject
	private EntityManager em;
	
	public void insertar(Usuarios usuario) {
		em.persist(usuario);
	}
	
	public void editar(Usuarios usuario) {
		em.merge(usuario);
	}
	
	public void eliminar(String cedula) {
		em.remove(buscar(cedula));
	}
	
	public Usuarios buscar(String cedula) {
		Usuarios u;
		u=em.find(Usuarios.class, cedula);
		System.out.println();
		return u;
	}
	public List<Usuarios> loginbus(String correo, String contra) {
		System.out.println("dao "+correo);
		String sql = "SELECT u FROM Usuarios u where u.correo = '"+correo+"' and u.contrasenia='"+contra+"'";
		Query q = em.createQuery(sql,Usuarios.class);
		List<Usuarios> login = q.getResultList();
		return login;
	}

	public List<Usuarios> listarUsuario() {
		String jpql = "SELECT u FROM usuarios u";
		Query q = em.createQuery(jpql, Usuarios.class);
		List<Usuarios> usuario = q.getResultList();
		System.out.println("usuariosssssssssss"+usuario.toString());
		return usuario;
	}

}
