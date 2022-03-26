package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Affichage {

	public Connection connection;
	
	// Methode qui retourne les notes des etudiants d'un classe
	public ResultSet affichNoteEtudiantClasse(String id_classe) throws SQLException {
		// requete sql
		String affichNoteEtClasse="SELECT NomEtudiant, PrenomEtudiant , NomMatiere , CoefMatiere,  ValeurNote, TypeNote \r\n"
				+ "FROM classe c, etudiant e, matiere m, note n \r\n"
				+ "WHERE e.IdClasse = c.IdClasse and e.IdEtudiant = n.IdEtudiant \r\n"
				+ "and m.IdMatiere = n.IdMatiere and e.IdClasse = '"+id_classe+"';";
		PreparedStatement pst=connection.prepareStatement(affichNoteEtClasse);
		//execution du requete
		ResultSet rs=pst.executeQuery();
		
		return rs ;
	}
	
	// Methode qui retourne les notes d'un etudiant specifique
	public ResultSet affichNoteEtudiant(String id_etudiant) throws SQLException {
		// requete sql
		String affichNoteEtudiant="SELECT NomEtudiant, PrenomEtudiant , NomMatiere , CoefMatiere,  ValeurNote, TypeNote \r\n"
				+ "FROM etudiant e, matiere m, note n \r\n"
				+ "WHERE e.IdEtudiant = n.IdEtudiant \r\n"
				+ "and m.IdMatiere = n.IdMatiere and e.IdEtudiant = '"+id_etudiant+"';";
		
		PreparedStatement pst=connection.prepareStatement(affichNoteEtudiant);
		//execution du requete
		ResultSet rs=pst.executeQuery();
		
		return rs;
		
	}

	
	
}
