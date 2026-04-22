import java.io.File;
import java.io.IOException;

public class FileDeletion {

    public static void forceDeleteOnExit(File file) throws IOException {
        if (file == null) {
            throw new NullPointerException("El archivo no puede ser null.");
        }

        // Registrar el archivo o directorio para eliminación al salir
        file.deleteOnExit();

        // Si es un directorio, eliminar recursivamente todos los subdirectorios y archivos
        if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File subFile : files) {
                    forceDeleteOnExit(subFile);
                }
            }
        }
    }

    public static void main(String[] args) {
        try {
            File file = new File("ruta/al/archivo/o/directorio");
            forceDeleteOnExit(file);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}