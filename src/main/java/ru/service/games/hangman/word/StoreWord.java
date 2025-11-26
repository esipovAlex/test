package ru.service.games.hangman.word;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Stream;

public class StoreWord {

    private static final Random RANDOM = new Random();

    private StoreWord() {
    }

    public static long countLinesWithStream(String fileName) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            return stream.count();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return 0;
    }

    private static Optional<String> getLineByNumber(String fileName, long number) {
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            long n = number - 1L;
            if (n <= 0) {
                return stream.findFirst();
            }
            return stream.skip(n).findFirst();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Optional.empty();
    }

    public static String getRandomLine(String fileName, int total) {
        int nextInt = RANDOM.nextInt(0, total);
        return getLineByNumber(fileName, nextInt).orElse("");
    }
}
