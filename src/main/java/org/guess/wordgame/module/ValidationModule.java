package org.guess.wordgame.module;

import java.util.HashMap;

public class ValidationModule implements Runnable {

    private HashMap<Integer, Character> hashMap;

    public ValidationModule(HashMap<Integer, Character> hashMap){
        this.hashMap = hashMap;
    }


    public static void isWordGuessed(HashMap<Integer, Character> hashMap) {
        while(true) {
            if(hashMap.containsValue('_'))
                continue;
            else
                System.out.println("Your word has been guessed. Try again!");
                System.exit(0);
        }
    }

    @Override
    public void run() {
        isWordGuessed(hashMap);
    }
}
