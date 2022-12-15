package miu.edu.springsecuritylab6.exception;

public class EmailExistException extends Exception{
    public EmailExistException(String message){
        super(message);
    }
}
