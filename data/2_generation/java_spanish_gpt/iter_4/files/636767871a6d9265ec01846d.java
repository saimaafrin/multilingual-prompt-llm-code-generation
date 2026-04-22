import java.io.File;

public class ConfigurationDirectoryCreator {

    /** 
     * Crea el directorio donde se escribirá la lista de archivos MRU. El directorio "lf5" se crea en el directorio de Documentos y Configuraciones en máquinas con Windows 2000 y donde sea que apunte la variable user.home en todas las demás plataformas.
     */
    public static void createConfigurationDirectory() {
        String userHome = System.getProperty("user.home");
        String os = System.getProperty("os.name").toLowerCase();
        String configDirPath;

        if (os.contains("win")) {
            // For Windows, we create the directory in the user's home directory
            configDirPath = userHome + "\\lf5";
        } else {
            // For other platforms, we also create it in the user's home directory
            configDirPath = userHome + "/lf5";
        }

        File configDir = new File(configDirPath);
        if (!configDir.exists()) {
            boolean created = configDir.mkdirs();
            if (created) {
                System.out.println("Directory created: " + configDirPath);
            } else {
                System.out.println("Failed to create directory: " + configDirPath);
            }
        } else {
            System.out.println("Directory already exists: " + configDirPath);
        }
    }

    public static void main(String[] args) {
        createConfigurationDirectory();
    }
}