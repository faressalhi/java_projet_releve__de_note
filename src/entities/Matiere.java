package entities;

public class Matiere {
	private String id_matiere;
	private String nom_matiere;
	private float coef_matiere;
	
	
	/**
	 * 
	 */
	public Matiere() {
	}



	/**
	 * @param id_matiere
	 */
	public Matiere(String id_matiere) {
		this.id_matiere = id_matiere;
	}

	/**
	 * @param id_matiere
	 * @param nom_matiere
	 * @param coef_matiere
	 */
	public Matiere(String id_matiere, String nom_matiere, float coef_matiere) {
		this.id_matiere = id_matiere;
		this.nom_matiere = nom_matiere;
		this.coef_matiere = coef_matiere;
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
	 * @return the nom_matiere
	 */
	public String getNom_matiere() {
		return nom_matiere;
	}



	/**
	 * @param nom_matiere the nom_matiere to set
	 */
	public void setNom_matiere(String nom_matiere) {
		this.nom_matiere = nom_matiere;
	}



	/**
	 * @return the coef_matiere
	 */
	public float getCoef_matiere() {
		return coef_matiere;
	}



	/**
	 * @param coef_matiere the coef_matiere to set
	 */
	public void setCoef_matiere(float coef_matiere) {
		this.coef_matiere = coef_matiere;
	}
	
	
	
	

}
