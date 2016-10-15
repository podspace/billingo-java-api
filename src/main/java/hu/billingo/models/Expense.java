
package hu.billingo.models;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import javax.annotation.Generated;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "categories_id",
    "name",
    "invoice_no",
    "gross_price",
    "vat",
    "client_uid",
    "due_date",
    "currency"
})
public class Expense {

    @JsonProperty("categories_id")
    public Long categoriesId;
    @JsonProperty("name")
    public String name;
    @JsonProperty("invoice_no")
    public String invoiceNo;
    @JsonProperty("gross_price")
    public Double grossPrice;
    @JsonProperty("vat")
    public Long vat;
    @JsonProperty("client_uid")
    public Long clientUid;
    @JsonProperty("due_date")
    public String dueDate;
    @JsonProperty("currency")
    public String currency;

}
