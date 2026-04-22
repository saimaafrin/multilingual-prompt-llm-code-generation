import java.io.File;

public class ConfigurationDirectoryCreator {

    /**
     * Crea el directorio donde se escribirá la lista de archivos MRU. El directorio "lf5" se crea en el directorio de Documentos y Configuraciones en máquinas con Windows 2000 y donde sea que apunte la variable user.home en todas las demás plataformas.
     */
    public static void createConfigurationDirectory() {
        // Obtener el directorio de inicio del usuario
        String userHome = System.getProperty("user.home");
        
        // Crear la ruta del directorio "lf5"
        String directoryPath = userHome + File.separator + "lf5";
        
        // Crear el objeto File para el directorio
        File directory = new File(directoryPath);
        
        // Verificar si el directorio ya existe
        if (!directory.exists()) {
            // Intentar crear el directorio
            boolean wasCreated = directory.mkdir();
            
            if (wasCreated) {
                System.out.println("Directorio creado exitosamente en: " + directoryPath);
            } else {
                System.out.println("No se pudo crear el directorio en: " + directoryPath);
            }
        } else {
            System.out.println("El directorio ya existe en: " + directoryPath);
        }
    }

    public static void main(String[] args) {
        createConfigurationDirectory();
    }
}