import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.serializer.SerializerFeature;

public class JsonSerializer {

    /**
     * Serializza in JSON {@link String}
     * @param features funzionalità da abilitare nella serializzazione
     * @return JSON {@link String}
     */
    @SuppressWarnings("unchecked")
    public String toString(JSONWriter.Feature... features) {
        // Example object to serialize
        MyObject obj = new MyObject("example", 123);
        
        // Convert features to SerializerFeature
        SerializerFeature[] serializerFeatures = new SerializerFeature[features.length];
        for (int i = 0; i < features.length; i++) {
            serializerFeatures[i] = SerializerFeature.valueOf(features[i].name());
        }
        
        // Serialize the object to JSON
        return JSON.toJSONString(obj, serializerFeatures);
    }

    // Example class to serialize
    public static class MyObject {
        private String name;
        private int value;

        public MyObject(String name, int value) {
            this.name = name;
            this.value = value;
        }

        // Getters and setters (if needed)
    }
}