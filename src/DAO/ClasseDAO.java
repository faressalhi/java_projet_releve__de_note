package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Classe;
import entities.Section;

public class ClasseDAO {

	public Connection connection;


	
	// methode qui retourne tous les classes 
	public ResultSet getClasses() throws SQLException{
		String selectClasseReq ="select * from classe ";
		Statement  st = connection.createStatement();
		ResultSet res = st.executeQuery(selectClasseReq);
		
		
		return res;
	}
	

	public void ajouteClasse(Classe classe) throws SQLException {
		String insrtClasseReq =" insert into classe values ('"+classe.getId_classe()+"','"+classe.getNom_classe()+"','"+classe.getId_Section()+"')";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(insrtClasseReq);
		
		if(res!=0) System.out.println("Classe ajoutée");
		else System.out.println("Erreur dans l'ajout !!");
	}
	
	
	public void updateClasse(Classe classe) throws SQLException {
		String updateClasseReq ="update classe set NomClasse='"+classe.getNom_classe()+"',IdSection = '"+classe.getId_Section()
		+"'"+ " where IdClasse ='"+classe.getId_classe()+"'";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(updateClasseReq);
		
		if(res!=0) System.out.println("Classe modifiée");
		else System.out.println("Erreur dans la modification !!"); 
	}
	
	public void deleteClasse(String code) throws SQLException {
		String deleteClasseReq =" delete from classe where IdClasse ='"+code+"'";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(deleteClasseReq);
		
		if(res!=0) System.out.println("Classe supprimée");
		else System.out.println("Erreur dans la suppression !!");
	}

	

	
}
