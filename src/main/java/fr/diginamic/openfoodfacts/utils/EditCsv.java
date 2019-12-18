package fr.diginamic.openfoodfacts.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;

import org.apache.commons.io.FilenameUtils;

public class EditCsv {
	/**Preparation du fichier pour faciliter traitement
	 * remplacements faites: des ";" pour "," des "|" pour ";", MILK et milk pour lait
	 * suppresions: "_", "."
	 * @param path
	 * @param ending
	 * @return path string de nouveau file.
	 */
	public static String edit(String path, String ending) {
		String newFile = "";
		File newF = new File(FilenameUtils.removeExtension(path) + ending + ".csv");
		newFile = newF.toString();
		try {
			if (!newF.exists()) {

				File tempFile = File.createTempFile("buffer", ".tmp");
				FileWriter fileW = new FileWriter(tempFile);

				Reader fr = new FileReader(path);
				BufferedReader br = new BufferedReader(fr);

				while (br.ready()) {
					fileW.write(br.readLine().replaceAll(";", ",").replaceAll("\\|", ";").replaceAll("_", " ")
							.replaceAll("(?i)milk", "lait").replaceAll("œufs", "œuf").replaceAll("eggs", "œuf")
							.replaceAll("soybeans", "soja").replaceAll("fish", "poisson")
							.replaceAll("nuts", "fruits à coques").replaceAll("oeufs", "œuf")
							.replaceAll("\\.", "") + "\n");
				}
				fileW.close();
				br.close();
				fr.close();

				tempFile.renameTo(newF);
				System.out.println("done! "+newFile);
			}
			return newFile;
		} catch (IOException e) {
			System.out.println(e.getMessage());
			return null;
		}

	}
}
