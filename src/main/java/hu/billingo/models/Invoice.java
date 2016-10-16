
package hu.billingo.models;

import com.fasterxml.jackson.annotation.*;

import javax.annotation.Generated;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "fulfillment_date",
    "due_date",
    "payment_method",
    "round_to",
    "comment",
    "currency",
    "client_uid",
    "block_uid",
    "electronic_invoice",
    "template_lang_code",
    "type",
    "exchange_rate",
    "items"
})
public class Invoice {

    /**
     * The date the invoice was fulfilled
     * (Required)
     */
    @JsonProperty("fulfillment_date")
    public String fulfillmentDate;
    /**
     * The date when the invoice is due
     * (Required)
     */
    @JsonProperty("due_date")
    public String dueDate;
    /**
     * The payment method ID
     * (Required)
     */
    @JsonProperty("payment_method")
    @JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
    @JsonIdentityReference(alwaysAsId = true)
    public PaymentMethod paymentMethod;
    /**
     * Invoice rounding
     */
    @JsonProperty("round_to")
    public RoundTo roundTo;
    /**
     * The comment that should be visible on the invoice
     * (Required)
     */
    @JsonProperty("comment")
    public String comment;
    /**
     * ISO 4217 currency code
     * (Required)
     */
    @JsonProperty("currency")
    public String currency;
    /**
     * The client ID
     * (Required)
     */
    @JsonProperty("client_uid")
    public Long clientUid;
    /**
     * The invoice block ID, should be left out if using default block
     * (Required)
     */
    @JsonProperty("block_uid")
    public Long blockUid;
    /**
     * 1 if invoice needs digital signature and trusted timestamp
     * (Required)
     */
    @JsonProperty("electronic_invoice")
    public ElectronicInvoice electronicInvoice;
    /**
     * The language code
     * (Required)
     */
    @JsonProperty("template_lang_code")
    public TemplateLangCode templateLangCode;
    /**
     * Invoice type
     * (Required)
     */
    @JsonProperty("type")
    public Type type;
    /**
     * Exchange rate for the invoice
     */
    @JsonProperty("exchange_rate")
    public Double exchangeRate;
    /**
     * List of the invoiceItems
     * (Required)
     */
    @JsonProperty("items")
    public List<InvoiceItem> invoiceItems = new ArrayList<InvoiceItem>();

    @Generated("org.jsonschema2pojo")
    public enum ElectronicInvoice {

        _0(0),
        _1(1);
        private final Integer value;
        private final static Map<Integer, ElectronicInvoice> CONSTANTS = new HashMap<Integer, ElectronicInvoice>();

        static {
            for(ElectronicInvoice c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private ElectronicInvoice(Integer value) {
            this.value = value;
        }

        @JsonValue
        public Integer toJson() {
            return this.value;
        }

        @JsonCreator
        public static ElectronicInvoice fromValue(String value) {
            ElectronicInvoice constant = CONSTANTS.get(Integer.parseInt(value));
            if(constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    @Generated("org.jsonschema2pojo")
    public enum RoundTo {

        _0(0),
        _1(1),
        _5(5),
        _10(10);
        private final Integer value;
        private final static Map<Integer, RoundTo> CONSTANTS = new HashMap<Integer, RoundTo>();

        static {
            for(RoundTo c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private RoundTo(Integer value) {
            this.value = value;
        }

        @JsonValue
        public Integer toJson() {
            return this.value;
        }

        @JsonCreator
        public static RoundTo fromValue(String value) {
            RoundTo constant = CONSTANTS.get(Integer.parseInt(value));
            if(constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    @Generated("org.jsonschema2pojo")
    public enum TemplateLangCode {

        HU("hu"),
        EN("en"),
        DE("de");
        private final String value;
        private final static Map<String, TemplateLangCode> CONSTANTS = new HashMap<String, TemplateLangCode>();

        static {
            for(TemplateLangCode c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private TemplateLangCode(String value) {
            this.value = value;
        }

        @JsonValue
        @Override
        public String toString() {
            return this.value;
        }

        @JsonCreator
        public static TemplateLangCode fromValue(String value) {
            TemplateLangCode constant = CONSTANTS.get(value);
            if(constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    @Generated("org.jsonschema2pojo")
    public enum Type {

        _0(0),
        _1(1),
        _2(2),
        _3(3);
        private final Integer value;
        private final static Map<Integer, Type> CONSTANTS = new HashMap<Integer, Type>();

        static {
            for(Type c : values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private Type(Integer value) {
            this.value = value;
        }

        @JsonValue
        public Integer toJson() {
            return this.value;
        }

        @JsonCreator
        public static Type fromValue(String value) {
            Type constant = CONSTANTS.get(Integer.parseInt(value));
            if(constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
