package guess.word.pckg;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Guesser {

	private static WordLength newWord;

	private static int counter;
	
	private static int add;

	private static Scanner scans;

	private static String answer;

	private static ArrayList<Character> guessed = new ArrayList<Character>();

	public static void main(String args[]) throws IOException, InterruptedException {

	
			
		welcomeGame();
		playGame();

	}

	protected static void welcomeGame() {

		int word_len = 0;

		System.out.println("Let's play word gesser! How many characters your word has? * Only from 4 to 9");
		System.out.println("You have 3 chances to provide correct value!!!");

		scans = new Scanner(System.in);

		word_len = scans.nextInt();

		checkLength(word_len);

	}

	protected static void checkLength(int word) {

		counter++;

		if (counter == 3) {
			System.out.println("You provided bad length 3 times, try again.");
			System.exit(0);
		}

		if (word >= 4 && word <= 9) {
			newWord = new WordLength();
			newWord.setLength(word);
			System.out.println("You are good to go!!");

		} else {
			System.out.println("Bad! Try again!!");
			welcomeGame();

		}

	}

	protected static void playGame() {

		int word_length = newWord.getLength();

		switch (word_length) {
		case 4:
			write(1);
			firstQuestion();
			guessWord();

			break;
		case 5:
			write(1);
			firstQuestion();
			guessWord();
			break;
		case 6:
			write(1);
			firstQuestion();
			guessWord();
			break;
		case 7:
			write(1);
			firstQuestion();
			guessWord();
			break;
		case 8:
			write(1);
			firstQuestion();
			guessWord();
			break;
		case 9:
			write(1);
			firstQuestion();
			guessWord();
			break;

		}

	}

	protected static void firstQuestion() {

		char alpha_char = (char) randomLetter();
		System.out.println("|| Does first letter is " + alpha_char + "?");

		String ans = asker();

		if (ans.equals("yes")) {
			add++;
			System.out.print(alpha_char + " ");
			write(2);
			guessed.add(alpha_char);
		} else {
			firstQuestion();
		}

	}

	protected static void guessWord() {
		
		if(guessed.size() == newWord.getLength()) {
			System.out.println("|| I guessed your word, you can try again if you want!");
			System.exit(0);
		}


		char alpha_char = (char) randomLetter();
       

		System.out.println("|| Does next letter is " + alpha_char + "?");

		String ans = asker();
		

		if (ans.equals("show")) {

			for(int count = 0; count < guessed.size(); count++) {
			   System.out.println();
			   System.out.println(guessed.get(count)+ " ");
			   
		  }
			if(guessed.size() == 1) {
				write(2);
			}else if(guessed.size() == 2) {
				write(3);
			}else if(guessed.size() == 3) {
				
			}else if(guessed.size() == 4) {
				
			}
		}

		if (ans.equals("yes")) {
			
			add++;
			        
			newWord.setTimeOfGuesses(add);
			
			guessed.add(alpha_char);
			
			System.out.println(guessed.get(0));
			
			for (int count = 0; count < guessed.size(); count++) {
				System.out.print(guessed.get(count) + " ");
			}
	
			guessWord();

		} else {
			guessWord();

		}

	}

	// __________ USEFULL METHODS ________ //

	protected static String asker() {

		Scanner answers = new Scanner(System.in);

		answer = answers.nextLine();

		return answer;

	}

	protected static int randomLetter() {

		Random alphaRandom = new Random();

		int alpha = alphaRandom.nextInt(26) + (char) 'a';

		return (char) alpha;

	}

	protected static void write(int splice) {

		int length = newWord.getLength();

		for (int a = 0; a <= length - splice; a++) {
			System.out.print("_ ");
		}


	}

}
