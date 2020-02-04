package org.guess.wordgame.module;

import java.util.HashMap;

public class ValidationModule implements Runnable {

    private HashMap<Integer, Character> hashMap;

    public ValidationModule(HashMap<Integer, Character> hashMap){
        this.hashMap = hashMap;
    }


    public static void isWordGuessed(HashMap<Integer, Character> hashMap) {
        long currentMilis = System.currentTimeMillis();

        while(true) {
            if(hashMap.containsValue('_'))
                continue;
            else
                System.out.println("Your word has been guessed. Try again!");
                System.out.println("I have guessed your word in " + (System.currentTimeMillis() - currentMilis) + " milliseconds");
                System.exit(0);
        }
    }

    @Override
    public void run() {
        isWordGuessed(hashMap);
    }
}
