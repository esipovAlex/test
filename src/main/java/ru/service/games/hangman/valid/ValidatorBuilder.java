package ru.service.games.hangman.valid;

public class ValidatorBuilder {
    private ValidCheck first;
    private ValidCheck last;

    public ValidatorBuilder addValidator(ValidCheck validator) {
        if (first == null) {
            first = validator;
        } else {
            last.setNext(validator);
        }
        last = validator;
        return this;
    }

    public ValidCheck build() {
        return first;
    }
}
