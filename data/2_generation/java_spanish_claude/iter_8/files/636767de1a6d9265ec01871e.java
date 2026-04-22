import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ModelChecker {
    
    private void check(String modelName) throws IllegalStateException {
        if (modelName == null || modelName.isEmpty()) {
            throw new IllegalStateException("Model name cannot be null or empty");
        }

        // Check for continuous sharding key indices using regex
        Pattern pattern = Pattern.compile("\\{(\\d+)\\}");
        Matcher matcher = pattern.matcher(modelName);
        
        int expectedIndex = 0;
        while (matcher.find()) {
            int currentIndex = Integer.parseInt(matcher.group(1));
            if (currentIndex != expectedIndex) {
                throw new IllegalStateException("Sharding key indices must be continuous. Expected index " 
                    + expectedIndex + " but found " + currentIndex);
            }
            expectedIndex++;
        }
    }
}