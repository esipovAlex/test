package ru.service.games.hangman.render;

import ru.service.games.hangman.messages.Message;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.lang.System.out;

public class Render implements Renderer {

    private final List<String> gallows;

    public Render() {
        this.gallows = emptyGallows();
    }

    @Override
    public void start( char[] showWord) {
        emptyGallows().forEach(out::println);
        out.println(Message.SHOW_WORD.getText() + String.valueOf(showWord));
    }

    @Override
    public void prepare(int errNumber) {
        gallows.set(replaceLineNumber(errNumber), ErrorState.values()[errNumber].getText());
    }

    @Override
    public void show(char[] showWord, int max, int errNumber) {
        gallows.forEach(out::println);
        out.println(Message.SHOW_WORD.getText() + String.valueOf(showWord));
        out.println(Message.TRY_OUT.getText() + (max - errNumber));
    }

    private List<String> emptyGallows() {
        return Stream.of(
                        " _____ ",
                        "     | ",
                        "     | ",
                        "     | ",
                        "     | ",
                        "-------")
                .collect(Collectors.toList());
    }

    private int replaceLineNumber(int errNumber) {
        return switch (errNumber) {
            case 0 -> 1;
            case 1, 2, 3 -> 2;
            case 4, 5 -> 3;
            default -> -1;
        };
    }
}
