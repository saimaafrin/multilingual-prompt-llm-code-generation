import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.JSON;

public class JsonSerializer {

    /**
     * JSON में सीरियलाइज़ करें {@link String}
     * @param features सीरियलाइज़ेशन में सक्षम करने के लिए विशेषताएँ
     * @return JSON {@link String}
     */
    @SuppressWarnings("unchecked")
    public String toString(JSONWriter.Feature... features) {
        // Assuming this method is part of a class that has some data to serialize
        // For example, let's assume this class has a field `data` that needs to be serialized
        Object data = this.getData(); // Replace with actual data retrieval logic

        // Configure JSONWriter with the provided features
        JSONWriter writer = JSONWriter.of(features);

        // Serialize the data to JSON
        return JSON.toJSONString(data, writer);
    }

    // Example method to retrieve data (replace with actual logic)
    private Object getData() {
        // Return the data to be serialized
        return new Object(); // Replace with actual data
    }

    public static void main(String[] args) {
        JsonSerializer serializer = new JsonSerializer();
        String jsonString = serializer.toString(JSONWriter.Feature.PrettyFormat);
        System.out.println(jsonString);
    }
}