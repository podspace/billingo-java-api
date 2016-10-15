package hu.billingo.models;

import java.util.List;


public class APIResponseList<T> implements ApiResponseWithStatus {
    public String success;
    public String type;
    public List<T> data;
    public String error;

    public String getSuccess() {
        return success;
    }

    public String getError() {
        return error;
    }
}
