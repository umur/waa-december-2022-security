package edu.miu.springsecurity1.exception;


public class OffensiveWordException extends RuntimeException {
    public  OffensiveWordException(String message) {
        super(message);
    }
}