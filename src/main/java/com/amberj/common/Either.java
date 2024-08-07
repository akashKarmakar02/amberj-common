package com.amberj.common;

import java.util.function.Consumer;


public class Either<R, E> {
    private final R response;
    private final E error;

    private Either(R response, E error) {
        this.response = response;
        this.error = error;
    }

    public static <R, E> Either<R, E> ofResponse(R response) {
        return new Either<>(response, null);
    }

    public static <R, E> Either<R, E> ofError(E error) {
        return new Either<>(null, error);
    }

    public boolean isResponse() {
        return response != null;
    }

    public boolean isError() {
        return error != null;
    }

    public void get(Consumer<R> responseConsumer, Consumer<E> errorConsumer) {
        if (isResponse()) {
            responseConsumer.accept(response);
        } else if (isError()) {
            errorConsumer.accept(error);
        }
    }
}