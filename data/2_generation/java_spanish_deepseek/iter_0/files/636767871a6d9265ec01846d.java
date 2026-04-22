import java.io.File;

public class ConfigurationDirectoryCreator {

    /**
     * Crea el directorio donde se escribirá la lista de archivos MRU. El directorio "lf5" se crea en el directorio de Documentos y Configuraciones en máquinas con Windows 2000 y donde sea que apunte la variable user.home en todas las demás plataformas.
     */
    public static void createConfigurationDirectory() {
        // Obtener la ruta del directorio de inicio del usuario
        String userHome = System.getProperty("user.home");
        
        // Crear la ruta del directorio "lf5"
        String configDirPath = userHome + File.separator + "lf5";
        
        // Crear el objeto File para el directorio
        File configDir = new File(configDirPath);
        
        // Verificar si el directorio ya existe
        if (!configDir.exists()) {
            // Intentar crear el directorio
            boolean dirCreated = configDir.mkdir();
            
            if (dirCreated) {
                System.out.println("Directorio creado exitosamente en: " + configDirPath);
            } else {
                System.out.println("No se pudo crear el directorio en: " + configDirPath);
            }
        } else {
            System.out.println("El directorio ya existe en: " + configDirPath);
        }
    }

    public static void main(String[] args) {
        createConfigurationDirectory();
    }
}