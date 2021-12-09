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
		String insrtNoteReq =" insert into note values ('"+note.getId_etudiant()+"''"+note.getId_matiere()+"','"+note.getValeur_note()+"','"+note.getType_note()+"')";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(insrtNoteReq);
		
		if(res!=0) System.out.println("Note ajouté");
		else System.out.println("Erreur dans l'ajout !!");
	}
	
	
	public ArrayList <Note> getNotes() throws SQLException{
		String selectNoteReq ="select * from note ";
		Statement  st = connection.createStatement();
		ResultSet res = st.executeQuery(selectNoteReq);
		ArrayList <Note> notes = new ArrayList <Note>();
		while(res.next()) {
			Note note = new Note();
			note.setId_etudiant(res.getString(1));
			note.setId_matiere(res.getString(2));
			note.setValeur_note(res.getFloat(3));
			note.setType_note(res.getString(4));
			notes.add(note);
		}
		return notes;
	}
	
	public void deleteNote(long code) throws SQLException {
		String deleteNoteReq =" delete from note where code ='"+code+"'";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(deleteNoteReq);
		
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
		
	
	public void updateMatiere(Note note) throws SQLException {
		String updateNoteReq ="update note set  designation='"+note.getType_note()+"',prix = '"+note.getId_etudiant()+"',prix = '"+note.getId_matiere()
		+"'"+ " where code ='"+note.getId_note()+"'";
		Statement  st = connection.createStatement();
		int res = st.executeUpdate(updateNoteReq);
		
		if(res!=0) System.out.println("Note modifiée");
		else System.out.println("Erreur dans la modification !!"); 
	}
	
	
	
}
