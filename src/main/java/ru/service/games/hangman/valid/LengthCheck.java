package ru.service.games.hangman.valid;

import ru.service.games.hangman.messages.Message;

import java.util.List;
import java.util.function.Predicate;

public class LengthCheck extends ValidatorHandler {

    @Override
    protected boolean doValidate(String input, List<Character> useLetter) {
        Predicate<String> check = line -> line.length() == 1;
        return check.test(input);
    }

    @Override
    protected Message getErrorMessage() {
        return Message.ONLY_ONE_LETTER;
    }
}
