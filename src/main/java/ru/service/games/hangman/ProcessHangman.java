package ru.service.games.hangman;

import ru.service.games.Game;
import ru.service.games.hangman.valid.Validator;
import ru.service.games.hangman.input.Input;
import ru.service.games.hangman.input.InputLetter;
import ru.service.games.hangman.messages.Message;
import ru.service.games.hangman.render.Render;
import ru.service.games.hangman.render.Renderer;
import ru.service.games.hangman.word.StoreWord;
import ru.service.games.hangman.word.Word;
import ru.service.games.hangman.word.WordImpl;
import ru.service.model.GameNames;
import ru.service.model.GameResult;
import ru.service.model.Result;
import ru.service.store.StoreResult;

import java.time.LocalDateTime;
import java.util.Scanner;
import java.util.Set;

import static java.lang.System.out;


public class ProcessHangman implements Game {

    private static final int MAX_ATTEMPT = 6;
    private final String path;
    private StoreResult storeResult;
    private int totalLines;

    public ProcessHangman(String path) {
        this.path = path;
    }

    @Override
    public Result startGame()  {
        Result result = new Result();
        Word wordI = new WordImpl(path, totalLines);
        String word = wordI.getInitWord();
        char[] showWord = wordI.showWord();
        Set<String> setStr = wordI.setStr();
        String letter;
        int errNumber = 0;
        Renderer renderer = new Render();
        renderer.start(showWord);
        Scanner scanner = new Scanner(System.in);
        Validator validator = new Validator();
        InputLetter inputLetter = new Input();
        while (!setStr.isEmpty() && errNumber < MAX_ATTEMPT) {
            letter = inputLetter.getLetter(scanner, validator);
            if (!setStr.remove(letter)) {
                renderer.prepare(errNumber++);
            }
            showWord = wordI.createShowWord(showWord, letter);
            renderer.show(showWord, MAX_ATTEMPT, errNumber);
        }
        printResultGame(errNumber == MAX_ATTEMPT ? Message.NEGATIVE_RESULT.getText() : Message.POSITIVE_RESULT.getText(),
                        word,
                        showWord);
        result.setName(getName().getText())
              .setGameResult(errNumber == MAX_ATTEMPT ? GameResult.LOOSER : GameResult.WINNER)
              .setFinished(LocalDateTime.now());
        storeResult.add(result);
        return result;
    }

    private void printResultGame(String result, String word, char[] initCh) {
        out.println(result);
        out.println(Message.SOURCE_WORD.getText() + word);
        out.println(Message.YOUR_INPUT.getText() + String.valueOf(initCh));
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
