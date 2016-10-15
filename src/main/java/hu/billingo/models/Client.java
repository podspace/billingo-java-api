
package hu.billingo.models;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "name",
    "force",
    "email",
    "taxcode",
    "billing_address",
    "bank"
})
public class Client {
    @JsonProperty("name")
    public String name;
    @JsonProperty("force")
    public Boolean force;
    @JsonProperty("email")
    public String email;
    @JsonProperty("taxcode")
    public String taxcode;
    @JsonProperty("billing_address")
    public BillingAddress billingAddress;
    @JsonProperty("bank")
    public Bank bank;

}
