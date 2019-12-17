package fr.diginamic.openfoodfacts.entites;

public class ScoreNutritionnelle {
 String score;

/**Construcuteur de Score Nutritionnel avec un seul parametre
 * @param score
 */
public ScoreNutritionnelle(String score) {
	super();
	this.score = score;
}

/**
 * @return the score
 */
public String getScore() {
	return score;
}

/**
 * @param score the score to set
 */
public void setScore(String score) {
	this.score = score;
}
@Override
public String toString(){
	return score;
}
 
}
