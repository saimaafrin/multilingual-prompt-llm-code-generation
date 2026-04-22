import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ShardingKeyChecker {

    /**
     * Verifica che gli indici della chiave di sharding siano continui.
     * 
     * @param modelName nome del modello dell'entità
     * @throws IllegalStateException se gli indici della chiave di sharding non sono continui
     */
    private void check(String modelName) throws IllegalStateException {
        // Estrai gli indici di sharding dal nome del modello
        Pattern pattern = Pattern.compile("_\\d+$");
        Matcher matcher = pattern.matcher(modelName);

        if (!matcher.find()) {
            throw new IllegalStateException("Il nome del modello non contiene indici di sharding.");
        }

        String shardingIndexStr = matcher.group().substring(1); // Rimuovi il "_" iniziale
        int shardingIndex = Integer.parseInt(shardingIndexStr);

        // Verifica la continuità degli indici
        // Supponiamo che il modello sia parte di una lista ordinata
        // e che l'indice corrente sia shardingIndex
        // Se l'indice precedente non è shardingIndex - 1, lancia un'eccezione
        if (shardingIndex > 0) {
            String previousModelName = modelName.replaceAll("_\\d+$", "_" + (shardingIndex - 1));
            if (!previousModelName.equals(modelName)) {
                throw new IllegalStateException("Gli indici della chiave di sharding non sono continui.");
            }
        }
    }

    public static void main(String[] args) {
        ShardingKeyChecker checker = new ShardingKeyChecker();
        try {
            checker.check("model_2");
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}