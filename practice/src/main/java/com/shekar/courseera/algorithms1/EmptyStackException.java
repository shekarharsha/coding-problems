package com.shekar.courseera.algorithms1;

import lombok.Getter;

public class EmptyStackException extends Throwable {

    @Getter
    private String message;

    public EmptyStackException(String message) {
        this.message = message;
    }
}
