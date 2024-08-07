package com.amberj.common;

import java.util.function.Consumer;


public class Either<R, E> {
    private final R data;
    private final E error;

    private Either(R data, E error) {
        this.data = data;
        this.error = error;
    }

    public static <R, E> Either<R, E> ofData(R data) {
        return new Either<>(data, null);
    }

    public static <R, E> Either<R, E> ofError(E error) {
        return new Either<>(null, error);
    }

    public boolean isData() {
        return data != null;
    }

    public boolean isError() {
        return error != null;
    }

    public void get(Consumer<R> responseConsumer, Consumer<E> errorConsumer) {
        if (isData()) {
            responseConsumer.accept(data);
        } else if (isError()) {
            errorConsumer.accept(error);
        }
    }
}