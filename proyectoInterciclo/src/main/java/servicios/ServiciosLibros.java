package servicios;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import Datos.facCabDAO;
import controlador.carritoControlador;
import controlador.categoriaControlador;
import controlador.direccionControlador;
import controlador.facCabControlador;
import controlador.facDetControlador;
import controlador.libroControlador;
import modelo.Carritos;
import modelo.Categoria;
import modelo.FacturaCabs;
import modelo.Libros;
import controlador.usuarioControlador;
import controlador.votosControlador;
import modelo.Usuarios;
import modelo.Votos;

@Path("/libros")
public class ServiciosLibros {
	
	private facCabDAO fcdao;
	
	@Inject
	private categoriaControlador cc;
	
	@Inject
	private libroControlador lc;

	@Inject
	private usuarioControlador uc;
	
	@Inject
	private carritoControlador cac;
	
	@Inject
	private votosControlador vd;
	
	@Inject
	private facCabControlador fcc;
	
	@Inject
	private facDetControlador fcd;
	
	@Inject
	private direccionControlador dc;

	@GET
	@Path("consultar")
	@Produces("application/json")
	public  List<Categoria> getCategorias(){
		System.out.println("Esta entrando"); 
		return cc.listado();
	}
	
	@POST
	@Produces("application/json")
	@Consumes("application/json")
	public respuestaLibros crearLibro(Libros libro)
	{
		respuestaLibros r = new respuestaLibros();
		try
		{
		r.setCodigo(0);
		r.setMensaje("Libro Insertado");
		lc.nuevoLibro(libro);
		}catch(Exception e)
		{
			r.setCodigo(99);
			r.setMensaje("Error Insertando Libro");
		}
		return r;
	}
	
	@GET
	@Path("/nuevacompra")
	@Produces("application/json")
	//@Consumes("application/json")
	public String crearCompra(@QueryParam("libro") int libro, @QueryParam("cantidad") int cantidad, @QueryParam("precio") double precio, @QueryParam("descuento") int descuento)
	{
		return cac.guardarCompra(libro, cantidad, precio, descuento);
	}
	
	@GET
	@Path("/nuevacabe")
	@Produces("application/json")
	//@Consumes("application/json")
	public String crearCabe(@QueryParam("direcid") int direc, @QueryParam("tarjetaid") int tarjeta, @QueryParam("usuid") String usuid)
	{
		return fcc.guardarCabecera(usuid, direc, tarjeta);
	}
	
	
	@GET
	@Path("/nuevodet")
	@Produces("application/json")
	//@Consumes("application/json")
	public String crearDet(@QueryParam("codlib") int codlib, @QueryParam("canti") int canti, @QueryParam("facab") int facab, @QueryParam("descu") int descu, @QueryParam("precio") double precio, @QueryParam("subtotal") double subtot, @QueryParam("total") double total)
	{
		return fcd.guardarDetalle(codlib, facab, canti, descu, precio, subtot, total);
	}
	
	@GET
	@Path("/nuevovoto")
	@Produces("application/json")
	//@Consumes("application/json")
	public String crearVoto(@QueryParam("libro") int libro)
	{
		return vd.guardarVoto(libro);
	}
	
	@GET
	@Path("/listVotos")
	@Produces("application/json")
	public List<Object[]> getVotos(){
		return vd.listaCompras();
	}
	
	
	@GET
	@Path("/listCompras")
	@Produces("application/json")
	public List<Carritos> getCarrito(){
		return cac.listaCompras();
	}
	
	@GET
	@Path("/listComprasTotales")
	@Produces("application/json")
	public List<Carritos> getCarritoTotal(){
		return cac.listaComprasTot();
	}
	
	//añadido de servicio
	@GET
	@Path("/listComprasT")
	@Produces("application/json")
	public String getCarritoT(@QueryParam("idPers") String idpers, @QueryParam("iddirec") int iddirec, @QueryParam("idtarj") int idtarj ){
		
		fcc.guardarCabecera(idpers, iddirec, idtarj);
		String registro = fcc.guardarCabecera(idpers, iddirec, idtarj);
		int facab=Integer.parseInt(registro);
		List<FacturaCabs> ulreg;
		List<Carritos> compras = getCarritoTotal();
		//System.out.println(compras.toString());
		for (Carritos carritos : compras) {
			/*ulreg=fcdao.ultimoReg();
			String codigo=ulreg.toString().substring(1,ulreg.toString().length()-1);
			int facab=Integer.parseInt(codigo);*/
			
			System.out.println(carritos);
			System.out.println(facab);
			int cantidad = carritos.getCantidad();
			double precio = carritos.getPrecioLib();
			int descuento = carritos.getDescuentoLib();
			double valdesc = precio - (precio * (Double.valueOf(descuento)/100));
			double subtotal = cantidad *  valdesc;
			double total = subtotal * 0.12;
			System.out.println(carritos.getId_libc_FK() +","+ (facab)+","+ cantidad+","+ descuento+","+ precio+","+ subtotal+","+ total);			
			fcd.guardarDetalle(carritos.getId_libc_FK(), (facab), cantidad, descuento, precio, subtotal, total);
		}
		cac.eliminarDatos();
		//fcd.guardarDetalle(codlib, facab, canti, descu, precio, subtot, total)
		//return cac.listaComprasT(idpers, iddirec, idtarj);
		return "ok";
	}
	//fin añadido
	

	@GET
	@Path("/listLibros")
	@Produces("application/json")
	public List<Libros> getLibros(){
		return lc.listado();
	}
	
	@GET
	@Path("/listUsuarios")
	@Produces("application/json")
	public List<Usuarios> getUsuarios(){
		return uc.listado();
	}
	
	@GET
	@Path("/cleartabla")
	@Produces("application/json")
	public String limpiarcarrito(){
		return cac.eliminarDatos();
	}
	
	@GET
	@Path("/ultreg")
	@Produces("application/json")
	public List<Carritos> ultreg(){
		return cac.ultimoReg();
	}
	//nuevo servicio
	@GET
	@Path("/nuevadir")
	@Produces("application/json")
	public String nuevaDirec(@QueryParam("callep")String callep, @QueryParam("calles")String calles, @QueryParam("numcasa")String numcasa,@QueryParam("ciud")String ciud,@QueryParam("prov")String prov, @QueryParam("idusu") String usuario){
		System.out.println(callep+" "+calles+" "+numcasa+" "+ciud+" "+prov+" "+usuario);
		return dc.guardarDireccion(callep, calles, numcasa, ciud, prov, usuario);
	}
	
	
	
	
}
