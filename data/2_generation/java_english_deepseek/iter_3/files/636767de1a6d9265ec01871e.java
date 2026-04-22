import java.util.regex.Pattern;
import java.util.regex.Matcher;

private void check(String modelName) throws IllegalStateException {
    // Assuming the sharding key indices are part of the model name and are in the format "modelName_shardX"
    // where X is a continuous integer starting from 0.
    
    // Extract the shard indices from the model name
    Pattern pattern = Pattern.compile("_shard(\\d+)");
    Matcher matcher = pattern.matcher(modelName);
    
    int previousIndex = -1;
    while (matcher.find()) {
        int currentIndex = Integer.parseInt(matcher.group(1));
        
        // Check if the indices are continuous
        if (previousIndex != -1 && currentIndex != previousIndex + 1) {
            throw new IllegalStateException("Sharding key indices are not continuous.");
        }
        
        previousIndex = currentIndex;
    }
    
    // If no shard indices are found, it's considered valid
    if (previousIndex == -1) {
        return;
    }
}