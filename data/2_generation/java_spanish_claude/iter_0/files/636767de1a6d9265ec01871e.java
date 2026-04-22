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
            String shardNumberStr = matcher.group(1);
            int shardNumber = Integer.parseInt(shardNumberStr);

            // Check if shard number is negative
            if (shardNumber < 0) {
                throw new IllegalStateException("Shard index cannot be negative: " + modelName);
            }

            // Check if shard number is continuous with previous
            // This assumes shard numbers should start from 0 and be continuous
            String baseModelName = modelName.substring(0, modelName.lastIndexOf("_"));
            for (int i = 0; i < shardNumber; i++) {
                String previousShardName = baseModelName + "_" + i;
                // Here you would typically check if previous shard exists in your system
                // For demonstration, we'll just throw exception if gap found
                if (!previousShardExists(previousShardName)) {
                    throw new IllegalStateException("Non-continuous shard index detected at: " + previousShardName);
                }
            }
        }
    }

    // Helper method to check if a shard exists
    private boolean previousShardExists(String shardName) {
        // Implementation would depend on your system's way of tracking shards
        // This is just a placeholder
        return true;
    }
}