import java.util.Objects;

public class ShardingKeyValidator {
    
    /**
     * @param modelName model name of the entity
     * @throws IllegalStateException if sharding key indices are not continuous
     */
    private void check(String modelName) throws IllegalStateException {
        if (Objects.isNull(modelName)) {
            throw new IllegalStateException("Model name cannot be null");
        }

        if (modelName.trim().isEmpty()) {
            throw new IllegalStateException("Model name cannot be empty");
        }

        // Validate that sharding key indices are continuous
        // This is a basic implementation - extend based on specific requirements
        for (int i = 0; i < modelName.length() - 1; i++) {
            if (Character.isDigit(modelName.charAt(i)) && 
                Character.isDigit(modelName.charAt(i + 1))) {
                int curr = Character.getNumericValue(modelName.charAt(i));
                int next = Character.getNumericValue(modelName.charAt(i + 1));
                if (next - curr != 1) {
                    throw new IllegalStateException(
                        "Sharding key indices must be continuous in model: " + modelName);
                }
            }
        }
    }
}