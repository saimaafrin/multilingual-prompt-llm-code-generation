import java.io.File;

public class FileDeleter {

    /**
     * Elimina el archivo especificado si existe
     * 
     * @param fileName El nombre del archivo a eliminar
     */
    protected static void deleteFile(String fileName) {
        File file = new File(fileName);
        if (file.exists()) {
            if (file.delete()) {
                System.out.println("Archivo eliminado: " + fileName);
            } else {
                System.out.println("No se pudo eliminar el archivo: " + fileName);
            }
        } else {
            System.out.println("El archivo no existe: " + fileName);
        }
    }

    public static void main(String[] args) {
        // Ejemplo de uso
        deleteFile("test.txt");
    }
}