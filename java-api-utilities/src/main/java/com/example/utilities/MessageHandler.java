package com.example.utilities;

public interface MessageHandler<T> {

    void handle(T request);
}