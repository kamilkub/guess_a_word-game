package guess.the.word;

import java.util.Random;
import java.util.Scanner;

public class Guesser {
      
	public static void main(String args []) {
		
		System.out.println("Let's play word gesser! How many characters your word has? * Only from 4 to 9");
		
		Scanner scan_word = new Scanner(System.in);
		
		int word = scan_word.nextInt();
		
		wordChecker(word);	
		
		wordSpaces(word);
		
		guessLetter(word);
		
	}
	
	public static void wordChecker(int word) {
		
	    if(word >= 4 && word <= 9) {
	    	System.out.println("Okay you are good to go!");
	    	System.out.println("");
	    }else {
	    	System.out.println("Your word does not match. Try again!");
	    	System.exit(0);
	    }
		
	}
	
	public static void wordSpaces(int word) {
		
		System.out.println("So.. Your word has "+Integer.valueOf(word));
		
		for(int i = 0; i <= word-1;i++) {
			System.out.print("_ ");
		}
		
	}
	
	public static void guessLetter(int word) {
		
		boolean guessed = false;
		
		Random rand = new Random(); int numb = rand.nextInt(27);
		
		String counts [] = {"Is first","Is second", "Is third", "Is fourth", "Is fifth", "Is sixth", "Is seventh","Is eighth","Is ninth","Is tenth"};
		
		char[] letters = {
		'a','b','c','d','e','f','g','h',
		'i','j','k','l','m','n','o','u','q',
		'p','r','s','t','u','v','w','x','y','z'
		};
		
		System.out.println(" ");
		System.out.println("\n"+counts[0]+" letter is "+letters[numb]+"? Write yes or no");
		
		char a = letters[numb];
		
		Scanner decision = new Scanner(System.in);
		
		String yrn = decision.nextLine();
		
		yrn = yrn.toLowerCase();
		
		
		if(yrn.equals("yes")) {
			 guessed = true;
			 System.out.print(a+" ");
			 for(int i = 0; i <= word-2;i++) {
				 System.out.print("_ ");
			 }
			 int numb_two = rand.nextInt(27);
			 System.out.println(counts[1]+" one "+letters[numb_two]+"?");
			 char b = letters[numb_two];
			 yrn = decision.nextLine();
			 if(yrn.equals("yes")) {
				 guessed = true;
				 System.out.print(a+" "+b+" ");
				 for(int i = 0; i <= word-3;i++) {
					 System.out.print("_ ");
				 }
			 }
			 
		}else if(yrn.equals("no")) {
			guessed = false;
			
			System.out.println("Is it "+letters[numb]+"?");
			yrn = decision.nextLine();
			
		}else {
			System.out.println("That's not how we gonna play!");
			System.exit(0);
		}
		
		/*
		switch(word) {
		case 4:
			  int plus = 1;
			  for(int i = 0; i <= word;i++) {
				  
				  System.out.println(counts[i]+" letter is "+letters[numb]+"? Write yes or no");
				  yrn = decision.nextLine();
				  if(yrn.equals("yes")) {
						 guessed = true;
						 System.out.print(a+" ");
						 for(int s = 0; s <= word-2;s++) {
							 System.out.print("_ ");
						 }
				  
				  
			  }
			  }
			break;
		case 5:
			for(int i = 0; i <= word;i++) {
				  System.out.println(counts[i]+" letter is "+letters[numb]+"? Write yes or no");
			  }
			break;
		case 6:
			for(int i = 0; i <= word;i++) {
				  System.out.println(counts[i]+" letter is "+letters[numb]+"? Write yes or no");
			  }
			break;
		case 7:
			for(int i = 0; i <= word;i++) {
				  System.out.println(counts[i]+" letter is "+letters[numb]+"? Write yes or no");
			  }
			break;
		case 8:
			for(int i = 0; i <= word;i++) {
				  System.out.println(counts[i]+" letter is "+letters[numb]+"? Write yes or no");
			  }
			break;
		case 9:
			for(int i = 0; i <= word;i++) {
				  System.out.println(counts[i]+" letter is "+letters[numb]+"? Write yes or no");
			  }
			break;
		 
		}
		*/
		
		
		
	}
	

	
	
	
}
