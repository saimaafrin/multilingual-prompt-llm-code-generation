import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.JSON;

public class MyClass {

    /**
     * 序列化为 JSON {@link String}
     * @param features 在序列化中启用的特性
     * @return JSON {@link String}
     */
    @SuppressWarnings("unchecked")
    public String toString(JSONWriter.Feature... features) {
        // Assuming this method is part of a class that can be serialized to JSON
        // Using Fastjson2 to serialize the object to a JSON string with the given features
        return JSON.toJSONString(this, features);
    }
}