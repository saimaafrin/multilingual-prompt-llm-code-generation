import java.io.File;

public class ConfigurationDirectoryCreator {

    /**
     * Crea el directorio donde se escribirá la lista de archivos MRU. El directorio "lf5" se crea en el directorio de Documentos y Configuraciones en máquinas con Windows 2000 y donde sea que apunte la variable user.home en todas las demás plataformas.
     */
    public static void createConfigurationDirectory() {
        // Obtener el directorio de inicio del usuario
        String userHome = System.getProperty("user.home");
        
        // Crear la ruta del directorio "lf5"
        File configDir = new File(userHome, "lf5");
        
        // Verificar si el directorio ya existe
        if (!configDir.exists()) {
            // Intentar crear el directorio
            boolean dirCreated = configDir.mkdir();
            if (dirCreated) {
                System.out.println("Directorio 'lf5' creado exitosamente en: " + configDir.getAbsolutePath());
            } else {
                System.out.println("No se pudo crear el directorio 'lf5' en: " + configDir.getAbsolutePath());
            }
        } else {
            System.out.println("El directorio 'lf5' ya existe en: " + configDir.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        createConfigurationDirectory();
    }
}