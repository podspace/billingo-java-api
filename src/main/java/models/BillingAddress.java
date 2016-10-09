
package models;

import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "street_name",
    "street_type",
    "house_nr",
    "block",
    "entrance",
    "floor",
    "door",
    "city",
    "postcode",
    "country"
})
public class BillingAddress {
    @JsonProperty("street_name")
    public String streetName;
    @JsonProperty("street_type")
    public String streetType;
    @JsonProperty("house_nr")
    public String houseNr;
    @JsonProperty("block")
    public String block;
    @JsonProperty("entrance")
    public String entrance;
    @JsonProperty("floor")
    public String floor;
    @JsonProperty("door")
    public String door;
    @JsonProperty("city")
    public String city;
    @JsonProperty("postcode")
    public String postcode;
    @JsonProperty("country")
    public String country;

}
