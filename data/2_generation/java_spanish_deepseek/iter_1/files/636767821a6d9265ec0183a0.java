import java.io.File;

/**
 * Elimina el archivo especificado si existe
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