package ua.kiev.prog;

public class ContactWithSameIDAndDifferentOtherFieldsException extends Exception{
    public ContactWithSameIDAndDifferentOtherFieldsException() {
    }

    public ContactWithSameIDAndDifferentOtherFieldsException(String message) {
        super(message);
    }

    public ContactWithSameIDAndDifferentOtherFieldsException(String message, Throwable cause) {
        super(message, cause);
    }

    public ContactWithSameIDAndDifferentOtherFieldsException(Throwable cause) {
        super(cause);
    }
}
