import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileManager {
    
    /** 
     * Agrega los archivos especificados en orden inverso.
     */
    private void addReverse(final File[] files) {
        List<File> fileList = new ArrayList<>();
        Collections.addAll(fileList, files);
        Collections.reverse(fileList);
        
        for (File file : fileList) {
            // Aquí se puede agregar la lógica para agregar el archivo
            System.out.println("Agregando archivo: " + file.getName());
        }
    }
}