import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.JSON;

public class JsonSerializer {
    private Object value;

    public JsonSerializer(Object value) {
        this.value = value;
    }

    @SuppressWarnings("unchecked")
    public String toString(JSONWriter.Feature... features) {
        if (features == null || features.length == 0) {
            return JSON.toJSONString(value);
        }
        return JSON.toJSONString(value, features);
    }
}