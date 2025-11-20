package ru.service.model;

public enum GameNames {
    HANGMAN("HangMan"),
    FIZZBUZZ("FizzBuzz");
    private final String text;
    GameNames(String text) {
        this.text = text;
    }
    public String getText() {
        return text;
    }
}
