package fr.diginamic.openfoodfacts.entites;

public class Marque {
String nom;

/**Constructeur de la Marque avec un seul parametre 
 * @param nom
 */
public Marque(String nom) {
	super();
	this.nom = nom;
}

/**
 * @return the nom
 */
public String getNom() {
	return nom;
}

}
