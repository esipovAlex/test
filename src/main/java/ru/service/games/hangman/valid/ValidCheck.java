package ru.service.games.hangman.valid;

import java.util.List;

public interface ValidCheck {

    void setNext(ValidCheck next);

    void validate(String input, List<Character> useLetter);
}
