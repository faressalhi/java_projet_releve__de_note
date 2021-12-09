package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Etudiant;

public class EtudiantDAO {

	public Connection connection;
	
	public void ajouteEtudiant(Etudiant etudiant) throws SQLException {
		String insrtEtudReq =" insert into etudiant values ('"+etudiant.getId_etudiant()+"','"+etudiant.getNom_etudiant()+"','"+etudiant.getPrenom_etudiant()+"')";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(insrtEtudReq);
		
		if(res!=0) System.out.println("Etudiant ajouté");
		else System.out.println("Erreur dans l'ajout !!");
	}
	
	

	public ArrayList <Etudiant> getEtudiants() throws SQLException{
		String selectNoteReq ="select * from etudiant ";
		Statement  st = connection.createStatement();
		ResultSet res = st.executeQuery(selectNoteReq);
		ArrayList <Etudiant> etudiants = new ArrayList <Etudiant>();
		while(res.next()) {
			Etudiant etudiant = new Etudiant();
			etudiant.setId_etudiant(res.getString(1));
			etudiant.setNom_etudiant(res.getString(2));
			etudiant.setPrenom_etudiant(res.getString(3));
			etudiant.setId_classe(res.getString(4));
			etudiants.add(etudiant);
		}
		return etudiants;
	}
	
	public void deleteEtudiant(long code) throws SQLException {
		String deleteEtudReq =" delete from etudiant where code ='"+code+"'";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(deleteEtudReq);
		
		if(res!=0) System.out.println("Etudiant supprimé");
		else System.out.println("Erreur dans la suppression !!");
	}
	
	/*
	 * public Produit getProduitByCode(long code) throws SQLException { String
	 * selectOneProdReq ="select * from produit where code = "+code+""; Statement st
	 * = conn.createStatement(); ResultSet res = st.executeQuery(selectOneProdReq);
	 * res.next(); Produit p = new Produit(res.getInt(1),
	 * res.getString(2),res.getDouble(3)); return p; }
	 */
		
	
	public void updateEtudiant(Etudiant etudiant) throws SQLException {
		String updateEtudReq ="update etudiant set  designation='"+etudiant.getNom_etudiant()+"',prix = '"+etudiant.getPrenom_etudiant()+"',prix = '"+etudiant.getId_classe()
		+"'"+ " where code ='"+etudiant.getId_etudiant()+"'";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(updateEtudReq);
		
		if(res!=0) System.out.println("Etudiant modifié");
		else System.out.println("Erreur dans la modification !!"); 
	}
	
}
