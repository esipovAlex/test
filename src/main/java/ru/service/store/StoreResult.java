package ru.service.store;

import ru.service.model.Result;

import java.util.List;

public interface StoreResult extends AutoCloseable {
    void init();
    Result add(Result result);

    Result getFast();
    Result getLastResult();
    List<Result> getAllResults();
}
