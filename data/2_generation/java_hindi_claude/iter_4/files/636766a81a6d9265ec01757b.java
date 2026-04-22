import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.util.EnumSet;

public class JsonSerializer {

    /**
     * Serialize to JSON {@link String}
     * @param features features to be enabled in serialization
     * @return JSON {@link String}
     */
    public String serializeToJson(EnumSet<SerializationFeature> features) {
        try {
            ObjectMapper mapper = new ObjectMapper();
            
            // Enable all requested serialization features
            if (features != null) {
                for (SerializationFeature feature : features) {
                    mapper.enable(feature);
                }
            }

            // Convert this object to JSON string
            return mapper.writeValueAsString(this);

        } catch (Exception e) {
            throw new RuntimeException("Error serializing object to JSON", e);
        }
    }
}