package ru.service.actions;

import ru.service.games.Game;
import ru.service.store.StoreResult;
import ru.service.inout.Input;
import ru.service.inout.Output;
import ru.service.model.GameNames;
import ru.service.model.StoreAndGame;

public class GameHangman implements UserAction {
    private final Output output;
    public GameHangman(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "=== Game Hangman ===";
    }

    @Override
    public boolean execute(Input input, StoreAndGame games) {
        StoreResult storeResult = games.getStoreResult();
        Game game = games.getGame(GameNames.HANGMAN);
        game.init(storeResult);
        game.startGame();

        return true;
    }

}
