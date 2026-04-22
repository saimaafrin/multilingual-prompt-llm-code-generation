import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShardingKeyChecker {

    /**
     * Verifica si los índices de la clave de "sharding" son continuos.
     * 
     * @param modelName nombre del modelo de la entidad
     * @throws IllegalStateException si los índices de la clave de "sharding" no son continuos
     */
    private void check(String modelName) throws IllegalStateException {
        // Expresión regular para encontrar los índices de sharding en el nombre del modelo
        Pattern pattern = Pattern.compile("_\\d+");
        Matcher matcher = pattern.matcher(modelName);

        int previousIndex = -1;
        while (matcher.find()) {
            String match = matcher.group();
            int currentIndex = Integer.parseInt(match.substring(1)); // Elimina el "_" y convierte a entero

            if (previousIndex != -1 && currentIndex != previousIndex + 1) {
                throw new IllegalStateException("Los índices de la clave de sharding no son continuos.");
            }

            previousIndex = currentIndex;
        }
    }
}