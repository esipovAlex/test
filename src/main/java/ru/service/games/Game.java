package ru.service.games;

import ru.service.model.GameNames;
import ru.service.model.Result;
import ru.service.store.StoreResult;

public interface Game {
    GameNames getName();
    void init(StoreResult storeResult);
    Result startGame();
    Result endGame();
}
