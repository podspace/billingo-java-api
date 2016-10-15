package hu.billingo.models;

/**
 * Created by torcsi on 15/10/2016.
 */
public class APIResponseStatusOnly implements ApiResponseWithStatus {
    public String success;
    public String error;

    public String getSuccess() {
        return success;
    }

    public String getError() {
        return error;
    }
}
