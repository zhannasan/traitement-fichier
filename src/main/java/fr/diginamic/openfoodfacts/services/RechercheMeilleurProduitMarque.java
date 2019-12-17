package fr.diginamic.openfoodfacts.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

import fr.diginamic.openfoodfacts.entites.Produit;
import fr.diginamic.openfoodfacts.entites.ScoreNutritionnelle;
import fr.diginamic.openfoodfacts.entites.Stock;
import fr.diginamic.openfoodfacts.utils.CompareScore;
import fr.diginamic.openfoodfacts.utils.CompareStrings;;

public class RechercheMeilleurProduitMarque extends MenuService {
	@Override
	public void traiter(Stock stock, Scanner scanner) {
		List<Produit> produits = stock.getProduit();
		System.out.println("Veuillez choisir une marque");
		String marque = scanner.nextLine();

		List<String> names = new ArrayList<>();
		List<ScoreNutritionnelle> listScore = new ArrayList<ScoreNutritionnelle>();
		String mark="";
		for (Produit p : produits) {
			if (CompareStrings.isSame(marque, p.getMarque().getNom())) {
				mark = p.getMarque().getNom();
				listScore.add(p.getScore());
			}
		}
		Collections.sort(listScore, new CompareScore());
		
		for (Produit p : produits) {
			if (CompareStrings.isSame(marque, p.getMarque().getNom()) && p.getScore().toString().equals(listScore.get(0).toString())) {
				names.add(p.getNom());
			}
		}
		if (names.isEmpty()) {
			System.out.println("Aucun produit n'a pas été trouvé.");
		} else {
			System.out.println("Le meilleure score de la marque " +mark+" est "+listScore.get(0));
			for (String s : names) {
				System.out.println(s);
			}
		}

	}
}
