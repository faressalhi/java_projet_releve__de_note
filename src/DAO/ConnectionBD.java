package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionBD {
	
	Connection connection=null;
	
	public ConnectionBD() {
		
	}
 	
	public Connection connecter() throws SQLException {
		 
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestion_releve_note", "root", "");
		System.out.println("Connectà à BD.");
		return connection;
	
	}
	
	public void deconnecter() {
		connection = null;
		System.out.println("Deconnecté de BD.");
	}
	
}
