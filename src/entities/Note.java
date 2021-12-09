package entities;

public class Note {
	private String id_etudiant;
	private String id_matiere;
	private float valeur_note;
	private String type_note;
	


	/**
	 * 
	 */
	public Note() {
	}

	
	
	/**
	 * @param id_etudiant
	 * @param id_matiere
	 * @param valeur_note
	 * @param type_note
	 */
	public Note(String id_etudiant, String id_matiere, float valeur_note, String type_note) {
		this.id_etudiant = id_etudiant;
		this.id_matiere = id_matiere;
		this.valeur_note = valeur_note;
		this.type_note = type_note;
	}



	/**
	 * @return the id_etudiant
	 */
	public String getId_etudiant() {
		return id_etudiant;
	}



	/**
	 * @param id_etudiant the id_etudiant to set
	 */
	public void setId_etudiant(String id_etudiant) {
		this.id_etudiant = id_etudiant;
	}



	/**
	 * @return the id_matiere
	 */
	public String getId_matiere() {
		return id_matiere;
	}



	/**
	 * @param id_matiere the id_matiere to set
	 */
	public void setId_matiere(String id_matiere) {
		this.id_matiere = id_matiere;
	}



	/**
	 * @return the valeur_note
	 */
	public float getValeur_note() {
		return valeur_note;
	}



	/**
	 * @param valeur_note the valeur_note to set
	 */
	public void setValeur_note(float valeur_note) {
		this.valeur_note = valeur_note;
	}



	/**
	 * @return the type_note
	 */
	public String getType_note() {
		return type_note;
	}



	/**
	 * @param type_note the type_note to set
	 */
	public void setType_note(String type_note) {
		this.type_note = type_note;
	}


	

	
	

}
