package ru.service.model;

import ru.service.games.Game;
import ru.service.store.StoreResult;

import java.util.Map;

public class StoreAndGame {
    private final StoreResult storeResult;
    private final Map<GameNames,Game> gameMap;

    public StoreAndGame(StoreResult storeResult, Map<GameNames,Game> gameMap) {
        this.storeResult = storeResult;
        this.gameMap = gameMap;
    }

    public StoreResult getStoreResult() {
        return storeResult;
    }

    public Game getGame(GameNames name) {
        return gameMap.get(name);
    }
}
