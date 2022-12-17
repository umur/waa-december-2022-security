package miu.edu.springsecuritylab6.exception;

public class EmailNotFoundException extends Exception{
    public EmailNotFoundException(String message){
        super(message);
    }
}
