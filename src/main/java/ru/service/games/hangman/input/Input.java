package ru.service.games.hangman.input;

import ru.service.games.hangman.valid.Validator;
import ru.service.games.hangman.messages.Message;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Input implements InputLetter {

    private final List<String> useLetter;

    public Input() {
        useLetter = new LinkedList<>();
    }

    @Override
    public String getLetter(Scanner scanner, Validator validator) {
        out.println("использованные буквы: " + useLetter);
        boolean notValid = true;
        String letter = "";
        while (notValid) {
            out.print(Message.INPUT_LETTER.getText());
            letter = scanner.nextLine().trim();
            notValid = !validator.valid(letter, useLetter);
        }
        useLetter.add(letter);
        return letter;
    }
}
