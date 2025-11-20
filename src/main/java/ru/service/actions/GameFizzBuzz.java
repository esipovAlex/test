package ru.service.actions;

import ru.service.games.Game;
import ru.service.inout.Input;
import ru.service.inout.Output;
import ru.service.model.GameNames;
import ru.service.model.StoreAndGame;
import ru.service.store.StoreResult;

public class GameFizzBuzz implements UserAction {
    private final Output output;

    public GameFizzBuzz(Output output) {
        this.output = output;
    }

    @Override
    public String name() {
        return "=== Game FizzBuzz ===";
    }

    @Override
    public boolean execute(Input input, StoreAndGame games) {
        StoreResult storeResult = games.getStoreResult();
        Game game = games.getGame(GameNames.FIZZBUZZ);
        game.init(storeResult);
        game.startGame();
        return true;
    }
}
