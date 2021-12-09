package entities;

public class Classe {
	private String id_classe;
	private String nom_classe;
	private String id_section ;
	

	
	
	
	
	/**
	 * 
	 */
	public Classe() {
	}


	/**
	 * @param id_classe
	 */
	public Classe(String id_classe) {
		this.id_classe = id_classe;
	}


	/**
	 * @param id_classe
	 * @param nom_classe
	 */
	public Classe(String id_classe, String nom_classe, String id_section) {
		this.id_classe = id_classe;
		this.nom_classe = nom_classe;
		this.id_section = id_section;
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


	/**
	 * @return the nom_classe
	 */
	public String getNom_classe() {
		return nom_classe;
	}


	/**
	 * @param nom_classe the nom_classe to set
	 */
	public void setNom_classe(String nom_classe) {
		this.nom_classe = nom_classe;
	}


	/**
	 * @return the id_section
	 */
	public String getId_Section() {
		return id_section;
	}


	/**
	 * @param id_section the id_section to set
	 */
	public void setId_Section(String id_section) {
		this.id_section = id_section;
	}

	
	
}
