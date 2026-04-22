import java.util.HashMap;
import java.util.Map;
import com.google.gson.JsonObject;

private Map<String, Object> buildContent(JsonObject jsonObject) {
    Map<String, Object> content = new HashMap<>();

    if (jsonObject.has("ATS")) {
        content.put("ATS", jsonObject.get("ATS").getAsString());
    }

    // Aggiungi altri campi se necessario
    // Esempio: content.put("altroCampo", jsonObject.get("altroCampo").getAsString());

    return content;
}