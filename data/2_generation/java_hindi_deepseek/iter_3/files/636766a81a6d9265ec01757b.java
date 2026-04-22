import com.alibaba.fastjson2.JSONWriter;
import com.alibaba.fastjson2.JSON;

public class Example {

    /**
     * JSON में सीरियलाइज़ करें {@link String}
     * @param features सीरियलाइज़ेशन में सक्षम करने के लिए विशेषताएँ
     * @return JSON {@link String}
     */
    @SuppressWarnings("unchecked")
    public String toString(JSONWriter.Feature... features) {
        // Assuming this method is part of a class that can be serialized to JSON
        // For example, let's assume this class has some fields that can be serialized
        // Here, we use Fastjson to serialize the current object to a JSON string
        return JSON.toJSONString(this, features);
    }

    // Example fields for serialization
    private String name;
    private int age;

    // Constructor, getters, and setters
    public Example(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    // Main method for testing
    public static void main(String[] args) {
        Example example = new Example("John Doe", 30);
        String jsonString = example.toString(JSONWriter.Feature.PrettyFormat);
        System.out.println(jsonString);
    }
}