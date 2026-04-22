import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileAdder {

    /** 
     * Agrega los archivos especificados en orden inverso.
     */
    private void addReverse(final InputStream[] files) {
        List<InputStream> fileList = new ArrayList<>();
        Collections.addAll(fileList, files);
        Collections.reverse(fileList);
        
        for (InputStream file : fileList) {
            // Aquí se puede agregar la lógica para procesar cada archivo
            // Por ejemplo, leer el contenido del InputStream
            System.out.println("Processing file: " + file);
        }
    }
}