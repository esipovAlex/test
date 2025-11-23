package ru.service.games.hangman.valid;

import ru.service.games.hangman.messages.Message;

import java.util.List;
import java.util.regex.Pattern;

public class CyrillicCheck extends ValidatorHandler {

    private final Pattern pattern = Pattern.compile("^[а-яё]+$");

    @Override
    protected boolean doValidate(String input, List<Character> useLetter) {
        return pattern.matcher(input).matches();
    }

    @Override
    protected Message getErrorMessage() {
        return Message.ONLY_CYRILLIC;
    }
}
