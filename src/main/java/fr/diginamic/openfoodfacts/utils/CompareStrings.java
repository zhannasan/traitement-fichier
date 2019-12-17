package fr.diginamic.openfoodfacts.utils;

import java.text.Collator;
import java.util.Locale;

public class CompareStrings {
	
	/**
	 * @param s
	 * @param p
	 * @return
	 */
	public static boolean isSame(String s, String p) {
		Collator frCollator = Collator.getInstance(Locale.FRANCE);
		frCollator.setStrength(Collator.PRIMARY);
		return frCollator.compare(s.toLowerCase().replaceAll(" ", ""), p.toLowerCase().replaceAll(" ", ""))==0;
	}
}
