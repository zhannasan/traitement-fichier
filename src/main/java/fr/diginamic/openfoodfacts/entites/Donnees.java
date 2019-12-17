package fr.diginamic.openfoodfacts.entites;

public class Donnees {
	String donnees;

	/**Constructeur de Donnees Nutritionnelles avec un seul parametre
	 * @param data
	 */
	public Donnees(String donnees) {
		super();
		this.donnees = donnees;
	}

	/**
	 * @return the data
	 */
	public String getDonnees() {
		return donnees;
	}

	/**
	 * @param data the data to set
	 */
	public void setDonnees(String donnees) {
		this.donnees = donnees;
	}
	
}
