package entities;

public class Section {
	private String id_section;
	private String nom_section;
	
	
	
	
	
	/**
	 * 
	 */
	public Section() {
	}



	/**
	 * @param id_section
	 */
	public Section(String id_section) {
		this.id_section = id_section;
	}



	/**
	 * @param id_section
	 * @param nom_section
	 */
	public Section(String id_section, String nom_section) {
		this.id_section = id_section;
		this.nom_section = nom_section;
	}



	/**
	 * @return the id_section
	 */
	public String getId_section() {
		return id_section;
	}



	/**
	 * @param id_section the id_section to set
	 */
	public void setId_section(String id_section) {
		this.id_section = id_section;
	}



	/**
	 * @return the nom_section
	 */
	public String getNom_section() {
		return nom_section;
	}



	/**
	 * @param nom_section the nom_section to set
	 */
	public void setNom_section(String nom_section) {
		this.nom_section = nom_section;
	}


	
	
	
}
