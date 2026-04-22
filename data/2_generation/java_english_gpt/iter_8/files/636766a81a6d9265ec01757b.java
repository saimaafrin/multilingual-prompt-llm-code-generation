import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class JsonSerializer {

    @SuppressWarnings("unchecked")
    public String toString(JSONWriter.Feature... features) {
        ObjectMapper objectMapper = new ObjectMapper();
        
        // Enable features based on the input
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

        // Example object to serialize
        MyObject myObject = new MyObject("example", 123);

        try {
            return objectMapper.writeValueAsString(myObject);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    // Example class to serialize
    public static class MyObject {
        private String name;
        private int value;

        public MyObject(String name, int value) {
            this.name = name;
            this.value = value;
        }

        // Getters and setters (if needed)
    }

    // Example enum for features
    public enum JSONWriter {
        Feature {
            PRETTY_PRINT
            // Add more features as needed
        }
    }

    public static void main(String[] args) {
        JsonSerializer serializer = new JsonSerializer();
        String json = serializer.toString(JSONWriter.Feature.PRETTY_PRINT);
        System.out.println(json);
    }
}