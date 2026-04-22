import java.io.File;

public class ConfigurationManager {
    
    /**
     * Crea el directorio donde se escribirá la lista de archivos MRU. El directorio "lf5" se crea en el directorio de Documentos y Configuraciones en máquinas con Windows 2000 y donde sea que apunte la variable user.home en todas las demás plataformas.
     */
    public static void createConfigurationDirectory() {
        String userHome = System.getProperty("user.home");
        String fileSeparator = System.getProperty("file.separator");
        String configDirPath = userHome + fileSeparator + "lf5";
        
        File configDir = new File(configDirPath);
        
        if (!configDir.exists()) {
            boolean created = configDir.mkdir();
            if (!created) {
                throw new RuntimeException("No se pudo crear el directorio de configuración en: " + configDirPath);
            }
        }
    }
}