package ru.skypro.exceptions;

public class IndexOutOfBoundsException extends ArrayIndexOutOfBoundsException {
    public IndexOutOfBoundsException() {
    }

    public IndexOutOfBoundsException(String s) {
        super(s);
    }

    public IndexOutOfBoundsException(int index) {
        super(index);
    }
}
