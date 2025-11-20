package ru.service.games.hangman.valid;

import ru.service.games.hangman.messages.Message;

import java.util.List;
import java.util.function.Predicate;

public class EmptyCheck extends ValidatorHandler {

    @Override
    protected boolean doValidate(String input, List<String> useLetter) {
        Predicate<String> check = String::isEmpty;
        return check.negate().test(input);
    }

    @Override
    protected Message getErrorMessage() {
        return Message.INPUT_ONLY_SPACES;
    }
}
