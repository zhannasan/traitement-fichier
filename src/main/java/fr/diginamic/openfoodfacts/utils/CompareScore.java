package fr.diginamic.openfoodfacts.utils;

import java.util.Comparator;

import fr.diginamic.openfoodfacts.entites.ScoreNutritionnelle;


public class CompareScore implements Comparator<ScoreNutritionnelle> {
	@Override
	public int compare(ScoreNutritionnelle s, ScoreNutritionnelle p) {
		return s.toString().compareTo(p.toString());
	}
}
