import java.util.HashMap;
import java.util.Map;
import javax.json.JsonObject;

public class ContentBuilder {

    /**
     * Costruisci il contenuto, se ha "ATS", imposta l'"ATS"
     */
    private Map<String,Object> buildContent(JsonObject jsonObject) {
        Map<String,Object> content = new HashMap<>();
        
        if (jsonObject != null) {
            // Check if jsonObject contains "ATS" key
            if (jsonObject.containsKey("ATS")) {
                content.put("ATS", jsonObject.getString("ATS"));
            }
            
            // Add all other key-value pairs from jsonObject to content map
            for (String key : jsonObject.keySet()) {
                if (!key.equals("ATS")) {
                    Object value = jsonObject.get(key);
                    content.put(key, value); 
                }
            }
        }
        
        return content;
    }
}