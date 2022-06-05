package ru.gb.alekseev.exceptions;

public class MyArrayDataException extends RuntimeException {
    public MyArrayDataException(int i, int j, Exception exception) {
        super(String.format("Error in [%d, %d]", i, j), exception);
    }
}
