import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class FileUtils {

    /**
     * Programa un archivo para que se elimine cuando la JVM exista. Si el archivo es un directorio, elimínalo y todos sus subdirectorios.
     * @param file  archivo o directorio a eliminar, no debe ser {@code null}
     * @throws NullPointerException si el archivo es {@code null}
     * @throws IOException en caso de que la eliminación no sea exitosa
     */
    public static void forceDeleteOnExit(File file) throws IOException {
        if (file == null) {
            throw new NullPointerException("El archivo no puede ser null");
        }

        if (!file.exists()) {
            return;
        }

        // Si es un directorio, programar eliminación recursiva de contenidos
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files) {
                    forceDeleteOnExit(f);
                }
            }
        }

        // Programar eliminación del archivo/directorio
        try {
            file.deleteOnExit();
        } catch (SecurityException e) {
            throw new IOException("No se pudo programar la eliminación del archivo: " + file.getAbsolutePath(), e);
        }
    }
}