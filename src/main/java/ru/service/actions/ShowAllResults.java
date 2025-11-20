package ru.service.actions;

import ru.service.inout.Input;
import ru.service.inout.Output;
import ru.service.model.Result;
import ru.service.model.StoreAndGame;
import ru.service.store.StoreResult;

import java.util.List;

public class ShowAllResults implements UserAction{

    private final Output out;

    public ShowAllResults(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show All Results ===";
    }

    @Override
    public boolean execute(Input input, StoreAndGame storeAndGame) {
        StoreResult storeResult = storeAndGame.getStoreResult();
        List<Result> allResults = storeResult.getAllResults();
        allResults.forEach(out::println);
        return true;
    }
}
