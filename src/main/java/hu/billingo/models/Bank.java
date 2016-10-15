
package hu.billingo.models;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "iban",
    "swift",
    "account_no"
})
public class Bank {

    @JsonProperty("iban")
    public String iban;
    @JsonProperty("swift")
    public String swift;
    @JsonProperty("account_no")
    public String accountNo;

}
