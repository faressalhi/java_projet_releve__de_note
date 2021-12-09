package entities;

public class Etudiant {
	private String id_etudiant;
	private String nom_etudiant;
	private String prenom_etudiant;
	private String id_classe;
	
	
	
	
	/**
	 * 
	 */
	public Etudiant() {
	}
	/**
	 * @param id_etudiant
	 */
	public Etudiant(String id_etudiant) {
		this.id_etudiant = id_etudiant;
	}
	
	
	/**
	 * @param id_etudiant
	 * @param nom_etudiant
	 * @param prenom_etudiant
	 * @param id_classe
	 */
	public Etudiant(String id_etudiant, String nom_etudiant, String prenom_etudiant, String id_classe) {
		this.id_etudiant = id_etudiant;
		this.nom_etudiant = nom_etudiant;
		this.prenom_etudiant = prenom_etudiant;
		this.id_classe = id_classe;
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
	 * @return the nom_etudiant
	 */
	public String getNom_etudiant() {
		return nom_etudiant;
	}
	/**
	 * @param nom_etudiant the nom_etudiant to set
	 */
	public void setNom_etudiant(String nom_etudiant) {
		this.nom_etudiant = nom_etudiant;
	}
	/**
	 * @return the prenom_etudiant
	 */
	public String getPrenom_etudiant() {
		return prenom_etudiant;
	}
	/**
	 * @param prenom_etudiant the prenom_etudiant to set
	 */
	public void setPrenom_etudiant(String prenom_etudiant) {
		this.prenom_etudiant = prenom_etudiant;
	}
	/**
	 * @return the id_classe
	 */
	public String getId_classe() {
		return id_classe;
	}
	/**
	 * @param id_classe the id_classe to set
	 */
	public void setId_classe(String id_classe) {
		this.id_classe = id_classe;
	}

	
	

}
