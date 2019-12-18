package fr.diginamic.openfoodfacts.services;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map.Entry;

import fr.diginamic.openfoodfacts.entites.Additif;
import fr.diginamic.openfoodfacts.entites.Allergene;
import fr.diginamic.openfoodfacts.entites.Produit;
import fr.diginamic.openfoodfacts.entites.Stock;

public class AfficherAdditifPlusCourant {
	public void traiter(Stock stock, Scanner scanner) {
		List<Produit> produits = stock.getProduit();
		HashMap<Additif, String> additifs = new HashMap<Additif, String>();
		HashMap<Integer, Additif> adds = new HashMap<Integer, Additif>();

		for (Produit p : produits) {
			additifs.putAll(p.getMapAdditif());
		}

		for (Entry<Additif, String> entry : additifs.entrySet()) {
			List<String> valueList = Arrays.asList(entry.getValue().split("\\s*,\\s*"));
			adds.put(valueList.size(), entry.getKey());
		}
		TreeMap<Integer, Additif> addings = new TreeMap<Integer, Additif>(Collections.reverseOrder());
		addings.putAll(adds);
		if (addings != null) {
			System.out.println("Les 20 additifs le plus courrants sont :");
			int i=0;
			for (Entry<Integer, Additif> entry : addings.entrySet()) {
				System.out.println(entry.getValue().getLibelle() + " est présent dans : " 
									+ entry.getKey() + " produits");
				i++;
				if(i==20){
				break;}
			}
		} else {
			System.out.println("Aucun produit n'a pas été trouvé.");
		}	}
}
