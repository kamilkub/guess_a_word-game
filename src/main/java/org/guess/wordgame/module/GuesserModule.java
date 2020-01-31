package org.guess.wordgame.module;


import org.guess.wordgame.module.enums.Questions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.HashMap;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class GuesserModule implements Runnable {

    private static Logger logger = LoggerFactory.getLogger(GuesserModule.class);

    private static List<Questions> questionsArrayList = Questions.getAllQuestions();

    static HashMap<Integer, Character> word = new HashMap<>();

    private static WordLength wordLength = new WordLength();

    private static int randomQuestionCounter = 0;

    private static int letterCounter = randomQuestionCounter;

    public GuesserModule () {
        word.put(1, '_');
    }


    public static void buildUpWord() {
        Scanner scanner = new Scanner(System.in);
        logger.warn("How many letters your word has? Be specific * only 4 - 9 are available");
        int wordSize = scanner.nextInt();

        if(wordSize < 4 || wordSize > 9){
            logger.error("Bad number of letters try again!");
            buildUpWord();
        }

        wordLength.setLength(wordSize);

        for(int i = 0; i < wordLength.getLength(); i++) {
            word.put(i, '_');
        }
        word.forEach((key, a) -> System.out.print(" "+a));
        System.out.println();
    }

    public static void askerMethod() {
        Scanner scanner = new Scanner(System.in);
        char askedLetter = (char) randomLetter();

        System.out.println(getRandomQuestion()+askedLetter+"?");
        String answer = scanner.nextLine();

        if(answer.equals("y")){
            word.forEach((key, value) -> {
                word.replace(letterCounter, askedLetter);
             });
             printOutWord();
             letterCounter++;
             askerMethod();
        } else if(answer.equals("n")) {
            askerMethod();
        }
    }

    public static void printOutWord() {
        word.forEach((key, value) -> System.out.print(" "+value));
        System.out.println();
    }

    protected static String getRandomQuestion() {
        randomQuestionCounter = (int) Math.floor(Math.random()*wordLength.getLength());
        letterCounter = randomQuestionCounter;
        return questionsArrayList.get(randomQuestionCounter).question;
    }

    protected static int randomLetter() {
        Random alphaRandom = new Random();
        int alpha = alphaRandom.nextInt(26) + (char) 'a';

        return (char) alpha;
    }

    protected HashMap<Integer, Character> getWord() {
        return word;
    }

    @Override
    public void run() {
        buildUpWord();
        askerMethod();
    }
}
