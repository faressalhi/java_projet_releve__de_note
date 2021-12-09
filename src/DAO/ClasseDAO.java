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
	
	public void ajouteClasse(Classe classe) throws SQLException {
		String insrtClasseReq =" insert into classe values ('"+classe.getId_classe()+"','"+classe.getNom_classe()+"','"+classe.getId_Section()+"')";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(insrtClasseReq);
		
		if(res!=0) System.out.println("Classe ajoutée");
		else System.out.println("Erreur dans l'ajout !!");
	}
	
	

	public ArrayList <Classe> getClasses() throws SQLException{
		String selectClasseReq ="select * from classe ";
		Statement  st = connection.createStatement();
		ResultSet res = st.executeQuery(selectClasseReq);
		ArrayList <Classe> classes = new ArrayList <Classe>();
		while(res.next()) {
			Classe classe = new Classe();
			classe.setId_classe(res.getString(1));
			classe.setNom_classe(res.getString(2));
			classe.setId_Section(res.getString(3));
			classes.add(classe);
		}
		return classes;
	}
	
	public void deleteClasse(long code) throws SQLException {
		String deleteClasseReq =" delete from classe where code ='"+code+"'";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(deleteClasseReq);
		
		if(res!=0) System.out.println("Classe supprimée");
		else System.out.println("Erreur dans la suppression !!");
	}
	
	/*
	 * public Produit getProduitByCode(long code) throws SQLException { String
	 * selectOneProdReq ="select * from produit where code = "+code+""; Statement st
	 * = conn.createStatement(); ResultSet res = st.executeQuery(selectOneProdReq);
	 * res.next(); Produit p = new Produit(res.getInt(1),
	 * res.getString(2),res.getDouble(3)); return p; }
	 */
		
	
	public void updateClasse(Classe classe) throws SQLException {
		String updateClasseReq ="update classe set designation='"+classe.getNom_classe()+"',prix = '"+classe.getId_Section()
		+"'"+ " where code ='"+classe.getId_classe()+"'";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(updateClasseReq);
		
		if(res!=0) System.out.println("Classe modifiée");
		else System.out.println("Erreur dans la modification !!"); 
	}
	
}
