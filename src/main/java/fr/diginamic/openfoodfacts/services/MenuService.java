package fr.diginamic.openfoodfacts.services;

import java.util.Scanner;

import fr.diginamic.openfoodfacts.entites.Stock;


public abstract class MenuService {
	
	public abstract void traiter(Stock stock, Scanner scanner) ;
}
