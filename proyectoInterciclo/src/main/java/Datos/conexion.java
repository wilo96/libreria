package Datos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class conexion {
	
	
	 public static Connection getCon() {
		return con;
	}

	public static void setCon(Connection con) {
		conexion.con = con;
	}
	
	private static Connection con;
	private static final String url="jdbc:mysql://localhost:3306/tienda";
	private static final String driver="com.mysql.jdbc.Driver";
	private static final String user="root";
	private static final String pass="";

	public void conexionsql()
	    {
		con=null;
	        try {
	            Class.forName(driver);
	            con=(Connection) DriverManager.getConnection(url,user,pass);
	            if(con!=null) {
	            	System.out.println("conecto");
	            }
	        } catch (ClassNotFoundException | SQLException e) {
	            System.out.println("Error de Conexion "+e.getMessage());
	        }
	    }
}
