import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.JSON;

public class MyClass {

    /**
     * Serialize to JSON {@link String}
     * @param features features to be enabled in serialization
     * @return JSON {@link String}
     */
    @SuppressWarnings("unchecked")
    public String toString(JSONWriter.Feature... features) {
        // Assuming this method is part of a class that can be serialized to JSON
        // Using Fastjson2 to serialize the current object to a JSON string with the specified features
        return JSON.toJSONString(this, features);
    }
}