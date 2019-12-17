/**
 * 
 */
package fr.diginamic.openfoodfacts.utils;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;

import fr.diginamic.openfoodfacts.entites.*;

public class ReadCsv {

	public static Stock read(String path) {
		/**
		 * Before reading an open food facts file, we have to take care of delimiters
		 */
		path = EditCsv.edit(path,"_new");
		
		Stock stock = new Stock();			
		HashMap<Ingredient,String> mapIngred = new HashMap<Ingredient,String>();		
		HashMap<String, Donnees> mapNutrition = new HashMap<String, Donnees>();		
		HashMap< Allergene, String> mapAllergene = new HashMap< Allergene, String>();
		HashMap<Additif, String> mapAdditif = new HashMap<Additif, String>();
		
		List<String> nutrLabels = new ArrayList<>();
		
		try{
			File file = new File(path);
			List<String> lines = FileUtils.readLines(file, "UTF-8");
			
			String[] nColumn = lines.get(0).split(";");
			for(int j=5; j<30; j++){
				nutrLabels.add(nColumn[j].toString());
			}
					
		for (int i=1; i<lines.size(); i++)  {
			String[] columns = lines.get(i).split(";");
			String nom = columns[0];
			
			String scoreCol = columns[1];
			ScoreNutritionnelle score = new ScoreNutritionnelle(scoreCol);
			
			String catCol = columns[2];
			Categorie cat = new Categorie(catCol);
			
			String marqueCol = columns[3];
			Marque marque = new Marque(marqueCol);
			
			String[] ings = columns[4].split(",");
			for (String n: ings){
				Ingredient ingredient = new Ingredient(n.replaceAll("[\\[\\]]", "").replaceAll("\\.","").trim().toLowerCase());
				if (!ingredient.getLibelle().equals("")) {
					if (mapIngred.containsKey(ingredient) &&  mapIngred.get(ingredient)!=null) {
						mapIngred.put(ingredient, mapIngred.get(ingredient) + ", " + nom);
					} else {
						mapIngred.put(ingredient, nom);}		
				}
			}
						
			int k=0;
			for(int j=5; j<30; j++){
				String nutr = columns[j].toString();
				Donnees donNutr= new Donnees(nutr);
				mapNutrition.put(nutrLabels.get(k), donNutr);
				k++;
			}
			

			String[] allergenes = columns[30].split(",");
			for (String  a: allergenes) {
				Allergene allergene = new Allergene(a.replaceAll("[\\[\\]]", "").trim().toLowerCase());
				if (!allergene.getLibelle().equals("")) {
					if (mapAllergene.containsKey(allergene) &&  mapAllergene.get(allergene)!=null) {
						mapAllergene.put(allergene, mapAllergene.get(allergene) + ", " + nom);
					} else {
						mapAllergene.put(allergene, nom);}		
				}
			}
		
			
			String[] adds = columns[31].split(",");
			for (String ad : adds) {
				Additif additive = new Additif(ad.replaceAll("[\\[\\]]", "").trim());
				if (!additive.getLibelle().equals("")) {
					if (mapAdditif.containsKey(additive) &&  mapAdditif.get(additive)!=null) {
						mapAdditif.put(additive, mapAdditif.get(additive) + ", " + nom);
					} else {
						mapAdditif.put(additive, nom);}		
				}
			}
			
			Produit produit = new Produit(nom, cat, marque, score, mapNutrition,  mapIngred, mapAdditif, mapAllergene);
			
			stock.getProduit().add(produit);
		}
		} catch (IOException e) {
			System.out.println("File not found"+e.getMessage());
			return null;
		}
		return stock;
	}
}
