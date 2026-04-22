import java.util.regex.Pattern;
import java.util.regex.Matcher;

private void check(String modelName) throws IllegalStateException {
    // Define a regex pattern to match the sharding indices
    Pattern pattern = Pattern.compile(".*_\\d+$");
    Matcher matcher = pattern.matcher(modelName);

    if (!matcher.find()) {
        throw new IllegalStateException("Model name does not contain sharding indices.");
    }

    // Extract the sharding index from the model name
    String[] parts = modelName.split("_");
    int lastIndex = Integer.parseInt(parts[parts.length - 1]);

    // Check if the sharding indices are continuous
    for (int i = 0; i < parts.length - 1; i++) {
        try {
            int currentIndex = Integer.parseInt(parts[i]);
            if (currentIndex != lastIndex - (parts.length - 1 - i)) {
                throw new IllegalStateException("Sharding indices are not continuous.");
            }
        } catch (NumberFormatException e) {
            // Ignore non-numeric parts
        }
    }
}