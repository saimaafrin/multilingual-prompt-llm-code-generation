import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ShardingValidator {

    /**
     * @param modelName nombre del modelo de la entidad
     * @throws IllegalStateException si los índices de la clave de "sharding" no son continuos
     */
    private void check(String modelName) throws IllegalStateException {
        if (modelName == null || modelName.isEmpty()) {
            throw new IllegalStateException("Model name cannot be null or empty");
        }

        // Regex pattern to find shard numbers in format _0, _1, _2 etc
        Pattern pattern = Pattern.compile("_([0-9]+)$");
        Matcher matcher = pattern.matcher(modelName);

        if (matcher.find()) {
            String shardIndexStr = matcher.group(1);
            int shardIndex = Integer.parseInt(shardIndexStr);

            // Check if shard index is negative
            if (shardIndex < 0) {
                throw new IllegalStateException("Shard index cannot be negative: " + modelName);
            }

            // Check if shard index skips numbers
            // This assumes shard indices should start from 0 and be continuous
            String baseModelName = modelName.substring(0, modelName.lastIndexOf('_'));
            for (int i = 0; i < shardIndex; i++) {
                String expectedModelName = baseModelName + "_" + i;
                // Here you would typically check if expectedModelName exists in your system
                // For demonstration, we'll just throw an exception if there's a gap
                if (!modelExists(expectedModelName)) {
                    throw new IllegalStateException("Non-continuous shard index detected. Missing shard: " + expectedModelName);
                }
            }
        }
    }

    // Helper method to check if a model exists - implementation would depend on your system
    private boolean modelExists(String modelName) {
        // Implement according to your system's model checking logic
        return true; // Placeholder implementation
    }
}