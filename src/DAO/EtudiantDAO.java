package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Etudiant;

public class EtudiantDAO {

	public Connection connection;
	
	// methode d'ajout d'un etudiant
	public void ajouteEtudiant(Etudiant etudiant) throws SQLException {
		// preparer la requete
		String insrtEtudReq =" insert into etudiant values ('"+etudiant.getId_etudiant()+"','"+etudiant.getNom_etudiant()+"','"+etudiant.getPrenom_etudiant()+"','"+etudiant.getId_classe()+"')";
		Statement  st = connection.createStatement();
		// execution de l'update
		int res = st.executeUpdate(insrtEtudReq);
		// verifier si la methode est reussite ou pas 
		if(res!=0) System.out.println("Etudiant ajouté");
		else System.out.println("Erreur dans l'ajout !!");
	}
	
	
	// mettre a jour un etudiant
	public void updateEtudiant(Etudiant etudiant) throws SQLException {
		String updateEtudReq ="update etudiant set  NomEtudiant='"+etudiant.getNom_etudiant()+"',PrenomEtudiant = '"+etudiant.getPrenom_etudiant()+"',IdClasse  = '"+etudiant.getId_classe()
		+"'"+ " where IdEtudiant  ='"+etudiant.getId_etudiant()+"'";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(updateEtudReq);
		
		if(res!=0) System.out.println("Etudiant modifié");
		else System.out.println("Erreur dans la modification !!"); 
	}

	// supprimer un etudiant
	public void deleteEtudiant(String code) throws SQLException {
		String deleteEtudReq =" delete from etudiant where IdEtudiant ='"+code+"'";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(deleteEtudReq);
		
		if(res!=0) System.out.println("Etudiant supprimé");
		else System.out.println("Erreur dans la suppression !!");
	}
	


	
}
