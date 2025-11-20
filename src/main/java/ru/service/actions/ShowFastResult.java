package ru.service.actions;

import ru.service.inout.Input;
import ru.service.inout.Output;
import ru.service.model.StoreAndGame;
import ru.service.store.StoreResult;

public class ShowFastResult implements UserAction {

    private final Output out;

    public ShowFastResult(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show Fast Result ===";
    }

    @Override
    public boolean execute(Input input, StoreAndGame storeAndGame) {
        StoreResult storeResult = storeAndGame.getStoreResult();
        if (!storeResult.getAllResults().isEmpty()) {
            out.println(storeResult.getFast().toString());
        }
        return true;
    }
}
