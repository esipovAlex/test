package ru.service.games.hangman.word;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;
import java.util.Objects;
import java.util.Random;

public class StoreWord {

    private static final Random RANDOM = new Random();

    private StoreWord() {
    }

    public static long countLinesWithStream(String path) {
        try (InputStream inputStream = StoreWord.class.getResourceAsStream(path)) {
            if (inputStream == null) {
                System.err.println("Файл не найден в classpath: " + path);
                return 0;
            }
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(inputStream, StandardCharsets.UTF_8))) {
                return reader.lines().count();
            }
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
    }

    public static String getRandomLine(String fileName, int total) {
        int nextInt = RANDOM.nextInt(0, total);
        String line = "";
            long count = 0L;
            try (BufferedReader reader = new BufferedReader(
                    new InputStreamReader(
                            Objects.requireNonNull(
                                    StoreWord.class.getResourceAsStream(fileName)),
                            StandardCharsets.UTF_8))) {
                while ((line = reader.readLine()) != null) {
                    if (count == nextInt) {
                        break;
                    }
                    count++;
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return line;
    }
}
