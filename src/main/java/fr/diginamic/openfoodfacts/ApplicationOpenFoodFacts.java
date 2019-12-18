package fr.diginamic.openfoodfacts;

import java.io.File;
import java.util.Scanner;

import org.apache.commons.lang3.StringUtils;

import fr.diginamic.openfoodfacts.entites.Stock;
import fr.diginamic.openfoodfacts.services.*;
import fr.diginamic.openfoodfacts.utils.ReadCsv;

public class ApplicationOpenFoodFacts {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		 ClassLoader classLoader = new ApplicationOpenFoodFacts().getClass().getClassLoader();
		File file = new File( classLoader.getResource("open-food-facts.csv").getFile());
		Stock stock = ReadCsv.read(file.toString());	
		
		if(stock==null || stock.getProduit().isEmpty()){
			System.out.println("Une erreur est survenue et l'application va se fermer.");
			System.exit(0);
		}
			
		int input = 0;
		do{
			afficherMenu();
			String inputS = scanner.nextLine();

			if (StringUtils.isNumeric(inputS)) {
				input = Integer.valueOf(inputS);
				switch (input) {
				case 1:
					//Rechercher les meilleurs produits pour une Marque donnée
					RechercheMeilleurProduitMarque rechercheMarque = new RechercheMeilleurProduitMarque();
					rechercheMarque.traiter(stock, scanner);
					break;
				
				case 2:
					//Rechercher les meilleurs produits pour une Catégorie donnée
					RechercheMeilleurProduitCategorie rechercheCategorie = new RechercheMeilleurProduitCategorie();
					rechercheCategorie.traiter(stock, scanner);
					break;
					
				case 3:
					//Rechercher les meilleurs produits pour une Catégorie et Marque donnée
					RechercheMeilleurProduitMarqueCategorie rechercheMarqueCategorie = new RechercheMeilleurProduitMarqueCategorie();
					rechercheMarqueCategorie.traiter(stock, scanner);
					break;
					
				case 4:
					//Afficher les allergènes les plus courants avec le nb de produits dans lesquels ils apparaissent
					AfficherAllergenePlusCourant afficheAllergene = new AfficherAllergenePlusCourant();
					afficheAllergene.traiter(stock, scanner);
					break;
					
				case 5:
					//Afficher les additifs les plus courants avec le nb de produits dans lesquels ils apparaissent.
					AfficherAdditifPlusCourant afficheAdditif = new AfficherAdditifPlusCourant();
					afficheAdditif.traiter(stock, scanner);
					break;
					
				case 9:
					System.out.println("Au revoir !");
					break;
					
				default:
					System.out.println("Veuillez choisir du menu.");
					break;
				}
			}else{
				System.out.println("Veuillez saisir un nombre.");
			}
		}while(input!=9);
	}

	public static void afficherMenu() {
		System.out.println("1. Rechercher les meilleurs produits pour une Marque donnée.");
		System.out.println("2. Rechercher les meilleurs produits pour une Catégorie donnée.");
		System.out.println("3. Rechercher les meilleurs produits par Marque et par Catégorie.");
		System.out.println(
				"4. Afficher les allergènes les plus courants avec le nb de produits dans lesquels ils apparaissent.");
		System.out.println(
				"5. Afficher les additifs les plus courants avec le nb de produits dans lesquels ils apparaissent.");
		System.out.println("9. Sortir");
	}
	

}
