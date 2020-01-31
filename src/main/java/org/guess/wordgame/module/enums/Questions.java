package org.guess.wordgame.module.enums;

import java.util.Arrays;
import java.util.List;

public enum Questions {

    FIRST_QUESTION("Is first letter "),
    SECOND_QUESTION("Is second letter "),
    THIRD_QUESTION("Is third letter "),
    FOURTH_QUESTION("Is fourth letter "),
    FIFTH_QUESTION("Is fifth letter "),
    SIXTH_QUESTION("Is sixth letter "),
    SEVENTH_QUESTION("Is seventh letter "),
    EIGHTH_QUESTION("Is eighth letter "),
    NINTH_QUESTION("Is ninth letter ");

    public final String question;

    private Questions(String question) {
        this.question = question;
    }

    public static List<Questions> getAllQuestions() {

        Questions [] arrayOfQuestions = {FIRST_QUESTION, SECOND_QUESTION, THIRD_QUESTION, FOURTH_QUESTION,
                FIFTH_QUESTION, SIXTH_QUESTION, SEVENTH_QUESTION, EIGHTH_QUESTION, NINTH_QUESTION};

        return Arrays.asList(arrayOfQuestions);
    }

}

