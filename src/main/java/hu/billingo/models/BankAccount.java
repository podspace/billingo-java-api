
package hu.billingo.models;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "bank_name",
    "account_no",
    "account_no_iban",
    "account_swift",
    "currency"
})
public class BankAccount {
    @JsonProperty("bank_name")
    public String bankName;
    @JsonProperty("account_no")
    public String accountNo;
    @JsonProperty("account_no_iban")
    public String accountNoIban;
    @JsonProperty("account_swift")
    public String accountSwift;
    @JsonProperty("currency")
    public String currency;

}
