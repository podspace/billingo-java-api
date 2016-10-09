
package models;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "amount",
    "date",
    "payment_method"
})
public class InvoicePayment {

    /**
     * The gross amount paid
     * (Required)
     * 
     */
    @JsonProperty("amount")
    public Double amount;
    /**
     * The date when the payment was made
     * (Required)
     * 
     */
    @JsonProperty("date")
    public String date;
    /**
     * The payment method ID
     * (Required)
     * 
     */
    @JsonProperty("payment_method")
    public Long paymentMethod;

}
