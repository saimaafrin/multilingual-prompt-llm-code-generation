import java.io.File;

public class ConfigurationDirectoryCreator {

    /**
     * Crea el directorio donde se escribirá la lista de archivos MRU. El directorio "lf5" se crea en el directorio de Documentos y Configuraciones en máquinas con Windows 2000 y donde sea que apunte la variable user.home en todas las demás plataformas.
     */
    public static void createConfigurationDirectory() {
        String userHome = System.getProperty("user.home");
        String directoryPath = userHome + File.separator + "lf5";

        File directory = new File(directoryPath);
        if (!directory.exists()) {
            boolean created = directory.mkdir();
            if (created) {
                System.out.println("Directorio creado exitosamente: " + directoryPath);
            } else {
                System.out.println("No se pudo crear el directorio: " + directoryPath);
            }
        } else {
            System.out.println("El directorio ya existe: " + directoryPath);
        }
    }

    public static void main(String[] args) {
        createConfigurationDirectory();
    }
}