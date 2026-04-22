import java.io.File;

public class FileDeleter {

    /**
     * Elimina il file specificato se esiste
     * @param fileName il nome del file da eliminare
     */
    protected static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("File eliminato con successo: " + fileName);
            } else {
                System.out.println("Impossibile eliminare il file: " + fileName);
            }
        } else {
            System.out.println("Il file non esiste: " + fileName);
        }
    }

    public static void main(String[] args) {
        // Esempio di utilizzo
        deleteFile("example.txt");
    }
}