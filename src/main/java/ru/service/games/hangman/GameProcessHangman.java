package ru.service.games.hangman;

import ru.service.games.Game;
import ru.service.games.hangman.input.Input;
import ru.service.games.hangman.input.InputLetter;
import ru.service.games.hangman.messages.Message;
import ru.service.games.hangman.render.Render;
import ru.service.games.hangman.render.Renderer;
import ru.service.games.hangman.valid.Validator;
import ru.service.games.hangman.word.StoreWord;
import ru.service.games.hangman.word.Word;
import ru.service.games.hangman.word.WordImpl;
import ru.service.model.GameNames;
import ru.service.model.GameResult;
import ru.service.model.Result;
import ru.service.store.StoreResult;

import java.time.LocalDateTime;
import java.util.Set;

public class GameProcessHangman implements Game {

    private static final int MAX_ATTEMPT = 6;
    private final String path;
    private int totalLines;
    private StoreResult storeResult;

    public GameProcessHangman(String path) {
        this.path = path;
    }

    @Override
    public Result startGame()  {
        LocalDateTime startTime = LocalDateTime.now();
        Word wordI = new WordImpl(path, totalLines);
        String word = wordI.getInitWord();
        char[] showWord = wordI.showWord();
        Set<Character> letters = wordI.setStr();
        int errNumber = 0;
        Renderer renderer = new Render();
        renderer.start(showWord);
        Validator validator = new Validator();
        InputLetter inputLetter = new Input();
        while (!letters.isEmpty() && errNumber < MAX_ATTEMPT) {
            Character letter = inputLetter.getLetter(validator);
            if (!letters.remove(letter)) {
                renderer.prepare(errNumber++);
            }
            showWord = wordI.createShowWord(showWord, letter);
            renderer.show(showWord, MAX_ATTEMPT - errNumber);
        }
        renderer.result(errNumber == MAX_ATTEMPT ? Message.NEGATIVE_RESULT.getText() : Message.POSITIVE_RESULT.getText(),
                        word,
                        showWord);
        Result result = new Result(
                getName().getText(),
                errNumber == MAX_ATTEMPT ? GameResult.LOOSER : GameResult.WINNER,
                startTime,
                LocalDateTime.now()
        );
        storeResult.add(result);
        return result;
    }

    @Override
    public GameNames getName() {
        return GameNames.HANGMAN;
    }

    @Override
    public void init(StoreResult storeResult) {
        this.storeResult = storeResult;
        this.totalLines = (int) StoreWord.countLinesWithStream(path);
    }

    @Override
    public Result endGame() {
        return null;
    }
}
