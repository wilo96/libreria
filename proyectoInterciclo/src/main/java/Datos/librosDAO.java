package Datos;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import modelo.Libro;

public class librosDAO {
	conexion cc=new conexion();
	/*
	public boolean insertarLibro(libros lib) {
		String sqlscr="INSERT INTO libros (descripcion,precio,descuento,categoria,imagen) VALUES (?,?,?,?,?)";
		try {
		cc.conexionsql();
		PreparedStatement pst = cc.getCon().prepareStatement(sqlscr);
		pst.setString(1, lib.getDescripcion());
		pst.setDouble(2, lib.getPrecio());
	    pst.setInt(3, lib.getDescuento());
	    pst.setInt(4, lib.getCategoria());
	    pst.setString(5, lib.getImagen());
	    
	    pst.executeUpdate();
	    System.out.println("Se inserto un nuevo Libro");
	    cc.getCon().close();
			return true;
		}catch(Exception e){
			System.out.println("No se inserto un nuevo libro "+e.getMessage());
			return false;
		}
	}
	
	public boolean actualizarLibro(libros lib) {
		cc.conexionsql();
	    try {   
	    	String sqlscr = "UPDATE libros SET descripcion=?,precio=?,descuento=?,categoria=?,imagen=? WHERE codigo= "+lib.getCodigo();
	        PreparedStatement pst = cc.getCon().prepareStatement(sqlscr);
	        pst.setString(1, lib.getDescripcion());
	        pst.setDouble(2, lib.getPrecio());
	        pst.setInt(3, lib.getDescuento());
	        pst.setInt(4, lib.getCategoria());
	        pst.setString(5, lib.getImagen());
	        pst.execute();
	        System.out.print("Libro actualizado");
	        cc.getCon().close();
	        return true;
	        } catch (Exception e) {
	        	System.out.print("Libro no actualizado "+e.getMessage());
	        	return false;
	        }
	}
	
	public boolean eliminarLibro(libros lib) {
		cc.conexionsql();
	    try {   
	    	String sqlscr = "DELETE FROM libros WHERE codigo= "+lib.getCodigo();
	    	Statement pst = cc.getCon().createStatement();
            int n = pst.executeUpdate(sqlscr);
            if (n >= 0) {
                System.out.println("El libro se elimino");
            }
            cc.getCon().close();
            return true;
	        } catch (Exception e) {
	        	System.out.print("El libro no se elimino "+e.getMessage());
	        	return false;
	        }
	}
	
	public ArrayList<libros> listarLibro( ) {
		cc.conexionsql();
		ArrayList<libros> lista=new ArrayList<>();
	    try {   
	    	String sqlscr = "SELECT * FROM libros";
	        PreparedStatement pst = cc.getCon().prepareStatement(sqlscr);
	        ResultSet rs=pst.executeQuery();
	        while(rs.next()) {
	        	libros lib=new libros();
	        	lib.setCodigo(rs.getInt("codigo"));
	        	lib.setDescripcion(rs.getString("descripcion"));
	        	lib.setPrecio(rs.getDouble("precio"));
	        	lib.setDescuento(rs.getInt("descuento"));
	        	lib.setCategoria(rs.getInt("categoria"));
	        	lib.setImagen(rs.getString("imagen"));
	        }
	        return lista;
	        } catch (Exception e) {
	        	System.out.print("Los libros no son encontrados "+e.getMessage());
	        	return lista;
	        }
	}
	
	public ArrayList<libros> buscarLibro(int codigo) {
		cc.conexionsql();
		ArrayList<libros> lista=new ArrayList<>();
	    try {   
	    	String sqlscr = "SELECT * FROM libros WHERE codigo= "+codigo;
	        PreparedStatement pst = cc.getCon().prepareStatement(sqlscr);
	        ResultSet rs=pst.executeQuery();
	        while(rs.next()) {
	        	libros lib=new libros();
	        	lib.setCodigo(rs.getInt("codigo"));
	        	lib.setDescripcion(rs.getString("descripcion"));
	        	lib.setPrecio(rs.getDouble("precio"));
	        	lib.setDescuento(rs.getInt("descuento"));
	        	lib.setCategoria(rs.getInt("categoria"));
	        	lib.setImagen(rs.getString("imagen"));
	        }
	        return lista;
	        } catch (Exception e) {
	        	System.out.print("los libros no son encontrados "+e.getMessage());
	        	return lista;
	        }
	}
	*/
}
