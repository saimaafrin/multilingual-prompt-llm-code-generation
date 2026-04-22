import java.io.File;
import java.net.URL;
import java.util.Vector;

public class ClassPathUtils {

    /**
     * Aggiunge tutti i file jar in una directory al classpath, rappresentato come un Vector di URL.
     */
    @SuppressWarnings("unchecked")
    public static void addToClassPath(Vector<URL> cpV, String dir) {
        File directory = new File(dir);
        
        // Verifica che la directory esista ed è effettivamente una directory
        if (!directory.exists() || !directory.isDirectory()) {
            return;
        }

        // Ottiene la lista di tutti i file nella directory
        File[] files = directory.listFiles();
        if (files == null) {
            return;
        }

        try {
            // Itera su tutti i file
            for (File file : files) {
                // Controlla se il file è un file JAR
                if (file.isFile() && file.getName().toLowerCase().endsWith(".jar")) {
                    // Converte il file in URL e lo aggiunge al vector
                    URL url = file.toURI().toURL();
                    if (!cpV.contains(url)) {
                        cpV.add(url);
                    }
                }
            }
        } catch (Exception e) {
            // Gestisce eventuali errori nella conversione del file in URL
            e.printStackTrace();
        }
    }
}