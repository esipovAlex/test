package ru.service;

import ru.service.actions.*;
import ru.service.games.Game;
import ru.service.games.fizzbuzz.RefFool;
import ru.service.games.hangman.GameProcessHangman;
import ru.service.inout.*;
import ru.service.model.GameNames;
import ru.service.model.StoreAndGame;
import ru.service.store.MemStoreResult;
import ru.service.store.StoreResult;

import java.util.*;

public class StartUI {

    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    public void init(Input input, StoreAndGame storeAndGame, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, storeAndGame);
        }
    }

    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (int index = 0; index < actions.size(); index++) {
            out.println(index + ". " + actions.get(index).name());
        }
    }

    public static void main(String[] args) {
        String fileForHangman = "src/main/java/ru/service/files/dict.txt";
        Output output = new ConsoleOutput();
        Input input = new ValidateInput(output, new ConsoleInput());
        Map<GameNames, Game> gameMap = new EnumMap<>(GameNames.class);
        RefFool refFool = new RefFool();
        GameProcessHangman hangman = new GameProcessHangman(fileForHangman);
        gameMap.put(refFool.getName(), refFool);
        gameMap.put(hangman.getName(), hangman);
        try (StoreResult storeResult = new MemStoreResult()){
            storeResult.init();
            List<UserAction> actions = new ArrayList<>();
            actions.add(new GameHangman(output));
            actions.add(new GameFizzBuzz(output));
            actions.add(new ShowAllResults(output));
            actions.add(new ShowFastResult(output));
            actions.add(new ExitProgram(output));
            StoreAndGame storeAndGames = new StoreAndGame(storeResult, gameMap);
            new StartUI(output).init(input, storeAndGames, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
