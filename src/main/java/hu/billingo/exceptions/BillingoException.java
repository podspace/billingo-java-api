package hu.billingo.exceptions;


public class BillingoException extends Exception {
    public BillingoException(String s, Throwable e) {
        super(s, e);
    }

    public BillingoException(String message) {
        super(message);
    }
}
