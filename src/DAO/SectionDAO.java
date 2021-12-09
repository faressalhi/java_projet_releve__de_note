package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Section;

public class SectionDAO {

	
public Connection connection;

	public void ajouteSection(Section section) throws SQLException {
		String insrtSecReq =" insert into section values ('"+section.getId_section()+"','"+section.getNom_section()+"')";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(insrtSecReq);
		
		if(res!=0) System.out.println("Section ajoutée");
		else System.out.println("Erreur dans l'ajout !!");
	}
	


	public ArrayList <Section> getSections() throws SQLException{
		String selectSecReq ="select * from section ";
		Statement  st = connection.createStatement();
		ResultSet res = st.executeQuery(selectSecReq);
		ArrayList <Section> sections = new ArrayList<Section>();
		while(res.next()) {
			Section section = new Section() ;
			section.setId_section(res.getString(1));
			section.setNom_section(res.getString(2));
			sections.add(section);
		}
		return sections;
	}
	
	public void deleteSection(long code) throws SQLException {
		String deleteSecReq =" delete from section where code ='"+code+"'";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(deleteSecReq);
		
		if(res!=0) System.out.println("Note supprimée");
		else System.out.println("Erreur dans la suppression !!");
	}
	
	
	/*
	 * public Produit getProduitByCode(long code) throws SQLException { String
	 * selectOneProdReq ="select * from produit where code = "+code+""; Statement st
	 * = conn.createStatement(); ResultSet res = st.executeQuery(selectOneProdReq);
	 * res.next(); Produit p = new Produit(res.getInt(1),
	 * res.getString(2),res.getDouble(3)); return p; }
	 */
		
	
	public void updateSection(Section section) throws SQLException {
		String updateSecReq ="update section set  designation='"+section.getNom_section()
		+"'"+ " where code ='"+section.getId_section()+"'";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(updateSecReq);
		
		if(res!=0) System.out.println("Section modifiée");
		else System.out.println("Erreur dans la modification !!"); 
	}
	
		
}
