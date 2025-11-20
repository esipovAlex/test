package ru.service.games.hangman.render;

public interface Renderer {

    void start(char[] word);

    void prepare(int errNumber);

    void show(char[] showWord, int max, int errNumber);
}
