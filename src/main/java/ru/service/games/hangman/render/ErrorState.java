package ru.service.games.hangman.render;

public enum ErrorState {

    ERR_0(" 0   | "),
    ERR_1("/    | "),
    ERR_2("/|   | "),
    ERR_3("/|\\  | "),
    ERR_4("/    | "),
    ERR_5("/ \\  | ");

    private final String text;

    ErrorState(String representation) {
        this.text = representation;
    }

    public String getText() {
        return text;
    }
}
