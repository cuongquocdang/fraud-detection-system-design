package com.example.utilities;

import java.util.function.Function;

public class RequestChain<T> {

    private final T input;

    private RequestChain(T input) {
        this.input = input;
    }

    public static <T> RequestChain<T> of(T input) {
        return new RequestChain<>(input);
    }

    public <R> RequestChain<R> thenApply(Function<T, R> function) {
        return new RequestChain<>(function.apply(input));
    }

    public T getResult() {
        return input;
    }
}
