package controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.Stateless;
import javax.inject.Inject;

import Datos.carritoDAO;
import modelo.Carritos;
import modelo.FacturaCabs;

@Stateless
public class carritoControlador {
	private Carritos carrito;
	private FacturaCabs fca;
	private facDetControlador fdc;
	private facCabControlador fcc;
	
	@Inject
	private carritoDAO cdao;
	
	@PostConstruct
	public void init() {
		carrito = new Carritos();
		fca= new FacturaCabs();
		fdc = new facDetControlador();
		fcc = new facCabControlador();
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
	
	public List<Carritos> listaComprasTot(){
		return cdao.listaCarroTot();
	}
	
	public List<Carritos> listaComprasT(String idpers, int iddirec, int idtarj){
		List<Carritos> elemen=cdao.listaCarritoT();
		System.out.println(elemen.toString());
		fcc.guardarCabecera(idpers, iddirec, idtarj);
		//int facab = Integer.parseInt(fcc.ultReg().toString().substring(1,fcc.ultReg().toString().length()-1));
		for(Carritos elem : elemen) {
			//fdc.guardarDetalle(elem.getId_libc_FK(), facab, elem.getCantidad(), elem.getDescuentoLib(), elem.getPrecioLib(), (Double.valueOf(elem.getCantidad())*(elem.getPrecioLib()-(Double.valueOf(elem.getDescuentoLib())/100))), (Double.valueOf(elem.getCantidad())*(elem.getPrecioLib()-(Double.valueOf(elem.getDescuentoLib())/100))*(0.12)));
		//	guardarCompra(elem.getId_libc_FK(), elem.getCantidad(), elem.getPrecioLib(), elem.getDescuentoLib());
			System.out.println(elem.toString());
		}
		System.out.println(cdao.listaCarritoT().toString());
		return cdao.listaCarritoT();
		
	}
	
	public String guardarCompra( int libro, int cantidad, double precio, int descuento) {
		Carritos carrito= new Carritos();
		carrito.setId_libc_FK(libro);
		carrito.setCantidad(cantidad);
		carrito.setPrecioLib(precio);
		carrito.setDescuentoLib(descuento);
		int codigo=1+Integer.parseInt(ultimoReg().toString().substring(1,ultimoReg().toString().length()-1));
		carrito.setCodigo(codigo);
		System.out.println("Estaos en el carrito: "+carrito.toString());
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
