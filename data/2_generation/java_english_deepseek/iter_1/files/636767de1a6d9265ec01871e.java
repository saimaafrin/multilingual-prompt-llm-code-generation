import java.util.regex.Pattern;
import java.util.regex.Matcher;

private void check(String modelName) throws IllegalStateException {
    // Assuming the sharding key indices are part of the model name and are in the format "modelName_shardX"
    // where X is a continuous integer starting from 0.
    
    // Extract the shard indices from the model name
    Pattern pattern = Pattern.compile("_shard(\\d+)");
    Matcher matcher = pattern.matcher(modelName);
    
    int previousIndex = -1;
    boolean isFirstMatch = true;
    
    while (matcher.find()) {
        int currentIndex = Integer.parseInt(matcher.group(1));
        
        if (isFirstMatch) {
            if (currentIndex != 0) {
                throw new IllegalStateException("Sharding key indices must start from 0.");
            }
            isFirstMatch = false;
        } else {
            if (currentIndex != previousIndex + 1) {
                throw new IllegalStateException("Sharding key indices are not continuous.");
            }
        }
        
        previousIndex = currentIndex;
    }
    
    if (previousIndex == -1) {
        throw new IllegalStateException("No sharding key indices found in the model name.");
    }
}