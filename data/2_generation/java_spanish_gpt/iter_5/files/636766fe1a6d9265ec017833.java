import java.io.File;
import java.io.IOException;

public class FileDeleter {

    /** 
     * Programa un archivo para que se elimine cuando la JVM exista. Si el archivo es un directorio, elimínalo y todos sus subdirectorios.
     * @param file  archivo o directorio a eliminar, no debe ser {@code null}
     * @throws NullPointerException si el archivo es {@code null}
     * @throws IOException en caso de que la eliminación no sea exitosa
     */
    public static void forceDeleteOnExit(File file) throws IOException {
        if (file == null) {
            throw new NullPointerException("El archivo no debe ser null");
        }
        
        if (file.isDirectory()) {
            for (File subFile : file.listFiles()) {
                forceDeleteOnExit(subFile);
            }
        }
        
        if (!file.delete()) {
            throw new IOException("No se pudo eliminar el archivo: " + file.getAbsolutePath());
        }
        
        // Register the file for deletion on JVM exit
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try {
                if (file.exists()) {
                    forceDeleteOnExit(file);
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }));
    }
}