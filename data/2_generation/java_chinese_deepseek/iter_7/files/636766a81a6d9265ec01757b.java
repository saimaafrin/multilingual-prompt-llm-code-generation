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
        // Assuming this class has fields that need to be serialized
        // Using Fastjson2 to serialize the object to JSON with the specified features
        return JSON.toJSONString(this, features);
    }
}