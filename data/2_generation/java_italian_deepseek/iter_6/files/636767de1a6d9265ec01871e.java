import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShardingKeyChecker {

    /**
     * @param modelName nome del modello dell'entità
     * @throws IllegalStateException se gli indici della chiave di sharding non sono continui
     */
    private void check(String modelName) throws IllegalStateException {
        // Assuming the modelName contains sharding indices in the format "modelName_shardIndex"
        Pattern pattern = Pattern.compile(".*_(\\d+)$");
        Matcher matcher = pattern.matcher(modelName);

        if (!matcher.find()) {
            throw new IllegalStateException("Invalid model name format. Expected format: 'modelName_shardIndex'");
        }

        int shardIndex = Integer.parseInt(matcher.group(1));

        // Assuming we have a method to get the total number of shards
        int totalShards = getTotalShards();

        if (shardIndex < 0 || shardIndex >= totalShards) {
            throw new IllegalStateException("Shard index is out of bounds. Expected range: [0, " + (totalShards - 1) + "]");
        }

        // Check if the shard indices are continuous
        for (int i = 0; i < totalShards; i++) {
            if (!isShardPresent(i)) {
                throw new IllegalStateException("Shard indices are not continuous. Missing shard index: " + i);
            }
        }
    }

    // Dummy method to simulate getting the total number of shards
    private int getTotalShards() {
        // This should be replaced with actual logic to get the total number of shards
        return 10; // Example value
    }

    // Dummy method to simulate checking if a shard is present
    private boolean isShardPresent(int shardIndex) {
        // This should be replaced with actual logic to check if a shard is present
        return true; // Example value
    }

    public static void main(String[] args) {
        ShardingKeyChecker checker = new ShardingKeyChecker();
        try {
            checker.check("modelName_5");
        } catch (IllegalStateException e) {
            System.err.println(e.getMessage());
        }
    }
}