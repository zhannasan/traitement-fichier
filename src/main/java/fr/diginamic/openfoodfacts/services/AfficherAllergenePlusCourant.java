package fr.diginamic.openfoodfacts.services;


import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Map.Entry;

import fr.diginamic.openfoodfacts.entites.Allergene;
import fr.diginamic.openfoodfacts.entites.Produit;
import fr.diginamic.openfoodfacts.entites.Stock;

public class AfficherAllergenePlusCourant {

	public void traiter(Stock stock, Scanner scanner) {
		List<Produit> produits = stock.getProduit();
		HashMap<Allergene, String> allergenes = new HashMap<Allergene, String>();

		for (Produit p : produits) {
			allergenes.putAll(p.getMapAllergene());
		}

		int maxVal = 0;
		Allergene maxKey = null;
		List<String> maxValueList = null;
		for (Entry<Allergene, String> entry : allergenes.entrySet()) {
			List<String> valueList = Arrays.asList(entry.getValue().split("\\s*,\\s*"));
			if (valueList.size() > maxVal) {
				maxVal = valueList.size();
				maxKey = entry.getKey();
				maxValueList = Arrays.asList(entry.getValue().split("\\s*,\\s*"));
			}
		}
		
		if (maxKey != null && maxValueList!=null) {
			System.out.println("L'allergene le plus courrant est " + maxKey.getLibelle()
			+ "\rIl est présent dans : " +maxValueList.size()+" produits"+"\rVoici les premiers 20 :");
			for (int i=0; i<20; i++) {
				System.out.println(maxValueList.get(i));
			}
		} else {
			System.out.println("Aucun produit n'a pas été trouvé.");
		}
		
	}

}
