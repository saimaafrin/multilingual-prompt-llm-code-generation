import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.JSON;

public class MyClass {

    /**
     * Serializza in JSON {@link String}
     * @param features funzionalità da abilitare nella serializzazione
     * @return JSON {@link String}
     */
    @SuppressWarnings("unchecked")
    public String toString(JSONWriter.Feature... features) {
        // Assuming 'this' is the object to be serialized
        return JSON.toJSONString(this, features);
    }
}