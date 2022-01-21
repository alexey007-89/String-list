package ru.skypro.exceptions;

public class ElementDoNotExistException extends RuntimeException {
    public ElementDoNotExistException() {
    }

    public ElementDoNotExistException(String message) {
        super(message);
    }

    public ElementDoNotExistException(String message, Throwable cause) {
        super(message, cause);
    }

    public ElementDoNotExistException(Throwable cause) {
        super(cause);
    }

    public ElementDoNotExistException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
