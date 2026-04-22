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
        for (File file : files) {
            if (file != null) {
                fileList.add(file);
            }
        }

        Collections.reverse(fileList);

        // Aquí puedes agregar la lógica para procesar los archivos en orden inverso
        for (File file : fileList) {
            System.out.println("Archivo agregado: " + file.getName());
        }
    }

    public static void main(String[] args) {
        File[] files = { new File("file1.txt"), new File("file2.txt"), new File("file3.txt") };
        FileAdder fileAdder = new FileAdder();
        fileAdder.addReverse(files);
    }
}