import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ModelChecker {

    /**
     * @param modelName nombre del modelo de la entidad
     * @throws IllegalStateException si los índices de la clave de "sharding" no son continuos
     */
    private void check(String modelName) throws IllegalStateException {
        if (modelName == null || modelName.isEmpty()) {
            throw new IllegalStateException("Model name cannot be null or empty");
        }

        // Pattern to match sharding key indices like "shard_1", "shard_2", etc
        Pattern pattern = Pattern.compile("shard_(\\d+)");
        Matcher matcher = pattern.matcher(modelName);

        int expectedIndex = 1;
        while (matcher.find()) {
            int currentIndex = Integer.parseInt(matcher.group(1));
            if (currentIndex != expectedIndex) {
                throw new IllegalStateException("Sharding indices must be continuous. Expected " + 
                    expectedIndex + " but found " + currentIndex);
            }
            expectedIndex++;
        }
    }
}