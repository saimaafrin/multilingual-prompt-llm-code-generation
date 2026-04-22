import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.JSON;

public class JSONSerializer {

    private Object value;

    public JSONSerializer(Object value) {
        this.value = value;
    }

    /**
     * 序列化为 JSON {@link String}
     * @param features 在序列化中启用的特性
     * @return JSON {@link String}
     */
    @SuppressWarnings("unchecked")
    public String toString(JSONWriter.Feature... features) {
        if (value == null) {
            return "null";
        }

        try {
            // Use FastJSON to serialize the object with specified features
            return JSON.toJSONString(value, features);
        } catch (Exception e) {
            // Return empty string if serialization fails
            return "";
        }
    }
}