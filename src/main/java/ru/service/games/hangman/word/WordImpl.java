package ru.service.games.hangman.word;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class WordImpl implements Word {

    private final String word;

    public WordImpl(String path, int totalLines) {
        this.word = StoreWord.getRandomLine(path, totalLines);
    }

    @Override
    public String getInitWord() {
        return word;
    }

    @Override
    public char[] showWord() {
        char[] result = new char[word.length()];
        Arrays.fill(result, '-');
        return result;
    }

    @Override
    public char[] createShowWord(char[] showWord, Character letter) {
        char[] chars = word.toCharArray();
        char input = letter;
        int length = chars.length;
        char[] resultCharArray = new char[length];
        for (int i = 0; i < length; i++) {
            resultCharArray[i] = (input == chars[i] || chars[i] == showWord[i])
                    ? chars[i]
                    : '-';
        }
        return resultCharArray;
    }

    @Override
    public Set<Character> setStr() {
        return word.chars()
                .mapToObj(c -> (char) c)
//                .map(Objects::toString)
                .collect(Collectors.toSet());
    }
}
