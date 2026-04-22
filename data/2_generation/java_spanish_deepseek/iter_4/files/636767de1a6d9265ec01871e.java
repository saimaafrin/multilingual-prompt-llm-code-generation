import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShardingKeyChecker {

    /**
     * @param modelName nombre del modelo de la entidad
     * @throws IllegalStateException si los índices de la clave de "sharding" no son continuos
     */
    private void check(String modelName) throws IllegalStateException {
        // Assuming the modelName contains sharding indices in the format "modelName_shardX"
        Pattern pattern = Pattern.compile("_shard(\\d+)");
        Matcher matcher = pattern.matcher(modelName);

        int previousIndex = -1;
        while (matcher.find()) {
            int currentIndex = Integer.parseInt(matcher.group(1));
            if (previousIndex != -1 && currentIndex != previousIndex + 1) {
                throw new IllegalStateException("Los índices de la clave de 'sharding' no son continuos");
            }
            previousIndex = currentIndex;
        }
    }

    public static void main(String[] args) {
        ShardingKeyChecker checker = new ShardingKeyChecker();
        try {
            checker.check("model_shard0_shard1_shard2");
            System.out.println("Sharding indices are continuous.");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}