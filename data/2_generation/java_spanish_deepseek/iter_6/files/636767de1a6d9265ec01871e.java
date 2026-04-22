import java.util.regex.Pattern;
import java.util.regex.Matcher;

private void check(String modelName) throws IllegalStateException {
    // Assuming the modelName contains sharding indices in the format "modelName_shardX_shardY_..."
    Pattern pattern = Pattern.compile("_shard(\\d+)");
    Matcher matcher = pattern.matcher(modelName);

    int previousIndex = -1;
    while (matcher.find()) {
        int currentIndex = Integer.parseInt(matcher.group(1));
        if (previousIndex != -1 && currentIndex != previousIndex + 1) {
            throw new IllegalStateException("Sharding indices are not continuous.");
        }
        previousIndex = currentIndex;
    }
}