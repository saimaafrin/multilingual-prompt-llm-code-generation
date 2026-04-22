import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.JSON;

public class MyClass {

    @SuppressWarnings("unchecked")
    public String toString(JSONWriter.Feature... features) {
        // Assuming this method is part of a class that can be serialized to JSON
        // Using Fastjson2 to serialize the object to a JSON string with the given features
        return JSON.toJSONString(this, features);
    }
}