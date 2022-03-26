package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Matiere;

public class MatiereDAO {

	public Connection connection;
	
	public void ajouterMatiere(Matiere matiere) throws SQLException {
		String insrtMatReq =" insert into matiere values ('"+matiere.getId_matiere()+"','"+matiere.getNom_matiere()+"','"+matiere.getCoef_matiere()+"')";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(insrtMatReq);
		
		if(res!=0) System.out.println("matière ajouté");
		else System.out.println("Erreur dans l'ajout !!");
	}
	
	public void updateMatiere(Matiere matiere) throws SQLException {
		String updateMatReq ="update matiere set  NomMatiere='"+matiere.getNom_matiere()+"',CoefMatiere = '"+matiere.getCoef_matiere()
		+"'"+ " where  IdMatiere ='"+matiere.getId_matiere()+"'";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(updateMatReq);
		
		if(res!=0) System.out.println("Matiere modifié");
		else System.out.println("Erreur dans la modification !!"); 
	}
	
	
	
	
	public void deleteMatiere(String code) throws SQLException {
		String deleteMatReq =" delete from matiere where IdMatiere ='"+code+"'";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(deleteMatReq);
		
		if(res!=0) System.out.println("Matiere supprimé");
		else System.out.println("Erreur dans la suppression !!");
	}
	

	

	
	
	
	
	
}
