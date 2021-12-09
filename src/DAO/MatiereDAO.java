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
	

	public ArrayList <Matiere> getMatieres() throws SQLException{
		String selectMatReq ="select * from produit ";
		Statement  st = connection.createStatement();
		ResultSet res = st.executeQuery(selectMatReq);
		ArrayList <Matiere> matieres = new ArrayList <Matiere>();
		while(res.next()) {
			Matiere matiere = new Matiere();
			matiere.setId_matiere(res.getString(1));
			matiere.setNom_matiere(res.getString(2));
			matiere.setCoef_matiere(res.getFloat(3));
			matieres.add(matiere);
		}
		return matieres;
	}
	
	public void deleteMatiere(long code) throws SQLException {
		String deleteMatReq =" delete from matiere where code ='"+code+"'";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(deleteMatReq);
		
		if(res!=0) System.out.println("Matiere supprimé");
		else System.out.println("Erreur dans la suppression !!");
	}
	
	
	/*
	 * public Produit getProduitByCode(long code) throws SQLException { String
	 * selectOneProdReq ="select * from produit where code = "+code+""; Statement st
	 * = conn.createStatement(); ResultSet res = st.executeQuery(selectOneProdReq);
	 * res.next(); Produit p = new Produit(res.getInt(1),
	 * res.getString(2),res.getDouble(3)); return p; }
	 */
		
	
	public void updateMatiere(Matiere matiere) throws SQLException {
		String updateMatReq ="update matiere set  designation='"+matiere.getNom_matiere()+"',prix = '"+matiere.getCoef_matiere()
		+"'"+ " where code ='"+matiere.getId_matiere()+"'";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(updateMatReq);
		
		if(res!=0) System.out.println("Matiere modifié");
		else System.out.println("Erreur dans la modification !!"); 
	}
	
	
	
	
	
	
	
}
