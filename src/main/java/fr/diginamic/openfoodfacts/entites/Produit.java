package fr.diginamic.openfoodfacts.entites;

import java.util.HashMap;


public class Produit {
	String nom;
	Categorie cat;
	Marque marque;
	ScoreNutritionnelle score;
	HashMap<String, Donnees> mapNutrition;
	HashMap<Ingredient, String> mapIngred;
	HashMap<Additif, String> mapAdditif;
	HashMap<Allergene, String> mapAllergene;
	
	/**Constructeur du Produit avec parametres:
	 * @param nom Nom du produit
	 * @param cat Categorie du produit
	 * @param marque Marque du produit
	 * @param score Score nutritionnel du produit
	 * @param mapNutrition les Donnees Nutritionnelles
	 * @param mapIngred Inredients du produit
	 * @param mapAdditif Additifs du produit
	 * @param mapAllergene Allergenes du produit
	 */
	public Produit(String nom, Categorie cat, Marque marque, ScoreNutritionnelle score,
			HashMap<String, Donnees> mapNutrition, HashMap<Ingredient, String> mapIngred,
			HashMap<Additif, String> mapAdditif, HashMap<Allergene, String> mapAllergene) {
		super();
		this.nom = nom;
		this.cat = cat;
		this.marque = marque;
		this.score = score;
		this.mapNutrition = mapNutrition;
		this.mapIngred = mapIngred;
		this.mapAdditif = mapAdditif;
		this.mapAllergene = mapAllergene;
	}
	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}
	/**
	 * @return the cat
	 */
	public Categorie getCat() {
		return cat;
	}
	/**
	 * @return the marque
	 */
	public Marque getMarque() {
		return marque;
	}
	/**
	 * @return the score
	 */
	public ScoreNutritionnelle getScore() {
		return score;
	}
	/**
	 * @return the mapNutrition
	 */
	public HashMap<String, Donnees> getMapNutrition() {
		return mapNutrition;
	}
	/**
	 * @return the mapIngred
	 */
	public HashMap<Ingredient, String> getMapInrged() {
		return mapIngred;
	}
	/**
	 * @return the mapAdditif
	 */
	public HashMap<Additif, String> getMapAdditif() {
		return mapAdditif;
	}
	/**
	 * @return the mapAllergene
	 */
	public HashMap<Allergene, String> getMapAllergene() {
		return mapAllergene;
	}
	
}
