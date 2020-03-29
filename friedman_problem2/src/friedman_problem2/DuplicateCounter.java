//Made by Jason Friedman
package friedman_problem2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DuplicateCounter {
	static int wordCounter = 0;
	static List<String> uniqueWords = new ArrayList<String>();
	
	public static void count() {
		try {
			String dataFile = "problem2.txt";
			File input = new File(dataFile);
			
			if (!input.exists()) {
				System.out.println(dataFile + " not found, ending program");
				System.exit(0);
			}
		
			Scanner file = new Scanner(input);
			while (file.hasNextLine()) {
				Scanner line = new Scanner(file.nextLine());
				while (line.hasNext()) {
					String word = line.next();
					testForDuplicates(word);
				}
				line.close();
			}
			file.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	public static int testForDuplicates(String word) {
		for ( int i = 0 ; i < uniqueWords.size() ; i++ ) {
			if ( word.equalsIgnoreCase(uniqueWords.get(i))) {
				wordCounter++;
				return 1;
			}
		}
		uniqueWords.add(word.toLowerCase());
		return 0;
	}
	
	public static void write() {
		try {
			String outputFile = "unique_word_counts.txt";
			File output = new File(outputFile);
		
			if (output.createNewFile()) {
				System.out.println(outputFile + " Created");
			}
			else {
				System.out.println(outputFile + " already exists");
			}

			FileWriter myWriter = new FileWriter(outputFile);
			
			System.out.println("Output:");

			System.out.println(wordCounter);
			myWriter.write(Integer.toString(wordCounter));

			myWriter.close();

		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}