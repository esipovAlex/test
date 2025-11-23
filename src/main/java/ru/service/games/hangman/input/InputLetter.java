package ru.service.games.hangman.input;

import ru.service.games.hangman.valid.Validator;

import java.util.Scanner;

public interface InputLetter {

    Character getLetter(Validator validator);
}
