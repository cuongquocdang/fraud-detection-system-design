package com.example.utilities;

public interface RequestHandler<T, U> {

    U handle(T request);
}