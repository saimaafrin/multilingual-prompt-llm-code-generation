import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileAdder {

    /**
     * Agrega los archivos especificados en orden inverso.
     */
    private void addReverse(final InputStream[] files) {
        if (files == null || files.length == 0) {
            return;
        }

        List<InputStream> fileList = new ArrayList<>();
        for (InputStream file : files) {
            fileList.add(file);
        }

        Collections.reverse(fileList);

        // Aquí puedes agregar la lógica para procesar los archivos en orden inverso
        for (InputStream file : fileList) {
            // Procesar cada archivo
        }
    }
}