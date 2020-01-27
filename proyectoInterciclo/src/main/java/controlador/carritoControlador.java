package controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import Datos.carritoDAO;
import modelo.Carritos;

@Stateless
public class carritoControlador {
	private Carritos carrito;
	
	@Inject
	private carritoDAO cdao;
	
	@PostConstruct
	public void init() {
		carrito = new Carritos();
	}
	
	public Carritos getCarrito() {
		return carrito;
	}
	
	public void setCarrito(Carritos carrito) {
		this.carrito=carrito;
	}
	
	public List<Carritos> listaCompras(){
		return cdao.listaCarro();
	}
	
	public String guardarCompra( int libro, int cantidad, double precio, int descuento) {
		Carritos carrito= new Carritos();
		carrito.setId_libc_FK(libro);
		carrito.setCantidad(cantidad);
		carrito.setPrecioLib(precio);
		carrito.setDescuentoLib(descuento);
		int codigo=1+Integer.parseInt(ultimoReg().toString().substring(1,ultimoReg().toString().length()-1));
		carrito.setCodigo(codigo);
		System.out.println(carrito.toString());
		return cdao.insertar(carrito);
		
	}
	
	public String editarCompra() {
		cdao.editar(carrito);
		return null;
	}
	
	public String eliminarCompra(int codigo) {
		cdao.eliminar(codigo);
		return null;
	}
	
	public List<Carritos> ultimoReg() {
		return cdao.ultimoReg();
	}

}
