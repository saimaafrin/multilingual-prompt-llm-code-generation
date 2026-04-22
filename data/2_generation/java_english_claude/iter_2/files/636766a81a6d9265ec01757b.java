import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.JSON;

public class JsonSerializer {

    private Object value;

    public JsonSerializer(Object value) {
        this.value = value;
    }

    @SuppressWarnings("unchecked")
    public String toString(JSONWriter.Feature... features) {
        if (value == null) {
            return null;
        }

        try {
            // Use FastJSON to serialize object to JSON string with specified features
            return JSON.toJSONString(value, features);
        } catch (Exception e) {
            // Return empty string if serialization fails
            return "";
        }
    }
}