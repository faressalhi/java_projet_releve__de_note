package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import entities.Note;

public class NoteDAO {

	public Connection connection;
	
	public void ajouteNote(Note note) throws SQLException {
		String insrtNoteReq =" insert into note values ('"+note.getId_etudiant()+"','"+note.getId_matiere()+"','"+note.getValeur_note()+"','"+note.getType_note()+"')";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(insrtNoteReq);
		
		if(res!=0) System.out.println("Note ajouté");
		else System.out.println("Erreur dans l'ajout !!");
	}
	

	public void updateNote(Note note) throws SQLException {
		String updateNoteReq ="update note set  ValeurNote ='"+note.getValeur_note()+"' where IdEtudiant  ='"+note.getId_etudiant()+"' and IdMatiere ='"+note.getId_matiere()+"' and TypeNote = '"+note.getType_note()+"'";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(updateNoteReq);
		
		if(res!=0) System.out.println("Note modifiée");
		else System.out.println("Erreur dans la modification !!"); 
	}
	
	public void deleteNote(String code1, String code2, String code3) throws SQLException {
		String deleteNoteReq =" delete from note where IdEtudiant ='"+code1+"' and IdMatiere = '"+code2 +"' and TypeNote = '"+code3+"' ";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(deleteNoteReq);
		
		if(res!=0) System.out.println("Note supprimée");
		else System.out.println("Erreur dans la suppression !!");
	}
	
	

	
	
	
	
}
