import java.io.File;
import java.io.IOException;

public class FileUtils {

    /**
     * Programa un archivo para que se elimine cuando la JVM exista. Si el archivo es un directorio, elimínalo y todos sus subdirectorios.
     * @param file  archivo o directorio a eliminar, no debe ser {@code null}
     * @throws NullPointerException si el archivo es {@code null}
     * @throws IOException en caso de que la eliminación no sea exitosa
     */
    public static void forceDeleteOnExit(File file) throws IOException {
        if (file == null) {
            throw new NullPointerException("El archivo no puede ser null.");
        }

        if (file.isDirectory()) {
            deleteDirectoryOnExit(file);
        } else {
            file.deleteOnExit();
        }
    }

    private static void deleteDirectoryOnExit(File directory) throws IOException {
        if (!directory.exists()) {
            return;
        }

        File[] files = directory.listFiles();
        if (files != null) {
            for (File file : files) {
                if (file.isDirectory()) {
                    deleteDirectoryOnExit(file);
                } else {
                    file.deleteOnExit();
                }
            }
        }

        directory.deleteOnExit();
    }

    public static void main(String[] args) {
        try {
            File file = new File("path/to/your/file_or_directory");
            forceDeleteOnExit(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}