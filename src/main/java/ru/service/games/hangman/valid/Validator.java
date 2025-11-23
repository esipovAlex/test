package ru.service.games.hangman.valid;

import ru.service.games.hangman.exception.ValidationException;

import java.util.List;

import static java.lang.System.out;

public class Validator {
    private final ValidCheck validationHandler;

    public Validator() {
        this.validationHandler = new ValidatorBuilder()
                .addValidator(new EmptyCheck())
                .addValidator(new LengthCheck())
                .addValidator(new CyrillicCheck())
                .addValidator(new DuplicateCheck())
                .build();
    }

    public boolean valid(String letter, List<Character> useLetter) {
        try {
            validationHandler.validate(letter, useLetter);
        } catch (ValidationException e) {
            out.println(e.getMessage());
            return false;
        }
        return true;
    }
}
