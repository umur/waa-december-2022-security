package edu.miu.labthree.aspect;

public class AopIsAwesomeHeaderException extends Exception{
    public AopIsAwesomeHeaderException(){
        super();
    }
    public AopIsAwesomeHeaderException(String message) {
        super(message);
    }
    public AopIsAwesomeHeaderException(Throwable ex) {
        super(ex);
    }
}
