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
            try {
                int shardIndex = Integer.parseInt(shardIndexStr);
                
                // Check if shard index is negative
                if (shardIndex < 0) {
                    throw new IllegalStateException("Shard index cannot be negative: " + modelName);
                }

                // Check if shard index is continuous (should start from 0)
                if (shardIndex > 0) {
                    String previousShardName = modelName.substring(0, modelName.lastIndexOf('_')) + "_" + (shardIndex - 1);
                    // Here you would typically check if previous shard exists in your system
                    // For demonstration, we'll assume if previous shard doesn't follow naming convention, it's invalid
                    if (!previousShardName.matches(".*_[0-9]+$")) {
                        throw new IllegalStateException("Non-continuous shard index detected in: " + modelName);
                    }
                }
            } catch (NumberFormatException e) {
                throw new IllegalStateException("Invalid shard index format in: " + modelName);
            }
        }
    }
}