import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonSerializer {

    /**
     * JSON में सीरियलाइज़ करें {@link String}
     * @param features सीरियलाइज़ेशन में सक्षम करने के लिए विशेषताएँ
     * @return JSON {@link String}
     */
    @SuppressWarnings("unchecked")
    public String toString(SerializerFeature... features) {
        // Assuming 'this' is the object to be serialized
        return JSON.toJSONString(this, features);
    }
}