package ru.service.actions;

import ru.service.inout.Input;
import ru.service.inout.Output;
import ru.service.model.StoreAndGame;

public class ExitProgram implements UserAction {

    private final Output out;

    public ExitProgram(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Exit Program ===";
    }

    @Override
    public boolean execute(Input input, StoreAndGame games) {
        return false;
    }
}
