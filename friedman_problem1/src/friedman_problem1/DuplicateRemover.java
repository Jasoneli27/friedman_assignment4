//Made by Jason Friedman
package friedman_problem1;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class DuplicateRemover {
	static List<String> uniqueWords = new ArrayList<String>();
	
	public static void remove() {
		try {
			String dataFile = "problem1.txt";
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
					testForUniqueWords(word);
				}
				line.close();
			}
			file.close();
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
	
	public static int testForUniqueWords(String word) {
		for ( int i = 0 ; i < uniqueWords.size() ; i++ ) {
			if ( word.equalsIgnoreCase(uniqueWords.get(i))) {
				uniqueWords.remove(word.toLowerCase());
				return 1;
			}
		}
		uniqueWords.add(word.toLowerCase());
		return 0;
	}
	
	public static void write() {
		try {
			String outputFile = "unique_words.txt";
			File output = new File(outputFile);
		
			if (output.createNewFile()) {
				System.out.println(outputFile + " Created");
			}
			else {
				System.out.println(outputFile + " already exists");
			}
		
			FileWriter myWriter = new FileWriter(outputFile);
			
			System.out.println("Output:");
		
			for ( int i = 0 ; i < uniqueWords.size() ; i++ ) {
				System.out.println(uniqueWords.get(i));
				myWriter.write(uniqueWords.get(i) + "\n");
			}
			myWriter.close();
			
		} catch (IOException e) {
			System.out.println("An error occurred.");
			e.printStackTrace();
		}
	}
}