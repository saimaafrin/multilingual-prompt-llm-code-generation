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
            // Example object to serialize, replace with actual object
            Object exampleObject = new Object(); 
            return objectMapper.writeValueAsString(exampleObject);
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

    public static void main(String[] args) {
        JsonSerializer serializer = new JsonSerializer();
        String jsonString = serializer.toString(JSONWriter.Feature.PRETTY_PRINT);
        System.out.println(jsonString);
    }
}