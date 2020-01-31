package org.guess.wordgame.module;

public class MainRunner {

    public static void main(String[] args) throws InterruptedException {
        GuesserModule guesserModule = new GuesserModule();
        ValidationModule validationModule = new ValidationModule(guesserModule.getWord());

        new Thread(guesserModule).start();
        new Thread(validationModule).start();

    }
}
