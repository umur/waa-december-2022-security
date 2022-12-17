package miu.edu.lab5.exception;

public class ConcurrentRequestException extends Exception {
    public ConcurrentRequestException(String message) {
        super(message);
    }
}