import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ModelChecker {
    
    private void check(String modelName) throws IllegalStateException {
        if (modelName == null || modelName.isEmpty()) {
            throw new IllegalStateException("Model name cannot be null or empty");
        }

        // Pattern to match numbers at the end of model name (e.g. "model_1", "model_2")
        Pattern pattern = Pattern.compile("_(\\d+)$");
        Matcher matcher = pattern.matcher(modelName);

        if (matcher.find()) {
            int currentIndex = Integer.parseInt(matcher.group(1));
            
            // Check if index is less than 1
            if (currentIndex < 1) {
                throw new IllegalStateException("Sharding index must be greater than 0 for model: " + modelName);
            }

            // Check if there are gaps in the sequence by verifying previous model exists
            String baseModelName = modelName.substring(0, matcher.start());
            String previousModelName = baseModelName + "_" + (currentIndex - 1);
            
            // If current index is greater than 1, previous model should exist
            if (currentIndex > 1 && !modelExists(previousModelName)) {
                throw new IllegalStateException("Non-continuous sharding index detected. Missing model: " + previousModelName);
            }
        }
    }

    // Helper method to check if a model exists
    private boolean modelExists(String modelName) {
        // Implementation would depend on how models are stored/managed
        // This is just a placeholder
        return true;
    }
}