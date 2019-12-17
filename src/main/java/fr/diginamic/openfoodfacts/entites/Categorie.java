package fr.diginamic.openfoodfacts.entites;

public class Categorie {
String libelle;

/**Constructeur de Categorie avec un seul parametre
 * @param libelle
 */
public Categorie(String libelle) {
	super();
	this.libelle = libelle;
}

/**
 * @return the libelle
 */
public String getLibelle() {
	return libelle;
}

/**
 * @param libelle the libelle to set
 */
public void setLibelle(String libelle) {
	this.libelle = libelle;
}

@Override
public String toString(){
	return libelle;
}

}
