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
		System.out.println("Llegue aqui "+carrito.toString());
		em.persist(carrito);
		return "Insertada Compra";
	}
	
	public void editar(Carritos carrito) {
		em.merge(carrito);
	}
	
	public void eliminar(int codigo) {
		Carritos c = em.find(Carritos.class, codigo);
		em.remove(c);
	}
	
	public void eliminardatos(String cedu) {
		Query q = em.createQuery("DELETE FROM Carritos WHERE id_usuta_FK='"+cedu+"'");
		q.executeUpdate();
	}
	
//modificado	
	public List<Carritos> listaCarro(String cedu){
		//String sql="SELECT c FROM Carritos c";
		String sql ="SELECT c.codigo, c.cantidad, c.precioLib, c.descuentoLib, l.titulo, l.imagen, c.id_libc_FK FROM Carritos c, Libros l where l.codigo= c.id_libc_FK and c.id_usuta_FK='"+cedu+"'";
		Query q = em.createQuery(sql, Object[].class);
		List<Carritos> carro = q.getResultList();
		return carro;
		
	}
	public List<Carritos> listaCarroTot(String cedula){
		String sql="SELECT c FROM Carritos c where c.id_usuta_FK='"+cedula+"'";
		//String sql ="SELECT c.codigo, c.cantidad, c.precioLib, c.descuentoLib, l.titulo, l.imagen, c.id_libc_FK FROM Carritos c, Libros l where l.codigo= c.id_libc_FK";
		Query q = em.createQuery(sql, Object[].class);
		List<Carritos> carro = q.getResultList();
		return carro;
		
	}
	public List<Carritos> listaCarritoT(String cedula){
		String sql="SELECT c FROM Carritos c where c.id_usuta_FK='"+cedula+"'";
		//String sql ="SELECT c.codigo, c.cantidad, c.precioLib, c.descuentoLib, l.titulo, l.imagen, c.id_libc_FK FROM Carritos c, Libros l where l.codigo= c.id_libc_FK";
		Query q = em.createQuery(sql, Carritos.class);
		List<Carritos> carro = q.getResultList();
		return carro;
		
	}

//fin modificado
	public List<Carritos> ultimoReg() {
		String sql = "SELECT MAX(c.codigo) FROM Carritos c";
		Query q = em.createQuery(sql, Integer.class);
		List<Carritos> res=q.getResultList();
		System.out.println("Carritulo ultimo ingreso "+res.toString());
		return res;
	}
	

}
