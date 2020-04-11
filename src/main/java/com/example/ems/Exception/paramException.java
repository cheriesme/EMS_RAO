package com.example.ems.Exception;

public class paramException extends RuntimeException{
    public paramException() {
        super();
    }

    public paramException(String message) {
        super(message);
    }

    public paramException(String message, Throwable cause) {
        super(message, cause);
    }

    public paramException(Throwable cause) {
        super(cause);
    }

    protected paramException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
