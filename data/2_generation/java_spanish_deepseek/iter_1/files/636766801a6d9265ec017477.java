import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class FileAdder {
    private List<InputStream> fileList;

    public FileAdder() {
        this.fileList = new ArrayList<>();
    }

    /** 
     * Agrega los archivos especificados en orden inverso.
     */
    private void addReverse(final InputStream[] files) {
        if (files == null) {
            throw new IllegalArgumentException("El arreglo de archivos no puede ser nulo.");
        }

        // Convertir el arreglo a una lista para facilitar la manipulación
        List<InputStream> tempList = new ArrayList<>();
        for (InputStream file : files) {
            if (file != null) {
                tempList.add(file);
            }
        }

        // Invertir la lista
        Collections.reverse(tempList);

        // Agregar los archivos invertidos a la lista principal
        fileList.addAll(tempList);
    }

    // Método para obtener la lista de archivos (solo para propósitos de prueba)
    public List<InputStream> getFileList() {
        return fileList;
    }
}