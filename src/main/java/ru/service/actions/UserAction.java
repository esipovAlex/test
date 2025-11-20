package ru.service.actions;

import ru.service.inout.Input;
import ru.service.model.StoreAndGame;

public interface UserAction {
    String name();
    boolean execute(Input input, StoreAndGame storeAndGame);
}
