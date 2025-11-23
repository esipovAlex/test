package ru.service.games.hangman.input;

import ru.service.games.hangman.valid.Validator;
import ru.service.games.hangman.messages.Message;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class Input implements InputLetter {

    private final List<Character> usedLetter;

    public Input() {
        usedLetter = new LinkedList<>();
    }

    @Override
    public Character getLetter(Validator validator) {
        out.println(Message.USED_LETTERS.getText() + usedLetter);
        boolean notValid = true;
        String input = "";
        Scanner scanner = new Scanner(System.in);
        while (notValid) {
            out.print(Message.INPUT_LETTER.getText());
            input = scanner.nextLine().trim();
            notValid = !validator.valid(input, usedLetter);
        }
        Character letter = input.charAt(0);
        usedLetter.add(letter);
        return letter;
    }
}
