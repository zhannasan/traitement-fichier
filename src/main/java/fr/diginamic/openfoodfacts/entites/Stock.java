package fr.diginamic.openfoodfacts.entites;

import java.util.ArrayList;
import java.util.List;

public class Stock {
	List <Produit> produit = new ArrayList<Produit>();

	/**Constructeur de la Liste des produits
	 * @return the produit
	 */
	public List <Produit> getProduit() {
		return produit;
	}

	/**
	 * @param List<Produit> the produit to set
	 */
	public void setProduit(List <Produit> stock) {
		this.produit = produit;
	}
	
}
