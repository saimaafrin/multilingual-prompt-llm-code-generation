import java.io.File;

public class ConfigurationDirectoryCreator {

    /**
     * Crea el directorio donde se escribirá la lista de archivos MRU. El directorio "lf5" se crea en el directorio de Documentos y Configuraciones en máquinas con Windows 2000 y donde sea que apunte la variable user.home en todas las demás plataformas.
     */
    public static void createConfigurationDirectory() {
        // Obtener la ruta del directorio home del usuario
        String userHome = System.getProperty("user.home");
        
        // Crear la ruta del directorio "lf5"
        String configDirPath = userHome + File.separator + "lf5";
        File configDir = new File(configDirPath);
        
        // Crear el directorio si no existe
        if (!configDir.exists()) {
            boolean created = configDir.mkdir();
            if (created) {
                System.out.println("Directorio creado: " + configDirPath);
            } else {
                System.out.println("No se pudo crear el directorio: " + configDirPath);
            }
        } else {
            System.out.println("El directorio ya existe: " + configDirPath);
        }
    }

    public static void main(String[] args) {
        createConfigurationDirectory();
    }
}