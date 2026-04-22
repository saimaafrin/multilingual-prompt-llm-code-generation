import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import com.fasterxml.jackson.databind.json.JsonMapper.Builder;
import com.fasterxml.jackson.databind.json.JsonMapper.Feature;

public class JSONWriter {

    private Object data;

    public JSONWriter(Object data) {
        this.data = data;
    }

    @SuppressWarnings("unchecked")
    public String toString(Feature... features) {
        Builder builder = JsonMapper.builder();
        for (Feature feature : features) {
            builder = builder.enable(feature);
        }
        ObjectMapper mapper = builder.build();
        try {
            return mapper.writeValueAsString(data);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        // Example usage
        JSONWriter writer = new JSONWriter(new MyDataClass());
        String json = writer.toString(Feature.INDENT_OUTPUT);
        System.out.println(json);
    }
}

class MyDataClass {
    private String name = "example";
    private int value = 42;

    // Getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}