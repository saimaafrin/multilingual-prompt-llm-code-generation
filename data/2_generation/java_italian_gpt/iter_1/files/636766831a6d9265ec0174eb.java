import java.io.File;

public class FileManager {
    
    /**
     * Aggiungi i file specificati in ordine inverso.
     */
    private void addReverse(final File[] files) {
        if (files == null || files.length == 0) {
            return;
        }
        
        for (int i = files.length - 1; i >= 0; i--) {
            addFile(files[i]);
        }
    }
    
    private void addFile(File file) {
        // Implementazione per aggiungere il file
        System.out.println("Aggiunto file: " + file.getName());
    }
}