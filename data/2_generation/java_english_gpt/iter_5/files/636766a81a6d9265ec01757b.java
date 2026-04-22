import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonSerializer {

    private ObjectMapper objectMapper;

    public JsonSerializer() {
        this.objectMapper = new ObjectMapper();
    }

    /** 
     * Serialize to JSON  {@link String}
     * @param features features to be enabled in serialization
     * @return JSON {@link String}
     */
    @SuppressWarnings("unchecked") 
    public String toString(JSONWriter.Feature... features) {
        for (JSONWriter.Feature feature : features) {
            switch (feature) {
                case PRETTY_PRINT:
                    objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
                    break;
                // Add more features as needed
                default:
                    break;
            }
        }
        
        try {
            // Assuming we are serializing an object, replace 'yourObject' with the actual object to serialize
            Object yourObject = new Object(); // Replace with actual object
            return objectMapper.writeValueAsString(yourObject);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public enum JSONWriter {
        Feature {
            PRETTY_PRINT
            // Add more features as needed
        }
    }
}