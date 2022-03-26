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
	
	public void updateSection(Section section) throws SQLException {
		String updateSecReq ="update section set  NomSection='"+section.getNom_section()
		+"'"+ " where IdSection ='"+section.getId_section()+"'";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(updateSecReq);
		
		if(res!=0) System.out.println("Section modifiée");
		else System.out.println("Erreur dans la modification !!"); 
	}

	
	public void deleteSection(String code) throws SQLException {
		String deleteSecReq =" delete from section where IdSection ='"+code+"'";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(deleteSecReq);
		
		if(res!=0) System.out.println("Note supprimée");
		else System.out.println("Erreur dans la suppression !!");
	}
	

		
	

	
		
}
