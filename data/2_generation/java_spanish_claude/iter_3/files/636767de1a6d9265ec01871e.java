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

            // Check if shard number is continuous with previous shards
            // This assumes shard numbers should start from 0 and be continuous
            if (shardNumber > 0) {
                String previousShardName = modelName.substring(0, modelName.lastIndexOf('_')) + "_" + (shardNumber - 1);
                if (!shardExists(previousShardName)) {
                    throw new IllegalStateException("Non-continuous shard index detected in: " + modelName);
                }
            }
        }
    }

    // Helper method to check if a shard exists
    private boolean shardExists(String shardName) {
        // Implementation would depend on how shards are stored/managed
        // This is just a placeholder
        return true;
    }
}