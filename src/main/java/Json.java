import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;


public class Json {
    private static final ObjectMapper defaultObjectMapper = newDefaultMapper();
    private static volatile ObjectMapper objectMapper = null;

    public Json() {
    }

    static ObjectMapper newDefaultMapper() {
        ObjectMapper var0 = new ObjectMapper();
        var0.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return var0;
    }

    public static ObjectMapper mapper() {
        return objectMapper == null ? defaultObjectMapper : objectMapper;
    }


    public static JsonNode toJson(Object var0) {
        try {
            return mapper().valueToTree(var0);
        } catch(Exception var2) {
            throw new RuntimeException(var2);
        }
    }


    public static <A> A fromJson(String var0, TypeReference<A> var1) {
        try {
            return (A) mapper().readValue(var0, var1);
        } catch(Exception var3) {
            throw new RuntimeException(var3);
        }
    }

}
