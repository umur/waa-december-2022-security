package com.example.lab3springdata;

public class AopIsAwesomeHeaderException extends Exception{
    public AopIsAwesomeHeaderException(String header_missing) {
        super(header_missing);
    }

}
