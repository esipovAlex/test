package ru.service.games.hangman.valid;

import ru.service.games.hangman.exception.ValidationException;
import ru.service.games.hangman.messages.Message;

import java.util.List;

public abstract class ValidatorHandler implements ValidCheck{

    private ValidCheck next;

    @Override
    public void setNext(ValidCheck next) {
        this.next = next;
    }

    @Override
    public void validate(String input, List<String> useLetter) {
        if (!doValidate(input, useLetter)) {
            throw new ValidationException(getErrorMessage().getText());
        }
        if (next != null) {
            next.validate(input, useLetter);
        }
    }

    protected abstract boolean doValidate(String input, List<String> useLetter);

    protected abstract Message getErrorMessage();
}
