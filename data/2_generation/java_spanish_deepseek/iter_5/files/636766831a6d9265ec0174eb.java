import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class FileAdder {

    /**
     * Agrega los archivos especificados en orden inverso.
     */
    private void addReverse(final File[] files) {
        if (files == null) {
            throw new IllegalArgumentException("El array de archivos no puede ser nulo.");
        }

        List<File> fileList = new ArrayList<>();
        Collections.addAll(fileList, files);
        Collections.reverse(fileList);

        // Aquí puedes agregar la lógica para procesar los archivos en orden inverso
        for (File file : fileList) {
            // Procesar cada archivo
            System.out.println("Procesando archivo: " + file.getName());
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        File[] files = { new File("archivo1.txt"), new File("archivo2.txt"), new File("archivo3.txt") };
        FileAdder fileAdder = new FileAdder();
        fileAdder.addReverse(files);
    }
}