package com.fstg.mediatech.exception;

public class EntityAlreadyExistsException extends Exception{

    public EntityAlreadyExistsException() {
    }

    public EntityAlreadyExistsException(String message) {
        super(message);
    }
}
