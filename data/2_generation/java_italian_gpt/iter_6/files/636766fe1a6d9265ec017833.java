import java.io.File;
import java.io.IOException;

public class FileDeletionScheduler {

    /** 
     * Pianifica la cancellazione di un file quando la JVM termina. Se il file è una directory, cancella lei e tutte le sottodirectory.
     * @param file  file o directory da cancellare, non deve essere {@code null}
     * @throws NullPointerException se il file è {@code null}
     * @throws IOException in caso di cancellazione non riuscita
     */
    public static void forceDeleteOnExit(File file) throws IOException {
        if (file == null) {
            throw new NullPointerException("Il file non deve essere null");
        }

        // Registrare il file per la cancellazione al termine della JVM
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                deleteRecursively(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }

    private static void deleteRecursively(File file) throws IOException {
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File subFile : files) {
                    deleteRecursively(subFile);
                }
            }
        }
        if (!file.delete()) {
            throw new IOException("Impossibile cancellare il file: " + file.getAbsolutePath());
        }
    }
}