package fr.diginamic.openfoodfacts.entites;

import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

import org.apache.commons.io.FileUtils;

import fr.diginamic.openfoodfacts.ApplicationOpenFoodFacts;
import fr.diginamic.openfoodfacts.utils.CompareScore;
import fr.diginamic.openfoodfacts.utils.CompareStrings;
import fr.diginamic.openfoodfacts.utils.EditCsv;
import fr.diginamic.openfoodfacts.utils.ReadCsv;

public class Test {

	public static void main(String[] args) {
		// File file = new File(
		// ApplicationOpenFoodFacts.class.getClassLoader().getResource("open-food-facts.csv").getFile());
		// String path = EditCsv.edit(file.toString(),"_new");
		Stock stock = new Stock();
		HashMap<Ingredient, String> mapIngred = new HashMap<Ingredient, String>();
		HashMap<String, Donnees> mapNutrition = new HashMap<String, Donnees>();
		HashMap<Allergene, String> mapAllergene = new HashMap<Allergene, String>();
		HashMap<Additif, String> mapAdditif = new HashMap<Additif, String>();

		List<String> nutrLabels = new ArrayList<>();

		try {
			File file = new File(
					"C:/Users/jsant/Documents/Docs/Formations/Diginamic/Materials/JAVA/OOPJ7-10/open-food-factsN_new.csv");
			//File file = new File( ApplicationOpenFoodFacts.class.getClassLoader().getResource("open-food-facts.csv").getFile());
			//stock = ReadCsv.read(file.toString());	
			// File("C:/Users/jsant/MyProjects/SpringP/traitement-fichier/target/classes/open-food-facts_new.csv");
			List<String> lines = FileUtils.readLines(file, "UTF-8");

			String[] cols = lines.get(0).split(";");
			for (int j = 5; j < 30; j++) {
				nutrLabels.add(cols[j]);
			}
			for (int i = 1; i < lines.size(); i++) {
				String[] columns = lines.get(i).split(";");
				String nom = columns[0];

				String scoreCol = columns[1];
				ScoreNutritionnelle score = new ScoreNutritionnelle(scoreCol);

				String catCol = columns[2];
				Categorie cat = new Categorie(catCol);

				String marqueCol = columns[3];
				Marque marque = new Marque(marqueCol);

				String[] ings = columns[4].split(",");
				for (String n : ings) {
					Ingredient ingredient = new Ingredient(
							n.replaceAll("[\\[\\]]", "").replaceAll("\\.", "").trim().toLowerCase());
					if (!ingredient.getLibelle().equals("")) {
						if (mapIngred.containsKey(ingredient) && mapIngred.get(ingredient) != null) {
							mapIngred.put(ingredient, mapIngred.get(ingredient) + ", " + nom);
						} else {
							mapIngred.put(ingredient, nom);
						}
					}
				}

				int k = 0;
				for (int j = 5; j < 30; j++) {
					String nutr = columns[j].toString();
					Donnees donNutr = new Donnees(nutr);
					mapNutrition.put(nutrLabels.get(k), donNutr);
					k++;
				}

				String[] allergenes = columns[30].split(",");
				for (String a : allergenes) {
					Allergene allergene = new Allergene(a.replaceAll("[\\[\\]]", "").trim().toLowerCase());
					if (!allergene.getLibelle().equals("")) {
						if (mapAllergene.containsKey(allergene) && mapAllergene.get(allergene) != null) {
							mapAllergene.put(allergene, mapAllergene.get(allergene) + ", " + nom);
						} else {
							mapAllergene.put(allergene, nom);
						}
					}
				}

				String[] adds = columns[31].split(",");
				for (String ad : adds) {
					Additif additive = new Additif(ad.replaceAll("[\\[\\]]", "").trim());
					if (!additive.getLibelle().equals("")) {
						if (mapAdditif.containsKey(additive) && mapAdditif.get(additive) != null) {
							mapAdditif.put(additive, mapAdditif.get(additive) + ", " + nom);
						} else {
							mapAdditif.put(additive, nom);
						}
					}
				}

				Produit produit = new Produit(nom, cat, marque, score, mapNutrition, mapIngred, mapAdditif,
						mapAllergene);

				stock.getProduit().add(produit);
			}
			Scanner scanner = new Scanner(System.in);
			List<Produit> produits = stock.getProduit();
			System.out.println("Veuillez choisir une marque");
			String categorie = scanner.nextLine();

			List<String> names = new ArrayList<>();
			List<ScoreNutritionnelle> listScore = new ArrayList<ScoreNutritionnelle>();
			String cat="";
			for (Produit p : produits) {
				if (CompareStrings.isSame(categorie, p.getCat().getLibelle())) {
					cat = p.getCat().getLibelle();
					listScore.add(p.getScore());
				}
			}
			Collections.sort(listScore, new CompareScore());
			
			for (Produit p : produits) {
				System.out.println(CompareStrings.isSame(categorie, p.getCat().getLibelle())+" "+p.getScore().toString().equals(listScore.get(0).toString()));
				if (CompareStrings.isSame(categorie, p.getCat().getLibelle()) && p.getScore().toString().equals(listScore.get(0).toString())) {
					names.add(p.getNom());
				}
			}
			if (names.isEmpty()) {
				System.out.println("Aucun produit n'a pas été trouvé.");
			} else {
				System.out.println("Le meilleure score de la categorie " +cat+" est "+listScore.get(0));
				for (String s : names) {
					System.out.println(s);
				}
			}
			
			
		} catch (IOException e) {
			System.out.println(e.getMessage());
		}
	}

}
