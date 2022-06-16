package spring;

public class DatabaseException extends RuntimeException{
    public DatabaseException(String message){
        super(message);
    }
}
