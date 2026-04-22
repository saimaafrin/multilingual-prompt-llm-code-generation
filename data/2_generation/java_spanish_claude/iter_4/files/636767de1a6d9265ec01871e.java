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
            // Assuming shards should start from 0 and be continuous
            if (!modelName.replace("_" + shardIndex, "").equals(modelName.substring(0, modelName.lastIndexOf("_")))) {
                throw new IllegalStateException("Invalid shard format in model name: " + modelName);
            }

            // Check previous shard exists if not zero
            if (shardIndex > 0) {
                String previousShardName = modelName.substring(0, modelName.lastIndexOf("_")) + "_" + (shardIndex - 1);
                // Here you might want to add additional logic to check if previous shard exists
                // This would depend on your specific implementation requirements
            }
        }
    }
}