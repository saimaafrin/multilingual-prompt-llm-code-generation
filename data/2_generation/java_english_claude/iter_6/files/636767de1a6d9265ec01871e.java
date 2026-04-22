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
        String[] parts = modelName.split("_");
        if (parts.length > 1) {
            try {
                for (int i = 1; i < parts.length; i++) {
                    int currentIndex = Integer.parseInt(parts[i]);
                    int previousIndex = Integer.parseInt(parts[i-1]);
                    if (currentIndex != previousIndex + 1) {
                        throw new IllegalStateException("Sharding key indices must be continuous. Found gap between " + 
                            previousIndex + " and " + currentIndex);
                    }
                }
            } catch (NumberFormatException e) {
                throw new IllegalStateException("Invalid sharding key format in model name: " + modelName);
            }
        }
    }
}