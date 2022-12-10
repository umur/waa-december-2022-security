package edu.miu.springsecurity.exception;

public class ConcurrentRequestException extends Exception {
    public ConcurrentRequestException(String message) {
        super(message);
    }
}
