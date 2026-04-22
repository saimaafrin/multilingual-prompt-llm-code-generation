import com.google.gson.JsonObject;
import java.util.List;

private JsonObject convertProperties(List<KeyStringValuePair> properties) {
    JsonObject jsonObject = new JsonObject();
    for (KeyStringValuePair property : properties) {
        jsonObject.addProperty(property.getKey(), property.getValue());
    }
    return jsonObject;
}