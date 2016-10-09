
package models;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "description",
    "net_unit_price",
    "gross_unit_price",
    "qty",
    "unit",
    "vat_id",
    "item_comment"
})
public class InvoiceItem {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("description")
    public String description;
    @JsonProperty("net_unit_price")
    public Double netUnitPrice;
    @JsonProperty("gross_unit_price")
    public Double grossUnitPrice;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("qty")
    public Double qty;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("unit")
    public String unit;
    /**
     * The VAT ID for the item
     * (Required)
     * 
     */
    @JsonProperty("vat_id")
    public Long vatId;
    @JsonProperty("item_comment")
    public String itemComment;

}
