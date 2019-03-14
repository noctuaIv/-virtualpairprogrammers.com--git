import java.io.Console;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.LinkedList;

class Game {

	public static void printHelp() {
		System.out.println("Guess the capital city");
		System.out.println("type 'EXIT' to stop the game, or 'HELP' to display this text.");
	}


	public static void main(String[] args) {

		Console console = System.console();

		int total = 0;
		int correct = 0;
		Random r = new Random();
		LinkedList<String> questions = new LinkedList<String>();
		try (BufferedReader br = new BufferedReader(new FileReader("capitals.csv"));) {
			
			String line;
			while ((line = br.readLine()) != null) {
				questions.add(line);
				}
			}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

				
		while (!questions.isEmpty()) {
			String line = questions.remove(0);
			String[] cols = line.split(",");
			String country = cols[0];
			String capital = cols[1];
			String answer = null;				
			do {
				answer = console.readLine("What is the capital of " + country + "? ");
				if (answer.equalsIgnoreCase("help")) {
					printHelp();
				}
			}
			while (answer.equalsIgnoreCase("help"));
			if (answer.equalsIgnoreCase("exit")) {
				break;
			}
			if (answer.equalsIgnoreCase(capital)) {
				switch (r.nextInt() % 3) {
					case 0:
						System.out.println("Well done!");
						break;
					case 1:
						System.out.println("That's right!");
						break;
					default:
						System.out.println("Correct!");
						break;
					}
					
				correct++;
			}
			else {
				System.out.println("No, the answer is " + capital);	
			}
			total++;
		}
	System.out.println("You scored " + correct + " out of " + total);
	}
}