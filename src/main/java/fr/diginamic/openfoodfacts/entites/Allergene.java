package fr.diginamic.openfoodfacts.entites;

import java.util.HashMap;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

public class Allergene {
	String libelle;
	HashMap<Allergene, String> mapAllergene;
	
	/**Constructeur d'Allergene avec un seul parametre
	 * @param libelle
	 */
	public Allergene(String libelle) {
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
		if (!(obj instanceof Allergene) || obj == null) {
			return false;
		}
		if (this == obj) {
			return true;
		}
		Allergene a = (Allergene) obj;
		return new EqualsBuilder().append(libelle, a.libelle).isEquals();
	}

	@Override
	public int hashCode() {
		return new HashCodeBuilder(17, 31).append(libelle).toHashCode();
	}
}
