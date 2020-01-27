package Datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import modelo.Carritos;

@Stateless
public class carritoDAO {
	
	@Inject
	private EntityManager em;
	
	public String insertar(Carritos carrito) {
		//em.persist(carrito);
		//int codigo=1+Integer.parseInt(ultimoReg().toString().substring(1,ultimoReg().toString().length()-1));
		//String sql = "INSERT INTO carritos VALUES ("+codigo+","+cantidad+","+descuento+","+libro+","+precio+")";
		//Query q = em.createNativeQuery(sql, Carritos.class);
		//Query q = em.createQuery(sql);
		System.out.println("Llegue aqui "+carrito.toString());
		em.persist(carrito);
		return "Insertada Compra";
	}
	
	public void editar(Carritos carrito) {
		em.merge(carrito);
	}
	
	public void eliminar(int codigo) {
		em.remove(codigo);
	}
	
	public List<Carritos> listaCarro(){
		String sql="SELECT c FROM Carritos c";
		Query q = em.createQuery(sql, Carritos.class);
		List<Carritos> carro = q.getResultList();
		return carro;
		
	}
	
	public List<Carritos> ultimoReg() {
		String sql = "SELECT MAX(c.codigo) FROM Carritos c";
		Query q = em.createQuery(sql, Integer.class);
		List<Carritos> res=q.getResultList();
		return res;
	}
	

}
