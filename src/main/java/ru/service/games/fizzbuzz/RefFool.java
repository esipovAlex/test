package ru.service.games.fizzbuzz;

import ru.service.games.Game;
import ru.service.model.GameNames;
import ru.service.model.GameResult;
import ru.service.model.Result;
import ru.service.store.StoreResult;

import java.time.LocalDateTime;
import java.util.Scanner;

public class RefFool implements Game {

    private StoreResult storeResult;

    @Override
    public GameNames getName() {
        return GameNames.FIZZBUZZ;
    }

    @Override
    public void init(StoreResult storeResult) {
        this.storeResult = storeResult;
    }

    @Override
    public Result endGame() {
        return null;
    }

    static class Answer {
        private int number;

        public Answer(int num) {
            this.number = num;
        }

        public String label() {
            String result = String.valueOf(number);
            if (number % 3 == 0 && number % 5 == 0) {
                result = "FizzBuzz";
            } else if (number % 3 == 0) {
                result = "Fizz";
            } else if (number % 5 == 0) {
                result = "Buzz";
            }
            return result;
        }
    }


    @Override
    public Result startGame() {
        Result result = new Result();
        result.setName(getName().getText());
        System.out.println("Игра FizzBuzz.");
        var startAt = 1;
        var io = new Scanner(System.in);
        while (startAt < 100) {
            System.out.println(new Answer(startAt++).label());
            if (!io.nextLine().equals(new Answer(startAt).label())) {
                System.out.println("Ошибка");
                break;
            }
            startAt++;
        }
        result.setGameResult(startAt < 100
                ? GameResult.LOOSER
                : GameResult.WINNER);
        result.setFinished(LocalDateTime.now());
        storeResult.add(result);
        return result;
    }
}



