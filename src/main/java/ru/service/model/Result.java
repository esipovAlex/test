package ru.service.model;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Result {
    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");
    private int id;
    private String name;
    private GameResult gameResult;
    private LocalDateTime created = LocalDateTime.now();
    private LocalDateTime finished = LocalDateTime.now();
    private Long duration;

    public Result() {
    }

    public Result(String name, GameResult gameResult, LocalDateTime created, LocalDateTime finished) {
        this.name = name;
        this.gameResult = gameResult;
        this.finished = finished;
        this.created = created;
        this.duration = Duration.between(created, finished).toSeconds();
    }

    public LocalDateTime getFinished() {
        return finished;
    }

    public Result setFinished(LocalDateTime finished) {
        this.finished = finished;
        this.duration = Duration.between(created, finished).toSeconds();
        return this;
    }

    public Result setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Result setName(String name) {
        this.name = name;
        return this;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Result setGameResult(GameResult gameResult) {
        this.gameResult = gameResult;
        return this;
    }

    public Long getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return String.format("id: %s, game: %s, result: %s, duration(seconds): %d, start: %s, finished: %s",
                id, name, gameResult.name(), duration, FORMATTER.format(created), FORMATTER.format(finished));
    }
}
