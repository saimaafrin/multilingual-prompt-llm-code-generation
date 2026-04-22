import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ShardingKeyChecker {

    /**
     * Checks if the sharding key indices in the model name are continuous.
     * 
     * @param modelName model name of the entity
     * @throws IllegalStateException if sharding key indices are not continuous
     */
    private void check(String modelName) throws IllegalStateException {
        // Regular expression to match sharding key indices in the model name
        Pattern pattern = Pattern.compile("_\\d+");
        Matcher matcher = pattern.matcher(modelName);

        int previousIndex = -1;
        while (matcher.find()) {
            String match = matcher.group();
            int currentIndex = Integer.parseInt(match.substring(1)); // Extract the number after '_'

            if (previousIndex != -1 && currentIndex != previousIndex + 1) {
                throw new IllegalStateException("Sharding key indices are not continuous.");
            }

            previousIndex = currentIndex;
        }
    }
}