package ru.service.store;

import ru.service.model.Result;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MemStoreResult implements StoreResult {
    private final List<Result> list = new ArrayList<>();
    private int ids = 1;

    @Override
    public void init() {

    }

    @Override
    public Result add(Result result) {
        result.setId(ids++);
        list.add(result);
        return result;
    }

    @Override
    public Result getFast() {
        return list.stream().min(Comparator.comparingLong(Result::getDuration)).orElse(new Result());
    }

    @Override
    public Result getLastResult() {

        return ids == 1 ? new Result() : list.get(ids - 1);
    }

    @Override
    public List<Result> getAllResults() {
        return list;
    }

    @Override
    public void close() throws Exception {

    }
}
