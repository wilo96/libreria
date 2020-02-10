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
import controlador.likesControlador;
import controlador.tarjetaControlador;
import modelo.Carritos;
import modelo.Categoria;
import modelo.Direcciones;
import modelo.FacturaCabs;
import modelo.Libros;
import modelo.Tarjetas;
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
	
	@Inject
	private tarjetaControlador tc;
	
	@Inject
	private likesControlador lic;

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
	public String crearCompra(@QueryParam("usu") String cedula, @QueryParam("libro") int libro, @QueryParam("cantidad") int cantidad, @QueryParam("precio") double precio, @QueryParam("descuento") int descuento)
	{
		return cac.guardarCompra(cedula, libro, cantidad, precio, descuento);
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
	@Path("/buscalibro")
	@Produces("application/json")
	//@Consumes("application/json")
	public Libros buscaLibro(@QueryParam("libro") int libro)
	{
		return lc.filtrar(libro);
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
	public List<Carritos> getCarrito(@QueryParam("cedu") String cedu){
		return cac.listaCompras(cedu);
	}
	
	@GET
	@Path("/listComprasTotales")
	@Produces("application/json")
	public List<Carritos> getCarritoTotal(@QueryParam("cedu") String cedu){
		return cac.listaComprasTot(cedu);
	}
	
	//añadido de servicio
	@GET
	@Path("/consultastock")
	@Produces("application/json")
	public String consultaStock(@QueryParam("cedu") String cedu){
		String mensaje="";
		int contador=0, pos=0;
		List<Libros> libros = lc.listado();
		List<Carritos> compras = getCarritoTotal(cedu);
		for (Carritos carritos : compras) {
			System.out.println(carritos.toString());
			Libros l = lc.filtrar(carritos.getId_libc_FK());
			System.out.println(l.toString());
			if(carritos.getCantidad() < l.getStock()) {
				mensaje = mensaje+";"+(l.getStock()-carritos.getCantidad());
				
			}
			else
			{
				contador=contador+1;
			}
		}
		if(contador == 0) {
			
			return "ok";
		}
		else
		{
			System.out.println(contador);
			return "Sin Stock";
		}
		
	}
	
	@GET
	@Path("/listComprasT")
	@Produces("application/json")
	public String getCarritoT(@QueryParam("idPers") String idpers, @QueryParam("iddirec") int iddirec, @QueryParam("idtarj") int idtarj ){
		String stockres=consultaStock(idpers);
		String [] valorestock=stockres.split(";");
		if(stockres.equals("Sin Stock")) {
			return "No";
		}
		else {
		fcc.guardarCabecera(idpers, iddirec, idtarj);
		String registro = fcc.guardarCabecera(idpers, iddirec, idtarj);
		int facab=Integer.parseInt(registro);
		List<FacturaCabs> ulreg;
		List<Carritos> compras = getCarritoTotal(idpers);
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
			Libros l = lc.filtrar(carritos.getId_libc_FK());
			l.setStock(l.getStock()-cantidad);
			lc.editarLibros(l);
			fcd.guardarDetalle(carritos.getId_libc_FK(), (facab), cantidad, descuento, precio, subtotal, total);
		}
		cac.eliminarDatos(idpers);
		//fcd.guardarDetalle(codlib, facab, canti, descu, precio, subtot, total)
		//return cac.listaComprasT(idpers, iddirec, idtarj);
		return "ok";
		}
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
	public String limpiarcarrito(@QueryParam("cedu") String cedu){
		return cac.eliminarDatos(cedu);
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
	//metodos creados
	@GET
	@Path("/modificarcarro")
	@Produces("application/json")
	public String modifCarro(@QueryParam("libro") int carroid, @QueryParam("libro") int libro, @QueryParam("cantidad") int cantidad, @QueryParam("precio") double precio, @QueryParam("descuento") int descuento){
		Carritos ca = new Carritos();
		ca.setCantidad(cantidad);
		ca.setDescuentoLib(descuento);
		ca.setId_libc_FK(libro);
		ca.setPrecioLib(precio);
		ca.setCodigo(carroid);
		return cac.editarCompra(ca);
	}
	
	@GET
	@Path("/elimitcarro")
	@Produces("application/json")
	public String elimitCarro(@QueryParam("libro") int carroid){
		Carritos carro = new Carritos();
		carro.setCodigo(carroid);
		return cac.eliminarCompra(carro);
	}
	
	@GET
	@Path("/modificardirec")
	@Produces("application/json")
	public String modifDirec(@QueryParam("direc") int dirid, @QueryParam("callep") String callep, @QueryParam("calles") String calles, @QueryParam("numcasa") String numcasa, @QueryParam("prov") String provincia, @QueryParam("ciudad") String ciudad, @QueryParam("cedula") String cedula){
		Direcciones dir = new Direcciones();
		dir.setCallePrinc(callep);
		dir.setCalleSec(calles);
		dir.setCiudad(ciudad);
		dir.setNumCasa(numcasa);
		dir.setProvincia(provincia);
		dir.setId_usu_FK(cedula);
		return dc.editarDireccion(dir);
	}
	
	@GET
	@Path("/elimitdirec")
	@Produces("application/json")
	public String elimitDirec(@QueryParam("iddiec") int iddir){
		Direcciones dir = new Direcciones();
		dir.setCodigo(iddir);
		return dc.eliminarDireccion(iddir);
	}
	
	@GET
	@Path("/modificartarj")
	@Produces("application/json")
	public String modifTarj(@QueryParam("idtarj") int tarjid, @QueryParam("numtarj") String numtarj, @QueryParam("identif") String ident, @QueryParam("Empresa") String empresa, @QueryParam("Usuario") String Usuario){
		Tarjetas t = new Tarjetas();
		t.setCodigo(tarjid);
		t.setCodVerif(ident);
		t.setEmpTarj(empresa);
		t.setId_usuta_FK(Usuario);
		t.setNumTarj(numtarj);
		return tc.editarTarjetas(t);
	}
	
	@GET
	@Path("/elimittarj")
	@Produces("application/json")
	public String elimitTarj(@QueryParam("idtarj") int tarjid){
		Tarjetas t = new Tarjetas();
		t.setCodigo(tarjid);
		return tc.eliminarTarjeta(tarjid);
	}
	//fin
	@GET
	@Path("/listadirec")
	@Produces("application/json")
	public List<Direcciones> listarDirec(@QueryParam("cedu") String cedula){
		return dc.listado(cedula);
	}
	
	@GET
	@Path("/listatarj")
	@Produces("application/json")
	public List<Tarjetas> listarTarj(@QueryParam("cedu") String cedula){
		return tc.listado(cedula);
	}
	
	@GET
	@Path("/nuevatar")
	@Produces("application/json")
	public String nuevaTarj(@QueryParam("numt")String numt, @QueryParam("codver")String ccodverf, @QueryParam("empresa")String empresa,@QueryParam("cedula")String cedula){
		System.out.println(numt+" "+ccodverf+" "+empresa+" "+cedula);
		return tc.guardarTarjetas(ccodverf, numt, empresa, cedula);
	}
	
	@GET
	@Path("/listalikes")
	@Produces("application/json")
	public List<Object[]> listarLikes(){
		return lic.listaLikes();
	}
	
}
