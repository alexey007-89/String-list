package ru.skypro.exceptions;

public class InputNullException extends NullPointerException {
    public InputNullException() {
    }

    public InputNullException(String s) {
        super(s);
    }
}
