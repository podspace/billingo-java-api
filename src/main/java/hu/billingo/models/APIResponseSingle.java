package hu.billingo.models;

public class APIResponseSingle<T> implements ApiResponseWithStatus{
    public String success;
    public String type;
    public T data;
    public String error;

    public String getSuccess() {
        return success;
    }

    public String getError() {
        return error;
    }
}
