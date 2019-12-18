package fr.diginamic.openfoodfacts.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

import fr.diginamic.openfoodfacts.entites.Allergene;
import fr.diginamic.openfoodfacts.entites.Produit;
import fr.diginamic.openfoodfacts.entites.Stock;

public class AfficherAllergenePlusCourant {

	public void traiter(Stock stock, Scanner scanner) {
		List<Produit> produits = stock.getProduit();
		HashMap<Allergene, String> allergenes = new HashMap<Allergene, String>();
		HashMap<Integer, Allergene> allerdings = new HashMap<Integer, Allergene>();

		for (Produit p : produits) {
			allergenes.putAll(p.getMapAllergene());
		}

		for (Entry<Allergene, String> entry : allergenes.entrySet()) {
			List<String> valueList = Arrays.asList(entry.getValue().split("\\s*,\\s*"));
			allerdings.put(valueList.size(), entry.getKey());
		}
		TreeMap<Integer, Allergene> allings = new TreeMap<Integer, Allergene>(Collections.reverseOrder());
		allings.putAll(allerdings);
		if (allings != null) {
			System.out.println("Les 20 allergenes le plus courrants sont :");
			int i=0;
			for (Entry<Integer, Allergene> entry : allings.entrySet()) {
				System.out.println(entry.getValue().getLibelle() + " est présent dans : " 
									+ entry.getKey() + " produits");
				i++;
				if(i==20){
				break;}
			}
		} else {
			System.out.println("Aucun produit n'a pas été trouvé.");
		}

	}

}
