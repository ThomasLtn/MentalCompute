package fr.tlottin.mentalcompute.models.exception;

public class NoAnswerException extends Exception{
    public NoAnswerException (String message){
        super(message);
    }
    public NoAnswerException(String message, Throwable innerException){
        super(message, innerException);
    }
}
