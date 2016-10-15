package hu.billingo.models;

import java.util.List;


public class APIResponseList<T> {
    public String success;
    public String type;
    public List<T> data;
}
