import java.io.File;

public class FileManager {

    /** 
     * Agrega los archivos especificados en orden inverso.
     */
    private void addReverse(final File[] files) {
        if (files == null || files.length == 0) {
            return;
        }
        
        for (int i = files.length - 1; i >= 0; i--) {
            addFile(files[i]);
        }
    }

    private void addFile(File file) {
        // Implementación para agregar el archivo
        System.out.println("Archivo agregado: " + file.getName());
    }

    public static void main(String[] args) {
        FileManager fileManager = new FileManager();
        File[] files = { new File("file1.txt"), new File("file2.txt"), new File("file3.txt") };
        fileManager.addReverse(files);
    }
}