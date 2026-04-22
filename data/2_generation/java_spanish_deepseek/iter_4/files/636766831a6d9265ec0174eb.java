import java.io.File;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class FileHandler {

    /**
     * Agrega los archivos especificados en orden inverso.
     */
    private void addReverse(final File[] files) {
        if (files == null || files.length == 0) {
            return;
        }

        List<File> fileList = new ArrayList<>();
        for (File file : files) {
            if (file != null) {
                fileList.add(file);
            }
        }

        Collections.reverse(fileList);

        // Aquí puedes agregar la lógica para procesar los archivos en orden inverso
        for (File file : fileList) {
            // Procesar el archivo
            System.out.println("Procesando archivo: " + file.getName());
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        File[] files = { new File("file1.txt"), new File("file2.txt"), new File("file3.txt") };
        FileHandler handler = new FileHandler();
        handler.addReverse(files);
    }
}