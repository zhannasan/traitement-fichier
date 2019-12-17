package fr.diginamic.openfoodfacts.entites;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Additif {
	String libelle;
	/**Constructeur d'Additif avec un seul parametre
	 * @param libelle
	 */
	public Additif(String libelle) {
		super();
		this.libelle = libelle;
	}
	/**
	 * @return the libelle
	 */
	public String getLibelle() {
		return libelle;
	}

	@Override
	public boolean equals(Object obj) {
		if (!(obj instanceof Additif) || obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		Additif a = (Additif) obj;
		return new EqualsBuilder().append(libelle, a.libelle).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 31).append(libelle).toHashCode();
	}
}
