import java.io.InputStream;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class FileAdder {

    /**
     * Agrega los archivos especificados en orden inverso.
     */
    private void addReverse(final InputStream[] files) {
        if (files == null) {
            throw new IllegalArgumentException("El array de archivos no puede ser nulo.");
        }

        List<InputStream> fileList = new ArrayList<>();
        Collections.addAll(fileList, files);
        Collections.reverse(fileList);

        // Aquí puedes agregar la lógica para procesar los archivos en orden inverso.
        // Por ejemplo, podrías agregarlos a una lista o realizar alguna operación con ellos.
        for (InputStream file : fileList) {
            // Procesar cada archivo
        }
    }
}