import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONWriter;

public class JsonSerializer {

    /** 
     * JSON में सीरियलाइज़ करें {@link String}
     * @param features सीरियलाइज़ेशन में सक्षम करने के लिए विशेषताएँ
     * @return JSON {@link String}
     */
    @SuppressWarnings("unchecked") 
    public String toString(JSONWriter.Feature... features) {
        // Example object to serialize
        MyObject obj = new MyObject("example", 123);
        
        // Serialize the object to JSON string with the provided features
        return JSON.toJSONString(obj, features);
    }

    // Example class to demonstrate serialization
    public static class MyObject {
        private String name;
        private int value;

        public MyObject(String name, int value) {
            this.name = name;
            this.value = value;
        }

        // Getters and setters (if needed)
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }
    }

    public static void main(String[] args) {
        JsonSerializer serializer = new JsonSerializer();
        String jsonString = serializer.toString(JSONWriter.Feature.PrettyFormat);
        System.out.println(jsonString);
    }
}