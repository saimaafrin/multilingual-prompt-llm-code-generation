import java.util.regex.Matcher;
import java.util.regex.Pattern;

private void check(String modelName) throws IllegalStateException {
    // Regular expression to match sharding indices in the model name
    Pattern pattern = Pattern.compile("_\\d+");
    Matcher matcher = pattern.matcher(modelName);

    int previousIndex = -1;
    while (matcher.find()) {
        String match = matcher.group();
        int currentIndex = Integer.parseInt(match.substring(1)); // Extract the number after '_'

        if (previousIndex != -1 && currentIndex != previousIndex + 1) {
            throw new IllegalStateException("Sharding indices are not continuous.");
        }

        previousIndex = currentIndex;
    }
}