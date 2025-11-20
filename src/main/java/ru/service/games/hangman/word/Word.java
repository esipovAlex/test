package ru.service.games.hangman.word;

import java.util.Set;

public interface Word {

    String getInitWord();
    char[] showWord();
    char[] createShowWord(char[] showWord, String letter);
    Set<String> setStr();


}
