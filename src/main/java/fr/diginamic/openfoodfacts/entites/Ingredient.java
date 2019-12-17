package fr.diginamic.openfoodfacts.entites;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Ingredient {
String libelle;

/**Constructeur d'Ingredient avec un seul parametre
 * @param libelle
 */
public Ingredient(String libelle) {
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
public boolean equals(Object obj) {
	if (!(obj instanceof Ingredient) || obj == null) {
		return false;
	}
	if (this == obj) {
		return true;
	}
	Ingredient a = (Ingredient) obj;
	return new EqualsBuilder().append(libelle, a.libelle).isEquals();
}

@Override
public int hashCode() {
	return new HashCodeBuilder(17, 31).append(libelle).toHashCode();
}
}
