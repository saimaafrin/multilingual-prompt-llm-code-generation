import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.JSON;

public class JsonSerializer {

    @SuppressWarnings("unchecked")
    public String toString(JSONWriter.Feature... features) {
        try {
            if (features != null && features.length > 0) {
                return JSON.toJSONString(this, features);
            } else {
                return JSON.toJSONString(this);
            }
        } catch (Exception e) {
            return "{}";
        }
    }

}