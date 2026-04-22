import com.alibaba.fastjson.JSONWriter;
import com.alibaba.fastjson.JSON;

public class JsonSerializer {

    @SuppressWarnings("unchecked")
    public String toString(JSONWriter.Feature... features) {
        try {
            if (features == null || features.length == 0) {
                return JSON.toJSONString(this);
            }
            return JSON.toJSONString(this, features);
        } catch (Exception e) {
            return "{}";
        }
    }

}