package org.guess.wordgame.module;

public class MainRunner {

    public static void main(String[] args) throws InterruptedException {

        long currentMilis = System.currentTimeMillis();

        GuesserModule guesserModule = new GuesserModule();
        ValidationModule validationModule = new ValidationModule(guesserModule.getWord());

        new Thread(guesserModule).start();
        new Thread(validationModule).start();

        System.out.println("I have guessed your word in " + (System.currentTimeMillis() - currentMilis));

    }
}
