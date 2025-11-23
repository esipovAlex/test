package ru.service.games.hangman.messages;

public enum Message {
    GREETING("Введите слово: "),
    POSITIVE_RESULT("Вы выиграли"),
    NEGATIVE_RESULT("Вы повешены"),
    SHOW_WORD("Слово : "),
    SOURCE_WORD("Исходное слово : "),
    INPUT_LETTER("Введите букву : "),
    YOUR_INPUT("Ваш вариант : "),
    TRY_OUT("Количество оставшихся неудачных попыток : "),
    MORE_ONE_LETTER("Введенное слово содержит больше 1 символа."),
    ONLY_ONE_LETTER("Введенное слово должно содержать только 1 символ."),
    INPUT_ONLY_SPACES("Введенное слово содержит только одни пробелы."),
    INPUT_DUPLICATE("Буква уже была использована."),
    ONLY_CYRILLIC("Допускаются только русские буквы в нижнем регистре."),
    USED_LETTERS("Использованные буквы: ");
    private final String text;
    Message(String text) { this.text = text; }

    public String getText() {
        return text;
    }
}
