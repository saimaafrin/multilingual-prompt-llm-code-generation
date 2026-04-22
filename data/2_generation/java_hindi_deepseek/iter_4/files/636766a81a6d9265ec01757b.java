import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.JSON;

public class MyClass {

    /**
     * JSON में सीरियलाइज़ करें {@link String}
     * @param features सीरियलाइज़ेशन में सक्षम करने के लिए विशेषताएँ
     * @return JSON {@link String}
     */
    @SuppressWarnings("unchecked")
    public String toString(JSONWriter.Feature... features) {
        // Assuming 'this' is the object to be serialized
        return JSON.toJSONString(this, features);
    }
}