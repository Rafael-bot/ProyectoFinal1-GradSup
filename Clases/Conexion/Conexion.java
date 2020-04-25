package ProPlay.Clases.Conexion;

import java.sql.*;
import java.util.Properties;

public class Conexion {
	
	private String timeZone = "?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	private String dbName = "proplayit";//Nombre de la base de datos
	private String url = "jdbc:mysql://localhost:3306/" + dbName + timeZone;//Url completa
	private String user = "root";//usuario
	private String pass = "manolo";//contraseña
	private String driver = "com.mysql.cj.jdbc.Driver";//Driver
	
	private Connection miConexion;
	
	public void conex() {
		
		try {
			
			miConexion = DriverManager.getConnection(url,user,pass);
			
		}catch (Exception e) {
			System.out.println("Error, no sea conseguido conectar con la base de datos.");
		}
		
	}

}
