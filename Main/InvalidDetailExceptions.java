public class InvalidDetailExceptions extends Exception{

    enum ExceptionType{
        ENTERED_INVALID, ENTERED_NULL
    }

    ExceptionType type;
    public InvalidDetailExceptions(ExceptionType type, String message) {
        super(message);
        this.type = type;
    }
}