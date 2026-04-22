import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class ConfigurationInitializer {

    /** 
     * inicializa la configuración, como verificar la ruta de distribución
     */
    public void init() {
        String distributionPath = "path/to/distribution"; // Cambiar a la ruta real
        Path path = Paths.get(distributionPath);
        
        if (Files.exists(path) && Files.isDirectory(path)) {
            System.out.println("La ruta de distribución es válida: " + distributionPath);
        } else {
            System.out.println("La ruta de distribución no es válida: " + distributionPath);
        }
    }

    public static void main(String[] args) {
        ConfigurationInitializer initializer = new ConfigurationInitializer();
        initializer.init();
    }
}