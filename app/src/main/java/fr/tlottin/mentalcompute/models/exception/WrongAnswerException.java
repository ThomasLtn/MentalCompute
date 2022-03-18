package fr.tlottin.mentalcompute.models.exception;

public class WrongAnswerException extends Exception{
    public WrongAnswerException(String message){
        super(message);
    }
    public WrongAnswerException(String message, Throwable innerException){
        super(message, innerException);
    }
}
