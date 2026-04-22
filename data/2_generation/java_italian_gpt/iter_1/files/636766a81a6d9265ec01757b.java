import org.json.JSONObject;

@SuppressWarnings("unchecked")
public String toString(JSONWriter.Feature... features) {
    JSONObject jsonObject = new JSONObject();
    
    // Example of adding some data to the JSON object
    jsonObject.put("feature1", features.length > 0 ? features[0].toString() : "defaultFeature");
    
    // Convert the JSONObject to a JSON String
    return jsonObject.toString();
}