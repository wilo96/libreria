package servicios;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import controlador.carritoControlador;
import controlador.categoriaControlador;
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
	
	//añadido de servicio
	@GET
	@Path("/listComprasT")
	@Produces("application/json")
	public List<Carritos> getCarritoT(@QueryParam("idPers") String idpers, @QueryParam("iddirec") int iddirec, @QueryParam("idtarj") int idtarj ){
		return cac.listaComprasT(idpers, iddirec, idtarj);
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
	@Path("/ultreg")
	@Produces("application/json")
	public List<Carritos> ultreg(){
		return cac.ultimoReg();
	}
	
	@GET
	@Path("/ultregfacab")
	@Produces("application/json")
	public List<FacturaCabs> ultregfacab(){
		return fcc.ultReg();
	}
	
	
	
	
}
