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
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(modelName);

        int previousIndex = -1;
        while (matcher.find()) {
            int currentIndex = Integer.parseInt(matcher.group());
            if (previousIndex != -1 && currentIndex != previousIndex + 1) {
                throw new IllegalStateException("Gli indici della chiave di sharding non sono continui.");
            }
            previousIndex = currentIndex;
        }
    }

    public static void main(String[] args) {
        ShardingKeyChecker checker = new ShardingKeyChecker();
        try {
            checker.check("model_1_2_3"); // Esempio di chiamata
        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }
    }
}