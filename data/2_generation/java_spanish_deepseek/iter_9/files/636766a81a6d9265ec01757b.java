import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.JSON;

public class MyClass {

    /**
     * Serializar a JSON {@link String}
     * @param features características que se habilitarán en la serialización
     * @return JSON {@link String}
     */
    @SuppressWarnings("unchecked")
    public String toString(JSONWriter.Feature... features) {
        // Assuming 'this' is the object to be serialized
        return JSON.toJSONString(this, features);
    }
}