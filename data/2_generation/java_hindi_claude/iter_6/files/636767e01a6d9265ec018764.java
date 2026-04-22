import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class PropertyConverter {

    /**
     * Convert process properties to source data
     * @param properties The properties to convert
     * @return Map containing the converted property data
     */
    public Map<String, String> convertPropertiesToSourceData(Properties properties) {
        Map<String, String> sourceData = new HashMap<>();
        
        if (properties != null) {
            for (String key : properties.stringPropertyNames()) {
                String value = properties.getProperty(key);
                if (value != null) {
                    sourceData.put(key, value);
                }
            }
        }
        
        return sourceData;
    }
}